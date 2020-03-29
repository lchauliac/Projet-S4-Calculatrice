package modele.arbreCalcul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

import modele.arbre.Arbre;
import modele.arbreCalcul.operation.Addition;
import modele.arbreCalcul.operation.Division;
import modele.arbreCalcul.operation.Multiplication;
import modele.arbreCalcul.operation.Operateur;
import modele.arbreCalcul.operation.Soustraction;

public class ArbreCalcul extends Arbre<String>{

	private ArrayList<Operateur> ops;

	public ArbreCalcul(String s,ArrayList<Operateur> ops) {
		this.ops = ops;
		if(s.getS().contains("(")) {
			gestionParenthese(s);
		}
		else {
			int res =s.estOperation(this.ops);
			if(res>=0) {
				this.contenu = new String(this.ops.get(res).getOperande()+"");
				String[] tab = s.splitOnce( this.ops.get(res).getOperande() );
				this.filsG = new ArbreCalcul(tab[0],this.ops);
				this.filsD = new ArbreCalcul(tab[1],this.ops);	
			}
			else {
				this.contenu = s;
				this.filsD = new Arbre();
				this.filsG = new Arbre();
			}
		}
	}
	
	public void gestionParenthese(String s) {
		LinkedList<String> ls = new LinkedList<String>();
		int i=0;
		int deb,fin,nbParenthese;
		String sub = new String(s.getS());
		while(sub.getS().contains("(")) {
			nbParenthese=0;
			i=0;
			while(sub.getS().charAt(i)!='(') {
				i++;
			}
			deb = i;
			nbParenthese++;
			while(sub.getS().charAt(i)!=')' && nbParenthese!=0) {
				if(sub.getS().charAt(i)=='(') {
					nbParenthese++;
				}
				if(sub.getS().charAt(i)==')') {
					nbParenthese--;
				}
				i++;
			}
			i++;
			fin = i;
			ls.addFirst(new String(sub.getS().substring(deb,fin)));
			sub.replace(deb,fin,"a");
		}
		//coupez (estOperation) sur le sub
		int res = sub.estOperation(this.ops);
		if(res<0) {
			sub = ls.pollLast();
			sub.setS(sub.getS().substring(1, sub.getS().length()-1));
			System.out.println("last "+sub);
			res = sub.estOperation(this.ops);
			if(res>=0) {
				this.contenu = new String(this.ops.get(res).getOperande()+"");
				String[] tab = sub.splitOnce( this.ops.get(res).getOperande() );
				this.filsG = new ArbreCalcul(tab[0],this.ops);
				this.filsD = new ArbreCalcul(tab[1],this.ops);	
			}
			else {
				this.contenu = sub;
				this.filsD = new Arbre();
				this.filsG = new Arbre();
			}
		}
		else {
			String[] tab = sub.splitOnce(this.ops.get(res).getOperande());
			for(i=0;i<tab.length;i++) {
				while(tab[i].getS().contains("a")) {
					tab[i].replaceOnce('a', ls.pollLast().getS());
				}
			}
			this.contenu = new String( this.ops.get(res).getOperande()+"" );
			this.filsG = new ArbreCalcul(tab[0],this.ops);
			this.filsD = new ArbreCalcul(tab[1],this.ops);
		}
		System.out.println(sub+"moi verife"+this.toString());
	}

	//--Method-------------------------------------------------------------

	public double calcul() {
		if( estFeuille() ) {
			System.out.println(this.contenu.getS());
			return Double.parseDouble(this.contenu.getS());
		}
		if( !this.estVide() ){
			System.out.println(getContenu().estOperation(this.ops)+"");
			return (double)this.ops.get(getContenu().estOperation(this.ops)).resOperation(((ArbreCalcul) this.filsG).calcul(), ((ArbreCalcul) this.filsD).calcul());
		}
		return 0;
	}

	//getter/setter
	public ArrayList<Operateur> getOps(){
		return this.ops;
	}
}
