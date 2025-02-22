package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataAquisicao;
	private LocalDate dataDevolucao;
	
	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataAquisicao) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataAquisicao = dataAquisicao;
		this.dataDevolucao = dataAquisicao.plusDays(30);
	}

	private Usuario getUsuario() {
		return usuario;
	}

	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private Livro getLivro() {
		return livro;
	}

	private void setLivro(Livro livro) {
		this.livro = livro;
	}

	private LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	private void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
		this.dataDevolucao = dataAquisicao.plusDays(30);
	}

	private LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	
	
}
