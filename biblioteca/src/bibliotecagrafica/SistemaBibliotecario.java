package bibliotecagrafica;

import java.util.ArrayList;

import exception.EmprestimoJaAdicionadoException;
import exception.EmprestimoNaoEncontradoException;
import exception.LivroJaAdicionadoException;
import exception.LivroNaoEncontradoException;
import exception.MultaNaoPagaException;
import exception.NumeroPaginasInvalidoException;
import exception.UsuarioJaAdicionadoException;
import exception.UsuarioNaoEncontradoException;
import usuario.Aluno;
import usuario.Emprestimo;
import usuario.GerenciadorEmprestimo;
import usuario.GerenciadorUsuario;
import biblioteca.GerenciarLivro;
import biblioteca.Livro;
import biblioteca.Exemplares;
import usuario.Professor;
import usuario.Usuario;

public class SistemaBibliotecario implements SistemaBibliotecarioCollection {

	private GerenciadorUsuario gerenciarUsuarios = new GerenciadorUsuario();
	private GerenciadorEmprestimo gerenciarEmprestimos = new GerenciadorEmprestimo();
	private GerenciarLivro gerenciarLivros = new GerenciarLivro();
	
	private boolean temAlteracao;
	
	public boolean getTemAlteracao() {
		return temAlteracao;
	}
	
	public void setTemAlteracao(boolean temAlteracao) {
		this.temAlteracao = temAlteracao;
	}
	
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException {
			gerenciarLivros.adicionarLivro(livro);
	}
	@Override
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException {
		Livro l = gerenciarLivros.consultarLivro(codigo);
		return l;
	}
	@Override
	public void removerLivro(String codigo) throws LivroNaoEncontradoException {
		gerenciarLivros.removerLivro(codigo);
		
	}
	@Override
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException {
		gerenciarLivros.atualizarInformacao(codigo, novoLivro);
	}

	@Override
	public void adicionarEmprestimo(Emprestimo emprestimo) throws EmprestimoJaAdicionadoException {
		gerenciarEmprestimos.adicionarEmprestimo(emprestimo);

	}
	@Override
	public Emprestimo consultarEmprestimo(String codigo) throws LivroNaoEncontradoException, EmprestimoNaoEncontradoException {
		Livro l = consultarLivro(codigo);
		Emprestimo e = gerenciarEmprestimos.consultarEmprestimo(l);
		
		return e;
	}
	
	public ArrayList<Emprestimo> consultarEmprestimo(int matricula) throws UsuarioNaoEncontradoException, EmprestimoNaoEncontradoException {
		Usuario u = consultarUsuario(matricula);
		ArrayList<Emprestimo> e = gerenciarEmprestimos.consultarEmprestimo(u);
		return e;
	}
	@Override
	public void editarEmprestimo(Livro livro, Emprestimo emprestimo) throws EmprestimoNaoEncontradoException {
		gerenciarEmprestimos.editarEmprestimo(livro, emprestimo);
	}
	@Override
	public void removerEmprestimo(Livro livro) throws EmprestimoNaoEncontradoException, MultaNaoPagaException {
		gerenciarEmprestimos.removerEmprestimo(livro);
	}
	
	@Override
	public void adicionarUsuario(Usuario usuario) throws UsuarioJaAdicionadoException {
		gerenciarUsuarios.adicionarUsuario(usuario);	
	}

	public ArrayList<Usuario> getListaUsuarios(){
		return gerenciarUsuarios.getListaUsuario();
	}
	
	@Override
	public Usuario consultarUsuario(int matricula) throws UsuarioNaoEncontradoException {
		Usuario u = gerenciarUsuarios.consultarUsuario(matricula);
		return u;
	}
	@Override
	public void editarUsuario(int matricula, Aluno usuario) throws UsuarioNaoEncontradoException {
		gerenciarUsuarios.editarUsuario(matricula, usuario);
	}

	@Override
	public void editarUsuario(int matricula, Professor usuario) throws UsuarioNaoEncontradoException {
		gerenciarUsuarios.editarUsuario(matricula, usuario);
	}
	@Override
	public void removerUsuario(int matricula) throws UsuarioNaoEncontradoException  { 
		try {
			ArrayList<Emprestimo> emprestimo = gerenciarEmprestimos.consultarEmprestimo(gerenciarUsuarios.consultarUsuario(matricula));
		} catch (EmprestimoNaoEncontradoException e) {
			gerenciarUsuarios.removerUsuario(matricula);
		}
	}
	
	public ArrayList<Emprestimo> getListaEmprestimo() {
		return gerenciarEmprestimos.getListaEmprestimo();
	}
}
