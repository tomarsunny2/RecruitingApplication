package com.app.recruitingApp.controller;

import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.service.ApplicationService;
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
@RequestMapping("/offers/{offer_id}/applications")
public class ApplicationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private OfferService offerService;

    /**
     * Method to Add Application which is associated
     * to particular offer
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Application addApplication(@RequestBody Application application, @PathVariable("offer_id") Integer offerId) {
        Offer offer = offerService.get(offerId);
        application.setOffer(offer);
        return applicationService.add(application);
    }

    /**
     * Method to Get All Application details which is associated
     * to particular offer
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Application> getApplication(@PathVariable("offer_id") Integer offerId) {
        Offer offer = offerService.get(offerId);
        return (List<Application>) applicationService.list(offer);
    }
    
    /**
     * Method to Get Particular Application details which is associated
     * to particular offer
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Application getApplicationByID(@PathVariable("id") Integer applicationID) {
        return applicationService.get(applicationID);
    }

     /**
     * Method to update Particular Application details which is associated
     * to particular offer
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Application updateApplicationByID(@RequestBody Application application, @PathVariable("offer_id") Integer offerId, @PathVariable("id") Integer applicationID) {
        Offer offer = offerService.get(offerId);
        application.setOffer(offer);
        application.setApplicationId(applicationID);
        return applicationService.edit(application);
    }
}
