package com.service;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		try {
			
			String input1 =fh.getInputFromFile("input1.txt");
			String input2 = fh.getInputFromFile("input2.txt");
			System.out.println("dividend = "  + input1 );
			System.out.println("divisor = " + input2);
			DivisionCalculator d = new DivisionCalculator();
		
			System.out.println(d.computeDivision(input1, input2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
