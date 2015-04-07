package com.mrik.reader;

import java.io.FileNotFoundException;

import com.mrik.sol.App;

import junit.framework.TestCase;

public class ReadFileTest extends TestCase {

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPositiveRead() throws Exception
    {
    	
    	ReaderCSV read = new ReaderCSV("sample_data.csv");
    	
    	assertEquals(12, read.readAll().size());
    }
	public void testException() 
    {
    	
		try {
			new ReaderCSV("samplde_data.csv");
		} catch (Exception ex) {
			assertTrue(ex instanceof FileNotFoundException);
		}
    }

}
