package modele;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.arbreCalcul.String;
import modele.arbreCalcul.operation.Addition;
import modele.arbreCalcul.operation.Division;
import modele.arbreCalcul.operation.Multiplication;
import modele.arbreCalcul.operation.Operateur;
import modele.arbreCalcul.operation.Soustraction;
import modele.arbreCalcul.ArbreCalcul;

public class Calculatrice {
	private StringProperty expr;
	private LinkedList<Character> number;
	private ArrayList<Operateur> ops;
	private ArrayList<Character> lc;
	
	public Calculatrice() {
		this.initNumber();
		this.initOperationList();
		this.expr = new SimpleStringProperty("");
	}
	
	private void initOperationList() {
		this.ops = new ArrayList<Operateur>();
		this.ops.add(new Addition());
		this.ops.add(new Soustraction());
		this.ops.add(new Multiplication());
		this.ops.add(new Division());
		
		this.lc = new ArrayList<Character>();
		for(int i=0;i<this.ops.size();i++) {
			this.lc.add( this.ops.get(i).getOperande() );
		}
	}
	
	private void initNumber() {
		this.number = new LinkedList<Character>();
		for(int i=0;i<10;i++) {
			this.number.add((i+"").charAt(0));
		}
	}
	
	public double calcul() {
		ArbreCalcul ac = new ArbreCalcul(new String(this.expr.get()),this.ops);
		return ac.calcul();
	}
	
	public double calcul(String s) {
		ArbreCalcul ac = new ArbreCalcul(s,this.ops);
		return ac.calcul();
	}
	
	public boolean verificationCalcul() {
		return verifCalcul(this.expr.get(), 0, 0);
	}
	
	public String createRandomCalcul() {
		double d1,d2;
		int rand = (int)(Math.random()*lc.size());
		if(rand<2) {
			d1 = Math.round((double)(Math.random()*101) * 100.0) / 100.0;
			d2 = Math.round((double)(Math.random()*101) * 100.0) / 100.0;
		}
		else {
			d1 = (double)((int)(Math.random()*11));
			d2 = (double)((int)(Math.random()*11));
		}
		return new String(d1+""+lc.get(rand)+d2);
	}
	
	private boolean verifCalcul(java.lang.String calcul, int etat, int nbParentheses) {
        char c;
        System.out.println("etat = " + etat);
        System.out.println("calcul = " +calcul);
        System.out.println("nbParenthese = " + nbParentheses);
        System.out.println();
        if (calcul.length() != 0 && etat != 5) {
            
            c = calcul.charAt(0);
            
            switch(etat) {
            
                case 0:
                    if (c == '(') {
                        etat = 3;
                        nbParentheses++;
                    }
                    else if (this.number.contains(c)) {
                        etat = 1;
    
                    }
                    else {
                        etat = 5;
                    }
                break;
                
                case 1:
                    
                    if(this.lc.contains(c)) {
                        etat = 2;
                    }
                    else if (this.number.contains(c)) {
                        etat = 1;
                    }
                    else {
                        etat = 5;
                    }
                break;
                
                case 2:
                    if (this.number.contains(c)) {
                        etat = 1;
                    }
                    else if (c == '(') {
                        etat = 3;
                        nbParentheses++;
                    }
                    else {
                        etat = 5;
                    }
                break;
                
                case 3:
                    if (c == '(') {
                        etat = 3;
                        nbParentheses++;
                    }
                    else if (this.number.contains(c)) {
                        etat = 4;
                    }
                    else {
                        etat = 5;
                    }
                break;
                
                case 4:
                    if (this.number.contains(c)) {
                        etat = 4;
                    }
                    else if(this.lc.contains(c)) {
                        etat = 3;
                    }
                    else if (c == ')') {
                        nbParentheses--;
                        if (nbParentheses == 0) {
                            etat = 1;
                        }
                        else {
                            etat = 4;
                        }
                    }
                    else {
                        etat = 5;
                    }
                break;
            }
    
            return this.verifCalcul(calcul.substring(1), etat, nbParentheses);
            
        }
        
        else if (etat == 1) {
            System.out.println("good");
            return true;
        }
        
        else {
            System.out.println("bad");
            return false;
        }
        
    }
	
	//getter/setter
	public StringProperty getExpr() {//pour bind
		return this.expr;
	}
}
