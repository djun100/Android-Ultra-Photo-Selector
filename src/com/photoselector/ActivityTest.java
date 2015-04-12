package com.photoselector;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.photoselector.model.PhotoModel;
import com.photoselector.ui.PhotoSelectorActivity;

public class ActivityTest extends Activity {
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		btn=(Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				jumpToSelectPic();

			}
		});
	}
	void jumpToSelectPic(){
		 Intent intent = new Intent(this, PhotoSelectorActivity.class);
		    intent.putExtra(PhotoSelectorActivity.KEY_MAX, 1);
		    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		    startActivityForResult(intent, 0);
	}
	
	   @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	       if (resultCode != RESULT_OK)
	           return;
	       if (requestCode == 0) {// selected image
	           if (data != null && data.getExtras() != null) {
	               @SuppressWarnings("unchecked")
	               List<PhotoModel> photos = (List<PhotoModel>) data.getExtras().getSerializable("photos");
	               if (photos == null || photos.isEmpty()) {
//	                   UIHelper.ToastMessage(this, R.string.no_photo_selected);
	                   
	               } else {
	            	   for(PhotoModel photo:photos){
	            		   Log.w("", photo.toString());
	            	   }
/*	                   Intent intent = new Intent(this, YourOwnLogic.class);
	                   Bundle b = new Bundle();
	                   b.putSerializable("album_pojo", albumPojo);
	                   b.putSerializable("photos", (Serializable) photos);
	                   intent.putExtras(b);
	                   startActivity(intent);
	                   finish();*/
	               }
	           }
	       }
	   }
}
