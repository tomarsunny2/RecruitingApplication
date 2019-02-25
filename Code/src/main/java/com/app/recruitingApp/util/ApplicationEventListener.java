package com.app.recruitingApp.util;

import com.app.recruitingApp.model.Application;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sgtomar
 *
 * ApplicationEventListener will manage application status Change Event.
 *
 */
public class ApplicationEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListener.class);

    /**
     * Method to log application status change event
     */
    @PostUpdate
    public void preUpdateEvent(Object o) {
        if (o instanceof Application) {
            Application application = (Application) o;
            LOGGER.info("############## Status of application#{} changed to {}", application.getApplicationId(), application.getApplicationStatus());
        }
    }

    /**
     * Method to set application status as APPLIED before Insert Event
     */
    @PrePersist
    public void preInsertEvent(Object o) {
        if (o instanceof Application) {
            Application application = (Application) o;
            if (application.getApplicationId() == null) {
                application.setApplicationStatus(ApplicationStatus.APPLIED.name());
            }
        }
    }
}
