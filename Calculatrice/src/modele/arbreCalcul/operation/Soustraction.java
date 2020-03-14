package modele.arbreCalcul.operation;

import modele.arbreCalcul.String;

public class Soustraction extends Operateur {
	
	public Soustraction() {
		super('-');
	}

	@Override
	public double resOperation(double a, double b) {
		return a-b;
	}

}
