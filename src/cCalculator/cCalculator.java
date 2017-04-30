package cCalculator;

import com.singularsys.jep.*;

/**
 * @author Mathias
 *
 */
public class cCalculator{

	/**
	 * Main meetod
	 * @param args
	 */
	public static void main(String[] args) {
		Jep parser = new Jep();	// Jep objekt
		GrammarCheck gc = new GrammarCheck(); // GrammarCheck objekt
		// Jep-i seadistamine
		parser.setImplicitMul(true);
		parser.setAllowUndeclared(true);
		// Kalkulaatori initialiseerimine
		new CalculatorFrame(600, 400, parser, gc);
	}
}
