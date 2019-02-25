
package com.app.recruitingApp.repository;

import com.app.recruitingApp.model.Application;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author sgtomar
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ApplicationRepository applicationRepository;

    @Test
    public void whenGetByApplicationId_thenReturnApplicationObject(){

        // Given
        Offer offer =TestData.getOffer();
        entityManager.persist(offer);

        Application application = TestData.getApplication();
        application.setOffer(offer);
        application = entityManager.persistAndFlush(application);

        //When
        Optional<Application> applicationDB= applicationRepository.findById(application.getApplicationId());

        //Then
        assertThat(applicationDB.get().getCandidateEmail())
                .isEqualTo(application.getCandidateEmail());

        assertThat(applicationDB.get().getResumeText())
                .isEqualTo(application.getResumeText());

        assertThat(applicationDB.get().getApplicationId())
                .isEqualTo(application.getApplicationId());

        assertThat(applicationDB.get().getApplicationStatus())
                .isEqualTo(application.getApplicationStatus());

        assertThat(applicationDB.get().getOffer())
                .isEqualTo(application.getOffer());
    }
    
    @Test
    public void whenGetByOfferId_thenReturnListApplicationObject(){

        // Given
        Offer offer =TestData.getOffer();
        entityManager.persist(offer);

        Application application = TestData.getApplication();
        application.setOffer(offer);
        application = entityManager.persistAndFlush(application);

        //When
        List<Application> applicationDB= applicationRepository.findByOffer(offer);

        //Then
        assertThat(!applicationDB.isEmpty());
        assertThat(applicationDB.get(0).getCandidateEmail())
                .isEqualTo(application.getCandidateEmail());

        assertThat(applicationDB.get(0).getResumeText())
                .isEqualTo(application.getResumeText());

        assertThat(applicationDB.get(0).getApplicationId())
                .isEqualTo(application.getApplicationId());

        assertThat(applicationDB.get(0).getApplicationStatus())
                .isEqualTo(application.getApplicationStatus());

        assertThat(applicationDB.get(0).getOffer())
                .isEqualTo(application.getOffer());
    }
    
    @Test
    public void whenSaveApplication_thenReturnApplicationObject(){

        // Given
        Offer offer =TestData.getOffer();
        entityManager.persist(offer);

        Application application = TestData.getApplication();
        application.setOffer(offer);
        application = entityManager.persistAndFlush(application);

        //When
        Application applicationDB= applicationRepository.save(application);

        //Then
        assertThat(applicationDB.getCandidateEmail())
                .isEqualTo(application.getCandidateEmail());

        assertThat(applicationDB.getResumeText())
                .isEqualTo(application.getResumeText());

        assertThat(applicationDB.getApplicationId())
                .isEqualTo(application.getApplicationId());

        assertThat(applicationDB.getApplicationStatus())
                .isEqualTo(application.getApplicationStatus());

        assertThat(applicationDB.getOffer())
                .isEqualTo(application.getOffer());
    }
}
