package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	private static final String API_BASE_URL = "https://teapi.netlify.app/api/cats/";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatPic getPic() {
		CatPic catPic = null;
		try {
			catPic = restTemplate.getForObject(API_BASE_URL + "pictures/random", CatPic.class);
		} catch (RestClientResponseException | ResourceAccessException e) {
			BasicLogger.log(e.getMessage());
		}
		return catPic;
	}

}	
