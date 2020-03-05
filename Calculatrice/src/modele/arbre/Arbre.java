package modele.arbre;

import java.util.LinkedList;

/**
 * Cette classe est dite générique car le contenu du noeud de l'arbre peut être de tout type
 */
public class Arbre<E> {

	protected E contenu; // contenu du noeud
	protected Arbre<E> filsG, filsD; // les sous-arbres

	/**
	 * Constructeur
	 * 
	 * @param g
	 *            sous-arbre gauche
	 * @param c
	 *            contenu du noeud
	 * @param d
	 *            sous-arbre droit
	 */
	public Arbre(Arbre<E> g, E c, Arbre<E> d) {
		this.filsG = g;
		this.contenu = c;
		this.filsD = d;
	}

	/**
	 * Constructeur d'arbre vide
	 */
	public Arbre() {
		this(null, null, null);
	}

	/**
	 * Constructeur de feuille càd un contenu et deux sous-arbres vides
	 */
	public Arbre(E contenu) {
		this(new Arbre<E>(), contenu, new Arbre<E>());
	}

	/**
	 * Teste si l'arbre courant est vide
	 */
	public boolean estVide() {
		return this.filsG == null && this.filsD == null && this.contenu == null;
	}

	/**
	 * Retourne la taille de l'arbre courant
	 */
	public int taille() {
		if( this.estVide() ) {
			return 0;
		}else {
			return 1+this.getFilsG().taille()+this.getFilsD().taille();
		}
	}

	/**
	 * Retourne vrai si l'arbre courant est une feuille
	 */
	public boolean estFeuille() {
		if( !this.estVide() && this.filsD.estVide() && this.filsG.estVide() ) {
			return true;
		}
		return false;
	}

	/**
	 * Retourne le nombre de feuilles de l'arbre courant
	 */
	public int nbFeuilles() {
		int nbFeuille=0;
		if( this.estVide() ) {
			return nbFeuille;
		}
		else {
			if( this.estFeuille() ) {
				nbFeuille++;
			}
			else {
				return this.getFilsG().nbFeuilles() + this.getFilsD().nbFeuilles();
			}
		}
		return nbFeuille;
	}

	/**
	 * Retourne la hauteur de l'arbre courant (0 si feuille)
	 */
	public int hauteur() {
		if( this.estVide() ) {
			return -1;
		}
		if( this.estFeuille() ) {
			return 0;
		}
		if( this.getFilsG().hauteur()<this.getFilsD().hauteur() ) {
			return 1+this.getFilsD().hauteur();
		}
		else {
			return 1+this.getFilsG().hauteur();
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours préfixe
	 */
	public void parcoursPrefixe() { //prefixe NGD
		if( !this.estVide() ){
			System.out.print(this.contenu+",");
			this.getFilsG().parcoursPrefixe();
			this.getFilsD().parcoursPrefixe();
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours infixe
	 */
	public void parcoursInfixe() { //infixe GND
		if( !this.estVide() ){
			this.getFilsG().parcoursInfixe();
			System.out.print(this.contenu+",");
			this.getFilsD().parcoursInfixe();
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours postfixe
	 */
	public void parcoursPostfixe() { //postfixe GDN
		if( !this.estVide() ){
			this.getFilsG().parcoursPostfixe();
			this.getFilsD().parcoursPostfixe();
			System.out.print(this.contenu+",");
			
		}
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours en largeur
	 */
	public void parcoursLargeur() {
		LinkedList<Arbre<E>> fifo = new LinkedList<Arbre<E>>();
		if(!this.estVide()) {
			fifo.add(this);
			while(!fifo.isEmpty()) {
				if(!fifo.getLast().estVide()) {
					System.out.print(fifo.getLast().contenu+",");
					fifo.addFirst( fifo.getLast().filsG );
					fifo.addFirst( fifo.getLast().filsD );
				}
				fifo.removeLast();
			}
		}
	}

	/**************************
	 * Getters et utilitaires *
	 **************************/

	public Arbre<E> getFilsG() {
		return this.filsG;
	}

	public Arbre<E> getFilsD() {
		return this.filsD;
	}

	public E getContenu() {
		return this.contenu;
	}

	public boolean estIdentiqueA(Arbre<E> b) {
		if (this.estVide() && b.estVide())
			return true;
		if (!this.estVide() && !b.estVide() && this.contenu.equals(b.contenu))
			return this.filsG.estIdentiqueA(b.filsG) && this.filsD.estIdentiqueA(b.filsD);
		else
			return false;
	}

	@Override
	public String toString() {
		if (this.estVide())
			return "vide";
		return "[filsG=" + filsG + ", contenu=" + contenu + ", filsD=" + filsD + "]";
	}

}
