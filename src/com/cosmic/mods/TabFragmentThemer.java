package com.cosmic.mods;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class TabFragmentThemer extends SherlockFragment{
	
	TextView tv1;
	ImageView im1;
	ImageView fb;
	ImageView tw;
	ImageView xd;
	ImageView gp;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved){
		
		return inflater.inflate(R.layout.tab_about3, group, false);
		
		
	};
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		tv1 = (TextView) getActivity().findViewById(R.id.areebt);
		tv1.setText(Html.fromHtml(getString(R.string.areebinfo)));
		
		im1 = (ImageView) getActivity().findViewById(R.id.areebImage);
		im1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getActivity(), "Stop clicking on my pic!", Toast.LENGTH_SHORT).show();
			}
		});
		
		fb = (ImageView) getActivity().findViewById(R.id.facebook);
		fb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Intent fb = new Intent("android.intent.action.VIEW", Uri.parse("http://www.facebook.com/iamareebjamal"));
            	try{
            		startActivity(fb);
            	} catch (Exception e) {
            		Toast.makeText(getActivity(), "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
			}
		});
		
		tw = (ImageView) getActivity().findViewById(R.id.twitter);
		tw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Intent tw = new Intent("android.intent.action.VIEW", Uri.parse("http://www.twitter.com/iamareebjamal"));
            	try{
            		startActivity(tw);
            	} catch (Exception e) {
            		Toast.makeText(getActivity(), "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
			}
		});
		
		xd = (ImageView) getActivity().findViewById(R.id.xda);
		xd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Intent xd = new Intent("android.intent.action.VIEW", Uri.parse("http://forum.xda-developers.com/member.php?u=4782403"));
            	try{
            		startActivity(xd);
            	} catch (Exception e) {
            		Toast.makeText(getActivity(), "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
			}
		});
		
		gp = (ImageView) getActivity().findViewById(R.id.gplus);
		gp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Intent fb = new Intent("android.intent.action.VIEW", Uri.parse("http://plus.google.com/101187817179546867616"));
            	try{
            		startActivity(fb);
            	} catch (Exception e) {
            		Toast.makeText(getActivity(), "No Browser Found", Toast.LENGTH_SHORT).show();
            	}
			}
		});
		
	}

}
