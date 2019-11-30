package JogoDeTabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na criacao da tabela, e necessario que haja pelo menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}
	
	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if(!existeAPosicao(linha, coluna)) {
			throw new TabuleiroException("Posicao fora do quadro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!existeAPosicao(posicao)) {
			throw new TabuleiroException("Posicao fora do quadro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		if(existeUmaPecaNaPosicao(posicao)) {
			throw new TabuleiroException("Ja existe uma peca na posicao!");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean existeAPosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean existeAPosicao(Posicao posicao) {
		return existeAPosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existeUmaPecaNaPosicao(Posicao posicao) {
		if(!existeAPosicao(posicao)) {
			throw new TabuleiroException("Posicao fora do quadro");
		}
		return peca(posicao) != null;
	}
}
