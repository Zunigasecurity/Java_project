package starter;

import giocatore.Giocatore;
import giocatore.Punteggio;
import io.IO;
import mazzo.Mazzo;
import tavolo.Tavolo;

public class Main {

	public static void main(String[] args) {

		boolean preso1 = false;
		boolean preso2 = false;

		Integer[] puntiG1 = new Integer[5];
		Integer[] puntiG2 = new Integer[5];

		String nomeG1 = IO.getNome();
		String nomeG2 = IO.getNome();

		Mazzo mazzo = new Mazzo();

		Tavolo tavolo = new Tavolo(mazzo);

		Giocatore g1 = new Giocatore(mazzo, tavolo, nomeG1, puntiG1);
		Giocatore g2 = new Giocatore(mazzo, tavolo, nomeG2, puntiG2);

		Punteggio punteggio = new Punteggio(g1, g2);

		int dimensioneMazzo = mazzo.getMazzo().size();

		for (int i = 1; i <= ((dimensioneMazzo / 2) + 3); i++) { // Poichè in ogni turno potranno essere scartate 3
																	// carte,
																	// e nell'ultimo turno sarà il giocatore che ha
																	// preso
																	// per ultimo a prendere le carte dal tavolo

			System.out.println("************TURNO" + i + "************\n");

			preso1 = g1.scartaCarta(IO.scartaCarta(g1, tavolo));
			if (preso1 == true) // Se effettivamente, g1, ha preso
				if (preso2 == true) // Controlla se ha preso g2
					preso1 = false; // Nel caso g2 ha preso, prenderà le carte del tavolo poichè è stato l'ultimo a
									// prendere

			preso2 = g2.scartaCarta(IO.scartaCarta(g2, tavolo));
			if (preso2 == true) // Se effettivamente, g1, ha preso
				if (preso1 == true) // Controlla se g1 ha preso
					preso2 = false; // Nel caso g1 ha preso, prenderà le carte dal tavolo poichè è stato l'ultimo a
									// prendere
		}

		// ----AGGIUNGO LE CARTE DEL TAVAVOLO AL GIOCATORE CHE HA PRESO PER ULTIMO---

		dimensioneMazzo = tavolo.getTavolo().size();
		if (preso1 == true) {
			for (int i = 0; i < dimensioneMazzo; i++) {
				g1.addMazzoMio(tavolo.getTavolo().get(i));
			}
		} else {
			for (int i = 0; i < dimensioneMazzo; i++) {
				g2.addMazzoMio(tavolo.getTavolo().get(i));
			}
		}
		System.out.println("*******FINE PARTITA!************");

		punteggio.calcolaPunteggio(puntiG2, g2.getMazzoMio(), g2);
		punteggio.calcolaPunteggio(puntiG1, g1.getMazzoMio(), g1);
		punteggio.assegnaPrimiera(g1.getPunteggioPrimiera(), g2.getPunteggioPrimiera(), puntiG1, puntiG2);
		int vittoria = punteggio.confrontaPunteggio(puntiG1, puntiG2);
		if (vittoria > 0)
			System.out.println("\nIL GIOCATORE: " + nomeG1 + " HA VINTO!");
		if (vittoria < 0)
			System.out.println("\nIL GIOCATORE: " + nomeG2 + " HA VINTO!");
		if (vittoria == 0)
			System.out.println("\nPAREGGIO!");

		System.out.println("\n*******PUNTEGGIO PARTITA*******");

		System.out.println("\nIL GIOCATORE: " + nomeG1 + " HA TOTALIZZATO " + punteggio.getPunteggio(g1) + " PUNTO/I!");
		System.out.println(punteggio.stampaPunteggio(g1, puntiG1));
		System.out.println("\nIL GIOCATORE: " + nomeG2 + " HA TOTALIZZATO " + punteggio.getPunteggio(g2) + " PUNTO/I!");
		System.out.println(punteggio.stampaPunteggio(g2, puntiG2));
		System.out.println("\nPARTITA CONCLUSA!");
	}
}
