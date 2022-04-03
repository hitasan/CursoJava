package secao05;

import java.util.Scanner;

public class secao5_4 {

	public static void main(String[] args) {
		int hrIni, hrFim, duracao;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a hora inicial: ");
		hrIni = sc.nextInt();
		System.out.print("Digite a hora final: ");
		hrFim = sc.nextInt();

		System.out.println("---------------------------------------------------------------------------------");
		
		if (hrIni < hrFim) {
			duracao = hrFim - hrIni;
		}
		else {
			duracao = 24 - hrIni + hrFim;
		}
		
		System.out.printf("O jogo durou %d hora(s).", duracao);
		
		sc.close();
	}

}
