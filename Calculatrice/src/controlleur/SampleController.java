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
import modele.arbreCalcul.ArbreCalcul;
import modele.arbreCalcul.String;

public class SampleController implements Initializable { 

	private ArbreCalcul ac;

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

	private StringProperty calculActuel;


	//--KeyBoard-----------------------------------------------------
	@FXML
	void enter0(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"0");
	}

	@FXML
	void enter1(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"1");
	}

	@FXML
	void enter2(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"2");
	}

	@FXML
	void enter3(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"3");
	}

	@FXML
	void enter4(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"4");
	}

	@FXML
	void enter5(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"5");
	}

	@FXML
	void enter6(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"6");
	}

	@FXML
	void enter7(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"7");
	}

	@FXML
	void enter8(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"8");

	}

	@FXML
	void enter9(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"9");
	}


	//--Calcul---------------------------------
	@FXML
	void enterAddition(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"+");
	}

	@FXML
	void enterSoustraction(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"-");

	}

	@FXML
	void enterMultiplication(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"*");
	}

	@FXML
	void enterDiviser(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"/");
	}

	//--Fonctionalité-----------------------------------------------------
	@FXML
	void enterEgal(ActionEvent event) {
		this.ac = new ArbreCalcul(new String(this.calculActuel.get()));
		this.ecran.appendText(this.calculActuel.get()+" = "+this.ac.calcul()+"\n");
		this.calculActuel.set("");
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
		this.calculActuel.set(this.calculActuel.get()+")");

	}

	@FXML
	void enterParentheseO(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"(");
	}

	@FXML
	void enterPoint(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+".");

	}

	@FXML
	void enterPourcentage(ActionEvent event) {
		this.calculActuel.set(this.calculActuel.get()+"%");

	}

	@FXML
	void enterSupp(ActionEvent event) {
		if (this.calculActuel.get().length() != 0) {
			this.calculActuel.set(this.calculActuel.get().substring(0, this.calculActuel.get().length()-1));
		}

	}

	@FXML
	void enterjeux(ActionEvent event) {

	}

	//--Initialisation-----------------------------------------------------

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.calculActuel = new SimpleStringProperty();
		this.calculActuel.set("");
		zoneCalcul.textProperty().bind(this.calculActuel);
	}



}
