package com.cosmic.mods;

import java.net.URLEncoder;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.app.ActionBar.Tab;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import android.content.Intent;

public class About extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = getSupportActionBar().newTab();
        tab1.setText("Theme");
        tab1.setTabListener(new CosmicTab());
        getSupportActionBar().addTab(tab1);
        
        ActionBar.Tab tab2 = getSupportActionBar().newTab();
        tab2.setText("App");
        tab2.setTabListener(new CosmicTab());
        getSupportActionBar().addTab(tab2);
        
        ActionBar.Tab tab3 = getSupportActionBar().newTab();
        tab3.setText("Themer");
        tab3.setTabListener(new CosmicTab());
        getSupportActionBar().addTab(tab3);
        
        
        
        
        
        };
	
	private class CosmicTab implements ActionBar.TabListener{

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
			switch(tab.getPosition()) {
			case 0:
				TabFragmentTheme frag = new TabFragmentTheme();
				ft.replace(android.R.id.content, frag);
				break;
			case 1:
				TabFragmentApp frag1 = new TabFragmentApp();
				ft.replace(android.R.id.content, frag1);
				break;
			case 2:
				TabFragmentThemer frag2 = new TabFragmentThemer();
				ft.replace(android.R.id.content, frag2);
				break;
			}
			
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
		
		
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







	


