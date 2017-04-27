/**
 * 
 */
package cCalculator;

/**
 * @author Mathias
 *
 */
public class CalculatorTree {
	private String expression;
	private String element1, element2;
	private String operator;
	
	CalculatorTree(String expression){
		this.expression = expression;
	}
	
	void determineElements(){
		
//		System.out.println(expression);
		String[] sarr = expression.split(" ");
		int layer = 0, last_layer = 0, stage = 0;
		
		for(int i = 0; i < sarr.length; i++){
			
			last_layer = layer;
			if(sarr[i].equals("(")) layer++;
			else if(sarr[i-(i == 0 ? 0 : 1)].equals(")")) layer--;
			
			
			if(last_layer + layer == 1) stage++;
			
//			System.out.println(stage + " " + layer + " "  + sarr[i]);
			
			
			if(stage == 1){
				if(element1 != null) element1 += sarr[i];
				else element1 = sarr[i];
			}
			else if(stage == 2) operator = sarr[i];
			else if(stage == 3){
				if(element2 != null) element2 += sarr[i];
				else element2 = sarr[i];
			}
			
		}
		
		System.out.println(element1);
		System.out.println(operator);
		System.out.println(element2);
	}
	
	// (1+i)*(1+(1-i))
	
	private boolean isNumber(String s){
		try{
			Integer.parseInt(s);
		} catch (NumberFormatException exeption) {
            return false;
        }
		
		return true;
	}
	
}
