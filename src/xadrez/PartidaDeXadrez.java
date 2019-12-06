package xadrez;

import javax.transaction.xa.XAException;

import JogoDeTabuleiro.Peca;
import JogoDeTabuleiro.Posicao;
import JogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private int turno;
	private Color JogadorAtual;

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno =1;
		JogadorAtual = Color.WHITE;
		iniciarPartida();
	}
	
	public PecaDeXadrez[][] getPecas(){	
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	public int getTurno() {
		return turno;
	}

	public Color getJogadorAtual() {
		return JogadorAtual;
	}
	
	public boolean[][] possiveisMovimentos(PosicaoDoXadrez sourcePosicao) {
		Posicao posicao = sourcePosicao.toPosicao();
		validacaoDaPosicaoDeOrigem(posicao);
		return tabuleiro.peca(posicao).possiveisMovimentos();
	}

	public PecaDeXadrez ExecutarXadrez(PosicaoDoXadrez sourcePosicao, PosicaoDoXadrez targetPosicao) {
		Posicao source = sourcePosicao.toPosicao();
		Posicao target = targetPosicao.toPosicao();
		validacaoDaPosicaoDeOrigem(source);
		validacaoTargetPosicao(source, target);
		Peca capturaDaPeca = fazerMoverAPeca(source, target);
		trocarTurno();
		return (PecaDeXadrez)capturaDaPeca;
	}
	
	private Peca fazerMoverAPeca(Posicao source, Posicao target) {
		Peca p = tabuleiro.removePeca(source);
		Peca capturaDaPeca = tabuleiro.removePeca(target);
		tabuleiro.colocarPeca(p, target);
		return capturaDaPeca;
	}
	
	private void validacaoDaPosicaoDeOrigem(Posicao posicao) {
		if(!tabuleiro.existeUmaPecaNaPosicao(posicao)) {
			throw new XadrezExcption("N�o h� pe�a na posi��o de origem");
		}
		if(JogadorAtual != ((PecaDeXadrez)tabuleiro.peca(posicao)).getColor()){
			throw new XadrezExcption("A peca escolhida nao e sua");
		}
		if(!tabuleiro.peca(posicao).existeAlgumMovimentoPoss�vel()) {
			throw new XadrezExcption("Nao existem movimentos possiveis para a peca especifica");
		}
	}
	
	private void validacaoTargetPosicao(Posicao source, Posicao target) {
		if(!tabuleiro.peca(source).possiveisMovimento(target)) {
			throw new XadrezExcption("A peca escolhida nao pode se mover para a posicao de destino ");
		}
	}
	
	private void trocarTurno() {
		turno++;
		JogadorAtual = (JogadorAtual == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private void coloqueNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).toPosicao());
	}
	
	private void iniciarPartida() {
		coloqueNovaPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
		coloqueNovaPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
		coloqueNovaPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
		coloqueNovaPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
		coloqueNovaPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
		coloqueNovaPeca('d', 1, new Rei(tabuleiro, Color.WHITE));
		
		coloqueNovaPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
		coloqueNovaPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
		coloqueNovaPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
		coloqueNovaPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
		coloqueNovaPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
		coloqueNovaPeca('d', 8, new Rei(tabuleiro, Color.BLACK));

	}
	
}
