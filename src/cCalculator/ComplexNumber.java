package cCalculator;

/**
 * @author Mathias
 *
 */
public class ComplexNumber {
	private double imaginaryPart, realPart, phase, abs;
	
	ComplexNumber(double r){
		this.imaginaryPart = 0;
		this.realPart = r;
		this.phase = Math.atan2(imaginaryPart , realPart);
		this.abs = Math.sqrt((imaginaryPart*imaginaryPart + realPart*realPart));
	}
	
	ComplexNumber(double p, double abs, boolean n){
		this.imaginaryPart = Math.sin(p) * abs;
		this.realPart = Math.cos(p) * abs;
		this.phase = p;
		this.abs = abs;
	}
	
	ComplexNumber(double r, double i){
		this.imaginaryPart = i;
		this.realPart = r;
		this.phase = Math.atan2(imaginaryPart , realPart);
		this.abs = Math.sqrt((imaginaryPart*imaginaryPart + realPart*realPart));
	}
	
	double Re(){
		return realPart;
	}
	
	double Im(){
		return imaginaryPart;
	}
	
	void setIm(int i){
		this.imaginaryPart = i;
	}
	
	void setRe(int r){
		this.realPart = r;
	}
	
	double Abs(){
		return abs;
	}
	
	double RePolar(){
		return this.Abs() / realPart;
	}
	
	double ImPolar(){
		return this.Abs() / imaginaryPart;
	}
	
	double getArgument(){
		return phase;
	}
	
	ComplexNumber getNegative(){
		return new ComplexNumber(-this.Re(), -this.Im());
	}
	
}
