package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.repo.FoodRepo;
@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	public Food fetchFoodById(int foodId) {
		Optional<Food> food=foodRepo.findById(foodId);
		if(food.isPresent()) {
			return food.get();
		}
		return null;
	}
	public Food updateFoodById(int oldFoodId,Food newFood) {
		newFood.setFoodId(oldFoodId);
		return foodRepo.save(newFood);
	}
	public Food deleteFoodById(int foodId) {
		Food food=fetchFoodById(foodId);
		foodRepo.delete(food);
		return food;
	}
	public List<Food> fetchAllFood(){
		return foodRepo.findAll();
	}
	

}
