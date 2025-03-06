package bibliotecagrafica;

import java.io.Serializable;
import java.util.ArrayList;

import exception.*;
import usuario.*;
import biblioteca.*;

public interface SistemaBibliotecarioCollection extends Serializable {
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException;
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException;
	public void removerLivro(String codigo) throws LivroNaoEncontradoException;
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException;
	
	public void adicionarEmprestimo(Emprestimo emprestimo) throws EmprestimoJaAdicionadoException;
	public Emprestimo consultarEmprestimo(String codigo) throws LivroNaoEncontradoException, EmprestimoNaoEncontradoException;
	public ArrayList<Emprestimo> consultarEmprestimo(int matricula) throws UsuarioNaoEncontradoException, EmprestimoNaoEncontradoException;
	public void editarEmprestimo(Livro livro, Emprestimo emprestimo) throws EmprestimoNaoEncontradoException;
	public void removerEmprestimo(Livro livro) throws EmprestimoNaoEncontradoException, MultaNaoPagaException;
	
	public void adicionarUsuario(Usuario usuario) throws UsuarioJaAdicionadoException;
	public Usuario consultarUsuario(int matricula) throws UsuarioNaoEncontradoException;
	public void editarUsuario(int matricula, Aluno usuario) throws UsuarioNaoEncontradoException;
	public void editarUsuario(int matricula, Professor usuario) throws UsuarioNaoEncontradoException;
	public void removerUsuario(int matricula) throws UsuarioNaoEncontradoException;

}
