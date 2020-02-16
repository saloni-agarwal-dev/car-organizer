package com.saloni.carorganizer.repository;

import com.saloni.carorganizer.model.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturesRepository extends JpaRepository<Features, Long> {
  Features findByName(final String name);
}
