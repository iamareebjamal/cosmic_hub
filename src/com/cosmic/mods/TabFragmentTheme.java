package com.cosmic.mods;


import java.net.URLEncoder;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class TabFragmentTheme extends SherlockFragment {
	TextView tv1;
	ImageButton ib1;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved)
	{
		return inflater.inflate(R.layout.tab_about1, group, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		tv1 = (TextView) getActivity().findViewById(R.id.cosmicText);
		tv1.setText(Html.fromHtml(getString(R.string.cosmic_about)));
		
		ib1 = (ImageButton) getActivity().findViewById(R.id.cosmicImage);
		ib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				ib1.setBackgroundResource(R.drawable.platlogo);
			}
		
		});
		
		b1 = (Button) getActivity().findViewById(R.id.buttonNew);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view1) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder cl = new AlertDialog.Builder(getActivity());
				cl.setTitle("Changelog");
				cl.setMessage(Html.fromHtml(getString(R.string.changelog)));
				cl.show();
				
			}
		});
		
		b2 = (Button) getActivity().findViewById(R.id.buttonThread);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view3) {
				// TODO Auto-generated method stub
				final Intent xda = new Intent("android.intent.action.VIEW", Uri.parse("http://forum.xda-developers.com/showthread.php?t=2579836"));
            	try{
            		startActivity(xda);
            	} catch (Exception e) {
            		Toast.makeText(getActivity(), "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
				
			}
		});
		
		b3 = (Button) getActivity().findViewById(R.id.buttonFeedback);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view4) {
				// TODO Auto-generated method stub
				final Intent email = new Intent(android.content.Intent.ACTION_SENDTO);
    			String uriText = "mailto:jamal.areeb@gmail.com" +
    					"?subject=" + URLEncoder.encode("Cosmic Theme Feedback"); 
    			email.setData(Uri.parse(uriText));
    			try {
    				startActivity(email);
    			} catch (Exception e) {
    				Toast.makeText(getActivity(), "You don't have any email client", Toast.LENGTH_SHORT).show();
    			}
			}
		});
		
		b4 = (Button) getActivity().findViewById(R.id.buttonCreditTheme);
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder ab1 = new Builder(getActivity());
				ab1.setTitle("Credits");
				ab1.setMessage(R.string.credits);
				ab1.show();
			}
		});
	
	}

}
