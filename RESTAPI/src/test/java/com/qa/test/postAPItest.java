package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.pets;

import junit.framework.Assert;

public class postAPItest extends TestBase{
	TestBase testbase;
	String url2;
	RestClient restclient;
	CloseableHttpResponse closeableHttpResponse;
	
	
	
	@BeforeMethod
	public void SetUp() throws ClientProtocolException, IOException{
		testbase=new TestBase();
		url2=prop.getProperty("URL2");
		
		
	}
	
	@Test
	public void postapitest() throws JsonGenerationException, JsonMappingException, IOException{
		restclient=new RestClient();
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		
		//jackson api
		ObjectMapper mapper=new ObjectMapper();
		pets pet=new pets(100, "doggie", "available");
		
		//object to JSON
		mapper.writeValue(new File("C:\\Users\\RED MACHINE\\Desktop\\New folder\\RESTAPI\\src\\main\\java\\com\\qa\\data\\pets.json"), pet);
		
		//object to string
		String petsJSONstring=mapper.writeValueAsString(pet);
		System.out.println(petsJSONstring);
		
		closeableHttpResponse=restclient.post(url2, petsJSONstring, headerMap);
		
		//status code
		
		int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		//Assert.assertEquals(statuscode, 201);
		
		String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response form api is"+responseJson );
		pets p=mapper.readValue(responseString, pets.class);
		System.out.println(p);
		
		System.out.println(pet.getName().equals(p.getName()));
		System.out.println(pet.getStatus().equals(p.getStatus()));
		Assert.assertTrue(pet.getName().equals(p.getName()));
		Assert.assertTrue(pet.getStatus().equals(p.getStatus()));
	}
	
	
	

}
