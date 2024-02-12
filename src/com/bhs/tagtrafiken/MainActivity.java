package com.bhs.tagtrafiken;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
   
	 String URL = "http://xn--tg-yia.info/";  
     String result = "";  
     String deviceId = "xxxxx" ;  
     final String tag = "Your Logcat tag: ";  
     
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        callWebService("Hallsberg.xml?apikey=myapikey");
        
    }
    
    public void callWebService(String q){  
        HttpClient httpclient = new DefaultHttpClient();  
        HttpGet request = new HttpGet(URL + q);  
        //request.addHeader("deviceId", deviceId);  
        ResponseHandler<String> handler = new BasicResponseHandler();  
        try {  
            result = httpclient.execute(request, handler);  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        httpclient.getConnectionManager().shutdown();  
        Log.i(tag, result);  
    } 
}
 