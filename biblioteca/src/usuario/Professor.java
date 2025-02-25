package usuario;

public class Professor extends Usuario {
	public static final double MULTADIARIA = 5;
	private int qtdMaterias;

	//Construtor da classe Professor
	public Professor(String nome, int matricula, int idade, Titulo titulo, int qtdMaterias) {
		super(nome, matricula, idade, titulo);
		this.qtdMaterias = qtdMaterias;
	}

	//Métodos get e set
	public int getQtdMaterias() {
		return qtdMaterias;
	}

	private void setQtdMaterias(int qtdMaterias) {
		this.qtdMaterias = qtdMaterias;
	}

	//Método para imprimir as informações do professor
	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", matricula=" + matricula + ", idade="
				+ idade + ", titulo=" + titulo + ", qtdMaterias=" + qtdMaterias + "]";
	}

}
