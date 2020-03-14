package modele.arbreCalcul.operation;

public class Division extends Operateur{
	
	public Division() {
		super('/');
	}

	@Override
	public double resOperation(double a, double b) {
		return a/b;
	}
	
}
