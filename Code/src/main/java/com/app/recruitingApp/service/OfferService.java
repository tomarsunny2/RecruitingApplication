
package com.app.recruitingApp.service;

import com.app.recruitingApp.model.Offer;

/**
 *
 * @author sgtomar
 */
public interface OfferService {
    Offer get(Integer offerId);
    Offer add(Offer offer);
    Offer edit(Offer offer);
    Iterable<Offer> list();
}
