package modele;

public class time {
	//Attribut
	private UniteTemps heure;
	private UniteTemps minute;
	private UniteTemps seconde;
	
	//Construct
	public time(int heure, int minute, int seconde) {
		this.heure = new UniteTemps(24,heure);
		this.minute  = new UniteTemps(60,minute);
		this.seconde  = new UniteTemps(60,seconde);
	}
	public time() {
		this(0,0,0);
	}
	
	//Methods
	public void passezTemps() {
		int res = this.seconde.augmente();
		if(res>0) {
			res = this.minute.augmente(res);
			if(res>0) {
				res = this.heure.augmente(res);
				if(res>0) {
					throw new Error("Erreur impossible d'augmenter");
				}
			}
		}
	}
}
