package exception;

import usuario.Livro;
import usuario.Usuario;

public class EmprestimoNaoEncontradoException extends Exception {
	public EmprestimoNaoEncontradoException(Livro livro){
		super("Emprestimo do livro de codigo " + livro.getCodigo() + "não encontrado.");
	}
	
	public EmprestimoNaoEncontradoException(Usuario usuario){
		super("Não ha emprestimos para o usuario de matricula " + usuario.getMatricula());
	}


}
