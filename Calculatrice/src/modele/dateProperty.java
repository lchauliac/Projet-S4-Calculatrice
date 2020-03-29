package modele;

import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

public class dateProperty extends Observable{
	private Timer time;
	
	public dateProperty(Timer time) {
		super();
		this.time = time;
	}

	
	private void addObserver() {
		class UneClasse implements Observer{
			private Timer limiteTimer;
			public UneClasse(Timer limiteTimer) {
				this.limiteTimer = limiteTimer;
			}

			@Override
			public void update(Observable o, Object arg) {
				// TODO Auto-generated method stub
				
			}
		};
		Observer o = new UneClasse(this.time);
		//this.addObserver(UneClasse());
	}

	public Timer getTimer() {
		return time;
	}

	public void setTimer(Timer timer) {
		this.time = timer;
	}
}
