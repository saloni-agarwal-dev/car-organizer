package com.saloni.carorganizer.service;

import com.saloni.carorganizer.model.Manufacturer;
import com.saloni.carorganizer.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManufacturerService {

  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public Manufacturer getAllModels(final long manufacturerId) {
    return manufacturerRepository
        .findById(manufacturerId).orElse(Manufacturer.builder().build());
  }

}
