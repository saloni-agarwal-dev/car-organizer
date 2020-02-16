package com.saloni.carorganizer.service;

import com.saloni.carorganizer.model.Features;
import com.saloni.carorganizer.model.Model;
import com.saloni.carorganizer.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ModelService {

  @Autowired
  private ModelRepository modelRepository;

  public BigDecimal getCost(final Long modelId, final List<Long> featureIds) {
    Model model = modelRepository.findById(modelId).orElse(Model.builder().build());
    Set<Features> featuresSet = model.getFeatures();

    if (featureIds != null) {
      return featureIds.stream()
          .map(aLong -> featuresSet.stream().filter(feature -> feature.getId() == aLong).findFirst().get().getCost())
          .reduce(model.getBaseCost(), (subtotal, element) -> subtotal.add(element));
    }
    return model.getBaseCost();
  }

}
