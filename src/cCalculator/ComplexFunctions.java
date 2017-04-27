package cCalculator;

/**
 * @author Mathias
 *
 */
public class ComplexFunctions {
	
	private ComplexArithmetic cA;
	
	ComplexFunctions(){
		cA = new ComplexArithmetic();
	}
	
	ComplexNumber cSin(ComplexNumber z){
		return new ComplexNumber(Math.sin(z.Re()) * Math.cosh(z.Im()), Math.cos(z.Re()) * Math.sinh(z.Im()));
	}
	
	ComplexNumber cCos(ComplexNumber z){
		return new ComplexNumber(Math.cos(z.Re()) * Math.cosh(z.Im()), Math.sin(z.Re()) * Math.sinh(z.Im()));
	}
	
	ComplexNumber cTangent(ComplexNumber z){
		return cA.cDivide(cSin(z), cCos(z));
	}
	
	ComplexNumber cArcsin(ComplexNumber z){
		if(z.Re() == -1) return new ComplexNumber(-Math.PI/2);
		else if(z.Re() == 0) return new ComplexNumber(0);
		else if(z.Re() == 1) return new ComplexNumber(Math.PI/2);
		else return cA.cMulti(new ComplexNumber(0, -1), cA.cLog(cA.cAdd(cA.cMulti(new ComplexNumber(0, 1), z), cA.cSqrt(cA.cSubtract(new ComplexNumber(1), cA.cExpInt(z, 2)))), new ComplexNumber(Math.E)));
	}
	
	ComplexNumber cArccos(ComplexNumber z){
		if(z.Re() == -1) return new ComplexNumber(Math.PI);
		else if(z.Re() == 0) return new ComplexNumber(Math.PI/2);
		else if(z.Re() == 1) return new ComplexNumber(0);
		else return cA.cSubtract(new ComplexNumber(Math.PI/2), cArcsin(z));
	}
	
	ComplexNumber cArctan(ComplexNumber z){
		if(z.Im() == -1) return new ComplexNumber(0, -Double.MAX_VALUE);
		else if(z.Im() == 0 && z.Re() == 0) return new ComplexNumber(0);
		else if(z.Im() == 1) return new ComplexNumber(0, Double.MAX_VALUE);
		else return cA.cDivide(cArcsin(z), cArccos(z));
	}
	
	ComplexNumber cSinh(ComplexNumber z){
		if(z.Re() == 0 && z.Im() == 0) return new ComplexNumber(0);
		else if(z.Re() == Math.log((1 + Math.sqrt(5)) / 2) && z.Im() == 0) return new ComplexNumber(0.5);
		return cA.cDivide(cA.cSubtract(cA.cEExp(z), cA.cEExp(z.getNegative())), new ComplexNumber(2));
	}
	
	ComplexNumber cCosh(ComplexNumber z){
		if(z.Re() == 0 && z.Im() == 0) return new ComplexNumber(1);
		else if(z.Re() == Math.log((1 + Math.sqrt(5)) / 2) && z.Im() == 0) return new ComplexNumber(Math.sqrt(5)/2);
		else return cA.cDivide(cA.cAdd(cA.cEExp(z), cA.cEExp(z.getNegative())), new ComplexNumber(2));
	}
	
	ComplexNumber cTanh(ComplexNumber z){
		if(z.Re() == 0 && z.Im() == 0) return new ComplexNumber(0);
		else if(z.Re() == Math.log((1 + Math.sqrt(5)) / 2) && z.Im() == 0) return new ComplexNumber(Math.sqrt(5)/5);
		else return cA.cDivide(cSinh(z), cCosh(z));
	}
}
