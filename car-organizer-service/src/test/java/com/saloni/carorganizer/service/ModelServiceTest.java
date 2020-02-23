package com.saloni.carorganizer.service;

import com.saloni.carorganizer.model.Features;
import com.saloni.carorganizer.model.Manufacturer;
import com.saloni.carorganizer.model.Model;
import com.saloni.carorganizer.model.ModelDto;
import com.saloni.carorganizer.repository.FeaturesRepository;
import com.saloni.carorganizer.repository.ManufacturerRepository;
import com.saloni.carorganizer.repository.ModelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;


public class ModelServiceTest {

  @Mock
  private ModelRepository modelRepository;

  @Mock
  private FeaturesRepository featuresRepository;

  @Mock
  private ManufacturerRepository manufacturerRepository;

  @InjectMocks
  private ModelService modelService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getCost() {
    final Set<Features> featuresSet = new HashSet<>(
        Arrays.asList(
            Features.builder()
                .name("climate control")
                .Id(1L)
                .cost(BigDecimal.ONE)
                .build()
        )
    );

    Mockito.when(modelRepository.findById(anyLong()))
        .thenReturn(Optional.of(Model.builder().baseCost(BigDecimal.ONE).name("i3")
            .features(featuresSet).build()));
    final BigDecimal totalCost = modelService.getCost(1L, Arrays.asList(1L));
    Assertions.assertThat(totalCost).isEqualTo(new BigDecimal(2));
  }

  @Test
  void createModel() {
    final Manufacturer manufacturer = Manufacturer.builder()
        .city("amsterdam")
        .id(1L)
        .name("BMW")
        .models(new ArrayList<>())
        .build();
    Mockito.when(manufacturerRepository.findByName(anyString())).thenReturn(manufacturer);

    modelService.createModel(ModelDto
        .builder()
        .baseCost(new BigDecimal(35000))
        .manufacturerName("BMW")
        .modelName("i5")
        .featureNameList(Collections.emptyList())
        .build());

    Assertions.assertThat(manufacturer.getModels().size()).isEqualTo(1);
  }

  @Test
  void updateModel() {
    final Model model = Model.builder()
        .name("i3")
        .baseCost(new BigDecimal(35000))
        .features(new HashSet<>())
        .Id(1L)
        .build();
    Mockito.when(modelRepository.findById(anyLong())).thenReturn(Optional.of(model));

    modelService.updateModel(ModelDto
        .builder()
        .baseCost(new BigDecimal(40000))
        .manufacturerName("BMW")
        .modelName("i3")
        .featureNameList(Collections.emptyList())
        .build(), 1L);

    Assertions.assertThat(model.getBaseCost()).isEqualTo(new BigDecimal(40000));
  }
}
