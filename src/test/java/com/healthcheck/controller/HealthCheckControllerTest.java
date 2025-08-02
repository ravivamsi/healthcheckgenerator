package com.healthcheck.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HealthCheckController.class)
class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void gisHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/gis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("GIS"));
    }

    @Test
    void pocHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/poc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("POC"));
    }

    @Test
    void rmdHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/rmd"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("RMD"));
    }

    @Test
    void optionHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/option"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("OPTION"));
    }

    @Test
    void futureHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/future"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("FUTURE"));
    }

    @Test
    void legHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/leg"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("LEG"));
    }

    @Test
    void indexHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/index"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("Index"));
    }

    @Test
    void targetHealthCheck_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/target"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.component").value("Target"));
    }

    @Test
    void allHealthChecks_ShouldReturnHealthyStatus() throws Exception {
        mockMvc.perform(get("/api/health/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"))
                .andExpect(jsonPath("$.total_components").value(8))
                .andExpect(jsonPath("$.healthy_components").value(8))
                .andExpect(jsonPath("$.unhealthy_components").value(0));
    }
} 