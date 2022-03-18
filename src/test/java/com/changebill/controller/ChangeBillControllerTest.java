package com.changebill.controller;

import com.changebill.service.ChangeCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ChangeBillController.class})
@ExtendWith(SpringExtension.class)
class ChangeBillControllerTest {

    @Autowired
    private ChangeBillController changeBillController;

    @MockBean
    private ChangeCalculatorService changeCalculatorService;

    @Test
    void testGetChange() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{bill}/{minCoin}", 1,
                "Minimumcoin");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.changeBillController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

