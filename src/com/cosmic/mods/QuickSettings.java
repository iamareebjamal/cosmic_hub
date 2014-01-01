package com.cosmic.mods;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

public class QuickSettings extends SherlockPreferenceActivity {
	
    String color;
    String colorText;
    
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);  
        addPreferencesFromResource(R.xml.quicksettings);

        String bgcolor = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getString("toggleColor","#ff161616");
	    
	    ((ColorPickerPreference)findPreference("toggleColor")).setDefaultValue(bgcolor);
	    ((ColorPickerPreference)findPreference("toggleColor")).setSummary(bgcolor);
	    
        ((ColorPickerPreference)findPreference("toggleColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				color = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
				preference.setSummary(color);
	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	            editor.putString("toggleColor", color); //true or false
	            editor.commit();
				Intent intent = new Intent();
				intent.setAction("com.b16h22.statusbar.CHANGE_TOGGLE_BACKGROUND");
				intent.putExtra("shortcutBackgroundColor",color.toString());
				sendBroadcast(intent);				
				return false;
			}

        });
        

        String textcolor = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE).getString("toggleTextColor","#ffffffff");
	    
	    ((ColorPickerPreference)findPreference("textColor")).setDefaultValue(textcolor);
	    ((ColorPickerPreference)findPreference("textColor")).setSummary(textcolor);
	    
        ((ColorPickerPreference)findPreference("textColor")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				colorText = (ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));;
				preference.setSummary(colorText);
	            SharedPreferences sharedPreferences = getSharedPreferences("EvoPrefsFile",MODE_PRIVATE);
	            SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
	            editor.putString("toggleTextColor", colorText); //true or false
	            editor.commit();
				Intent intent = new Intent();
				intent.setAction("com.b16h22.statusbar.CHANGE_TOGGLETEXT_COLOR");
				intent.putExtra("toggleTextColor",colorText.toString());
				sendBroadcast(intent);				
				return false;
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
