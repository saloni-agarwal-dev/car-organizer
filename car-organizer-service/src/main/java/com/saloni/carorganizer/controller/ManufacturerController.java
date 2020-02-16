package com.saloni.carorganizer.controller;

import com.saloni.carorganizer.model.Manufacturer;
import com.saloni.carorganizer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manufacturer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerController {

  @Autowired
  private ManufacturerService manufacturerService;

  @GetMapping(value = "{manufacturerId}")
  public Manufacturer getModels(@PathVariable final long manufacturerId) {
    return manufacturerService.getAllModels(manufacturerId);
  }

}
