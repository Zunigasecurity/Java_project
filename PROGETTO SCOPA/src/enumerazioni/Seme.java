package enumerazioni;

//CONTIENE TUTTI I SEMI POSSIBILI

public enum Seme {
	SPADE, BASTONI, COPPE, DENARI;

	public String getName() {
		return name(); // Returna il nome tipo: "SPADE, BASTONI..."
	}

	public static Seme valueOf(int i) {
		Seme seme = null;
		switch (i) {
		case 0: {
			seme = Seme.SPADE;
			break;
		}
		case 1: {
			seme = Seme.BASTONI;
			break;
		}
		case 2: {
			seme = Seme.COPPE;
			break;
		}
		case 3: {
			seme = Seme.DENARI;
			break;
		}

		}
		return seme;
	}
}
