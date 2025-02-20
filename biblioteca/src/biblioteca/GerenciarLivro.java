package biblioteca;

import java.util.ArrayList;
import java.util.List;

import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;
import excepetion.NumeroPaginasInvalidoException;

public class GerenciarLivro implements SistemaBibliotecarioCollection {
	List<Livro> livros = new ArrayList<Livro>();

	//Método para adicionar livros
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException {
		try {
			Livro l= consultarLivro(livro.getCodigo());
			throw new LivroJaAdicionadoException("Livro já adicionado");
		} catch (LivroNaoEncontradoException e){
			livros.add(livro);
			if (livro.getNumPaginas()<0) {throw new NumeroPaginasInvalidoException("Número de páginas invalido"); }
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
			System.out.println("Livro removido");
		}
		
	}

	//Método para mostrar todos os livros
	public Livro[] listaLivros() {
		Livro[] retorno = new Livro[livros.size()];
		return livros.toArray(retorno);
	}

	//Método para atualizar as informações de um livro
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException {
		Livro l= this.consultarLivro(codigo);
		if (l!=null) {
			int pos= livros.indexOf(l);
			livros.set(pos, novoLivro);
		}
		
	}

}
