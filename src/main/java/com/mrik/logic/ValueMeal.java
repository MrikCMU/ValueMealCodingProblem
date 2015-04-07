package com.mrik.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ValueMeal {
	public void insertValues(String restaurantId, String labelName, Double price);



	public String getMostValueMeal(Set<Integer> restaurantIds,
			List<String> mealLabelList);
	

}
