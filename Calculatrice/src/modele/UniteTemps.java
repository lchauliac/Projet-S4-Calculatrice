package modele;

public class UniteTemps {
	//attribut
	private int limite;
	private int valeur;
	
	//constructor
	public UniteTemps(int limite, int valeur) {
		this.limite = limite;
		this.valeur = valeur;
	}
	public UniteTemps(int limite) {
		this.limite = limite;
		this.valeur = 0;
	}
	
	//methods
	public int augmente(int val) {
		if((val+this.valeur)>=limite) {
			this.valeur = 0;
			return (val+this.valeur)-limite;
		}else {
			this.valeur += val;
			return 0;
		}
	}
	public int augmente() {
		return this.augmente(1);
	}
	public int diminue(int val) {
		val = val*(-1);
		if((val+this.valeur)>=limite) {
			this.valeur = 0;
			return (val+this.valeur)-limite;
		}else {
			this.valeur += val;
			return 0;
		}
	}
	public int diminue() {
		return this.diminue(1);
	}
}
