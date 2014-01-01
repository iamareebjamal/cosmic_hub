package com.cosmic.mods;

import java.net.URLEncoder;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


public class FAQ extends SherlockActivity {
	
	private static final String TAG = "FAQ";
	
	private boolean ansIsVisible = true;
	
	
	LinearLayout que1;
	LinearLayout ans1;
	
	LinearLayout que2;
	LinearLayout ans2;
	
	LinearLayout que3;
	LinearLayout ans3;
	
	LinearLayout que4;
	LinearLayout ans4;
	
	LinearLayout que5;
	LinearLayout ans5;
	
	LinearLayout que6;
	LinearLayout ans6;
	
	LinearLayout quef;
	LinearLayout ansf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faq);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        que1 = (LinearLayout) findViewById(R.id.LLQ1);
        ans1 = (LinearLayout) findViewById(R.id.LLA1);
        
        que2 = (LinearLayout) findViewById(R.id.LLQ2);
        ans2 = (LinearLayout) findViewById(R.id.LLA2);
        
        que3 = (LinearLayout) findViewById(R.id.LLQ3);
        ans3 = (LinearLayout) findViewById(R.id.LLA3);
        
        que4 = (LinearLayout) findViewById(R.id.LLQ4);
        ans4 = (LinearLayout) findViewById(R.id.LLA4);
        
        que5 = (LinearLayout) findViewById(R.id.LLQ5);
        ans5 = (LinearLayout) findViewById(R.id.LLA5);
        
        que6 = (LinearLayout) findViewById(R.id.LLQ6);
        ans6 = (LinearLayout) findViewById(R.id.LLA6);
        
        quef = (LinearLayout) findViewById(R.id.LLQf);
        ansf = (LinearLayout) findViewById(R.id.LLAf);
        
        que1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans1.setVisibility(View.GONE);
					
				} else {
					
					ans1.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        que2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans2.setVisibility(View.GONE);
					
				} else {
					
					ans2.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        que3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans3.setVisibility(View.GONE);
					
				} else {
					
					ans3.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        que4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans4.setVisibility(View.GONE);
					
				} else {
					
					ans4.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        que5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans5.setVisibility(View.GONE);
					
				} else {
					
					ans5.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        que6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ans6.setVisibility(View.GONE);
					
				} else {
					
					ans6.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        quef.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if (ansIsVisible) {
					
					ansf.setVisibility(View.GONE);
					
				} else {
					
					ansf.setVisibility(View.VISIBLE);
					
					
				}
				
				ansIsVisible = ! ansIsVisible;
				
			}
		});
        
        
        
        
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


}
