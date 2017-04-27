/**
 * 
 */
package cCalculator;

import java.util.stream.IntStream;

/**
 * @author Mathias
 *
 */
public class Formater {
	private String expression, f_expression = "";
	char[] r_expression;
	int len;

	Formater(String expression){
		this.expression = expression;
		this.r_expression = this.expression.toCharArray();
		this.len = expression.length();
		setFormated();
	}
	
	private void setFormated(){
		int c_subst = 0;
		for(int c = 0; c < this.len; c++){
			f_expression += r_expression[c];
			if(c == this.len-1) continue;
			
			c_subst = c;
			if(r_expression[c+ (c + 1 == this.len ? 0 : 1) ] == ' '){
				for(int i = 2; i < this.len - c_subst; i++){
					if(r_expression[c_subst+i] == ' ') c++;
					else if(r_expression[c_subst+i] != ' ') break;
				}
			}else if((r_expression[c] == 'i' || Character.isDigit(r_expression[c])) &&
					(r_expression[c+1] == 'i' || Character.isDigit(r_expression[c+1]))) continue;
			else if(r_expression[c] != ' ') f_expression += ' ';
		}
	}
	
	int[] bracketize(){
		String[] s = f_expression.split(" ");
		int[] binject = {-1, -1, -1, -1};
		
		System.out.println(isNumber("2"));
		
		for(int i = 0; i < s.length; i++){
			if(s[i].equals("*") || s[i].equals("/") || s[i].equals("^")){
				
				if(this.isCorrect(f_expression)) break;
				
				if(!s[i-1].equals(")")){
//					if(isNumber(s[i-1]) || s[i-1].equals("\\d+" + "i")) binject[1] = i-1;
					binject[1] = i-1;
				}else{
					System.out.println(i);
					for(int j = 3; j <= i; j++){
						if(s[i-j].equals("(")) {
							binject[1] = i-j;
						}
					}
				}
				
				if(!s[i+ (i + 1 == s.length ? 0 : 1) ].equals("(")){
					//
					System.out.println("AA" + i);
					for(int j = 1; j < s.length - i; j++){
						if((isNumber(s[i+j]) || s[i+j].equals("\\d+" + "i")) && !s[i+j-1].equals("(") && !s[i+j+ (i + j + 1 == s.length ? 0 : 1)].equals(")")){
							binject[3] = i+j;
							break;
						}
					}
				}else{
					for(int j = 1; j < s.length - i; j++){
						if(s[i+j].equals(")")) binject[3] = i+j;
					}
				}
				
				System.out.println(binject[0] + " " + binject[1] + " " + binject[2] + " " + binject[3] + "\n" + f_expression);
				
				if(IntStream.of(binject).sum() != -4){
					getFormated2(f_expression, binject);
					s = f_expression.split(" ");
				}
				
//				if(this.isCorrect(f_expression)) break;
				
				for(int j = 0; j < binject.length; j++) binject[j] = -1;
				
			}
		}
		
		System.out.println(binject[0] + " " + binject[1] + " " + binject[2] + " " + binject[3]);
		return binject;
	}
	
	// (1+i)*(1+(1-i))   (1*2)*(3*(4/5))
	
	String getFormated2(String string, int[] binject){
		String[] s = string.split(" ");
		String product = "";
		for(int i = 0; i < s.length; i++){
			if(binject[1] == i || binject[2] == i) product += "(";
			
			product += s[i];
			
			if(binject[0] == i || binject[3] == i) product += ")";
			System.out.println(product);
		}
		
		this.expression = product;
		this.f_expression = "";
		this.r_expression = this.expression.toCharArray();
		
		this.len = product.length();
		
		this.setFormated();
		
//		System.out.println("a: " + this.getFormated());
		
		return product;
	}
	
	String getFormated(){
		return f_expression;
	}
	
	private int countOperators(String string){
		String[] s = string.split(" ");
		int count = 0;
		for(String h : s){
			if(h.equals("+") || h.equals("-") || h.equals("*") || h.equals("/") || h.equals("^")) count++;
		}
		return count;
	}
	
	private int countBrackets(String string){
		String[] s = string.split(" ");
		int count = 0;
		for(String h : s){
			if(h.equals("(") || h.equals(")")) count++;
		}
		return count;
	}
	
	private boolean bracketBalance(String string){
		String[] s = string.split(" ");
		int count1 = 0, count2 = 0;
		for(String h : s){
			if(h.equals("(")) count1++;
		}
		for(String h : s){
			if(h.equals(")")) count2++;
		}
		
		if(count1>count2) return true;
		return false;
	}
	
	private boolean isCorrect(String string){
		if(countBrackets(string) / countOperators(string) >= 2) return true;
		return false;
	}
	
	private boolean isNumber(String s){
		try{
			Integer.parseInt(s);
		} catch (NumberFormatException exeption) {
            return false;
        }
		
		return true;
	}
}



