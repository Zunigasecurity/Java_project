package bot;

public class Bot {

	/*
	 * CI STAVO PROVANDO, MA HO PREFERITO COMPLETARE LA PARTE PRINCIPALE
	 * 
	 * -------COMPARA LA CARTA CHECK----
	 * 
	 * public boolean comparaCarte(Carta carta) {
	 * 
	 * if (this.seme == carta.getSeme() && this.valore.ordinal() + 1 ==
	 * carta.getValoreAsInt()) return true; return false;
	 * 
	 * }
	 * 
	 * public boolean scegliCarta(Carta mia, Stack<Carta> mazzoMio) {
	 * 
	 * for (int i = 0; i < ; i++) { if (carteTavola[i].getSeme() == Seme.DENARI &&
	 * mia.getValore().ordinal() == carteTavola[i].getValore().ordinal()) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(mia); return true; }
	 * 
	 * else if (mia.getValore().ordinal() == carteTavola[i].getValore().ordinal()) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(mia); return true; }
	 * 
	 * // --CONTROLLA SE LA CARTA PASSATA è UGUALE ALLA SOMMA TRA 2 CARTE---
	 * 
	 * for (int j = 0; j < numeroCarte; j++) { if ((carteTavola[i].getSeme() ==
	 * Seme.DENARI && carteTavola[j].getSeme() == Seme.DENARI ||
	 * carteTavola[i].getSeme() == Seme.DENARI || carteTavola[j].getSeme() ==
	 * Seme.DENARI) && (mia.getValore().ordinal() + AUMENTAEN ==
	 * (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN))) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(mia); return true; }
	 * 
	 * else if (mia.getValore().ordinal() + 1 ==
	 * (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN)) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(mia); return true; }
	 * 
	 * // --CONTROLLA SE LA CARTA PASSATA è UGUALE ALLA SOMMA TRA 3 CARTE---
	 * 
	 * for (int k = 0; k < numeroCarte; k++) { if ((carteTavola[i].getSeme() ==
	 * Seme.DENARI && carteTavola[j].getSeme() == Seme.DENARI &&
	 * carteTavola[k].getSeme() == Seme.DENARI || carteTavola[i].getSeme() ==
	 * Seme.DENARI || carteTavola[j].getSeme() == Seme.DENARI ||
	 * carteTavola[k].getSeme() == Seme.DENARI || carteTavola[i].getSeme() ==
	 * Seme.DENARI && carteTavola[j].getSeme() == Seme.DENARI ||
	 * carteTavola[i].getSeme() == Seme.DENARI && carteTavola[k].getSeme() ==
	 * Seme.DENARI || carteTavola[j].getSeme() == Seme.DENARI &&
	 * carteTavola[k].getSeme() == Seme.DENARI) && (mia.getValore().ordinal() +
	 * AUMENTAEN == (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[k].getValore().ordinal() + AUMENTAEN))) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(mia); return true; }
	 * 
	 * else if (mia.getValore().ordinal() + AUMENTAEN ==
	 * (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[k].getValore().ordinal() + AUMENTAEN)) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(carteTavola[k]); mazzoMio.push(mia); return true; }
	 * 
	 * // --CONTROLLA SE LA CARTA PASSATA è UGUALE ALLA SOMMA TRA 4 CARTE---
	 * 
	 * for (int l = 0; l < numeroCarte; l++) { if ((carteTavola[i].getSeme() ==
	 * Seme.DENARI && carteTavola[j].getSeme() == Seme.DENARI &&
	 * carteTavola[k].getSeme() == Seme.DENARI && carteTavola[l].getSeme() ==
	 * Seme.DENARI || carteTavola[i].getSeme() == Seme.DENARI ||
	 * carteTavola[j].getSeme() == Seme.DENARI || carteTavola[k].getSeme() ==
	 * Seme.DENARI || carteTavola[l].getSeme() == Seme.DENARI ||
	 * carteTavola[i].getSeme() == Seme.DENARI && carteTavola[j].getSeme() ==
	 * Seme.DENARI || carteTavola[i].getSeme() == Seme.DENARI &&
	 * carteTavola[k].getSeme() == Seme.DENARI || carteTavola[i].getSeme() ==
	 * Seme.DENARI && carteTavola[l].getSeme() == Seme.DENARI ||
	 * carteTavola[j].getSeme() == Seme.DENARI && carteTavola[k].getSeme() ==
	 * Seme.DENARI || carteTavola[j].getSeme() == Seme.DENARI &&
	 * carteTavola[l].getSeme() == Seme.DENARI || carteTavola[k].getSeme() ==
	 * Seme.DENARI && carteTavola[l].getSeme() == Seme.DENARI) &&
	 * (mia.getValore().ordinal() + AUMENTAEN ==
	 * (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[k].getValore().ordinal() + AUMENTAEN))) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(carteTavola[k]); mazzoMio.push(carteTavola[l]);
	 * mazzoMio.push(mia); return true; }
	 * 
	 * if (mia.getValore().ordinal() + AUMENTAEN ==
	 * (carteTavola[i].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[j].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[k].getValore().ordinal() + AUMENTAEN +
	 * carteTavola[l].getValore().ordinal() + AUMENTAEN)) {
	 * mazzoMio.push(carteTavola[i]); mazzoMio.push(carteTavola[j]);
	 * mazzoMio.push(carteTavola[k]); mazzoMio.push(carteTavola[l]);
	 * mazzoMio.push(mia); return true; }
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * 
	 * public void CalcolaCombinazione(Carta carta) { Random random = new Random();
	 * while (numeroCarte > 0) if (carta.getValore() ==
	 * carteTavola[random.nextInt(numeroCarte)].getValore()) // SE LA CARTA è UGUALE
	 * AD 1 CARTA numeroCarte -= 1;
	 * 
	 * else if (carta.getValore() ==
	 * ()carteTavola[random.nextInt(numeroCarte)].getValore()+
	 * carteTavola[random.nextInt(numeroCarte)].getValore()) // SE LA CARTA è UGUALE
	 * A 2 CARTE numeroCarte -= 2; else if (carta.getValore() ==
	 * carteTavola[random.nextInt(numeroCarte)].getValore() +
	 * carteTavola[random.nextInt(numeroCarte)].getValore() // SE LA CARTA è UGUALE
	 * A 3 CARTE + carteTavola[random.nextInt(numeroCarte)].getValore()) numeroCarte
	 * -= 3; else if (carta.getValore() ==
	 * carteTavola[random.nextInt(numeroCarte)].getValore() +
	 * carteTavola[random.nextInt(numeroCarte)].getValore() +
	 * carteTavola[random.nextInt(numeroCarte)].getValore() +
	 * carteTavola[random.nextInt(numeroCarte)].getValore()) // SE LA CARTA è UGUALE
	 * A 4 CARTE numeroCarte -= 4;
	 * 
	 * }
	 */
}
