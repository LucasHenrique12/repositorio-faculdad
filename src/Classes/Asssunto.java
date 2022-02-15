package Classes;


public class Asssunto {
int teclado;
private String[] LELP= {"1-Logica","2-Condicional","3-Repetição","4-Matriz e Vetores","5-Subprogramação"};

private String[] EstruturadeDados= {"1-Struct","2-Ponteiro","3-Lista encadeada","4-Lista duplamente encadeada","5-Arvore binaria"};

private String[] POO= {"1-Classes","2-Objetos","3-Herança","4-Polimorfismo","5-JDBC"
};

public void escolha(int nome )
{
	
	if(nome==1)
	{
		for (int i = 0; i < 5; i++) {
			System.out.println( LELP[i]);
		}
	}
	if(nome==2)
		{
			for (int ii = 0; ii < 5; ii++) {
				System.out.println( EstruturadeDados[ii]);
				}
		}
	if(nome==3)
	{
		for (int iii = 0; iii <5 ; iii++) {
			System.out.println( POO[iii]);
			}
	}
	
	

}
}
