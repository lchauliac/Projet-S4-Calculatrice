package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.abr.ABR;
import modele.abr.ABRInt;
import modele.arbre.ArbreInt;
import vue.Dessin;

public class ArbreApplication extends Application {

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
		dessin = new Dessin<Integer>(a);

		System.out.println("Infixe");
		a.parcoursInfixe();
		System.out.println("\nPrefixe");
		a.parcoursPrefixe();
		System.out.println("\nPostfixe");
		a.parcoursPostfixe();
		System.out.println("\nPParcour Largeur");
		a.parcoursLargeur();
		
		ABRInt gche2 = new ABRInt(new ABRInt(new ABRInt(),8,new ABRInt(10)),12,new ABRInt(new ABRInt(13),14,new ABRInt()));
		ABRInt drt2 = new ABRInt(new ABRInt(new ABRInt(),16,new ABRInt(new ABRInt(17),18,new ABRInt(19))),20,new ABRInt(21));
		ABRInt b = new ABRInt(gche2,15,drt2);
		dessin = new Dessin<Integer>(b);
		
		System.out.println("\n\n"+b.min());
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

}
