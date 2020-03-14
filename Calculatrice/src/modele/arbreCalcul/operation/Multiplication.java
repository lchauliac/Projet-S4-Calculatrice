package modele.arbreCalcul.operation;

import modele.arbreCalcul.String;

public class Multiplication extends Operateur {
	
	public Multiplication() {
		super('*');
	}

	@Override
	public double resOperation(double a, double b) {
		return a*b;
	}
}
