package biblioteca;

import java.util.ArrayList;

import excepetion.EmprestimoJaAdicionadoException;
import excepetion.EmprestimoNaoEncontradoException;
import excepetion.LivroJaAdicionadoException;
import excepetion.LivroNaoEncontradoException;
import excepetion.MultaNaoPagaException;
import excepetion.NumeroPaginasInvalidoException;
import excepetion.UsuarioJaAdicionadoException;
import excepetion.UsuarioNaoEncontradoException;

public class SistemaBibliotecario implements SistemaBibliotecarioCollection {

	private GerenciadorUsuario gerenciarUsuarios = new GerenciadorUsuario();
	private GerenciadorEmprestimo gerenciarEmprestimos = new GerenciadorEmprestimo();
	private GerenciarLivro gerenciarLivros = new GerenciarLivro();
	@Override
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
	public Livro[] listaLivros() {
		Livro[] l = gerenciarLivros.listaLivros();
		return l;
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
	
	@Override
	public Usuario consultarUsuario(int matricula) throws UsuarioNaoEncontradoException {
		Usuario u = gerenciarUsuarios.consultarUsuario(matricula);
		return u;
	}
	@Override
	public void editarUsuario(int matricula, Usuario usuario) throws UsuarioNaoEncontradoException {
		gerenciarUsuarios.editarUsuario(matricula, usuario);
	}
	@Override
	public void removerUsuario(int matricula) throws UsuarioNaoEncontradoException {
		gerenciarUsuarios.removerUsuario(matricula);		
	}
	
	
	
	
}
