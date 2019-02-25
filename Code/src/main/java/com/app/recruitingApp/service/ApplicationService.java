
package com.app.recruitingApp.service;

import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;

/**
 *
 * @author sgtomar
 */
public interface ApplicationService {
    Application get(Integer applicationId);
    Application add(Application application);
    Application edit(Application application);
    Iterable<Application> list(Offer offer);
}
