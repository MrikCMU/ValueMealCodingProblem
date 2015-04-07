package com.mrik.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ValueMealImpl implements ValueMeal {
	
	private HashMap<String, Double> mapOfRestaurantIdMealsWithValues = new HashMap<String, Double>();
	public HashMap<String, Double> getMapOfRestaurantIdMealsWithValues() {
		return mapOfRestaurantIdMealsWithValues;
	}

	private HashMap<Integer, Double> mapOfValueMealRestaurantIdMealsWithValues = new HashMap<Integer, Double>();


	


	private void insertIntoMap(String key, double val) {
		// TODO Auto-generated method stub
		if(mapOfRestaurantIdMealsWithValues.containsKey(key)) {
			double newVal = val;
			double currVal = mapOfRestaurantIdMealsWithValues.get(key);
			if (newVal < currVal) {
				mapOfRestaurantIdMealsWithValues.put(key, newVal);
			}
		} else {
			mapOfRestaurantIdMealsWithValues.put(key, val);
			
		}
	}

	public void insertValues(String restaurantId, String labelName, Double price) {
		// TODO Auto-generated method stub
		String key = restaurantId+":"+labelName;
		insertIntoMap(key, price);
	}

	public String getMostValueMeal(Set<Integer> restaurantIds,
			List<String> mealLabelList) {
		String returnStr = "";
		// TODO Auto-generated method stub
		Iterator<Integer> restaurantIterator=restaurantIds.iterator();
		while(restaurantIterator.hasNext()){
			int restaurantId=restaurantIterator.next();
			double total = 0.0;
			for (String mealLabel:mealLabelList) {
				{
					if (mapOfRestaurantIdMealsWithValues.containsKey(restaurantId+":"+mealLabel)) {
						total += mapOfRestaurantIdMealsWithValues.get(restaurantId+":"+mealLabel);
						mapOfValueMealRestaurantIdMealsWithValues.put(restaurantId, total);
					} else {
						mapOfValueMealRestaurantIdMealsWithValues.remove(restaurantId);
						break;
					}
				}

			}
		}
		
		Map<Double, Integer> map = reverseAndSort(mapOfValueMealRestaurantIdMealsWithValues);
		
		if (map.size() < 1) {
			returnStr = "nil";
		}
		//Displaying the first value
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			returnStr = pair.getValue() + ", " + pair.getKey();
			it.remove();
			break;
		}
		return returnStr;
	}

	private Map<Double, Integer> reverseAndSort(
			HashMap<Integer, Double> mapOfValueMealRestaurantIdMealsWithValues2) {
		//reversing value and key
		Map<Double, Integer> myNewHashMap = new HashMap<Double, Integer>();
		for(Map.Entry<Integer, Double> entry : mapOfValueMealRestaurantIdMealsWithValues.entrySet()){
			myNewHashMap.put(entry.getValue(), entry.getKey());
		}
		//sorting according to value
		Map<Double, Integer> map = new TreeMap<Double, Integer>(myNewHashMap);
		return map;
	}

}
