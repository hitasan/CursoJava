package secao10;

import java.util.Locale;
import java.util.Scanner;

public class secao10_ex4 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe a quantidade de linhas da matriz: ");
		int m = sc.nextInt();

		System.out.print("Informe a quantidade de colunas da matriz: ");
		int n = sc.nextInt();

		int[][] mat = new int[m][n];	// declarando a matriz mat e instanciando ela com M linhas e N colunas 
		
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				mat[x][y] = sc.nextInt();
			}
			
		}

		System.out.println();
		System.out.println("Matriz informada: ");
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				if (y == 0)
					System.out.print("|" + mat[x][y] + " ");
				else if (y == (mat[x].length)-1)
					System.out.println(mat[x][y] + "|");
				else
					System.out.print(mat[x][y] + " ");
			}
		}
		
		System.out.println();
		System.out.print("Informe um valor que pertence a matriz: ");
		int num = sc.nextInt();
		
		System.out.println();
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				if (mat[x][y] == num) {
					System.out.println("Position: " + x + "," + y);
					if (y > 0)
						System.out.println("Left: " + mat[x][y-1] );
					if (y < (mat[x].length - 1))
						System.out.println("Right: " + mat[x][y+1] );
					if (x > 0)
						System.out.println("Up: " + mat[x-1][y] );
					if (x < (mat.length - 1))
						System.out.println("Down: " + mat[x+1][y] );
					
					System.out.println();
				}
			}
		}
		
		
		
		
		sc.close();

	}

}
