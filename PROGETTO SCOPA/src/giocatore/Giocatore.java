package giocatore;

import java.util.ArrayList;
import java.util.Stack;

import mazzo.Carta; //	L'import è differente dall'ereditarietà perchè non si eredita: il costruttore...
import mazzo.Mazzo;
import tavolo.Tavolo;

public class Giocatore {

//-------ATTRIBUTI---

	private static final int INPUTCARTE = 3; // Carte che vengono distribuite all'inizio del giro
	private ArrayList<Carta> mano;
	private Stack<Carta> mazzoMio;
	private Tavolo tavolo;
	private Mazzo mazzo;
	private String nome;
	private Integer[] punti;
	private int punteggio;
	private int punteggioPrimiera;

//--------COSTRUTTORE---

	public Giocatore(Mazzo mazzo, Tavolo tavolo, String nome, Integer[] punti) {
		this.mazzo = mazzo;
		this.tavolo = tavolo;
		this.nome = nome;
		this.punti = punti;
		this.punteggioPrimiera = 0;

		// AZZERO L'ARRAY DOVE METTERò I PUNTI

		for (int i = 0; i < punti.length; i++)
			punti[i] = 0;

		// CREO CIò CHE MI SERVE

		mazzoMio = new Stack<Carta>();
		mano = new ArrayList<Carta>();

		// DISTRIBUISCO LE CARTE E LE METTO NELLA MANO

		for (int i = 0; i < INPUTCARTE; i++)
			mano.add(mazzo.next());
	}

//----AGGIUNGI UNA CARTA AL MAZZO---

	public void addMazzoMio(Carta carta) {
		mazzoMio.add(carta);
	}

// ----SCARTA UNA CARTA---

	public boolean scartaCarta(int i) {
		Carta carta = mano.get(i);
		if (scegliCarta(carta) == true) { // SE HO PRESO DAL TAVOLO, RIMUOVI DALLA MANO E NEL CASO PESCA
			rimuoviPescaMano(carta);
			return true;
		} else {
			tavolo.aggiungiCarta(mano.get(i)); // SE NON HO PRESO DAL TAVOLO SCARTA DALLA MANO ED AGGIUNGILA AL TAVOLO
			rimuoviPescaMano(carta);
			return false;
		}
	}

//----RIMUOVI DALLA MANO E IN CASO, SE NON HAI NIENTE PESCA---

	private void rimuoviPescaMano(Carta carta) {
		mano.remove(carta);
		if (mano.size() == 0)
			pescaCarte();
	}

//----SCEGLI CARTA/CARTE RISOLVERE IL CONTINUE---

	private boolean scegliCarta(Carta cartaGiocata) {

		// ----CONTROLLA SE LA CARTA GIOCATA è UGUALE AD UN'ALTRA CARTA ED HA LA
		// PRIORITà: PRENDERE UNA SOLA CARTA CORRISPONDENTE ALLA TUA E CONTROLLA SE HAI
		// FATTO SCOPA, NEL CASO AGGIUNGE: 1 PUNTO AL
		// PUNTEGGIO---

		// --CONTROLLA SE LA CARTA GIOCATA è UGUALE AD UNA CARTA---

		for (int i = 0; i < tavolo.getTavolo().size(); i++) {
			if (cartaGiocata.getValoreAsInt() == tavolo.getTavolo().get(i).getValoreAsInt()) {
				mazzoMio.push(tavolo.getTavolo().get(i));
				mazzoMio.push(cartaGiocata);
				if (tavolo.getTavolo().size() == 1)
					punti[4] += 1; // Perchè nella posizione 4 dei punti c'è il punteggio per la scopa
				tavolo.getTavolo().remove(i);

				return true;
			}

		}

		// --CONTROLLA SE LA CARTA GIOCATA è UGUALE ALLA SOMMA TRA 2 CARTE---

		for (int i = 0; i < tavolo.getTavolo().size(); i++) {
			for (int j = 0; j < tavolo.getTavolo().size(); j++) {
				if (i == j)
					continue;
				if (cartaGiocata.getValoreAsInt() == (tavolo.getTavolo().get(i).getValoreAsInt()
						+ tavolo.getTavolo().get(j).getValoreAsInt())) {
					mazzoMio.push((tavolo.getTavolo().get(i)));
					mazzoMio.push((tavolo.getTavolo().get(j)));
					mazzoMio.push(cartaGiocata);
					if (tavolo.getTavolo().size() == 2)
						punti[4] += 1;
					tavolo.getTavolo().remove(j);
					tavolo.getTavolo().remove(i);
					return true;

					// INIZIO A TOGLIERE DALL'INDICE PIù GRANDE AL PIù PICCOLO
					// PERCHè PARTENDO DAL PIù GRANDE ED ESSENDO UN ARRAYLIST
					// TOGLIENDO 1, DIMINUISCE AUTOMATICAMENTE LA DIMENSIONE,
					// RIMUOVENDO DALL'INDICE PIù PICCOLO LA CARTA, LA CARTA
					// CON L'INDICE PIù GRANDE NON SARà PIù TROVATA POICHE L'ARRAY
					// DIMINUISCE LA DIMENSIONE
				}
			}
		}

		// --CONTROLLA SE LA CARTA PASSATA è UGUALE ALLA SOMMA TRA 3 CARTE---

		for (int i = 0; i < tavolo.getTavolo().size(); i++) {
			for (int j = 0; j < tavolo.getTavolo().size(); j++) {
				for (int k = 0; k < tavolo.getTavolo().size(); k++) {
					if (i == j || j == k || k == i)
						continue;
					if (cartaGiocata.getValoreAsInt() == (tavolo.getTavolo().get(i).getValoreAsInt()
							+ tavolo.getTavolo().get(j).getValoreAsInt()
							+ tavolo.getTavolo().get(k).getValoreAsInt())) {
						mazzoMio.push((tavolo.getTavolo().get(i)));
						mazzoMio.push((tavolo.getTavolo().get(j)));
						mazzoMio.push((tavolo.getTavolo().get(k)));
						mazzoMio.push(cartaGiocata);
						if (tavolo.getTavolo().size() == 3)
							punti[4] += 1;
						tavolo.getTavolo().remove(k);
						tavolo.getTavolo().remove(j);
						tavolo.getTavolo().remove(i);
						return true;

					}
				}
			}
		}

		// --CONTROLLA SE LA CARTA PASSATA è UGUALE ALLA SOMMA TRA 4 CARTE---

		for (int i = 0; i < tavolo.getTavolo().size(); i++) {
			for (int j = 0; j < tavolo.getTavolo().size(); j++) {
				for (int k = 0; k < tavolo.getTavolo().size(); k++) {
					for (int l = 0; l < tavolo.getTavolo().size(); l++) {
						if (i == j || i == k || i == l || j == k || j == l || k == l)
							continue;
						if (cartaGiocata.getValoreAsInt() == (tavolo.getTavolo().get(i).getValoreAsInt()
								+ tavolo.getTavolo().get(j).getValoreAsInt()
								+ tavolo.getTavolo().get(k).getValoreAsInt()
								+ tavolo.getTavolo().get(l).getValoreAsInt()))

						{
							mazzoMio.push(tavolo.getTavolo().get(i));
							mazzoMio.push(tavolo.getTavolo().get(j));
							mazzoMio.push(tavolo.getTavolo().get(k));
							mazzoMio.push(tavolo.getTavolo().get(l));
							mazzoMio.push(cartaGiocata);
							if (tavolo.getTavolo().size() == 4)
								punti[4] += 1;
							tavolo.getTavolo().remove(l);
							tavolo.getTavolo().remove(k);
							tavolo.getTavolo().remove(j);
							tavolo.getTavolo().remove(i);

							return true;
						}

					}

				}
			}

		}

		return false;

	}

//----PRENDI TUTTE LE CARTE CHE SONO RIMASTE NELLA MANO---

	public void chiudiMano() {
		while (!mano.isEmpty())
			mazzoMio.add((mano.remove(mano.size() - 1)));
	}

//----PRENDI CARTE DAL MAZZO INIZIO PARTITA---

	private void pescaCarte() {
		for (int i = 0; i < INPUTCARTE; i++)
			if (mazzo.hasNext())
				mano.add(mazzo.next());
	}

//----RETURNA IL PUNTEGGIO DELLA PRIMIERA, MI SERVE PER CONFRONTARLI ED ASSEGNARE IL PUNTO---

	public int getPunteggioPrimiera() {
		return punteggioPrimiera;
	}

//----PRENDI MANO COME STRINGA---

	public String getManoasString() {
		String stringa = "----------Mano di " + this.nome + "-------------------\n";
		for (int i = 0; i < mano.size(); i++) {
			stringa += (i + 1) + ") " + mano.get(i).getCartaAsString();
			// Nella "tot" posizione c'è la carta come stringa
		}
		return stringa + "---------------------------------------------";

	}

//----VARI GET E SET CHE RICHIAMO IN ALTRE PARTI----

	public Stack<Carta> getMazzoMio() {
		return mazzoMio;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public String getNome() {
		return nome;
	}

	public void setPunteggio(int totale) {
		this.punteggio = totale;

	}

	public void setPunteggioPrimiera(int totale) {
		this.punteggioPrimiera = totale;

	}

	public int getPunteggio() {
		return punteggio;
	}

}
