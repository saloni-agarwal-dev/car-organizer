package com.saloni.carorganizer.controller;

import com.saloni.carorganizer.model.ModelDto;
import com.saloni.carorganizer.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "model", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelController {

  @Autowired
  private ModelService modelService;

  @GetMapping(value = "{modelId}/cost")
  public BigDecimal getCost(@PathVariable final long modelId, @RequestParam(required = false) List<Long> featureIds) {
    return modelService.getCost(modelId, featureIds);
  }

  @PostMapping
  public void createModel(@RequestBody final ModelDto modelDto) {
    modelService.createModel(modelDto);
  }

  @PutMapping(value = "{modelId}")
  public void updateModel(@RequestBody final ModelDto modelDto, @PathVariable final long modelId) {
    modelService.updateModel(modelDto, modelId);
  }

  @DeleteMapping(value = "{modelId}")
  public void removeModel(@PathVariable final long modelId) {
    modelService.deleteModel(modelId);
  }
}
