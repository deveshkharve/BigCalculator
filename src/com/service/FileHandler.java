package com.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class FileHandler {

	public String getInputFromFile(String fileName) throws Exception{
		BufferedReader br = null;
		FileInputStream fstream = null;
		String inputStr = null;
		// Open the file
		try {
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));
	
			String strLine;

		//Read File Line By Line
		
			if ((strLine = br.readLine()) != null)   {
				inputStr = strLine;
			}
			checkFilesContent(inputStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		finally{
			//Close the input stream
			br.close();
		}
		
		
		return inputStr;
		
	}
	
	public void setOuputToFile(String output){
		
	}
	
	public String checkFilesContent(String content) throws Exception{
		
		if(false == content.matches("[0-9]+")){
			throw new Exception("invalid input");
		}
		return null;
	}
}
