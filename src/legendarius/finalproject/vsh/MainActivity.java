package legendarius.finalproject.vsh;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        
        //ClarifaiClient clarifai = new ClarifaiClient(); // this causes crash
        
        toMainChallenges = (Button)findViewById(R.id.mainChallenges);
        toMainChallenges.setOnClickListener(this);
        
        toRandomChallenge = (Button)findViewById(R.id.randomChallenge);
        toRandomChallenge.setOnClickListener(this);
        
        toInstructions = (Button)findViewById(R.id.instruction);
        toInstructions.setOnClickListener(this);
        
        try {
			sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
        	new PostTaskTag().execute();
        } catch (Exception e) {
        	e.printStackTrace();
        }
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
    
    private void sendPost() throws Exception {
//    	httpclient = new DefaultHttpClient();
//    	HttpPost httppost = new HttpPost("https://api.clarifai.com/v1/token/");
//    	
//    	List<NameValuePair> nvp = new ArrayList<NameValuePair>(3);
//  		nvp.add(new BasicNameValuePair("client_id", Credentials.CLIENT_ID));
//   		nvp.add(new BasicNameValuePair("client_secret", Credentials.CLIENT_SECRET));
//   		nvp.add(new BasicNameValuePair("grant_type", "client_credentials"));
//   		
//    	httppost.setEntity(new UrlEncodedFormEntity(nvp));
//    		
//    	HttpResponse response = httpclient.execute(httppost);
//    	String resp = EntityUtils.toString(response.getEntity());
//    	Log.i("Ressdlafhlas", resp);
    	
    	new PostTask().execute();
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
