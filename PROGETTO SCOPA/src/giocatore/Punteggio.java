package giocatore;

import java.util.ArrayList;
import java.util.Stack;

import enumerazioni.Seme;
import mazzo.Carta;

public class Punteggio {

	private ArrayList<Carta> denari, bastoni, coppe, spade;
	private Giocatore g1, g2;
	private int punteggioPrimiera;

	public Punteggio(Giocatore g1, Giocatore g2) {
		this.g1 = g1;
		this.g2 = g2;
	}

	public void calcolaPunteggio(Integer[] punti, Stack<Carta> mazzoMio, Giocatore g) {

		this.punteggioPrimiera = 0;

		// PRIMA DIVIDO IN BASE AL SEME IL MAZZO POI CALCOLO PUNTEGGION PRIMIERA

		denari = new ArrayList<Carta>();
		coppe = new ArrayList<Carta>();
		bastoni = new ArrayList<Carta>();
		spade = new ArrayList<Carta>();

		// PUNTEGGIO PER LA PRIMIERA

		for (Carta a : mazzoMio) {
			if (a.getSeme() == Seme.BASTONI)
				bastoni.add(a);
			if (a.getSeme() == Seme.COPPE)
				coppe.add(a);
			if (a.getSeme() == Seme.DENARI)
				denari.add(a);
			if (a.getSeme() == Seme.SPADE)
				spade.add(a);
		}
		if (bastoni.size() >= 1 && denari.size() >= 1 && spade.size() >= 1 && coppe.size() >= 1) {

			for (Carta a : bastoni)
				punteggioPrimiera += a.getValoreAsIntPrimiera();
			for (Carta a : denari)
				punteggioPrimiera += a.getValoreAsIntPrimiera();
			for (Carta a : coppe)
				punteggioPrimiera += a.getValoreAsIntPrimiera();
			for (Carta a : spade)
				punteggioPrimiera += a.getValoreAsIntPrimiera();
		}

		// PUNTEGIO PER DENARI E CARTE E SETTEBELLO

		for (Carta a : denari) {
			if (a.comparaCartaSetteBello())
				punti[1] = 1;
		}
		if (denari.size() >= 6)
			punti[2] = 1;
		if (mazzoMio.size() >= 21)
			punti[3] = 1;

		g.setPunteggioPrimiera(punteggioPrimiera);
	}

	public void assegnaPrimiera(int puntPrim, int puntSec, Integer[] punti1, Integer[] punti2) {

		if (puntPrim > puntSec)
			punti1[0] = 1;
		if (puntPrim < puntSec)
			punti2[0] = 1;

	}

	public String stampaPunteggio(Giocatore g1, Integer punti[]) {

		String s = "";
		if (punti[0] == 1)
			s += "\nHa 1 punto per la 'Primiera' ";
		if (punti[1] == 1)
			s += "\nHa 1 punto per il 'Settebello' ";
		if (punti[2] == 1)
			s += "\nHa 1 punto per i 'Denari' ";
		if (punti[3] == 1)
			s += "\nHa 1 punto per le 'Carte' ";
		if (punti[4] == 1)
			s += "\nHa " + punti[4] + " punto per la 'Scopa' ";
		if (punti[4] > 1)
			s += "\nHa " + punti[4] + " punti per la 'Scopa' ";
		return s;

	}

	public int confrontaPunteggio(Integer[] punteggio1, Integer[] punteggio2) {

		// CALCOLO I PUNTEGGI DI ENTRAMBI DAGLI ARRAY

		int totale1 = 0;
		int totale2 = 0;
		for (int i = 0; i < punteggio1.length; i++) {
			totale1 += punteggio1[i];
			totale2 += punteggio2[i];
		}

		// ASSEGNO AI GIOCATORI I PUNTEGGI TOTALIZZATI

		g1.setPunteggio(totale1);
		g2.setPunteggio(totale2);

		if (totale1 > totale2)
			return 1;
		if (totale1 < totale2)
			return -1;
		return 0;

	}

	public int getPunteggio(Giocatore g) {
		return g.getPunteggio();
	}

}
