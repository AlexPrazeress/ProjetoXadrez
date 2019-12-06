package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Color;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;

public class Ui {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void limparTela() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	public static PosicaoDoXadrez lerPosicaoDoUsuario(Scanner sc) {
		
		try {
			
			String s = sc.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoDoXadrez(coluna, linha);
		
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro instanciando a posicao do xadrez. valores validos de a1 ate h8");
		}
	}
	
	public static void impressaoDeTabuleiro(PecaDeXadrez[][] pecas) {
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j < pecas.length; j++) {		
				impressaoDePeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h"); 
	}
	
	public static void imprimirAPartida(PartidaDeXadrez partidaDeXadrez) {
		impressaoDeTabuleiro(partidaDeXadrez.getPecas());
		System.out.println();
		System.out.println("Turno: " + partidaDeXadrez.getTurno());
		System.out.println("Esperando o jogador jogar: " + partidaDeXadrez.getJogadorAtual());
	}
	
	public static void impressaoDeTabuleiro(PecaDeXadrez[][] pecas, boolean[][] possiveisMovimentos) {
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j < pecas.length; j++) {		
				impressaoDePeca(pecas[i][j],possiveisMovimentos[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h"); 
	}
	
	private static void impressaoDePeca(PecaDeXadrez peca, boolean backGround) {
		if(backGround) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (peca == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (peca.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}

}
