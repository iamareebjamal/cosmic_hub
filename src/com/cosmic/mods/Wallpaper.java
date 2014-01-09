package com.cosmic.mods;

/**
 ** This is essentially a gallery view with custom animations
 ** MODIFY AT YOUR OWN RISK!!!
 **/

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



@SuppressWarnings("deprecation")
public class Wallpaper extends SherlockActivity implements AdapterView.OnItemSelectedListener,
        OnClickListener {

    private Gallery mGallery;
    private ImageView mImageView;
    private boolean mIsWallpaperSet;
    private Bitmap mBitmap;

    private ArrayList<Integer> mThumbs;
    private ArrayList<Integer> mImages;
    private WallpaperLoader mLoader;
    
    

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        setTitle(R.string.wallpaper);

        findWallpapers();

        setContentView(R.layout.wallpaper_chooser);

        mGallery = (Gallery) findViewById(R.id.gallery);
        mGallery.setAdapter(new ImageAdapter(this));
        mGallery.setOnItemSelectedListener(this);
        mGallery.setCallbackDuringFling(false);

        findViewById(R.id.set).setOnClickListener(this);

        mImageView = (ImageView) findViewById(R.id.wallpaper);
    }

    private void findWallpapers() {
        mThumbs = new ArrayList<Integer>(24);
        mImages = new ArrayList<Integer>(24);

        final Resources resources = getResources();
        final String packageName = getApplication().getPackageName();

        addWallpapers(resources, packageName, R.array.wallpapers);
        addWallpapers(resources, packageName, R.array.extra_wallpapers);
    }

    private void addWallpapers(Resources paramResources, String paramString, int paramInt)
    {
      String[] arrayOfString = paramResources.getStringArray(paramInt);
      int i = arrayOfString.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return;
        String str = arrayOfString[j];
        int k = paramResources.getIdentifier(str, "drawable", paramString);
        if (k == 0)
          continue;
        int m = paramResources.getIdentifier(str + "_small", "drawable", paramString);
        if (m == 0)
          continue;
        this.mThumbs.add(Integer.valueOf(m));
        this.mImages.add(Integer.valueOf(k));
      }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsWallpaperSet = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        if (mLoader != null && mLoader.getStatus() != WallpaperLoader.Status.FINISHED) {
            mLoader.cancel(true);
            mLoader = null;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (mLoader != null && mLoader.getStatus() != WallpaperLoader.Status.FINISHED) {
            mLoader.cancel();
        }
        mLoader = (WallpaperLoader) new WallpaperLoader().execute(position);
    }

    private void selectWallpaper(int position) {
        if (mIsWallpaperSet) {
            return;
        }

        mIsWallpaperSet = true;
        try {
            InputStream stream = getResources().openRawResource(mImages.get(position));
            setWallpaper(stream);
            setResult(RESULT_OK);
            Intent exit = new Intent(Intent.ACTION_MAIN);
        	exit.addCategory(Intent.CATEGORY_HOME);
        	exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	startActivity(exit);
            Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Log.e("Template", "Failed to set wallpaper: " + e);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    private class ImageAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        ImageAdapter(Wallpaper context) {
            mLayoutInflater = context.getLayoutInflater();
        }

        public int getCount() {
            return mThumbs.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView image;

            if (convertView == null) {
                image = (ImageView) mLayoutInflater.inflate(R.layout.wallpaper_item, parent, false);
            } else {
                image = (ImageView) convertView;
            }
            
            int thumbRes = mThumbs.get(position);
            image.setImageResource(thumbRes);
            Drawable thumbDrawable = image.getDrawable();
            if (thumbDrawable != null) {
                thumbDrawable.setDither(true);
            } else {
                Log.e("Template", String.format(
                    "Error decoding thumbnail resId=%d for wallpaper #%d",
                    thumbRes, position));
            }
            return image;
        }
    }

    public void onClick(View v) {
        selectWallpaper(mGallery.getSelectedItemPosition());
    }

    class WallpaperLoader extends AsyncTask<Integer, Void, Bitmap> {
        BitmapFactory.Options mOptions;

        WallpaperLoader() {
            mOptions = new BitmapFactory.Options();
            mOptions.inDither = false;
            mOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;            
        }
        
        protected Bitmap doInBackground(Integer... params) {
            if (isCancelled()) return null;
            try {
                return BitmapFactory.decodeResource(getResources(),
                        mImages.get(params[0]), mOptions);
            } catch (OutOfMemoryError e) {
                return null;
            }            
        }

        @Override
        protected void onPostExecute(Bitmap b) {
            if (b == null) return;

            if (!isCancelled() && !mOptions.mCancel) {

                if (mBitmap != null) {
                    mBitmap.recycle();
                }
    
                final ImageView view = mImageView;
                view.setImageBitmap(b);
    
                mBitmap = b;
    
                final Drawable drawable = view.getDrawable();
                drawable.setFilterBitmap(true);
                drawable.setDither(true);

                view.postInvalidate();

                mLoader = null;
            } else {
               b.recycle(); 
            }
        }

        void cancel() {
            mOptions.requestCancelDecode();
            super.cancel(true);
        }
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, Mods.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
                
            case R.id.appwa:
            	selectWallpaper(mGallery.getSelectedItemPosition());
            	break;
            default:
                return super.onOptionsItemSelected(item);
        }
		return mIsWallpaperSet;
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.wallpaper, menu);
		return true;
	}
    
    
}
