package com.sj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.model.FoodItem;
import com.sj.service.FoodService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/web")
@RestController
public class FoodController {
	
	@Autowired
	FoodService service;
	
	@GetMapping("/foods")
	public List<FoodItem> getFoodItem(){
		return service.getAllFoodItem();
		
	}
	
	@GetMapping("/foods/{id}")
	public FoodItem getFoodItemById(@PathVariable int id) {
		return service.getFoodItemById(id);
	}

	@PutMapping("/foods")
	public FoodItem addFood(@RequestBody FoodItem food) {
		return service.addFoodItem(food);
		
	}
	
	@GetMapping("/foods/afterDelete/{id}")
	public List<FoodItem> deleteFood(@PathVariable int id) {
		service.deleteFoodItem(id);
		return service.getAllFoodItem();
	}
	
	@PostMapping("/foods")
	public FoodItem updateFood(@RequestBody FoodItem f) {
		return service.updateFoodItem(f);
		
	}
}
