package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

import exception.EmprestimoJaAdicionadoException;
import exception.EmprestimoNaoEncontradoException;
import exception.LivroJaAdicionadoException;
import exception.LivroNaoEncontradoException;
import exception.MultaNaoPagaException;
import exception.NumeroPaginasInvalidoException;
import exception.UsuarioJaAdicionadoException;
import exception.UsuarioNaoEncontradoException;

public interface SistemaBibliotecarioCollection extends Serializable {
	
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException;
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException;
	public void removerLivro(String codigo) throws LivroNaoEncontradoException;
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException;
	public Livro[] listaLivros();
	
	public void adicionarEmprestimo(Emprestimo emprestimo) throws EmprestimoJaAdicionadoException;
	public Emprestimo consultarEmprestimo(String codigo) throws LivroNaoEncontradoException, EmprestimoNaoEncontradoException;
	public ArrayList<Emprestimo> consultarEmprestimo(int matricula) throws UsuarioNaoEncontradoException, EmprestimoNaoEncontradoException;
	public void editarEmprestimo(Livro livro, Emprestimo emprestimo) throws EmprestimoNaoEncontradoException;
	public void removerEmprestimo(Livro livro) throws EmprestimoNaoEncontradoException, MultaNaoPagaException;
	
	public void adicionarUsuario(Usuario usuario) throws UsuarioJaAdicionadoException;
	public Usuario consultarUsuario(int matricula) throws UsuarioNaoEncontradoException;
	public void editarUsuario(int matricula, Usuario usuario) throws UsuarioNaoEncontradoException;
	public void removerUsuario(int matricula) throws UsuarioNaoEncontradoException;
	
}

