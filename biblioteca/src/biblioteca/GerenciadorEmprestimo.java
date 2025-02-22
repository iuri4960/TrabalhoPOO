package biblioteca;

import java.util.ArrayList;

public class GerenciadorEmprestimo {
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
}
