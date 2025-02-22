package excepetion;

public class UsuarioJaAdicionadoException extends Exception {
	public UsuarioJaAdicionadoException(int matricula){
		super("Usuario de matricula" + matricula + " ja adicionado");
	}
}
