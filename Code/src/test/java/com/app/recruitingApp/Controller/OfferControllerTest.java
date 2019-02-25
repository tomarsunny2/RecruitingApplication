
package com.app.recruitingApp.Controller;

import com.app.recruitingApp.controller.OfferController;
import com.app.recruitingApp.exception.OfferNotFoundException;
import com.app.recruitingApp.model.Offer;
import com.app.recruitingApp.service.OfferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author sgtomar
 */

@RunWith(SpringRunner.class)
@WebMvcTest(OfferController.class)
public class OfferControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OfferService offerService;

    @Test
    public void givenOffer_whenGetOffer_thenReturnJson()
            throws Exception {

        Offer offer = new Offer();
        offer.setJobId(123);
        offer.setJobTitle("Software Engineer");
        offer.setStartDate(new Date());

        given(offerService.get(123)).willReturn(offer);

        mvc.perform(get("/offers/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jobTitle", is(offer.getJobTitle())))
                .andExpect(jsonPath("$.numberOfApplications",is(offer.getNumberOfApplications())));
    }

    @Test
    public void givenOffer_whenGetOffer_thenReturnErrorJson()
            throws Exception {

        given(offerService.get(123)).willThrow(new OfferNotFoundException("Offer not found."));

        mvc.perform(get("/offers/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error_code", is("NOT_FOUND")))
                .andExpect(jsonPath("$.user_message",is("Offer not found.")));
    }
}
