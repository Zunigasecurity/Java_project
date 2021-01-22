package tavolo;

import java.util.ArrayList;
import mazzo.Carta;
import mazzo.Mazzo;

public class Tavolo {

//----ATTRIBUTI---

	private ArrayList<Carta> tavolo;
	private static final int CARTETAVOLOSTART = 4; // Numero di carte da distribuire all'inizio

//----COSTRUTTORE---

	public Tavolo(Mazzo mazzo) {
		tavolo = new ArrayList<Carta>();
		for (int i = 0; i < CARTETAVOLOSTART; i++)
			tavolo.add(mazzo.next());

	}
	
//----AGGIUNGI UNA CARTA---

	public void aggiungiCarta(Carta carta) {
		tavolo.add(carta);
	}

//----RITORNA IL TAVOLO---

	public ArrayList<Carta> getTavolo() {
		return tavolo;
		
		// PERCHè AL GIOCATORE PASSERò QUESTO QUANDO DOVRà AGGIUNGERE LA CARTA

	}

//----TAVOLO COME STRINGA CHECK---	

	public String getTavoloAsString() {
		String stringa = "------------------TAVOLO-------------------\n";
		for (int i = 0; i < tavolo.size(); i++)
			stringa += "Nella " + (i + 1) + " posizione: " + tavolo.get(i).getCartaAsString();
		//System.out.println();
		return stringa + "\n--------------------------------------------------";

	}

}