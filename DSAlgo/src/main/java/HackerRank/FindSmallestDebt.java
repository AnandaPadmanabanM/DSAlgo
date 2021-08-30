package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestDebt {

	/*
	 * input-String array
	 * output- list<String> name
	 * Constraint - o(n)
	 * 
	 * 
	 */

	@Test
	public void test1(){
		String input[]={"Alex Blake 2","Blake Alex 2","Casey Alex 5", "Blake Casey 7","Alex  Blake 4", "Alex Casey 4"};
		findSmallestNedDebt(input);
		
		Assert.assertTrue(findSmallestNedDebt(input).equals(new ArrayList<>(Arrays.asList("Alex","Blake"))));
	
	}

	@Test
	public void test2(){
		String input[]={"Alex Blake 3","Blake Alex 2","Casey Alex 5", "Blake Casey 7","Alex  Blake 4", "Alex Casey 4"};
		findSmallestNegativeBalanace(input);
	}

	@Test
	public void test3(){
		String input[]={"Alex Blake 0","Blake Alex 0","Casey Alex 0", "Blake Casey 0","Alex  Blake 0", "Alex Casey 0"};
		findSmallestNegativeBalanace(input);
	}


	/*
	 * Initialize a hashmap for Borrower and lender with key as name and amount as value
	 * Traverse through the string array
	 * Split each input with space
	 * add the first name in borrower map and second one in lender map
	 * add the amount as value in both map
	 * Repeat till end of the array
	 * Initialize a list and min value
	 * Traverse through lender map
	 * check if lender map key is present in borrower map and subtract lender-boroower
	 * compare and check the value
	 * 	if min = current value add it in list
	 * if min< current value,replace min 
	 * return list
	 * if min >= 0 Nothing has a negative balance else list
	 */
	private List<String> findSmallestNegativeBalanace(String[] input) {

		HashMap<String,Integer> borrowerMap=new HashMap<String,Integer>();
		HashMap<String,Integer> lenderMap=new HashMap<String,Integer>();

		for (int i = 0; i < input.length; i++) {
			String str[] = input[i].split("\\s+");
			if(borrowerMap.containsKey(str[0])){
				int value=borrowerMap.get(str[0]);
				value+=Integer.parseInt(str[2]);
				borrowerMap.put(str[0],value);
			}else{
				borrowerMap.put(str[0], Integer.parseInt(str[2]));
			}
			if(lenderMap.containsKey(str[1])){
				int value=lenderMap.get(str[1]);
				value+=Integer.parseInt(str[2]);
				lenderMap.put(str[1],value);
			}else{
				lenderMap.put(str[1], Integer.parseInt(str[2]));
			}			

		}

		List<String> list = new ArrayList<String>();
		int min =0;
		for(String each:lenderMap.keySet()){
			if(borrowerMap.containsKey(each)){
				int value=lenderMap.get(each)-borrowerMap.get(each);
				//min=Math.min(min,value);
				if(min>value){
					min=value;
					if(list.size()>0){
						list.removeAll(list);
					}
					list.add(each);
				}else if(min==value){
					min=value;
					list.add(each);
				}
			}
		}
		if(min>=0){
			list.removeAll(list);
			list.add("Nobody has a negative balance");
			System.out.println("Nobody has a negative balance");
			return list;
		}
		System.out.println(list);
		return list;
	}
	
	/*
	 * Time -O(n)
	 * Space-O(n)
	 */
	
	private List<String> findSmallestNedDebt(String[] input){

		Map<String,Integer> map = new TreeMap<>();	
		for (int i = 0; i < input.length; i++) {
			String[] each=input[i].split("\\s+");
			map.put(each[0],map.getOrDefault(each[0], 0)- Integer.parseInt(each[2]));
			map.put(each[1],map.getOrDefault(each[1], 0)+ Integer.parseInt(each[2]));		
		}
		
		int minValue = Collections.min(map.values());
		if(minValue>=0) return new ArrayList<>(Arrays.asList("Nobody has a negative balance"));
		Set<String> retSet = new TreeSet<>();
		for (Map.Entry<String, Integer> eachSet : map.entrySet()){
			if(eachSet.getValue() == minValue) {
				retSet.add(eachSet.getKey());
			}
		}
		return new ArrayList<>(retSet);
	}
}
