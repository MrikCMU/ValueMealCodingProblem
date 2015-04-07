package com.mrik.sol;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.mrik.logic.ValueMeal;
import com.mrik.logic.ValueMealImpl;
import com.mrik.reader.ReadFile;
import com.mrik.reader.ReaderCSV;


/**
 * Mrikondu
 *
 */
public class App 
{

	static Set<Integer> restaurantIds;
	static List<String> mealLabelList;
	public static ValueMeal valueMeal;
	public static void main( String[] args )
	{

		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();

		if (args.length < 2) {
			System.err.println("enter args as <dataFile> <menuItems> ....");
			return;
		}
		for (int i = 1; i < args.length; i++) {
			mealLabelList.add(args[i]);
		}
		ReadFile reader = null;
		String [] nextLine;
		try {
			valueMeal = new ValueMealImpl();
			reader = new ReaderCSV(args[0]);
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine.length > 2) {
					//Enter values only needed for calculating the value meal to reduce space
					for (int j=2;j<nextLine.length;j++) {
						if (mealLabelList.contains(nextLine[j].trim())) {
							restaurantIds.add(Integer.parseInt(nextLine[0]));
							valueMeal.insertValues(nextLine[0], nextLine[j].trim(), Double.valueOf(nextLine[1].trim()));
						}
					}
				} else {
					System.err.println("Line error with Id : " + nextLine[0]);
				}
			}
			String valueMealStr = valueMeal.getMostValueMeal(restaurantIds, mealLabelList);
			System.out.println(valueMealStr);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public String getTest() {
		return "Success";
	}



}

