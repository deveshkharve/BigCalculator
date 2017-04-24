package com.service;

public class DivisionCalculator {

	private StringBuilder quotient = new StringBuilder();
	int exponent;
	long divCounter;
	private int carry;
	private StringBuilder input1, input2;
	
	public String computeDivision(String ip1, String ip2) throws Exception{
		String output = null;
		boolean doubleComputation = true;
		try {
			double input1 = Double.parseDouble(ip1);
			double input2 = Double.parseDouble(ip2);
			output = String.valueOf(input1/input2);
		} catch (Exception e) {
			doubleComputation = false;
			System.out.println("cannot be handled in variables");
		}
		
		if(false == output.equals("NaN") &&  true == doubleComputation){
			return  output;
		}
		
		setInputs(ip1, ip2);
		handleInputForDivision(true);
		boolean divisibilityFlag = checkInputs(input1, input2);
		if(false == divisibilityFlag){
			this.input1.append("0");
			quotient.append("0");
		}
		
		StringBuilder temp = input1;
		while(divisibilityFlag){
			temp = subtract(temp, input2);
			counter();
			divisibilityFlag = checkInputs(temp, input2);
		}
		
//		for(int i =0; i< dec; i++){
//			temp.append("0");
//		}
//		
		
		return quotient+String.valueOf(divCounter)+" e"+exponent;
	}
	
	/**
	 * handle input Strings, inputs should be of same length
	 * @param updateQuotient, update quotient when divisor is greater than dividend
	 * @return false if divisor is greater than dividend else true  
	 */
	private void handleInputForDivision(boolean updateQuotient)throws Exception{
		int counter = 0;
		StringBuilder temp = new StringBuilder();
		int ip1Length = input1.length();
		int ip2Length = input2.length();
		
		if(ip1Length >  ip2Length){
			if( ip1Length - ip2Length > 10)
			for(int i =0 ; i < ip1Length - ip2Length-3; i++){
				input2.append("0");
				exponent++;
			}
			
			for(int i =0 ; i < input1.length() - input2.length(); i++){
				temp.append("0");
			}
			input2 = temp.append(input2);
		}
		
		if(ip1Length <  ip2Length){
			for(int i =0 ; i < ip2Length - ip1Length; i++){
				input1.append("0");
				counter++;
			}
		}
//		while(input1.length() !=  ip2Length){
//			input1.append("0");
//			counter++;
//		}

		if(0 != counter && updateQuotient){
			quotient.append(".");
			counter --;
			while(0 != counter){
				quotient.append("0");
				counter--;
			}
		}
	}
	
	private void setInputs(String ip1, String ip2){
		
		this.input1 = new StringBuilder(ip1);
		this.input2 = new StringBuilder(ip2);
	}
	
	/**
	 * check input1 is greater than input2
	 * @param input1
	 * @param input2
	 * @return
	 */
	private boolean checkInputs(StringBuilder input1, StringBuilder input2)throws Exception{
		
		int index = 0;
		int length = input1.length();
		boolean divisibilityFlag = true;
		if(input1.equals(input2)){
			return true;
		}
		while(true && index < length){
			
			if(input1.charAt(index) > input2.charAt(index)){
				return true;
			}
			else if(input1.charAt(index) == input2.charAt(index)){
				index++;
			}
			else{
				divisibilityFlag = false;
				break;
			}
		}
		return divisibilityFlag;
	}
	
	private void counter(){
		divCounter++;		
	}
	
	private StringBuilder subtract(StringBuilder input1, StringBuilder input2)throws Exception{
		
		int input1Length = input1.length();
		StringBuilder diff = new StringBuilder();
		for(int i = 0; i< input1Length; i++){
			int a = Integer.parseInt( String.valueOf((input1.charAt(input1Length- i -1))));
			int b = Integer.parseInt( String.valueOf((input2.charAt(input1Length- i -1))));
			if(1 == carry){
				a = a-1;
				carry = 0;
			}
			if(a < b){
				a = a+10;
				carry = 1;
			}
			diff.append(String.valueOf(a-b).charAt(0));
		}
		
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < input1Length - diff.length(); i++){
			temp.append("0");
		}
		diff = temp.append(diff.reverse());
		if(diff.length() != input1Length){
			System.out.println("error");
			throw new Exception("unwanted error");
		}
		
		return diff;
	}

}
