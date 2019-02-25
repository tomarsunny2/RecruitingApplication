
package com.app.recruitingApp.repository;

import com.app.recruitingApp.model.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sgtomar
 * 
 * OfferRepository will manage all database related operation for Offer
 * 
 */
@Repository
public interface OfferRepository extends CrudRepository<Offer ,Integer>{
    
}
