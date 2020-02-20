import java.util.Scanner;

import modele.arbreCalcul.String;

public class Essai {
	public static void main(java.lang.String args[]) {
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
	}
}
