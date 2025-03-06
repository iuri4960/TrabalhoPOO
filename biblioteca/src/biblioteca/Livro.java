package biblioteca;

import java.io.Serializable;

public class Livro implements Serializable {
	private String  nome;
	private String codigo;
	private String ano;
	private String autor;
	private String  numPaginas;
	private String genero;
	private String editora;
	
	//Construtor da classe livro
	public Livro(String nome, String codigo,  String  ano, String autor,  String  numPaginas, String genero, String editora) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.ano = ano;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.genero = genero;
		this.editora = editora; 
	}

	//Métodos get e set dos atributos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public  String  getAno() {
		return ano;
	}

	public void setAno( String  ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public  String  getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas( String  numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	
	//Método para imprimir as informações do livro
		public String toString() {
			return "Livro [nome=" + nome + ", codigo=" + codigo + ", ano=" + ano + ", autor=" + autor + ", numPaginas="
					+ numPaginas + ", genero=" + genero + ", editora=" + editora + "]";
		}
		
		public String Descricao() {
			return "Livro \nnome=" + nome + ", \ncodigo=" + codigo + ", \nano=" + ano + ", \nautor=" + autor + ", \nnumPaginas="
						+ numPaginas + ", \ngenero=" + genero + ", \neditora=" + editora;
			}
	

}
