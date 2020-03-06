package modele.arbreCalcul.operation;

import modele.arbreCalcul.String;

abstract public class Operateur {
	private String s;
	public Operateur(String s) {
		this.s=s;
	}
	public abstract double resOperation(double a, double b);
}
