package com.sj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.model.FoodItem;
import com.sj.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository dao;

	public List<FoodItem> getAllFoodItem() {
		
		return dao.findAll();
	}
	
	public FoodItem getFoodItemById(int id) {
		Optional<FoodItem> food = dao.findById(id);
		return food.get();
		
	}
	
	public FoodItem addFoodItem(FoodItem food) {
		return dao.save(food);
		
	}
	
	public void deleteFoodItem(int id) {
		dao.deleteById(id);
		
	}
	public FoodItem updateFoodItem(FoodItem food) {
		Optional<FoodItem> update =dao.findById(food.getId());
		FoodItem fi = update.get();
		fi.setPrice(food.getPrice());
		return dao.save(food);
	}

}
