package cCalculator;

import java.util.Scanner;

/**
 * @author Mathias
 *
 */
public class cCalculator{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new cCalculator(600, 400);
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Formater f = new Formater(s);
		System.out.println(s);
		String str = f.getFormated();
		System.out.println(str);
		sc.close();
		
		System.out.println(f.getFormated2(str, f.bracketize()));
		
		CalculatorTree tree = new CalculatorTree(str);
		tree.determineElements();
		
		
	}
	
	public cCalculator(int x, int y){
		new CalculatorFrame(x, y, this);
	}

}
