package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_BASE_URL = "https://teapi.netlify.app/api/cats/";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		CatFact catFact = null;
		try {
			catFact = restTemplate.getForObject(API_BASE_URL + "facts/random", CatFact.class);
			System.out.println(catFact.getText());
		} catch (RestClientResponseException | ResourceAccessException e) {
		//	BasicLogger.log(e.getMessage());
		}

		return catFact;
	}

}
