package com.cosmic.mods;


import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.widget.Toast;

public class StatusBarLayout extends SherlockPreferenceActivity {
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);  
        addPreferencesFromResource(R.xml.statusbar_layout);
    	SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",Context.MODE_PRIVATE); 
    	String layoutType = sharedPreferences.getString("statusbarlayout","phablet");
    	((ListPreference)findPreference("statusbarlayout")).setSummary(layoutType);
    	
        ((ListPreference)findPreference("statusbarlayout")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				String type = (String.valueOf(newValue));
					Intent i = new Intent();
					i.setAction("com.b16h22.statusbar.CHANGE_LAYOUT");
					i.putExtra("layoutType",type);
					sendBroadcast(i);
				preference.setSummary(type);
	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	            editor.putString("statusbarlayout", type); //true or false
	            editor.commit();			
				return true;
			}

        });
        
	}
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:

                    Intent intent = new Intent(this, UserInterface.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
	}
}
