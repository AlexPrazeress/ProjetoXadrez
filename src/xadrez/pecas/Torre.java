package xadrez.pecas;

import JogoDeTabuleiro.Posicao;
import JogoDeTabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;

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
		
		Posicao p = new Posicao(0, 0);
		
		// Movendo para cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		
		while (getTabuleiro().existeAPosicao(p) && !getTabuleiro().existeUmaPecaNaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(getTabuleiro().existeAPosicao(p) &&  existePecaDoOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movendo para a esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		
		while (getTabuleiro().existeAPosicao(p) && !getTabuleiro().existeUmaPecaNaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if(getTabuleiro().existeAPosicao(p) &&  existePecaDoOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movendo para a direita
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		
		while (getTabuleiro().existeAPosicao(p) && !getTabuleiro().existeUmaPecaNaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if(getTabuleiro().existeAPosicao(p) &&  existePecaDoOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movendo para baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		
		while (getTabuleiro().existeAPosicao(p) && !getTabuleiro().existeUmaPecaNaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getTabuleiro().existeAPosicao(p) &&  existePecaDoOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}

}
