package com.saloni.carorganizer.controller;

import com.saloni.carorganizer.model.Manufacturer;
import com.saloni.carorganizer.service.ManufacturerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ManufacturerController.class)
class ManufacturerControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ManufacturerService manufacturerService;

  @Test
  public void getModels() throws Exception {
    Mockito.when(manufacturerService.getAllModels(anyLong())).thenReturn(Manufacturer.builder().build());
    this.mockMvc
        .perform(get("/manufacturer/1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }


}
