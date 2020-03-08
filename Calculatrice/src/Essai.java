import java.util.ArrayList;
import java.util.Scanner;

import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;

public class Essai {
	public static void main(java.lang.String args[]) {
		System.out.println("Essai");
		String s = new String("aaa+bbb");
		String strTab[] = s.split('+');
		java.lang.String s1,s2;
		String sa = new String("1+1");
		ArbreCalcul ac = new ArbreCalcul(sa);
		System.out.println(sa);
		System.out.println(ac.calcul());
	}
}
