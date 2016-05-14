package legendarius.finalproject.vsh;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	private final static String CLIENT_ID = "fxq2lxHCQyG_27zBJnZwxBxQRSn8e-FjpffWvShz";
	private final static String CLIENT_SECRET = "_R_GHkeSEkAFDARt_kf40gGBN5LE7SaeoTrH5Jv6";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Uses JSON and POST to get Access Token */
    public static void getAccessToken() {
    	
    	
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
    		
    		json = jsonobj.toString();
    		
    		/** URL tut: http://hmkcode.com/android-send-json-data-to-server/ */
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
