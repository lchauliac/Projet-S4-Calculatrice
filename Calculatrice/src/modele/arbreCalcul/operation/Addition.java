package modele.arbreCalcul.operation;

import modele.arbreCalcul.String;

public class Addition extends Operateur {
	
	public Addition() {
		super('+');
	}

	@Override
	public double resOperation(double a, double b) {
		return a+b;
	}


}
