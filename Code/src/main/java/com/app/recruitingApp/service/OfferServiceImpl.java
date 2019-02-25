package com.app.recruitingApp.service;

import com.app.recruitingApp.exception.OfferNotFoundException;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.repository.OfferRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sgtomar
 */
@Service
public class OfferServiceImpl implements OfferService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfferServiceImpl.class);

    @Autowired
    OfferRepository offerRepository;

    @Override
    public Offer get(Integer offerId) {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);
        if (!offerOptional.isPresent()) {
            throw new OfferNotFoundException("Offer not found.");
        }
        return offerOptional.orElse(null);
    }

    @Override
    public Offer add(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer edit(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> list() {
        return (List<Offer>) offerRepository.findAll();
    }

   
}
