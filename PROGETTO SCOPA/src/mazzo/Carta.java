package mazzo;

import enumerazioni.Seme;
import enumerazioni.Valore;

public class Carta {

//---------ATTRIBUTI----

	private Valore valore;
	private Seme seme;

//---------COSTRUTTORE----

	public Carta(int ilValore, int ilSeme) {
		this.valore = Valore.valueOf(ilValore);
		this.seme = Seme.valueOf(ilSeme);

	}

//----COMPARA CARTA CON SETTEBELLO----

	public boolean comparaCartaSetteBello() {
		if ((getSeme() == Seme.DENARI && getValoreAsValore() == Valore.SETTE)) {
			return true;
		}
		return false;
	}

	/*
	 * //-------COMPARA LA CARTA CHECK----
	 * 
	 * public boolean comparaCarte(Carta carta) {
	 * 
	 * if (this.seme == carta.getSeme() && this.valore.ordinal() + 1 ==
	 * carta.getValoreAsInt()) return true; return false;
	 * 
	 * }
	 */

//--------VARI GET----

	public Seme getSeme() {
		return seme;
	}

	public Valore getValoreAsValore() {
		return valore;
	}

	public int getValoreAsInt() {
		return valore.ordinal() + 1;
	}

	public int getValoreAsIntPrimiera() {

		if (this.valore == Valore.SETTE)
			return 21;
		if (this.valore == Valore.SEI)
			return 18;
		if (this.valore == Valore.ASSO)
			return 16;
		if (this.valore == Valore.CINQUE)
			return 15;
		if (this.valore == Valore.QUATTRO)
			return 14;
		if (this.valore == Valore.TRE)
			return 13;
		if (this.valore == Valore.DUE)
			return 12;
		else
			return 10;
	}

	public String getSemeAsString(Carta carta) {

		return carta.seme.getName();

	}

	public String getValoreAsString(Carta carta) {

		return carta.seme.getName();

	}

	public String getCartaAsString() {

		return " seme: " + this.seme.getName() + " - valore: " + this.valore.getName() + "\n";

	}

}
