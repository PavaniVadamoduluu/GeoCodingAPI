package com.GeocodingAPI.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class GeocodingController {
	 
	@GetMapping("/geocode/{address}")
	 public Object index(Object value, @PathVariable("address") String address,@Value("${key}") String key) {
	        final String uri = "https://maps.googleapis.com/maps/api/geocode/json?"+address+"&key="+key;
	        RestTemplate restTemplate = new RestTemplate();
	        String result = restTemplate.getForObject(uri, String.class);
	        
	        JSONObject object = new JSONObject(result);
	        JSONArray jArray = object.getJSONArray("results");
	        if (jArray.isNull(0)) {
				return "Kindly check the URL";
			} else {
				for (int i = 0; i < jArray.length(); i++)
		        {
		            Object geometryobj = ((JSONObject) jArray.getJSONObject(i).get("geometry")).get("location");
		            value = geometryobj;
		        }
			}
			return value.toString();
		}
}
