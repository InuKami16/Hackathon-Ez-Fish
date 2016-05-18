package legendarius.finalproject.vsh;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RandomChallenge extends Activity implements Button.OnClickListener {
	
	private String challenge = "Find a(n) ";
	
	private String[] objects = {"pigeon", "fast food restaurant", "shopping cart", 
								"playground", "fire hydrant", "sign", 
								"gas station", "cemetery", "bug", 
								"cat", "bridge", "newspaper",
								"recycling bin", "food stand", "policeman", "bank"};
	
	private String obj = "";
	
	private TextView scav;
	private Button refresh, testTokenButton;
	private ImageButton camButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_random_challenge);
		
		randomize();
		
		scav = (TextView)findViewById(R.id.textChallenge);
		scav.setText(challenge + obj);
		
		refresh = (Button)findViewById(R.id.btnRefresh);
		refresh.setOnClickListener(this);
		
		camButton = (ImageButton)findViewById(R.id.imageButton);
		camButton.setOnClickListener(this);
		
		testTokenButton = (Button)findViewById(R.id.btnTestTag);
		testTokenButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.random_challenge, menu);
		return true;
	}
	
	private void randomize() {
		Random r = new Random();
		int chosen = r.nextInt(objects.length);
		
		obj = objects[chosen];
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int viewId = arg0.getId();
		
		switch (viewId) {
			case R.id.btnRefresh:
				randomize();
				scav.setText(challenge + obj);
				break;
			case R.id.imageButton:
                // Here, the counter will be incremented each time, and the
                // picture taken by camera will be stored as 1.jpg,2.jpg
                // and likewise.
                CamController.count++;
                String file = CamController.PHOTO_DIRECTORY + CamController.count + ".jpg";
                File newfile = new File(file);
                CamController.setScavDirectory(file);
                
                try {
                    newfile.createNewFile();
                }
                catch (IOException e) {}

                Uri outputFileUri = Uri.fromFile(newfile);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                
                startActivityForResult(cameraIntent, CamController.PICTURE_TAKING_CODE);
                
				break;
			case R.id.btnTestTag:
				
		        try {
		        	new PostTaskTag().execute(); 
		        } catch (Exception e) { e.printStackTrace(); }
				
				break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
				case CamController.PICTURE_TAKING_CODE:
					
			        try {
			        	new PostTaskTag().execute(); 
			        } catch (Exception e) {
			        	e.printStackTrace();
			        }
					
					Log.i("Pic dir", CamController.PHOTO_DIRECTORY + CamController.count + ".jpg");
					Log.i("CameraResult", "Pic saved");
					break;
			}
		}
	}

}
