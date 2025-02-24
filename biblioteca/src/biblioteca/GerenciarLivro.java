package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.LivroJaAdicionadoException;
import exception.LivroNaoEncontradoException;
import exception.NumeroPaginasInvalidoException;

public class GerenciarLivro implements Serializable{
	ArrayList<Livro> livros;

	public GerenciarLivro(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	
	public GerenciarLivro() {
		this.livros = new ArrayList();
	}

	//Método para adicionar livros
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException {
	//NumeroPaginasInvalidoException {
		try {
			consultarLivro(livro.getCodigo());
			System.out.println("aaaa");
			throw new LivroJaAdicionadoException("Livro já adicionado");
		} catch (LivroNaoEncontradoException e){
			livros.add(livro);
			//if (Integer.parseInt(livro.getNumPaginas())<0) {throw new NumeroPaginasInvalidoException("Número de páginas invalido"); }
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
