package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import giocatore.Giocatore;
import tavolo.Tavolo;

public class IO {

	// METODI ED ATTRIBUTI STATICI PERCHè PER OGNI GIOCATORE SARANNO CREATI QUESTI
	// ELMENTI INOLTRE CREO UNA SOLA VARIABILE "BR" POICHè LA RIUTILIZZO

	static BufferedReader br;

	public static String getNome() {

		br = new BufferedReader(new InputStreamReader(System.in));
		String stringa = "";
		System.out.println("Inserisci il nome del giocatore: ");
		try {
			stringa = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringa;

	}

	public static int scartaCarta(Giocatore giocatore, Tavolo tavolo) {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(tavolo.getTavoloAsString());
		System.out.println(giocatore.getManoasString());
		System.out.println("\nInserisci la posizione della carta che vuoi scartare " + giocatore.getNome() + ": ");
		int a = 0;
		try {
			a = (Integer.parseInt(br.readLine()) - 1); // Poichè stampo la mano aggiungendo "1"
			// if (giocatore.getMano().size() == 0)
			// a += 1;
			while (a < 0 || a > (giocatore.getMano().size() - 1)) {

				System.out.println("\nHai inserito la posizione: " + (a + 1) + " che non esiste\n"
						+ "Inserisci un nuovo numero\n");

				a = (Integer.parseInt(br.readLine()) - 1);

			}
		} catch (IOException e) {
			System.out.println(
					"\nInserimento errato, puoi inserire esclusivamente i numeri, in base alla mano, senza spazi");
			scartaCarta(giocatore, tavolo);
			// e.printStackTrace();

		} catch (NumberFormatException ex) { // Indica la stringa inserita è stata trsformato in un numero, ma la
												// stringa non ha il giusto formato
			System.out.println(
					"\nInserimento errato, puoi inserire esclusivamente i numeri, in base alla mano, senza spazi");
			scartaCarta(giocatore, tavolo);
		}
		return a;

	}
}
