package secao13;

import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

// Classe exemplo de uso da classe StringBuilder no toString da classe Post
public class secao13_ex2 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Instanciando a postagem 1
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date moment = sdf.parse("21/06/2018 13:05:44");
		String title = "Traveling to New Zealand";
		String content = "I'm going to visit this wonderful country!";
		int likes = 12;

		Post p1 = new Post(moment, title, content, likes);

		// Adicionando os comentario na postagem
		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that's awesome!");
		p1.addComment(c1);
		p1.addComment(c2);
		
		
		// Instanciando a postagem 2
		Date moment2 = sdf.parse("28/07/2018 18:00:45");
		String title2 = "Good nigth guys";
		String content2 = "See you tomorrow";
		int likes2 = 5;

		Post p2 = new Post(moment2, title2, content2, likes2);

		// Adicionando os comentario na postagem
		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you!");
		p2.addComment(c3);
		p2.addComment(c4);
		
		
		System.out.println(p1);
		System.out.println(p2);
		
		sc.close();
	}

}
