public class ComplexNumber{

	ComplexNumber newComplex;

	private float newA;
	private float newB;

	private float a;
	private float b;

	public ComplexNumber(float a, float b){
		this.a = a;
		this.b = b;
	}
	public float getA(){
		return a;
	}
	public float getB(){
		return b;
	}

	public ComplexNumber add(ComplexNumber num){
		newA = a + num.getA();
		newB = b + num.getB();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}

	public ComplexNumber subtract(ComplexNumber num){
		newA = a - num.getA();
		newB = b - num.getB();
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}

	public ComplexNumber multiply(ComplexNumber num){
		newA = (a * num.getA()) - (b * num.getB());
		newB = (b * num.getA()) + (a * num.getB());
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}

	public ComplexNumber divide(ComplexNumber num){
		newA = ((a * num.getA()) + (b * num.getB())) / ((num.getA() * num.getA()) + (num.getB() * num.getB()));
		newB = ((b * num.getA()) - (a * num.getB())) / ((num.getA() * num.getA()) + (num.getB() * num.getB()));
		newComplex = new ComplexNumber(newA, newB);
		return newComplex;
	}
	public String toString(){
		return "(" + a + ") + (" + b + ")i";
	}
}