package secao17;

import java.io.File;
import java.util.Scanner;

public class Program05_Manipula_Diretorio {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);	// A variavel path do tipo File pode ser tanto o caminho de um arquivo quanto uma pasta
		
		// LISTANDO DIRETORIOS EXISTENTES NO DIRETORIO INFORMADO
		File[] folders = path.listFiles(File::isDirectory); // vetor folders recebe a listagem dos arquivos localizados no path (Arquivos = Diretorios pois no caso estamos indicando que o File::isDirectory)
		System.out.println("FOLDERS: ");
		for (File folder : folders) {	// percorro cada folder encontrado no array folders e imprimo na tela
			System.out.println(folder);
		}
		System.out.println();

		// LISTANDO ARQUIVOS EXISTENTES NO DIRETORIO INFORMADO
		File[] files = path.listFiles(File::isFile); // vetor folders recebe a listagem dos arquivos localizados no path
		System.out.println("FILES: ");
		for (File file : files) {
			System.out.println(file);
		}
		System.out.println();

		// CRIANDO UMA SUBPASTA DENTRO DA PASTA INFORMADA
		boolean sucess = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + sucess);
		
		sc.close();
	}

}
