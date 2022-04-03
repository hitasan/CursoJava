package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	// Declarando como static para não necessitar declarar a todo momento. Static usado para ter a copia do sdf para a plaicação toda e nao para cada Post
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	// Atributos da classe
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();	// Como um post pode ter N comentarios, instanciamos uma lista "comments" do tipo Comment(classe). Sempre lembrar que a lista nao entra no contrutor
	

	// Metodos construtores
	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	
	// Metodos Get / Set
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	// Não pode existir um set para alterar diretamente o comments entao faremos uma função especifica para adicionar comentarios
	// Listas são alteradas somente atravez dos metodos para add e remove
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	// Metodo toString
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes + " Likes - " + sdf.format(moment) + "\n");
		sb.append(content + "\n");
		sb.append("----------------------------------------------" + "\n");
		sb.append("Comments: " + "\n");
		
		// Laço forech para a cada comentario da lista de comentarios adicionado no Post, acrescentar o conteudo no stringBuilder
		for (Comment c : comments) {
			sb.append("- " + c.getText() + "\n");
		}
		sb.append("----------------------------------------------" + "\n");
		
		return sb.toString();
	}
	

}
