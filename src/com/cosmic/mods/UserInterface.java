package com.cosmic.mods;


import java.net.URLEncoder;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.Toast;

public class UserInterface extends SherlockPreferenceActivity {
    protected TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);        
		//For lock screen settings
        addPreferencesFromResource(R.xml.user_interface);        
        IconPreferenceScreen iconPref = (IconPreferenceScreen) findPreference("lock");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_lockscreen);
        iconPref.setIcon(icon);        
        IconPreferenceScreen iconPref4 = (IconPreferenceScreen) findPreference("notifpanel");
        Resources res4 = getResources();
        Drawable icon4 = res4.getDrawable(R.drawable.ic_notify);
        iconPref4.setIcon(icon4); 
        /*IconPreferenceScreen iconPref5 = (IconPreferenceScreen) findPreference("profile");
        *Resources res5 = getResources();
        *Drawable icon5 = res5.getDrawable(R.drawable.ic_settings_profile);
        *iconPref5.setIcon(icon5);
        */
        IconPreferenceScreen iconPref6 = (IconPreferenceScreen) findPreference("statusbar");
        Resources res6 = getResources();
        Drawable icon6 = res6.getDrawable(R.drawable.ic_settings_statusbar_color);
        iconPref6.setIcon(icon6);
        /*IconPreferenceScreen iconPref7 = (IconPreferenceScreen) findPreference("quicksettings");
        *Resources res7 = getResources();
        *Drawable icon7 = res7.getDrawable(R.drawable.ic_settings_quicksettings);
        *iconPref7.setIcon(icon7);
        */
        /*IconPreferenceScreen iconPref8 = (IconPreferenceScreen) findPreference("statusbarlayout");
        *Resources res8 = getResources();
        *Drawable icon8 = res8.getDrawable(R.drawable.ic_settings_statusbar);
        *iconPref8.setIcon(icon8);
        */
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
                Intent intent = new Intent(this, Mods.class);
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
    
   
}
