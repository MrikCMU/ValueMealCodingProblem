package com.mrik.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class ReaderCSV implements ReadFile {
	
	private CSVReader reader = null;
	
	public ReaderCSV(String file) throws FileNotFoundException {
		reader = new CSVReader(new FileReader(file));
	}

	public String[] readNext() throws IOException {
		return reader.readNext();
	}
	
	public List<String[]> readAll() throws IOException {
		return reader.readAll();
	}

}
