import java.util.ArrayList;
import java.util.Scanner;

import modele.Calculatrice;
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;
import modele.arbreCalcul.operation.Addition;
import modele.arbreCalcul.operation.Division;
import modele.arbreCalcul.operation.Multiplication;
import modele.arbreCalcul.operation.Operateur;
import modele.arbreCalcul.operation.Soustraction;

public class Essai {
	public static void main(java.lang.String args[]) {
		ArrayList<Operateur> ops = new ArrayList<Operateur>();
		ops.add(new Addition());
		ops.add(new Soustraction());
		ops.add(new Multiplication());
		ops.add(new Division());
		
		ArrayList<Character> lc = new ArrayList<Character>();
		for(int i=0;i<ops.size();i++) {
			lc.add( ops.get(i).getOperande() );
		}
		String sa = new String("2+(1+1)*(5+1)");
		ArbreCalcul calculette = new ArbreCalcul(sa,ops);
		
	}
}
