package com.techelevator.services;

import com.techelevator.util.BasicLogger;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_BASE_URL = "https://teapi.netlify.app/api/cats/facts/random";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		return restTemplate.getForObject(API_BASE_URL, CatFact.class);
	}

}
