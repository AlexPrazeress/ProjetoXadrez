package aplicacao;

import xadrez.PartidaDeXadrez;

public class Programa {
	
	public static void main(String[] args) {
		
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		Ui.impressaoDeTabuleiro(partidaDeXadrez.getPecas());
	}

}
