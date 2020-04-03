import java.util.ArrayList;
import java.util.Scanner;

import modele.Calculatrice;
import modele.dateProperty;
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;
import modele.arbreCalcul.operation.Addition;
import modele.arbreCalcul.operation.Division;
import modele.arbreCalcul.operation.Multiplication;
import modele.arbreCalcul.operation.Operateur;
import modele.arbreCalcul.operation.Soustraction;

public class Essai {
	public static void main(java.lang.String args[]) {
		Calculatrice calculette = new Calculatrice();
		Scanner sc = new Scanner(System.in);
		ArbreCalcul ac;
		String s;
		while (true) {
			System.out.println("saisie expr:");
			s = new String(sc.nextLine());
			ac = new ArbreCalcul(s, calculette.getOps());
			System.out.println("Resultat: "+ac.calcul());
		}
		
	}
}
