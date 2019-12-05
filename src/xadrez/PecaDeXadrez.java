package xadrez;

import JogoDeTabuleiro.Peca;
import JogoDeTabuleiro.Posicao;
import JogoDeTabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca{
	
	private Color color;

	public PecaDeXadrez(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color; 
	}
	
	protected boolean existePecaDoOponente(Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getColor() != color;
	}
	

}
