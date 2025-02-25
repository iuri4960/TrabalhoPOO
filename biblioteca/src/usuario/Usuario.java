package usuario;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
	protected String nome;
	protected int matricula;
	protected int idade;
	protected Titulo titulo;

	//Construtor da classe usuario
	public Usuario(String nome, int matricula, int idade, Titulo titulo) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
		this.titulo = titulo;
	}

	//Métodos get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", matricula=" + matricula + ", idade=" + idade + ", titulo=" + titulo + "]";
	}

}
