package xadrez.pecas;

import JogoDeTabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}

}
