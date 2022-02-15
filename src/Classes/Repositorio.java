package Classes;
import java.util.Scanner;
public class Repositorio {

private String autor;
private String descricao;
private String link;
int disciplina;

public int inserirDados(int nome) {
	Asssunto assunto=new Asssunto();
	int escolha=0;
	String aux3;
	Scanner texto=new Scanner(System.in);
	while(nome>0 && nome<4) {
		disciplina=nome;
		assunto.escolha(nome);
		
		while(escolha<=0 || escolha>5) {
			System.out.println("Insira o número do assunto:");
			aux3=texto.nextLine();
			escolha=Integer.parseInt(aux3);
		}
			
		System.out.println("Insira o nome do autor do projeto:");
		this.autor=texto.nextLine();
		
		System.out.println("Insira uma descrição para o projeto:");
		this.descricao=texto.nextLine();
		
		System.out.println("Insira o link do projeto no GitHub:");
		this.link=texto.nextLine();
	
		nome=0;
		
	}
	
	texto.close();
	return escolha;
	
}
public String getAutor() {
	return autor;
}


public void setAutor(String autor) {
	this.autor = autor;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public String getLink() {
	return link;
}


public void setLink(String link) {
	this.link = link;
}



public String getAssuntoLELP() {
	String assuntodaDisciplina;
	
	if(inserirDados(disciplina)==1){
		assuntodaDisciplina="Logica";
	}
	if(inserirDados(disciplina)==2){
		assuntodaDisciplina="Condicional";
	}
	if(inserirDados(disciplina)==3){
		assuntodaDisciplina="Repetição";
	}
	if(inserirDados(disciplina)==4){
		assuntodaDisciplina="Matriz e Vetores";
	}
	if(inserirDados(disciplina)==5){
		assuntodaDisciplina="Subprogramação";
	}
	else {
		assuntodaDisciplina=null;
	}
	return assuntodaDisciplina;
}

public String getAssuntoEstrutura() {
	String assuntodaDisciplina;
	
	if(inserirDados(disciplina)==1){
		assuntodaDisciplina="Struct";
	}
	if(inserirDados(disciplina)==2){
		assuntodaDisciplina="Ponteiro";
	}
	if(inserirDados(disciplina)==3){
		assuntodaDisciplina="Lista encadeada";
	}
	if(inserirDados(disciplina)==4){
		assuntodaDisciplina="Lista duplamente encadeada";
	}
	if(inserirDados(disciplina)==5){
		assuntodaDisciplina="Arvore binaria";
	}
	else {
		assuntodaDisciplina=null;
	}
	return assuntodaDisciplina;
}
public String getAssuntoPOO() {
	String assuntodaDisciplina;
	
	if(inserirDados(disciplina)==1){
		assuntodaDisciplina="Classes";
	}
	if(inserirDados(disciplina)==2){
		assuntodaDisciplina="Objetos";
	}
	if(inserirDados(disciplina)==3){
		assuntodaDisciplina="Herança";
	}
	if(inserirDados(disciplina)==4){
		assuntodaDisciplina="Polimorfismo";
	}
	if(inserirDados(disciplina)==5){
		assuntodaDisciplina="JDBC";
	}
	else {
		assuntodaDisciplina=null;
	}
	return assuntodaDisciplina;
}
public int getDisciplina() {
	System.out.println(disciplina);
	return disciplina;
}

}
