package secao10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee_Lst;

public class secao10_5_Matriz {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe a ordem da matriz quadrada: ");
		int n = sc.nextInt();
		
		int[][] mat = new int[n][n];	// declarando a matriz mat e instanciando ela com N linhas e colunas 
		
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				mat[x][y] = sc.nextInt();
			}

		}
		
		 
		System.out.print("Main Diagonal: ");
		for (int x = 0; x < mat.length; x++) {
			System.out.print(mat[x][x] + " ");
		}

		
		int count = 0;
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				if (mat[x][y] < 0) {
					count++;
				}
			}
		}
		System.out.print("Negative Numbers: " + count);
		
		sc.close();

	}

}
