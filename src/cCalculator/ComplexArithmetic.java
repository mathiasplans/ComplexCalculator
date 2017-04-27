package cCalculator;

/**
 * @author Mathias
 *
 */
public class ComplexArithmetic {

	ComplexNumber cAdd(ComplexNumber z1, ComplexNumber z2){
		return new ComplexNumber(z1.Re() + z2.Re(), z1.Im() + z2.Im());
	}
	
	ComplexNumber cSubtract(ComplexNumber z1, ComplexNumber z2){
		return new ComplexNumber(z1.Re() - z2.Re(), z1.Im() - z2.Im());
	}
	
	ComplexNumber cMulti(ComplexNumber z1, ComplexNumber z2){
		return new ComplexNumber( z1.getArgument() + z2.getArgument(), z1.Abs()*z2.Abs(), true);
	}
	
	ComplexNumber cDivide(ComplexNumber z1, ComplexNumber z2){
		return new ComplexNumber( z1.getArgument() - z2.getArgument(), z1.Abs() / z2.Abs(), true);
	}
	
	ComplexNumber cConjugate(ComplexNumber z){
		return new ComplexNumber( z.Re(), -z.Im() );
	}
	
	ComplexNumber cReciprocal(ComplexNumber z){
		return cDivide(cConjugate(z) , cMulti(z, cConjugate(z)));
	}
	
	ComplexNumber cSqrt(ComplexNumber z){
		return new ComplexNumber( (Math.sqrt(z.Re() + Math.sqrt( z.Re()*z.Re() + z.Im()*z.Im() )) / 2 ), (Math.abs(z.Im()) / z.Im() ) * Math.sqrt( (-z.Re() + Math.sqrt( z.Re()*z.Re() + z.Im()*z.Im() ) ) / 2) );
	}
	
	ComplexNumber cLog(ComplexNumber z, ComplexNumber base){
		return cDivide(new ComplexNumber(Math.log(z.Abs()), z.getArgument()), new ComplexNumber(Math.log(base.Abs()), base.getArgument()));
	}
	
	ComplexNumber cExpInt(ComplexNumber z, int n){
		return new ComplexNumber(z.getArgument()*n, z.Abs(), true);
	}
	
	ComplexNumber cPow(ComplexNumber z1, ComplexNumber z2){
		return new ComplexNumber(
				z2.Re() * z1.getArgument() + 0.5 * z2.Im() * Math.log(Math.pow(z1.Re(), 2) + Math.pow(z1.Im(), 2)),
				Math.pow(Math.pow(z1.Re(), 2) + Math.pow(z1.Im(), 2), z2.Re()/2) * Math.pow(Math.E, -z2.Im()*z1.getArgument()),
				true
				);
	}
	
	ComplexNumber cEExp(ComplexNumber z){
		return cPow(new ComplexNumber(Math.E), z);
	}
	
}
