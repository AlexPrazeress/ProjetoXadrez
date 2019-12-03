package xadrez;

import JogoDeTabuleiro.TabuleiroException;

public class XadrezExcption extends TabuleiroException{
	private static final long serialVersionUID = 1L;
	
	public XadrezExcption(String msg) {
		super(msg);
	}
	
}
