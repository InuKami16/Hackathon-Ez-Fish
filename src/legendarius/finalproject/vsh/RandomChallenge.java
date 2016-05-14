package legendarius.finalproject.vsh;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RandomChallenge extends Activity {
	
	private String challenge = "Find a ";
	private String[] objects = {"pigeon", "fast food restaurant", "shopping cart", "playground", "fire hydrant", "sign", "gas station", "cemetary",
								"bug", "cat", "bridge", "newspaper", "recycling", "food stand", "policeman", "bank"};
	private String obj = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_random_challenge);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.random_challenge, menu);
		return true;
	}

}
