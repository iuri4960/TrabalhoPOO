package excepetion;

public class UsuarioNaoEncontradoException extends Exception {
	public UsuarioNaoEncontradoException(int matricula){
		super("Usuario de matricula" + matricula + " não existe");
	}

}
