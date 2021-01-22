package mazzo;

import java.util.Iterator;

import java.util.Random;
import java.util.Stack;

public class Mazzo implements Iterator<Carta> {

//-----------ATTRIBUTI-------

	private static final int SEMI = 4;
	private static final int VALORI = 10;
	private Stack<Carta> stack;
	private int carteNelloStack[][];
	
//-----------COSTRUTTORE------

	public Mazzo() {
		carteNelloStack = new int[VALORI][SEMI]; 
		stack = new Stack<Carta>();

		// ----Azzera matrice in cui ho i valori ed i semi, ed ogni volta che creo unaq
		// carta con alcuni semi/valori nella matrice segno "1" in quella determinata
		// posizione---

		for (int j = 0; j < VALORI; j++)
			for (int i = 0; i < SEMI; i++)
				carteNelloStack[j][i] = 0;

//---------MESCOLA IL MAZZO------

		Random random = new Random();
		int valSeme;
		int valValore;
		while (mazzoCompleto()) { // Finchè il mazzo non è completo
			valSeme = random.nextInt(SEMI);
			valValore = random.nextInt(VALORI);
			if (carteNelloStack[valValore][valSeme] == 0) { // Se non ci sono carte nella posizione TOT
				stack.push(new Carta(valValore, valSeme)); // Metti nello stack una carta
				carteNelloStack[valValore][valSeme] = 1; // Ricordati che ci abbiamo messo una carta
			}
		}
	}

//----------VERIFICA CHE IL MAZZO è COMPLETO---

	private boolean mazzoCompleto() {
		int conta = 0;
		for (int i = 0; i < VALORI; i++)
			for (int j = 0; j < SEMI; j++)
				conta += carteNelloStack[i][j];
		if (conta == VALORI * SEMI)
			return false;
		// Se ho tutte le carte, ritorna true

		return true;
	}

//----------CONTROLLA SE IL MAZZO HA ALTRE CARTE---

	@Override
	public boolean hasNext() { 
		if (stack.empty())
			return false;
		return true;
	}
	
//----MAZZO COME STRINGA---

	public String getMazzoAsString() {
		String stringa = "";
		Carta a;
		while (!stack.isEmpty()) {
			a = stack.pop();
			stringa += a.getCartaAsString();

		}
		return stringa;
	}

//---------DISTRIBUISCI CARTE---------

	@Override
	public Carta next() { 
		return stack.pop(); 
	}
//----VARI GET---
	
	public Stack<Carta> getMazzo() {
		return stack;
	}

}