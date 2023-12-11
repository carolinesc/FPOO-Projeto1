package br.org.sesisp.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;

public class TelaMain {

	public static void main(String[] args) {
		//instanciar um objeto da classe crudDAO
		CrudDAO inserir_aluno = new CrudDAO();
		
		
	//instanciar um objeto aluno
		Aluno aluno1 = new Aluno();
	/*/*
	aluno1.setNome("José");
	aluno1.setIdade(17);
	inserir_aluno.create(aluno1);
	System.out.println("Nome: " + aluno1.getNome() + "e Idade: " + aluno1.getIdade());
	*/
	//atualizar valores
	/* aluno1.setNome("Marcelo Vieira");
	aluno1.setIdade(18);
	aluno1.setRa(1);
	inserir_aluno.update(aluno1);
	System.out.println("Nome: " + aluno1.getNome());
	System.out.println("Idade: " + aluno1.getIdade());
	
	//ler tabela alunos do 8d
	System.out.println("lendo a lista...");
	for(Aluno olho : inserir_aluno.read()) {
		System.out.println("Dados do aluno: " + olho.getRa() + olho.getNome() + olho.getIdade());
	}

	//excluir dados
	
	CrudDAO remover_aluno = new CrudDAO();
	remover_aluno.delete(2);
} */
	
	Scanner entrada = new Scanner(System.in);
	
	int opcao;
	
	do {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:" +
		"\n 1-Adiocionar aluno; \n 2-Atualizar aluno; \n 3-Verificar aluno; \n 4-Remover aluno; \n 0- Sair."));
		 
		 
		 switch (opcao) {
		 
		//opcao 1 create ------------------------
		 
		 case 1:
			 
		    	aluno1.setNome(JOptionPane.showInputDialog("Insira o nome do aluno :"));
				aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do aluno:")));
				inserir_aluno.create(aluno1);
				System.out.println("Nome: "+ aluno1.getNome()+ "\nIdade: "+aluno1.getIdade());
		    break;
		    
		    case 2:
		    	aluno1.setRa(Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno:")));
		    	aluno1.setNome(JOptionPane.showInputDialog("Insira o nome do aluno :"));
				aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do aluno:")));
				inserir_aluno.update(aluno1);
				
				break;
		   
		    case 3:
		    	
		    	JOptionPane.showMessageDialog(null, "lendo a lista...");
				for(Aluno olho : inserir_aluno.read()) {
					JOptionPane.showMessageDialog(null, "Dados do aluno: "+ olho.getRa()
					+ olho.getNome() + olho.getIdade());}
				break;
				
		    case 4:
		    	
		    	CrudDAO remover_aluno = new CrudDAO();
		    	int remover;
				remover = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do aluno:"));
				remover_aluno.delete(remover);
				break;
			}
		}  while (opcao != 0);   
				
		}
}