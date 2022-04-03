package secao17;

import java.io.File;
import java.util.Scanner;

public class Program06_Info_Path {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getName: " + path.getName());		// Somente o nome do arquivo e nao o caminho completo
		System.out.println("getParent: " + path.getParent());	// Somente o caminho completo
		System.out.println("getPath: " + path.getPath());		// caminho completo

		sc.close();
	}

}
