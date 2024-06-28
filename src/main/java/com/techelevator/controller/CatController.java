package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;
    private static final String API_BASE_URL = "http://localhost:8080";

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = API_BASE_URL, method = RequestMethod.GET)
    public CatFact getFact(@RequestBody CatFact catFact) {

        if (catFact != null) {

            return catFact;

        }
        return null;
    }
    @RequestMapping(path = API_BASE_URL, method = RequestMethod.GET)
    public CatPic getPic(@RequestBody CatPic catPic) {

        if (catPic != null) {

            return catPic;

        }
        return null;
    }
}

