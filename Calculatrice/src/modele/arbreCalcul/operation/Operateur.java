package modele.arbreCalcul.operation;

abstract public class Operateur {
	
	private Character operande;
	
	public Operateur(Character operande) {
		this.operande=operande;
	}
	
	public abstract double resOperation(double a, double b);
	
	public Character getOperande() {
		return this.operande;
	}
}
