package secao08;

import java.util.Locale;
import java.util.Scanner;
import entities.Rectangle;

public class secao8_ex1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Rectangle rect = new Rectangle();
		
		System.out.println("Enter retangle width and height:");
		rect.Width = sc.nextDouble();
		rect.Height = sc.nextDouble();
		
		System.out.println("---------------------------------------------------");
		System.out.println(rect);
		
	}

}
