
package com.app.recruitingApp.util;

import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sgtomar
 */
public class TestData {
    
    public static Offer getOffer(){
        Offer offer = new Offer();
        offer.setJobTitle("Software Engineer");
        offer.setStartDate(new Date());
        return offer;
    }
    public static Application getApplication(){
        Application application = new Application();
        application.setApplicationStatus(ApplicationStatus.APPLIED.name());
        application.setCandidateEmail("test@test.com");
        application.setResumeText("XYZ XYZ");
        return application;
    }
    public static Offer getOfferforService(){
        Offer offer = new Offer();
        offer.setJobTitle("Software Engineer");
        offer.setStartDate(new Date());
        List<Application> applications=new ArrayList<Application>();
        applications.add(getApplicationforService());
        offer.setApplications(applications);
        return offer; 
    }
    public static Application getApplicationforService(){
        Application application = new Application();
        application.setOffer(TestData.getOffer());
        application.setApplicationId(123);
        application.setApplicationStatus(ApplicationStatus.APPLIED.name());
        application.setCandidateEmail("test@test.com");
        application.setResumeText("XYZ XYZ");
        return application;
    }
}
