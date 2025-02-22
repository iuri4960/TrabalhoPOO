package biblioteca;

public abstract class Usuario {
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
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected int getMatricula() {
		return matricula;
	}

	protected void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	protected int getIdade() {
		return idade;
	}

	protected void setIdade(int idade) {
		this.idade = idade;
	}

	protected Titulo getTitulo() {
		return titulo;
	}

	protected void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", matricula=" + matricula + ", idade=" + idade + ", titulo=" + titulo + "]";
	}


	
}
