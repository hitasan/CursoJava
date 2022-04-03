package secao19.CuringaDelimitados.application;

import java.util.ArrayList;
import java.util.List;

import secao19.CuringaDelimitados.entities.Rectangle;
import secao19.CuringaDelimitados.entities.Circle;
import secao19.CuringaDelimitados.entities.Shape;

public class Program {

	public static void main(String[] args) {
		
		List<Shape> myShapes = new ArrayList<>();	// Criando uma lista de tipo shape
		myShapes.add(new Rectangle(3.0, 2.0));		// Adicionando 2 figuras (Classes Rectangle/Circle) na lista de figuras criada
		myShapes.add(new Circle(2.0));
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		
		// Imprime o metodo que retorna o total das areas dessa lista
		// Se manter desse motod sem tratar o tipo generico coringa no metodo totalArea, apresentará erro pois o list<Shape> não é um supertipo do list<circle>
		System.out.println("Total area: " + totalArea(myCircles));
	}
	
	// Modo inicial recebe somente por parametro o list do tipo shape, se passar um list<circle> apresentará erro, por isso precisamos corrigir o parametro de recebimento como abaixo
	//public static double totalArea(List<Shape> list) {

	// somente especificar o tipo coringa (List<?>) apresentará erro no loop pois nao necessariamente essa list será do tipo shape. List <? extends shape> resolve o problema indicando que pode vir um shape ou qqr subtipo de shape
	public static double totalArea(List<? extends Shape> list) {
		// Como tratamos o metodo para receber um lista generica com tipos diferentes indicados pelo tipo coringa, não é possivel mais adicionar itens nessa lista nesse metodo pois o compilador não consegue saber se os tipos adicionados
		// serão do mesmo tipo que a lista que veio por parametro.
		//list.add(new Rectangle(3.0, 4.0));
		
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}
		return sum;
	}
}
