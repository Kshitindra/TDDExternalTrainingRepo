package com.wf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GameEngine {
	
	private Map<String, String> outputMap;
	
	public GameEngine(){
		outputMap = new HashMap<>();
		outputMap.put("2", Messages.EVEN);
		outputMap.put("3", Messages.HOT);
		outputMap.put("5", Messages.HOTTER);
		outputMap.put("23", Messages.EVEN_HOT);
		outputMap.put("25", Messages.EVEN_HOTTER);
		outputMap.put("35", Messages.HOT_AND_HOTTER);
		outputMap.put("235", Messages.EXTREMELY_HOT);
	}
	
	/*
	 * This method takes an integer as a parameter. It then validates the number.
	 * It then chjecks if the number is divisible by 3.
	 * Checks if divisble by 5.
	 * THen go and sleep
	 * */
	public Object play(int num) {
		validateNumber(num);
		Object output = num;
		Iterator<String> keys = outputMap.keySet().iterator();
		while(keys.hasNext()){
			String keyText = keys.next();
			if(keyText.length() == 1){
				int keyNum = Integer.parseInt(keyText);
				if(num % keyNum == 0)
					output = outputMap.get(keyNum+"");
			}
			else{
				output = checkMultipleFactorDivisibility(num, output, keyText);
			}
		}
		return output;
	}

	private void validateNumber(int num) {
		if(num == 0)
			throw new GameEngineException("Invalid Number");
	}
	private Object checkMultipleFactorDivisibility(int num, Object output, String keyText) {
		int first = Integer.parseInt(keyText.substring(0,1));
		int second = Integer.parseInt(keyText.substring(1,2));
		if(keyText.length() == 2){
			if(checkDivisibilityBy(num, first) && checkDivisibilityBy(num, second))
				output = outputMap.get(keyText);
		}
		else{
			int third = Integer.parseInt(keyText.substring(2,3));
			if(checkDivisibilityBy(num, first) && checkDivisibilityBy(num, second) && checkDivisibilityBy(num, third))
				output = outputMap.get(keyText);
		}
		return output;
	}
	private boolean checkDivisibilityBy(int number,int factor){
		return number % factor == 0;
	}
	public Map<String, String> getOutputMap() {
		return outputMap;
	}

}











