package modele.arbreCalcul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

import modele.arbre.Arbre;

public class ArbreCalcul extends Arbre<String>{

	public LinkedList<Character> ops;
	public Map<java.lang.String,BiFunction> sToPred;

	public ArbreCalcul(String s) {
		initOperationList();
		initSToPred();
		int res =s.estOperation(this.ops);
		if(s.getS().contains("(")) {
			String[] tab = gestionParenthese(s);
			if(tab.length<=0) {
				this.contenu = tab[0];
			}
			else {
				this.filsG = new ArbreCalcul(tab[0]);
				this.contenu = tab[1];
				if(tab.length>1) {
					this.filsD = new ArbreCalcul(tab[2]);
				}
			}
		}
		else {
			if(res>=0) {
				this.contenu = new String(this.ops.get(res)+"");
				String[] tab = s.splitOnce( this.ops.get(res) );
				this.filsG = new ArbreCalcul(tab[0]);
				this.filsD = new ArbreCalcul(tab[1]);	
			}
			else {
				this.contenu = s;
				this.filsD = new Arbre();
				this.filsG = new Arbre();
			}
		}
	}

	private void initOperationList() {
		this.ops = new LinkedList();
		this.ops.add('+');
		this.ops.add('-');
		this.ops.add('*');
		this.ops.add('/');
	}

	private void initSToPred() {
		this.sToPred = new HashMap<java.lang.String,BiFunction>();
		BiFunction<Double,Double,Double> add = (Double a,Double b) -> a+b;
		BiFunction<Double,Double,Double> sous = (Double a,Double b) -> a-b;
		BiFunction<Double,Double,Double> mult = (Double a,Double b) -> a*b;
		BiFunction<Double,Double,Double> div = (Double a,Double b) -> a/b;
		this.sToPred.put("+", add);
		this.sToPred.put("-", sous);
		this.sToPred.put("*", mult);
		this.sToPred.put("/", div);
	}

	/*private String[] gestionParenthese(String s) {
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

	}*/
	private String[] gestionParenthese(String s) {
		ArrayList<String> ls = new ArrayList<String>();
		String tampon = new String();
		int i;
		String[] tab = new String[2];
		if(s.getS().charAt(0)=='('){
			i=1;
			do{
				tampon.setS(tampon.getS()+s.getS().charAt(i));
				i++;
			}while(s.getS().charAt(i)!=')');
			if(i+1==s.getS().length()) {//Tous n'est qu'une parenthese exemple: (a+b)
				return new String[1];
			}
			//operation apres parenthese exemple: (a+b)+c
			i++;
			tab[0] = tampon;
			tampon = new String();
			while(i<s.getS().length()) {
				tampon.setS(tampon.getS()+s.getS().charAt(i));
				i++;
			}
			tab[1] = tampon;
			return tab;
		}
		else { //operation avant parenthese exemple a+(b+c)
			i=0;
			do{
				tampon.setS(tampon.getS()+s.getS().charAt(i));
				i++;
			}while(s.getS().charAt(i)!='(');
			tab[0] = tampon;
			tampon = new String();
			while(i<s.getS().length()) {
				tampon.setS(tampon.getS()+s.getS().charAt(i));
				i++;
			}
			tab[1] = tampon;
			return tab;
		}
	}

	//--Method-------------------------------------------------------------

	public double calcul() {
		if( estFeuille() ) {
			return Double.parseDouble(this.contenu.getS());
		}
		if( !this.estVide() ){
			return (double)this.sToPred.get(getContenu().getS()).apply(((ArbreCalcul) this.filsG).calcul(), ((ArbreCalcul) this.filsD).calcul());
		}
		return 0;
	}

	//getter/setter
	public LinkedList<Character> getOps(){
		return this.ops;
	}
}
