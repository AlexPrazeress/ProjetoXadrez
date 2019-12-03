package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.XadrezExcption;

public class Programa {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		
		while (true) {
			try {
				Ui.limparTela();
				Ui.impressaoDeTabuleiro(partidaDeXadrez.getPecas());
				System.out.println();
				System.out.println("Source: ");
				PosicaoDoXadrez source = Ui.lerPosicaoDoUsuario(sc);
				
				System.out.println();
				System.out.println("Target: ");
				PosicaoDoXadrez target = Ui.lerPosicaoDoUsuario(sc);
			
				PecaDeXadrez capturaDaPeca = partidaDeXadrez.ExecutarXadrez(source, target);
			}
			catch(XadrezExcption e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
