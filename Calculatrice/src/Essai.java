<<<<<<< HEAD
import java.util.Scanner;

=======
import java.util.ArrayList;
import java.util.Scanner;

import modele.arbreCalcul.ArbreCalcul;
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
import modele.arbreCalcul.String;

public class Essai {
	public static void main(java.lang.String args[]) {
<<<<<<< HEAD
		String s = new String("aaa+bbb");
		String strTab[] = s.split('+');
		java.lang.String s1,s2;
		Scanner sc = new Scanner(System.in);
		s1=sc.nextLine();
		//s2=sc.nextLine();
		String[] tab = new String(s1).splitOnce(sc.nextLine().charAt(0));
		for(int i=0;i<tab.length;i++) {
			System.out.println(tab[i].getS());
		}
		/*System.out.println(new String(s1).equals(new String(s2)));
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s2.charAt(i)) {
				System.out.println("oui");
			}
		}
		for(int i=0;i<strTab.length;i++) {
			System.out.println(strTab[i].getS());
		}*/
=======
		System.out.println("Essai");
		String s = new String("aaa+bbb");
		String strTab[] = s.split('+');
		java.lang.String s1,s2;
		String sa = new String("1+1");
		ArbreCalcul ac = new ArbreCalcul(sa);
		System.out.println(sa);
		System.out.println(ac.calcul());
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
	}
}
