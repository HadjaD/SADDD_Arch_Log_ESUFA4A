package com.esiea.tp4A;

import com.esiea.tp4A.api.JeuGestion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = JeuGestion.class)
@AutoConfigureMockMvc
public class RequestHandlerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void createPlayerOnUnknownGame() throws Exception {
        this.mockMvc.perform(post("/api/session/unknown/player/rover"))
            .andExpect(status().isNotFound());
    }


    @Test
    public void GetUnknownPlayer() throws Exception{
        this.mockMvc.perform(post("/api/session/sixth"));
        this.mockMvc.perform(get("/api/session/sixth/player/rover"))
            .andExpect(status().isNotFound());
    }


    @Test
    public void moveUnknownPlayer() throws Exception{
        this.mockMvc.perform(post("/api/session/eighth"));
        this.mockMvc.perform(patch("/api/session/eighth/player/rover/r"))
            .andExpect(status().isNotFound());
    }



}
