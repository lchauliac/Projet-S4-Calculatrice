package controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.Calculatrice;
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;

public class SampleController implements Initializable { 

	private Calculatrice calculette;
	private String randCalcul;

	//--FXML-----------------------------------------------------
	@FXML
	private TextArea ecran;

	@FXML
	private TextField zoneCalcul;

	@FXML
	private Button toucheAddition;

	@FXML
	private Button toucheSoustraction;

	@FXML
	private Button toucheMultiplication;

	@FXML
	private Button toucheDiviser;

	@FXML
	private Button toucheParentheseO;

	@FXML
	private Button touchePoint;

	@FXML
	private Button toucheExit;

	@FXML
	private Button toucheJeux;

	@FXML
	private Button touchePourcentage;

	@FXML
	private Button toucheParentheseF;

	@FXML
	private Button toucheManuel;

	@FXML
	private Button toucheNext;

	@FXML
	private Button touche9;

	@FXML
	private Button touche8;

	@FXML
	private Button touche7;

	@FXML
	private Button touche6;

	@FXML
	private Button touche5;

	@FXML
	private Button touche4;

	@FXML
	private Button touche3;

	@FXML
	private Button touche2;

	@FXML
	private Button touche1;

	@FXML
	private Button touche0;

	@FXML
	private Button toucheSupp;

	@FXML
	private Button toucheEgal;


	//--KeyBoard-----------------------------------------------------
	@FXML
	void enter0(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"0");
	}

	@FXML
	void enter1(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"1");
	}

	@FXML
	void enter2(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"2");
	}

	@FXML
	void enter3(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"3");
	}

	@FXML
	void enter4(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"4");
	}

	@FXML
	void enter5(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"5");
	}

	@FXML
	void enter6(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"6");
	}

	@FXML
	void enter7(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"7");
	}

	@FXML
	void enter8(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"8");

	}

	@FXML
	void enter9(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"9");
	}


	//--Calcul---------------------------------
	@FXML
	void enterAddition(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"+");
	}

	@FXML
	void enterSoustraction(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"-");

	}

	@FXML
	void enterMultiplication(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"*");
	}

	@FXML
	void enterDiviser(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"/");
	}

	//--Fonctionalite-----------------------------------------------------
	@FXML
	void enterEgal(ActionEvent event) {
		if(this.randCalcul.getS() == "") {
			if(this.calculette.verificationCalcul()) {
				this.ecran.appendText(this.zoneCalcul.textProperty().get()+" = "+this.calculette.calcul()+"\n");
				this.calculette.getExpr().set("");
			}
			else {
				this.ecran.appendText("Erreur : Le calcul saisie n'est pas correct.\n");
			}
		}
		else {
			double res = this.calculette.calcul(this.randCalcul);
			res = res*100;
			res = Math.round(res);
			res = res/100;
			System.out.println(res);
			double saisie = Double.parseDouble(this.zoneCalcul.textProperty().get());
			if(saisie == res ) {
				this.ecran.appendText(res+"  Vrai\n");
				this.calculette.getExpr().set("");
			}
			else {
				this.ecran.appendText(" X\n");
				this.ecran.appendText("Faux resultat etait :"+res+"\n");
			}
		}
	}

	@FXML
	void enterExit(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void enterManuel(ActionEvent event) {

	}

	@FXML
	void enterNext(ActionEvent event) {

	}

	@FXML
	void enterParentheseF(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+")");

	}

	@FXML
	void enterParentheseO(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"(");
	}

	@FXML
	void enterPoint(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+".");

	}

	@FXML
	void enterPourcentage(ActionEvent event) {
		this.calculette.getExpr().set(this.calculette.getExpr().get()+"%");

	}

	@FXML
	void enterSupp(ActionEvent event) {
		if (this.calculette.getExpr().get().length() != 0) {
			this.calculette.getExpr().set(this.calculette.getExpr().get().substring(0, this.calculette.getExpr().get().length()-1));
		}

	}

	@FXML
	void enterjeux(ActionEvent event) {
		this.randCalcul = this.calculette.createRandomCalcul();
		this.ecran.appendText("Calculer: "+this.randCalcul+"=");
	}

	//--Initialisation-----------------------------------------------------

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.calculette = new Calculatrice();
		zoneCalcul.textProperty().bind(this.calculette.getExpr());
		this.randCalcul = new String("");
	}



}
