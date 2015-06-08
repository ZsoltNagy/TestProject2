package com.zsolt.bitmapdemo;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	ImageView imgView1 = null;
	ImageView imgView2 = null;
	ImageView imgView3 = null;
	ImageView imgView4 = null;

	class LoadPNGListener implements android.view.View.OnClickListener {
	    public void onClick(View v) {
	        
	        Point p = new Point();

	        getWindowManager().getDefaultDisplay().getSize(p);
	        int screenHeight = p.y;
	        int screenWidth = p.x;

	        int matrixN = 2;

	        int maxWForEachScreen = screenWidth / matrixN;
	        int maxHForEachScreen = screenHeight / matrixN;

	        
	    	File fileLocal = getFilesDir();
			Log.d("BITMAP", fileLocal.getAbsoluteFile() + "\n");

			RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rel_layout);
			
			File imgFile = new  File(fileLocal.getAbsoluteFile() +  "/clover_1.png");
			if(imgFile.exists()){
			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
			    //Drawable d = new BitmapDrawable(getResources(), myBitmap);

			    imgView1 = new ImageView(getApplicationContext());
			    imgView2 = new ImageView(getApplicationContext());
			    imgView3 = new ImageView(getApplicationContext());
			    imgView4 = new ImageView(getApplicationContext());

			    imgView1.setImageBitmap(myBitmap);
			    imgView2.setImageBitmap(myBitmap);
			    imgView3.setImageBitmap(myBitmap);
			    imgView4.setImageBitmap(myBitmap);

			    
			    
			    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(100, 100);
		        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(100, 100);
		        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(100, 100);
		        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(100, 100);
		        
		        params1.height = maxHForEachScreen/2;
		        params1.width = maxWForEachScreen/2;

		        params2.height = maxHForEachScreen/2;
		        params2.width = maxWForEachScreen/2;

		        params3.height = maxHForEachScreen/2;
		        params3.width = maxWForEachScreen/2;

		        params4.height = maxHForEachScreen/2;
		        params4.width = maxWForEachScreen/2;


		        params1.setMargins(0, 0, 0, 0);
		        params2.setMargins(maxWForEachScreen/2, 0, 0, 0);
		        params3.setMargins(0, maxHForEachScreen/2, 0, 0);
		        params4.setMargins(maxWForEachScreen/2, maxHForEachScreen/2, 0, 0);
		        
		        
		        relativeLayout.addView(imgView1, params1);
		        relativeLayout.addView(imgView2, params2);
		        relativeLayout.addView(imgView3, params2);
		        relativeLayout.addView(imgView4, params2);


		        
		        
			    // imgView1.setX(x)
			    
			    //ImageView myImage = (ImageView) findViewById(R.id.imageView1);
			    //myImage.setImageBitmap(myBitmap);
			}			
	    }
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LoadPNGListener clearListener = new LoadPNGListener();
        Button clearButton = (Button) findViewById(R.id.button1);
        clearButton.setOnClickListener(clearListener);       
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
