package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

import exception.EmprestimoJaAdicionadoException;
import exception.EmprestimoNaoEncontradoException;
import exception.MultaNaoPagaException;

public class GerenciadorEmprestimo implements Serializable {
	private ArrayList<Emprestimo> listaEmprestimo;

	/*Construtores da classe um para caso não haja uma lista ja sendo usada
	e outro pra caso ja haja uma lista*/
	public GerenciadorEmprestimo() {
		listaEmprestimo = new ArrayList();
	}
	
	public GerenciadorEmprestimo(ArrayList<Emprestimo> listaEmprestimo) {
		this.listaEmprestimo = listaEmprestimo;
	}
	
	//Adicionarei de madruga o restante da classe
	
	public void adicionarEmprestimo(Emprestimo emprestimo) throws EmprestimoJaAdicionadoException{
		try {
			this.consultarEmprestimo(emprestimo.getLivro());
			throw new EmprestimoJaAdicionadoException(emprestimo.getLivro());
		} catch (EmprestimoNaoEncontradoException e) {
			listaEmprestimo.add(emprestimo);
		}
	}
	
	public Emprestimo consultarEmprestimo(Livro livro) throws EmprestimoNaoEncontradoException {
		for(int i=0; i < listaEmprestimo.size(); i++) {
			if(listaEmprestimo.get(i).getLivro() == livro) {
				return listaEmprestimo.get(i);
			}
		}
		throw new EmprestimoNaoEncontradoException(livro);
	}
	
	public ArrayList<Emprestimo> consultarEmprestimo(Usuario usuario) throws EmprestimoNaoEncontradoException {
		ArrayList<Emprestimo> emprestimos = new ArrayList();
		for(int i=0; i < listaEmprestimo.size(); i++) {
			if(listaEmprestimo.get(i).getUsuario() == usuario) {
				emprestimos.add(listaEmprestimo.get(i));
			}
		}
		if (emprestimos.size() > 0) {
			return emprestimos;
		}
		throw new EmprestimoNaoEncontradoException(usuario);
	}
	
	public void editarEmprestimo(Livro livro, Emprestimo emprestimo) throws EmprestimoNaoEncontradoException {
		int controller = 0;
		for(int i=0; i < listaEmprestimo.size(); i++) {
			if(listaEmprestimo.get(i).getLivro() == livro) {
				listaEmprestimo.add(i, emprestimo);
				controller++;
			}
		}
		if (controller == 0) {
			throw new EmprestimoNaoEncontradoException(livro);
		}
	}
	
	public void removerEmprestimo(Livro livro) throws EmprestimoNaoEncontradoException, MultaNaoPagaException {
		int controller = 0;
		int controller2 = 0;
		for(int i=0; i < listaEmprestimo.size(); i++) {
			if(listaEmprestimo.get(i).getLivro().getCodigo() == livro.getCodigo()) {
				if (listaEmprestimo.get(i).getMultaTotal() == 0) {
					listaEmprestimo.remove(i);
					controller2++;
				}
				controller++;
			}
		}
		if (controller == 0) {
			throw new EmprestimoNaoEncontradoException(livro);
		} else if (controller2 == 0) {
			throw new MultaNaoPagaException();
		}
	}
	public ArrayList<Emprestimo> getListaEmprestimo() {
		return listaEmprestimo;
	}
}
