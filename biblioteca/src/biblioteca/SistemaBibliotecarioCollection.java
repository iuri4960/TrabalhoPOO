package biblioteca;

import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;

public interface SistemaBibliotecarioCollection {
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, LivroNaoEncontradoException;
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException;
	public void removerLivro(String codigo) throws LivroNaoEncontradoException;
	public Livro[] listaLivros();

}
