package biblioteca;

public class Aluno extends Usuario {
	public static final double MULTADIARIA = 1.10;
	private int semestre;

	//Construtor da classe Aluno
	public Aluno(String nome, int matricula, int idade, Titulo titulo, int semestre) {
		super(nome, matricula, idade, titulo);
		this.semestre = semestre;
	}

	//Métodos get e set
	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	//Método para imprimir as informações do aluno
	@Override
	public String toString() {
		return "Aluno: " + nome;
	}

}
