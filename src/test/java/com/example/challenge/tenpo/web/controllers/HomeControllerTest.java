package com.example.challenge.tenpo.web.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(HomeController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnOkWhenHomeIsCalled() throws Exception {
        // Given user is equals to test
        // When home is called
        MvcResult result = mvc.perform(get("/").accept(APPLICATION_JSON)).andReturn();

        // Expect Ok
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus(), equalTo(200));
    }

    @Test
    void shouldReturnDefaultMessageWhenHomeIsCalled() throws Exception {
        // Given user is equals to test
        // When home is called
        MvcResult result = mvc.perform(get("/").accept(APPLICATION_JSON)).andReturn();

        // Expect Ok
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getContentAsString(), equalTo("Hello world!"));
    }

    @WithMockUser(username = "test")
    @Test
    void shouldReturnDefaultMessageWhenSecuredIsCalled() throws Exception {
        // Given user is equals to test
        // When is called
        MvcResult result = mvc.perform(get("/secured").accept(APPLICATION_JSON)).andReturn();

        // Expect Ok
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getContentAsString(), equalTo("Hello secured world!"));
    }

    @Test
    void shouldReturnUnauthorizedWhenSecuredIsCalledWithNoCredentials() throws Exception {
        // Given user is equals to test
        // When is called
        MvcResult result = mvc.perform(get("/secured").accept(APPLICATION_JSON)).andReturn();

        // Expect Ok
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus(), equalTo(403));
        assertThat(response.getErrorMessage(), equalTo("Access Denied"));
    }
}
