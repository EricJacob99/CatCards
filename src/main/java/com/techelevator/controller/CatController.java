package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> catCardList() {
        return catCardDao.getCatCards();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard getCatCardById(@PathVariable int id) {
        return catCardDao.getCatCardById(id);
    }
    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard getRandomCatCard() {
        CatCard catCard = new CatCard();
        CatFact catFact = catFactService.getFact();
        catFact.getText();
        catCard.setCatFact(catFact.getText());

        CatPic catPic = catPicService.getPic();
        catCard.setImgUrl(catPic.getFile());
        return catCard;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public CatCard createCatCard(@RequestBody CatCard catCard) {
        return catCardDao.createCatCard(catCard);
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
    public CatCard updateCatCard(@Valid @RequestBody CatCard card, @PathVariable int id) {
        card.setCatCardId(id);
        try {
            CatCard catCard = catCardDao.updateCatCard(card);
            return catCard;
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Catcard not found.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public void deleteCatCardById(@PathVariable int id) {
        catCardDao.deleteCatCardById(id);
    }


}

