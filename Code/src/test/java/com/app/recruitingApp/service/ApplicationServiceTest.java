package com.app.recruitingApp.service;

import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.repository.ApplicationRepository;
import com.app.recruitingApp.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author sgtomar
 */
@RunWith(SpringRunner.class)
public class ApplicationServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public ApplicationService applicationService() {
            return new ApplicationServiceImpl();
        }
    }

    @Autowired
    private ApplicationService applicationService;

    @MockBean
    private ApplicationRepository applicationRepository;

    @Test
    public void whenValidID_thenApplicationShouldBeFound() {
        //Setup
        Application application = TestData.getApplicationforService();
        Mockito.when(applicationRepository.findById(application.getApplicationId()))
                .thenReturn(Optional.of(application));
        //When
        Application application1 = applicationService.get(123);
        //Then
        assertThat(application1.getApplicationId())
                .isEqualTo(123);
    }

    @Test
    public void whenAddApplication_thenApplicationSaved() {
        //Setup
        Application application = TestData.getApplicationforService();

        Mockito.when(applicationRepository.save(application))
                .thenReturn(application);
        //When
        Application application1 = applicationService.add(application);
        //Then
        assertThat(application1.getApplicationId())
                .isEqualTo(123);
    }

    @Test
    public void whenUpdateApplication_thenReturnApplicationUpdatedObject() {
        //Setup
        Application application = TestData.getApplicationforService();
        application.setCandidateEmail("updated@test.com");
        Mockito.when(applicationRepository.save(application))
                .thenReturn(application);
        //When
        Application application1 = applicationService.edit(application);
        //Then
        assertThat(application1.getCandidateEmail())
                .isEqualTo("updated@test.com");
    }

    @Test
    public void whenListApplication_thenReturnListOfApplicationObject() {
        //Setup

        Offer offer = TestData.getOfferforService();
        Mockito.when(applicationRepository.findByOffer(offer))
                .thenReturn(offer.getApplications());
        //When
        List<Application> application1 = (List<Application>) applicationService.list(offer);
        //Then
        assertThat(application1.get(0).getApplicationId())
                .isEqualTo(123);
    }
}
