package com.cosmic.mods;

import java.net.URLEncoder;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.cosmic.mods.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class Mods extends SherlockPreferenceActivity {
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        addPreferencesFromResource(R.xml.preferences);
        IconPreferenceScreen test = (IconPreferenceScreen) findPreference("ui");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_ui);
        test.setIcon(icon);
        test.setLayoutResource(R.layout.custom_icon_preference);
        IconPreferenceScreen test1 = (IconPreferenceScreen) findPreference("utility");
        Resources res1 = getResources();
        Drawable icon1 = res1.getDrawable(R.drawable.ic_settings_utilities);
        test1.setIcon(icon1);
        test1.setLayoutResource(R.layout.custom_icon_preference_01);
        IconPreferenceScreen test2 = (IconPreferenceScreen) findPreference("wallpaper");
        Resources res2 = getResources();
        Drawable icon2 = res2.getDrawable(R.drawable.ic_settings_wallpapers);
        test2.setIcon(icon2); 
        test2.setLayoutResource(R.layout.custom_icon_preference_02);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
                
            case R.id.aboutButton:
                // app icon in action bar clicked; go home
                Intent about = new Intent(this, About.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                return true;
                
            case R.id.emailButton:
            	final Intent email = new Intent(android.content.Intent.ACTION_SENDTO);
    			String uriText = "mailto:jamal.areeb@gmail.com" +
    					"?subject=" + URLEncoder.encode("Cosmic Theme Feedback"); 
    			email.setData(Uri.parse(uriText));
    			try {
    				startActivity(email);
    			} catch (Exception e) {
    				Toast.makeText(this, "You don't have any email client", Toast.LENGTH_SHORT).show();
    			}
    			return true;
    			
            case R.id.xdaButton:
            	final Intent xda = new Intent("android.intent.action.VIEW", Uri.parse("http://forum.xda-developers.com/showthread.php?t=2579836"));
            	try{
            		startActivity(xda);
            	} catch (Exception e) {
            		Toast.makeText(this, "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
