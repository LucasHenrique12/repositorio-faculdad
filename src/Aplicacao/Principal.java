package Aplicacao;
import java.util.Scanner;
import Classes.Disciplina;
import Classes.Repositorio;
import br.com.repositorio.db.ConexaoBD;

public class Principal {

	
	public static void main(String[] args) {
		
		
		try {
			ConexaoBD.getConexaoMySQL();
			System.out.println("Conectado ao BD Reposit�rio!");
		} catch (Exception e) {
			System.out.println("N�o foi conectado ao BD Reposit�rio!");
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		Disciplina disciplina= new Disciplina();
		Scanner texto=new Scanner(System.in);
		Repositorio repositorio=new Repositorio();
		int choice;
		String aux,aux2;
		int escolhas;
		System.out.println("Digite \n1-Inserir\n2-Pesquisar");
		aux=texto.nextLine();
		choice=Integer.parseInt(aux,10);
		if(choice==1) {
		disciplina.materia();
		System.out.println("Escolha uma das disciplinas:");
		aux2= texto.nextLine();	
		escolhas=Integer.parseInt(aux2);
		
		repositorio.inserirDados(escolhas);
		repositorio.getDisciplina();
		texto.close();
		}
		
		
	}

}
