package com.cosmic.mods;



import java.net.URLEncoder;


import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends SherlockActivity {
    private static final String TAG = "MainActivity";
	private static final String COM = "COM";

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if(!prefs.getBoolean("firstTime", false)) {
		// run your one time code
		
		if (Build.VERSION.SDK_INT > 10) {
			AlertDialog.Builder bl = new AlertDialog.Builder(this);
			bl.setTitle("No shit Sherlock!");
			bl.setMessage(R.string.warning);
			bl.setPositiveButton("YES",
		            new DialogInterface.OnClickListener() 
		            {
		                public void onClick(DialogInterface dialogInterface, int i) 
		                {
		                    
		                    finish();

		                }
		            });
		    bl.setNegativeButton("NO",
		            new DialogInterface.OnClickListener() 
		            {
		                public void onClick(DialogInterface dialog, int i) 
		                {
		                    dialog.dismiss();
		                }
		            });
		    bl.show();
		    
		    
		} else {
			
			Toast.makeText(this, "Welcome to Cosmic Hub", Toast.LENGTH_SHORT).show();
			
			
		    }
		
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("firstTime", true);
		editor.commit();
		}
		
			
		}
		
	
    
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
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
    };
    
    
    
    public void uiButton(View view){
    	
    	startActivity(new Intent(this, Mods.class));
    	
    };
    
public void easter(View view){
    	
    	startActivity(new Intent(this, PlatLogoActivity.class));
    	
    };
    
public void about(View view){
    	
    	startActivity(new Intent(this, About.class));
    	
    };
    
public void faq(View view){
    	
    	startActivity(new Intent(this, FAQ.class));
    	
    };
    
    
}
