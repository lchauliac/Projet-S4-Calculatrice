package modele.arbreCalcul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import modele.arbre.Arbre;

public class ArbreCalcul extends Arbre<String>{
	
	public boolean estOperation;
	public LinkedList<Character> ops;
	
	public ArbreCalcul(java.lang.String s) {
		this.contenu = new String(s);
		this.filsD = new Arbre();
		this.filsG = new Arbre();
		this.estOperation = false;
		initOperationList();
	}
		
	private void initOperationList() {
		this.ops = new LinkedList();
		this.ops.add('+');
		this.ops.add('-');
		this.ops.add('*');
		this.ops.add('/');
	}

	public ArbreCalcul(String s) {
		initOperationList();
		int res =s.estOperation(this.ops);
		if(s.getS().contains("(")) {
			String[] tab = gestionParenthese(s);
			if(tab.length==0) {
				this.contenu = tab[0];
			}
			if(tab.length>0) {
				this.filsG = new ArbreCalcul(tab[0]);
				this.contenu = tab[1];
				if(tab.length>1) {
					this.filsD = new ArbreCalcul(tab[2]);
				}
			}
		}
		else {
			if(res>=0) {
				this.estOperation = true;
				this.contenu = new String(this.ops.get(res)+"");
				String[] tab = s.splitOnce( this.ops.get(res) );
				this.filsG = new ArbreCalcul(tab[0]);
				this.filsD = new ArbreCalcul(tab[1]);
				
			}
			else {
				this.estOperation = false;
				this.contenu = s;
				this.filsD = new Arbre();
				this.filsG = new Arbre();
				this.estOperation = false;
			}
		}
	}
	
	public String[] gestionParenthese(String s) {
		ArrayList<String>ls=new ArrayList<String>();
		int i=0;
		int nbParenthese=0;
		String tampon=new String();
		//this.contenu.getS().charAt(i)!='(' && i<this.contenu.getS().length()
		while(s.getS().charAt(i)!='(' && i<s.getS().length()) {
			tampon.setS(tampon.getS()+s.getS().charAt(i));
			i++;
		}
		if(tampon.getS()!="") {
			ls.add(tampon);
			tampon = new String();
		}
		while(i<s.getS().length() && (s.getS().charAt(i)!=')' && nbParenthese!=0)) {
			if(s.getS().charAt(i)!='(') {
				nbParenthese++;
			}
			else if(s.getS().charAt(i)!=')') {
				nbParenthese--;
			}
			tampon.setS(tampon.getS()+s.getS().charAt(i));
			System.out.println(tampon);
			i++;
		}
		if(tampon.getS()!="") {
			ls.add(tampon);
			tampon = new String();
		}
		while(i<s.getS().length()) {
			ls.add(tampon);
			i++;
		}
		if(tampon.getS()!="") {
			ls.add(tampon);
			tampon = new String();
		}
		
		String[] tab = new String[ls.size()];
		for(i=0;i<ls.size();i++) {
			tab[i]=ls.get(i);
		}
		return tab;
	}
	
	public LinkedList<Character> getOps(){
		return this.ops;
	}
}
