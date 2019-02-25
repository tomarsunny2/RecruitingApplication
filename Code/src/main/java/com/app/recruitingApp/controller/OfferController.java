package com.app.recruitingApp.controller;

import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.service.OfferService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sgtomar
 */
@RestController
@RequestMapping("/offers")
public class OfferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    OfferService offerService;

    /**
     * Method to add Offer details
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Offer addOffer(@RequestBody Offer offer) {
        return offerService.add(offer);
    }

    /**
     * Method to get All Offers details
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Offer> getOffers() {
        return (List<Offer>) offerService.list();
    }

    /**
     * Method to get particular Offer details
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Offer getOfferByID(@PathVariable("id") Integer offerId) {
        return offerService.get(offerId);
    }
}
