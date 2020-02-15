package com.saloni.carorganizer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column
  private String name;

  @Column(name = "base_cost")
  private String baseCost;

  @ManyToOne
  @JoinColumn(name = "manufacturer_id",nullable = false)
  private Manufacturer manufacturer;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
              name="Model_Features",
              joinColumns = {@JoinColumn(name = "model_id")},
              inverseJoinColumns = {@JoinColumn(name = "features_id")}
            )
  private Set<Features> features = new HashSet<>();


}
