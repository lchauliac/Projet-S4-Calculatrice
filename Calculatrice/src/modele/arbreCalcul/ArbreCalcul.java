package modele.arbreCalcul;

import java.util.ArrayList;
import java.util.Arrays;

import modele.arbre.Arbre;

public class ArbreCalcul extends Arbre<String>{
	
	public boolean estOpreation;
	public ArrayList<Character> ops;
		
	public ArbreCalcul(ArrayList<Character> ops,String s) {
		this.contenu = s;
		int res =s.estOpération(this.ops);
		if(res>-1) {
			this.contenu = new String(this.ops.get(res)+"");
			String[] tab = s.splitOnce( this.ops.get(res) );
			this.filsG = new ArbreCalcul(ops,tab[0]);
			this.filsD = new ArbreCalcul(ops,tab[1]);
		}
		else {
			this.contenu = s;
			this.filsG = new Arbre();
			this.filsD = new Arbre();
		}
	}
	
}
