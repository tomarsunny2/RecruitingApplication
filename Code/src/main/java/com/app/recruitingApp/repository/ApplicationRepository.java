
package com.app.recruitingApp.repository;
import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sgtomar
 * 
 * ApplicationRepository will manage all database related operation for application
 * 
 */

 @Repository
public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    public List<Application> findByOffer(Offer offer);
}
