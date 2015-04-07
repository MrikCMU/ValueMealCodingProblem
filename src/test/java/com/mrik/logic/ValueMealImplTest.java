package com.mrik.logic;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ValueMealImplTest extends TestCase {
	

	public Set<Integer> restaurantIds;
	public List<String> mealLabelList;

	protected static void tearDownAfterClass() throws Exception {
	}
	public ValueMealImplTest( String testName )
    {
        super( testName );
    }
	public static Test suite()
    {
        return new TestSuite( ValueMealImplTest.class );
    }

	protected void setUp() throws Exception {

		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
     * Rigourous Test :-)
     */
	
	public void testInsertMapWithLowestValue() {

    	ValueMealImpl app = new ValueMealImpl();
    	app.insertValues("1", "burger", 5.0);
		app.insertValues("1", "burger", 1.0);
		app.insertValues("1", "burger", 3.0);
    	assertEquals(1.0, app.getMapOfRestaurantIdMealsWithValues().get("1:burger"));
    }
  
    public void testValueMealForRestaurant2()
    {
    	ValueMealImpl app = new ValueMealImpl();

		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();
		mealLabelList.add("burger");
		mealLabelList.add("burger2");
		restaurantIds.add(1);
		restaurantIds.add(2);
		app.insertValues("1", "burger", 5.0);
		app.insertValues("2", "burger", 1.0);
		app.insertValues("2", "burger2", 3.0);
    	String meal = app.getMostValueMeal(restaurantIds, mealLabelList);

        assertEquals(meal, "2, 4.0");
    }
    
    public void testValueMealForRestaurantNil()
    {
    	ValueMealImpl app = new ValueMealImpl();
		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();
		mealLabelList.add("burger");
		mealLabelList.add("burger5");
		restaurantIds.add(1);
		restaurantIds.add(2);
		app.insertValues("1", "burger", 5.0);
		app.insertValues("2", "burger", 1.0);
		app.insertValues("2", "burger2", 3.0);
    	String str = app.getMostValueMeal(restaurantIds, mealLabelList);
    	
    	assertEquals(str, "nil");
        
    }

    public void testValueMealForTwoSameItems()
    {
    	ValueMealImpl app = new ValueMealImpl();
		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();
		mealLabelList.add("burger");
		restaurantIds.add(1);
		restaurantIds.add(2);
		app.insertValues("1", "burger", 5.0);
		app.insertValues("2", "burger", 1.0);
		app.insertValues("2", "burger2", 3.0);

    	
		String str = app.getMostValueMeal(restaurantIds, mealLabelList);
    	
    	assertEquals(str, "2, 1.0");

        
        
    }
    public void testEmptyArgsList()
    {
    	ValueMealImpl app = new ValueMealImpl();
		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();

		restaurantIds.add(1);
		restaurantIds.add(2);
		app.insertValues("1", "burger", 5.0);
		app.insertValues("2", "burger", 1.0);
		app.insertValues("2", "burger2", 3.0);

    	
		String str = app.getMostValueMeal(restaurantIds, mealLabelList);
    	
    	assertEquals(str, "nil");

        
        
    }
    
    public void testEmptyLabelsList()
    {
    	ValueMealImpl app = new ValueMealImpl();
		restaurantIds = new TreeSet<Integer>();
		mealLabelList = new ArrayList<String>();
		mealLabelList.add("burger");
		restaurantIds.add(1);
		restaurantIds.add(2);
		
		String str = app.getMostValueMeal(restaurantIds, mealLabelList);
    	
    	assertEquals(str, "nil");

        
        
    }
    
    

}
