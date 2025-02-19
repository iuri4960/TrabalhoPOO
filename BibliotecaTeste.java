package biblioteca;

import java.util.Scanner;

import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;

public class BibliotecaTeste {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SistemaBibliotecarioCollection manager = new SistemaBibliotecario();
		
		
		while (true) {
			System.out.println("\n---Gerenciamento de Biblioteca---");
			System.out.println("1. Adicionar livro");
			System.out.println("2. Buscar livro");
			System.out.println("3. Mostrar livros");
			System.out.println("4. Remover livro");
			System.out.println("5. Sair");
			System.out.println("Escolha uma opção");
			
			int opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
				case 1 :
					System.out.print("Digite o nome do livro: ");
					String nome = s.nextLine();
					
					System.out.print("Digite o código do livro: ");
					String codigo = s.nextLine();
					
					System.out.print("Digite o ano do livro: ");
					int ano = s.nextInt();
					s.nextLine();
					
					System.out.print("Digite o autor do livro: ");
					String autor = s.nextLine();
					
					System.out.print("Digite o número de páginas do livro: ");
					int numPaginas = s.nextInt();
					s.nextLine();
					
					System.out.print("Digite o genero do livro: ");
					String genero = s.nextLine();
					
					System.out.print("Digite a editora do livro: ");
					String editora = s.nextLine();
					
					System.out.print("Digite se o livro foi alugado: ");
					boolean alugado = s.nextBoolean();
					s.nextLine();
					
					Livro l= new Livro(nome, codigo, ano, autor, numPaginas, genero, editora, alugado);
					try {
						manager.adicionarLivro(l);
					} catch (LivroJaAdicionadoException | LivroNaoEncontradoException e) {
						e.printStackTrace();
					}
					break;
					
				case 2:
					System.out.print("Digite o código do livro: ");
					String _codigo= s.nextLine();
					try {
						Livro _l= manager.consultarLivro(_codigo);
						System.out.println(_l);
					} catch (LivroNaoEncontradoException e) {
						System.out.println("livro não encontrado");	
					}	
					break;
					
				case 3:
					System.out.println("livros na bilioteca: ");
					Livro[] livros= manager.listaLivros();
					for (Livro livro : livros) {
						System.out.println(livro);
					}
					break;
				
				case 4:
					System.out.println("Digite o código do livro que quer remover: ");
					String codigoRemover = s.nextLine();
					try {
						manager.removerLivro(codigoRemover);
					} catch (LivroNaoEncontradoException e) {
						System.out.println("livro não encontrado");
					}
					break;
				
				case 5:
					System.out.println("Encerrando sessão");
					s.close();
					return;
					
				default:
					System.out.println("opção inválida");
			}
		}
	}

}
