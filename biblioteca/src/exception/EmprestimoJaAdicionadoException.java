package exception;

import biblioteca.Livro;

public class EmprestimoJaAdicionadoException extends Exception {
	public EmprestimoJaAdicionadoException(Livro livro){
		super("O livro de codigo " + livro.getCodigo() + " ja foi alugado");
	}

}
