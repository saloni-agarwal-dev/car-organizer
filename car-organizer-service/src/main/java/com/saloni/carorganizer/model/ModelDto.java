package com.saloni.carorganizer.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ModelDto {
  private final Long id;
  private final String manufacturerName;
  private final String modelName;
  private final BigDecimal baseCost;
  private final List<String> featureNameList;
}
