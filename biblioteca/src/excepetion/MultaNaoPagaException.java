package excepetion;

public class MultaNaoPagaException extends Exception {
	public MultaNaoPagaException() {
		super("O usuario ainda tem uma divida a pagar nesse emprestimo");
	}

}
