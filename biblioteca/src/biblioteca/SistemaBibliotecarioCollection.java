package biblioteca;

import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;
import excepetion.NumeroPaginasInvalidoException;

public interface SistemaBibliotecarioCollection {
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException;
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException;
	public void removerLivro(String codigo) throws LivroNaoEncontradoException;
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException;
	public Livro[] listaLivros();
	
	public void adicionarEmprestimo();
	public Emprestimo consultarEmprestimo();
	public void editarEmprestimo();
	public void removerEmprestimo();
	public void atualizarMulta();
	
	public void adicionarUsuario();
	public Usuario consultarUsuario();
	public void editarUsuario();
	public void removerUsuario();
	
}
