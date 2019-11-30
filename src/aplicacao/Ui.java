package aplicacao;

import xadrez.PecaDeXadrez;

public class Ui {
	
	public static void impressaoDeTabuleiro(PecaDeXadrez[][] pecas) {
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j < pecas.length; j++) {		
				impressaoDePeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void impressaoDePeca(PecaDeXadrez peca) {
		if(peca == null) {
			System.out.print("-");
		}else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}

}
