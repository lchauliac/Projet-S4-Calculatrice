package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.arbre.Arbre;
import modele.arbre.ArbreInt;
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;
import vue.Dessin;

public class ArbreApplication extends Application {

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
		
		String sa = new String("a+(bb+cc)");
		ArbreCalcul arbr = new ArbreCalcul(sa);
		dessin = new Dessin<String>(arbr);
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
		dessin = new Dessin<Integer>(a);

		System.out.println("Infixe");
		a.parcoursInfixe();
		System.out.println("\nPrefixe");
		a.parcoursPrefixe();
		System.out.println("\nPostfixe");
		a.parcoursPostfixe();
		System.out.println("\nParcour Largeur");
		a.parcoursLargeur();
		
		
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

}*/
