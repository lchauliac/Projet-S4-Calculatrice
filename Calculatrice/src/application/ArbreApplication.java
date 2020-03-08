package application;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
<<<<<<< HEAD
import modele.abr.ABR;
import modele.abr.ABRInt;
import modele.arbre.ArbreInt;
=======
import modele.arbre.Arbre;
import modele.arbre.ArbreInt;
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
import vue.Dessin;

public class ArbreApplication extends Application {

<<<<<<< HEAD
	private Dessin<Integer> dessin;

	@Override
	public void init() {
		/*
		 * Construire ici un arbre ainsi qu'une instance de la classe
		 * Dessin à laquelle on passe l'arbre.
		 * Par exemple:
		 */
		ArbreInt gche = new ArbreInt(new ArbreInt(new ArbreInt(),2,new ArbreInt(3)), 1, new ArbreInt(new ArbreInt(8),7,new ArbreInt(new ArbreInt(4),5,new ArbreInt())));
		ArbreInt drt = new ArbreInt(new ArbreInt(new ArbreInt(),11,new ArbreInt(0)), 6, new ArbreInt(17));
		ArbreInt a = new ArbreInt(gche, 10, drt);
=======
	private Dessin<String> dessin;

	@Override
	public void init() {
		ArbreInt gche = new ArbreInt(new ArbreInt(new ArbreInt(),2,new ArbreInt(3)), 1, new ArbreInt(new ArbreInt(8),7,new ArbreInt(new ArbreInt(4),5,new ArbreInt())));
		ArbreInt drt = new ArbreInt(new ArbreInt(new ArbreInt(),11,new ArbreInt(0)), 6, new ArbreInt(17));
		ArbreInt a = new ArbreInt(gche, 10, drt);
		//dessin = new Dessin<Integer>(a);

		System.out.println("Infixe");
		a.parcoursInfixe();
		System.out.println("\nPrefixe");
		a.parcoursPrefixe();
		System.out.println("\nPostfixe");
		a.parcoursPostfixe();
		System.out.println("\nParcour Largeur");
		a.parcoursLargeur();
		
		String sa = new String("1+1");
		ArbreCalcul arbr = new ArbreCalcul(sa);
		dessin = new Dessin<String>(arbr);
		System.out.println(arbr.calcul());
		/*Arbre<java.lang.String> unArbre = new Arbre<java.lang.String>(new Arbre(),s1,new Arbre());
		dessin = new Dessin<java.lang.String>(unArbre);*/
		
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 800, 500);
			root.setCenter(dessin);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Arbre");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) {
		launch(args);
	}

}
/*package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.arbre.Arbre;
import vue.Dessin;

public class ArbreApplication extends Application {

	private Dessin<Integer> dessin;

	@Override
	public void init() {
		Arbre gche = new Arbre(new Arbre(new Arbre(),2,new Arbre(3)), 1, new Arbre(new Arbre(8),7,new Arbre(new Arbre(4),5,new Arbre())));
		Arbre drt = new Arbre(new Arbre(new Arbre(),11,new Arbre(0)), 6, new Arbre(17));
		Arbre a = new Arbre(gche, 10, drt);
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
		dessin = new Dessin<Integer>(a);

		System.out.println("Infixe");
		a.parcoursInfixe();
		System.out.println("\nPrefixe");
		a.parcoursPrefixe();
		System.out.println("\nPostfixe");
		a.parcoursPostfixe();
<<<<<<< HEAD
		System.out.println("\nPParcour Largeur");
		a.parcoursLargeur();
		
		ABRInt gche2 = new ABRInt(new ABRInt(new ABRInt(),8,new ABRInt(10)),12,new ABRInt(new ABRInt(13),14,new ABRInt()));
		ABRInt drt2 = new ABRInt(new ABRInt(new ABRInt(),16,new ABRInt(new ABRInt(17),18,new ABRInt(19))),20,new ABRInt(21));
		ABRInt b = new ABRInt(gche2,15,drt2);
		dessin = new Dessin<Integer>(b);
		
		System.out.println("\n\n"+b.min());
=======
		System.out.println("\nParcour Largeur");
		a.parcoursLargeur();
		
		
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 800, 500);
			root.setCenter(dessin);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Arbre");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

<<<<<<< HEAD
}
=======
}*/
>>>>>>> 2b23567cd8e7ad6962e0c44ea5bb054caaaaba8c
