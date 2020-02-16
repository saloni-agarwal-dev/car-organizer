package com.saloni.carorganizer.service;

import com.saloni.carorganizer.model.Features;
import com.saloni.carorganizer.model.Manufacturer;
import com.saloni.carorganizer.model.Model;
import com.saloni.carorganizer.model.ModelDto;
import com.saloni.carorganizer.repository.FeaturesRepository;
import com.saloni.carorganizer.repository.ManufacturerRepository;
import com.saloni.carorganizer.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class ModelService {

  @Autowired
  private ModelRepository modelRepository;

  @Autowired
  private FeaturesRepository featuresRepository;

  @Autowired
  private ManufacturerRepository manufacturerRepository;

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

  public void createModel(final ModelDto modelDto) {
    final Model model = Model.builder()
        .baseCost(modelDto.getBaseCost())
        .name(modelDto.getModelName())
        .features(createFeatures(modelDto))
        .build();

    final Manufacturer manufacturer =
        manufacturerRepository.findByName(modelDto.getManufacturerName());

    final List<Model> models = Stream.concat(manufacturer.getModels().stream(), Arrays.asList(model).stream())
        .collect(Collectors.toList());

    manufacturer.getModels().clear();
    manufacturer.getModels().addAll(models);
  }

  private Set<Features> createFeatures(final ModelDto modelDto) {
    return modelDto.getFeatureNameList()
        .stream()
        .map(s -> featuresRepository.findByName(s))
        .collect(Collectors.toSet());
  }

}
