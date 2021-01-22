package enumerazioni;

//CONTIENE TUTTI I VALORI POSSIBILI

public enum Valore {
	ASSO, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, FANTE, CAVALLO, RE;

	public String getName() {
		return name(); // Returna una stringa: "UNO, DUE, TRE..."
	}

	public static Valore valueOf(int i) {
		Valore val = null;
		switch (i) {
		case 0: {
			val = Valore.ASSO;
			break;
		}
		case 1: {
			val = Valore.DUE;
			break;
		}
		case 2: {
			val = Valore.TRE;
			break;
		}
		case 3: {
			val = Valore.QUATTRO;
			break;
		}
		case 4: {
			val = Valore.CINQUE;
			break;
		}
		case 5: {
			val = Valore.SEI;
			break;
		}
		case 6: {
			val = Valore.SETTE;
			break;
		}
		case 7: {
			val = Valore.FANTE;
			break;
		}
		case 8: {
			val = Valore.CAVALLO;
			break;
		}
		case 9: {
			val = Valore.RE;
			break;
		}
		}
		return val;

	}
}
