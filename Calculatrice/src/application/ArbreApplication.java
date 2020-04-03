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
import modele.arbreCalcul.operation.Addition;
import modele.arbreCalcul.operation.Division;
import modele.arbreCalcul.operation.Multiplication;
import modele.arbreCalcul.operation.Operateur;
import modele.arbreCalcul.operation.Soustraction;
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
		
		ArrayList<Operateur> ops = new ArrayList<Operateur>();
		ops.add(new Addition());
		ops.add(new Soustraction());
		ops.add(new Multiplication());
		ops.add(new Division());
		
		String sa = new String("2+(1+1)*(5-1)");
		ArbreCalcul arbr = new ArbreCalcul(sa,ops);
		dessin = new Dessin<String>(arbr);
		
		
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