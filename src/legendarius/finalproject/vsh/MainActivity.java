package legendarius.finalproject.vsh;

import java.io.File;

import org.apache.http.client.HttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/** URL tut: http://hmkcode.com/android-send-json-data-to-server/ */

public class MainActivity extends Activity implements Button.OnClickListener {
	HttpClient httpclient;
	
	
	private Button toMainChallenges, toRandomChallenge, toInstructions;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toMainChallenges = (Button)findViewById(R.id.mainChallenges);
        toMainChallenges.setOnClickListener(this);
        
        toRandomChallenge = (Button)findViewById(R.id.randomChallenge);
        toRandomChallenge.setOnClickListener(this);
        
        toInstructions = (Button)findViewById(R.id.instruction);
        toInstructions.setOnClickListener(this);

        // Here, we are making a folder named picFolder to store
        // pics taken by the camera using this application.
        
        File newdir = new File(CamController.PHOTO_DIRECTORY);
        newdir.mkdirs();
        
        try {
        	new PostTask().execute(); // request access token from Clarifai servers
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int btnId = arg0.getId();
		
		switch (btnId) {
			case R.id.mainChallenges:
				Intent i = new Intent(this, MainChallenges.class);
				startActivity(i);
				break;
			case R.id.randomChallenge:
				Intent j = new Intent(this, RandomChallenge.class);
				startActivity(j);
				break;
			case R.id.instruction:
				Intent k = new Intent(this, Instructions.class);
				startActivity(k);
				break;
		}
	} 
}
