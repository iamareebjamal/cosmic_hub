package com.cosmic.mods;


import java.net.URLEncoder;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Utility extends SherlockPreferenceActivity {
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);	
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //Icon preference
        addPreferencesFromResource(R.xml.utilities);
        IconPreferenceScreen test = (IconPreferenceScreen) findPreference("cpu");
        Resources res = getResources();
        Drawable icon = res.getDrawable(R.drawable.ic_settings_cpu);
        test.setIcon(icon);
        IconPreferenceScreen test1 = (IconPreferenceScreen) findPreference("states");
        Resources res1 = getResources();
        Drawable icon1 = res1.getDrawable(R.drawable.ic_settings_states);
        test1.setIcon(icon1);
        IconPreferenceScreen test2 = (IconPreferenceScreen) findPreference("beats");
        Resources res2 = getResources();
        Drawable icon2 = res2.getDrawable(R.drawable.ic_settings_beats);
        test2.setIcon(icon2);
        IconPreferenceScreen test3 = (IconPreferenceScreen) findPreference("dolby");
        Resources res3 = getResources();
        Drawable icon3 = res3.getDrawable(R.drawable.ic_settings_dolby);
        test3.setIcon(icon3);
        IconPreferenceScreen test4 = (IconPreferenceScreen) findPreference("call");
        Resources res4 = getResources();
        Drawable icon4 = res4.getDrawable(R.drawable.ic_settings_recorder);
        test4.setIcon(icon4);
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
