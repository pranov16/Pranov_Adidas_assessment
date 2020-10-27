package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class RestClient {
	
	//1. GET method
	/*public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
	CloseableHttpClient httpClient=	HttpClients.createDefault();
	HttpGet httpGet= new HttpGet(url);
	CloseableHttpResponse closeableHttpResponse= httpClient.execute(httpGet);
	//int statuscode= closeableHttpResponse.getStatusLine().getStatusCode();
	//System.out.println(statuscode);
	
	//String responsestring=EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	//System.out.println(responsestring);
	
	//JSONObject responsejson=new JSONObject(responsestring.indexOf('{'));
	//System.out.println(responsejson);
	return closeableHttpResponse;
	
	}*/
	
	
	//2. POST method
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient=	HttpClients.createDefault();
		HttpPost httppost= new HttpPost(url);
		httppost.setEntity(new StringEntity(entityString));
		
		for(Map.Entry<String, String> entry : headerMap.entrySet()){
			httppost.addHeader(entry.getKey(), entry.getValue());
			
		}
		
		CloseableHttpResponse closeableHttpResponse=httpClient.execute(httppost);
		return closeableHttpResponse;
		
		
		
		
		
		
	}
}
