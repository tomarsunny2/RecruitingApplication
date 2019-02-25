package com.app.recruitingApp.repository;

import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.util.TestData;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sgtomar
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    OfferRepository offerRepository;

    @Test
    public void whenSaveOffer_thenReturnOfferObject() {

        // Given
        Offer offer = TestData.getOffer();
        entityManager.persist(offer);

        //When
        Offer offerDB = offerRepository.save(offer);

        //Then
        assertThat(offerDB.getJobTitle())
                .isEqualTo(offer.getJobTitle());

        assertThat(offerDB.getStartDate())
                .isEqualTo(offer.getStartDate());

        assertThat(offerDB.getJobId())
                .isEqualTo(offer.getJobId());

        assertThat(offerDB.getNumberOfApplications())
                .isEqualTo(offer.getNumberOfApplications());

    }

    @Test
    public void whenGetOffer_thenReturnOfferObject() {

        // Given
        Offer offer = TestData.getOffer();
        entityManager.persist(offer);

        //When
        Optional<Offer> offerDB = offerRepository.findById(offer.getJobId());

        //Then
        assertThat(offerDB.get().getJobTitle())
                .isEqualTo(offer.getJobTitle());

        assertThat(offerDB.get().getStartDate())
                .isEqualTo(offer.getStartDate());

        assertThat(offerDB.get().getJobId())
                .isEqualTo(offer.getJobId());

        assertThat(offerDB.get().getNumberOfApplications())
                .isEqualTo(offer.getNumberOfApplications());

    }

    @Test
    public void whenGetALLOffer_thenReturnListOfOfferObject() {

        // Given
        Offer offer = TestData.getOffer();
        entityManager.persist(offer);

        //When
        List<Offer> offerDB = (List<Offer>) offerRepository.findAll();

        //Then
        assertThat(!offerDB.isEmpty());
        assertThat(offerDB.get(0).getJobTitle())
                .isEqualTo(offer.getJobTitle());

        assertThat(offerDB.get(0).getStartDate())
                .isEqualTo(offer.getStartDate());

        assertThat(offerDB.get(0).getJobId())
                .isEqualTo(offer.getJobId());

        assertThat(offerDB.get(0).getNumberOfApplications())
                .isEqualTo(offer.getNumberOfApplications());

    }
}
