package biblioteca;

import java.util.ArrayList;
import java.util.List;

import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;

public class SistemaBibliotecario implements SistemaBibliotecarioCollection {
	List<Livro> livros = new ArrayList();

	//Método para adicionar livros
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException {
		try {
			Livro l= consultarLivro(livro.getCodigo());
			throw new LivroJaAdicionadoException("Livro já adicionado");
		} catch (LivroNaoEncontradoException e){
			livros.add(livro);;
		}
		
	}

	//Método para procurar um livro
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException {
		Livro l= null;
		for (Livro livro: livros) {
			if (livro.getCodigo().equalsIgnoreCase(codigo)) {
				l=livro;
				break;
			}
		}
		if (l==null) { throw new LivroNaoEncontradoException("Livro não encontrado"); }
		return l;
	}

	//Método para remover um livro
	public void removerLivro(String codigo) throws LivroNaoEncontradoException {
		Livro li= consultarLivro(codigo);
		if (li!= null) {
			livros.remove(li);
		}
		
	}

	//Método para mostrar todos os livros
	public Livro[] listaLivros() {
		Livro[] retorno = new Livro[livros.size()];
		return livros.toArray(retorno);
	}

}
