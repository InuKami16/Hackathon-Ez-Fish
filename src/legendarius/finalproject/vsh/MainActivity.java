package legendarius.finalproject.vsh;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.clarifai.api.ClarifaiClient;

/** URL tut: http://hmkcode.com/android-send-json-data-to-server/ */

public class MainActivity extends Activity implements Button.OnClickListener {
	
	private Button toMainChallenges, toRandomChallenge, toInstructions;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ClarifaiClient clarifai = new ClarifaiClient(); // this causes crash
        
        toMainChallenges = (Button)findViewById(R.id.mainChallenges);
        toMainChallenges.setOnClickListener(this);
        
        toRandomChallenge = (Button)findViewById(R.id.randomChallenge);
        toRandomChallenge.setOnClickListener(this);
        
        toInstructions = (Button)findViewById(R.id.instruction);
        toInstructions.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*
    public static String getAccessToken() {
    	InputStream stream = null;
    	String result = "";
    	
    	try {
            // 1. create HttpClient
    		HttpClient client = new DefaultHttpClient();
    		
            // 2. make POST request to the given URL
    		HttpPost postRequest = new HttpPost("https://api.clarifai.com/v1/token/");
    		
    		String json = "";
    		
    		// 3. Build JSON Object
    		JSONObject jsonobj = new JSONObject();
    		jsonobj.accumulate("client_id", CLIENT_ID);
    		jsonobj.accumulate("client_secret", CLIENT_SECRET);
    		jsonobj.accumulate("grant_type", "client_crededentials");
    		
    		// 4. convert JSONObject to string
    		json = jsonobj.toString();
    		Log.d("Something", json);
    		
    		// 5. Set json string to StringEntity
    		StringEntity entity = new StringEntity(json);
    		
    		// 6. Set HttpPost Entity
    		postRequest.setEntity(entity);
    		
    		// 7. Set headers to inform server about content type
    		postRequest.setHeader("Accept", "application/json");
    		postRequest.setHeader("Content-type", "application/json");
    		
    		// 8. Execute POST Request to Clarifai API
    		HttpResponse response = client.execute(postRequest);
    		
    		// 9. Receive response as inputstream
    		stream = response.getEntity().getContent();
    		
    		// 10. convert inputstream to string
    		if (stream != null) 
    			result = convertInputStreamToString(stream);
    		else
    			result = "Did not work!";
    		
    	} catch (Exception e) {
    		Log.d("InputStream", e.getLocalizedMessage());
    		e.printStackTrace();
    	}
    	
    	return result;
    }

    
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }
*/
    
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
				
				break;
			case R.id.instruction:
				Intent k = new Intent(this, Instructions.class);
				startActivity(k);
				break;
		}
	} 
}
