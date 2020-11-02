package com.sj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sj.model.FoodItem;

@Repository
public interface FoodRepository extends JpaRepository<FoodItem, Integer> {

}
