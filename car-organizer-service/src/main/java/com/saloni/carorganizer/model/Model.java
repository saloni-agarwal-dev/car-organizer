package com.saloni.carorganizer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column
  private String name;

  @Column(name = "base_cost")
  private BigDecimal baseCost;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "Model_Features",
      joinColumns = {@JoinColumn(name = "model_id")},
      inverseJoinColumns = {@JoinColumn(name = "feature_id")}
  )
  private Set<Features> features = new HashSet<>();
}
