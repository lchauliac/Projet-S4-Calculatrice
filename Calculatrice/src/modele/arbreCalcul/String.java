package modele.arbreCalcul;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.LinkedList;
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c

public class String {
	//attribut
	private java.lang.String s;
	
	//construtor
	public String(java.lang.String s) {
		this.s=s;
	}
	
<<<<<<< HEAD
=======
	public String() {
		this("");
	}
	
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
	//methods
	public String[] split(Character spliter) {
		String[] sSplited;
		ArrayList<String> piecesS = new ArrayList<String>();
		java.lang.String tamp = "";
		for(int i=0;i<this.s.length();i++) {
			if(this.s.charAt(i)!=spliter.charValue()) {
				tamp+=this.s.charAt(i);
			}
			else {
				if(tamp != "") {
					piecesS.add(new String(tamp));
					tamp = "";
				}
			}
		}
		if(tamp != "") {
			piecesS.add(new String(tamp));
		}
		sSplited = new String[piecesS.size()];
		for(int i=0; i<sSplited.length;i++) {
			sSplited[i] = piecesS.get(i);
		}
		return sSplited;
	}
	
	public String[] splitOnce(Character spliter) {
		String[] sSplited;
		java.lang.String tamp = "";
		int i=0;
		while(i<this.s.length() && spliter.charValue()!=this.s.charAt(i)){
			tamp += this.s.charAt(i);
			i++;
		}
		if(i != this.s.length()) {
			sSplited = new String[2];
			sSplited[0] = new String(tamp);
			tamp = "";
			i++;
			while((i<this.s.length())){
				tamp += this.s.charAt(i);
				i++;
			}
			sSplited[1] = new String(tamp);
			
		}
		else {
			sSplited = new String[1];
			sSplited[0] = new String(tamp);
		}

		return sSplited;
	}
	
<<<<<<< HEAD
	public int estOp�ration(ArrayList<Character> ops) {//liste des opr�andes
		for(int i=0;i<ops.size();i++) {
			if(this.s.contains(ops.get(i)+"")) {
=======
	public int estOperation(LinkedList<Character> ops) {//liste des opr�andes
		for(int i=0;i<ops.size();i++) {
			if(this.s.contains(ops.get(i).charValue()+"")) {
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
				return i;
			}
		}
		return -1;
	}
	
	/*public boolean equals(String otherS){
		try {
			for(int i=0;i<this.s.length();i++) {
				if(this.s.charAt(i)!=otherS.getS().charAt(i)) {
					return false;
				}
			}
		}catch(java.lang.StringIndexOutOfBoundsException sioobe) {
			return false;
		}
		return true;
	}*/
	
	//getter/setter
	public java.lang.String getS() {
		return s;
	}

	public void setS(java.lang.String s) {
		this.s = s;
	}
	
	public java.lang.String toString(){
<<<<<<< HEAD
		return "String: "+this.s;
=======
		return this.s;
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
	}
}
