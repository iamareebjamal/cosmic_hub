package com.cosmic.mods;

import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class TabFragmentApp extends SherlockFragment {
	
	TextView tv2;
	ImageView ib2;
	Button bt1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle saved)
	{
		return inflater.inflate(R.layout.tab_about2, group, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		tv2 = (TextView) getActivity().findViewById(R.id.hubText);
		tv2.setText(Html.fromHtml(getString(R.string.hub_about)));
		
		ib2 = (ImageView) getActivity().findViewById(R.id.caneimage);
		ib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view3) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getActivity(), "No candy for you", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		bt1 = (Button) getActivity().findViewById(R.id.licenseButton);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Builder lb = new Builder(getActivity());
				lb.setTitle("Licenses");
				lb.setMessage(Html.fromHtml(getString(R.string.licenses)));
				lb.show();
				
			}
		});
		
	}
	

}
