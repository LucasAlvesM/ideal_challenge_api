package com.ideal.quote.controller;

import com.ideal.quote.domain.quote.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class QuoteControllerTest {
        @Autowired
        private MockMvc mvc;

        @Autowired
        private JacksonTester < DadosQuoteRegister > dadosQuoteRegisterJson;

        @Autowired
        private JacksonTester< DadosQuoteDetails > dadosQuoteDetailsJson;

        @MockBean
        private QuoteRepository repository;

        @Test
        @DisplayName ("Should return http code 400 when information is invalid")
        @WithMockUser
        void register_first_scenario() throws Exception {
        var response = mvc
                .perform(post("/quotes"))
                .andReturn().getResponse();
        assertThat(response.getStatus(), equalTo(HttpStatus.BAD_REQUEST.value()));
        }

}