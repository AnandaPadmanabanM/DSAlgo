package LeetCode_Medium;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindWrongPrice {
	/*
			Problem Statement
			
			
		*/

	/*
	   1. 
	  	  Input(s):
		  Output :
		  Constraint(s):
	   
	   2. Test data
			Positive : 
			Negative :	
			Edge     :
	
	   3.  Approaches Known 
			 Approach : 
	
	   4.  O - Notation 
			  
	
	   5.  Pseudocode		
			1) 
	 */

	// Test data(s)
	@Test
	public void testData01() { // Positive
		
		String[] soldItems = {"eggs", "milk", "apple"};
		double[]  soldPrices = {1.00, 2.51, 2.1};
		String[] productsAvailable = {"eggs", "lemons", "milk", "apple"}; 
		double[] productPrices = {1.01,0.5,2.50,2.1}; 
		System.out.println(findWrongPrice(soldItems,soldPrices,productsAvailable,productPrices));     
	}
    
       private int findWrongPrice(String[] soldItems, double[] soldPrices, String[] productsAvailable,double[] productPrices ) {
			Map<String,Double> map = new HashMap<String,Double>();
			int count=0;
			for(int i=0;i<soldItems.length;i++) {
				map.put(soldItems[i],soldPrices[i]);
			}
			
			for(int i=0;i<productsAvailable.length;i++) {
				if(map.containsKey(productsAvailable[i]) && map.get(productsAvailable[i]) != productPrices[i])
					count++;			 
			}		
			return count;
		}	
}
