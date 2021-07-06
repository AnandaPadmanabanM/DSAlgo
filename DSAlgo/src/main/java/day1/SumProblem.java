package day1;

public class SumProblem {
	
	/*
	 * 1)	Did I understand the problem? Yes or No !! 
	 * 		-> If No, Ask the person to provide more detail with example(s) 
	 * 		-> If yes, go to next step !! 
	 * 
	 *  
	 *  What is the input(s)? 
	 *  What is the expected output? 
	 *  Do I have constraints to solve the problem? 
	 *  Do I have all informations to go to next step!! 
	 *  How big is your test data set will be?
	 * 
	 *  
	 *  2) Test Data Set
	 *   	-> Positive, Negative, Edge
	 *   
	 *  3)DO I know to solve it?
	 *   	-> Yes- check for alternate solution
	 *   	-> No - Check for feasibility to break down into sub problems
	 *   
	 *  4)Ask for hint
	 *  
	 *  5)Do I know alternate solutions?
	 *  	-> Yes - what are those?
	 *  	-> No - it's okay to proceed with what you know 
	 * 	
	 *   Approach Taken:
	 * 	1) Yes	 	
	 *  2) positive -> i/p1-> {3,5,4,4,8} i/p2 ->8   o/p ->{0,1},{2,3} { (first match | All matches)
	 *     negative -> i/p1-> {3,5,4,4,8} i/p2 ->15  what should return?
	 *     edge -> i/p1-> {3,5,4,4,8} i/p2 ->10   o/p ->{1,1}
	 *  3) yes  
	 *  4) Not required
	 *  5) Brute force
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder data = new StringBuilder("Anand");
		System.out.println(data.reverse());
	}

}