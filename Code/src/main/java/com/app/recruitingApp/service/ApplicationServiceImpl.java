package com.app.recruitingApp.service;

import com.app.recruitingApp.exception.ApplicationNotFoundException;
import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.repository.ApplicationRepository;
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
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application get(Integer applicationId) {
        Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
        if (!applicationOptional.isPresent()) {
            throw new ApplicationNotFoundException("Application not found.");
        }
        return applicationOptional.orElse(null);
    }

    @Override
    public Application add(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application edit(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> list(Offer offer) {
        return applicationRepository.findByOffer(offer);
    }

}
