package legendarius.finalproject.vsh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class PostTaskTag extends AsyncTask<String, String, String> {
	HttpClient httpclient;
	@Override
	protected String doInBackground(String... data) {
		// TODO Auto-generated method stub

		try {
	    	httpclient = new DefaultHttpClient();
	    	HttpPost httppost = new HttpPost("https://api.clarifai.com/v1/tag/");
	    	httppost.setHeader("Authorization: Bearer", Credentials.accessToken);
	    	
	    	List<NameValuePair> nvp = new ArrayList<NameValuePair>(3);
	  		nvp.add(new BasicNameValuePair("url", "https://samples.clarifai.com/metro-north.jpg"));
	   		
	    	httppost.setEntity(new UrlEncodedFormEntity(nvp));
	    		
	    	HttpResponse response = httpclient.execute(httppost);
	    	String resp = EntityUtils.toString(response.getEntity());
	    	Log.i("Gitrahsdm", resp);
	    	
	    	JSONObject jo = new JSONObject(resp);
	    	Credentials.setAccessToken((String)jo.get("access_token"));
		} catch (ClientProtocolException e) {
			
		} catch (IOException e) {
			
		} catch (JSONException e) {
			
		}
		
		return null;
	}
}
