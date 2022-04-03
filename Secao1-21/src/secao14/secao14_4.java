package secao14;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import secao14.entities.*;

// Classe exemplo de uso de classes com metodos abstratos. Se no caso um metodo for abstrato (Generico demais par ater uma implementação, entao toda a classe será abstrata)
public class secao14_4 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of shapes: ");
		int nShp = sc.nextInt();

		List<Shape> lst = new ArrayList<Shape>();

		for (int i = 0; i < nShp; i++) {
			System.out.println("");
			System.out.printf("Shape #%d data: ", i+1);
			System.out.println("");
			
			System.out.print("Rectangle ou Circle (r/c)? ");
			char opc = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			
			if (opc == 'r') {
				System.out.print("Width: ");
				Double width = sc.nextDouble();
				System.out.print("Height: ");
				Double height = sc.nextDouble();
				
				Shape ret = new Rectangle(color, width, height);
				lst.add(ret);
			}
			else {
				System.out.print("Radius: ");
				Double radius = sc.nextDouble();
				
				Shape rad = new Circle(color, radius);
				lst.add(rad);
			}
		}
		
		System.out.println("");
		System.out.println("============================================================================================");
		System.out.println("SHAPE AREAS:");
		for (Shape shp : lst) {
			System.out.println(String.format("%.2f", shp.area()));
		} 
		
		sc.close();

	}

}
