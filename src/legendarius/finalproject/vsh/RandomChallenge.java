package legendarius.finalproject.vsh;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
	private Button refresh;
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
				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivity(i);
				break;
		}
	}

}
