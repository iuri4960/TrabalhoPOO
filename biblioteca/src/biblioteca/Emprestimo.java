package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataAquisicao;
	private LocalDate dataDevolucao;
	private double multaTotal = 0;
	
	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataAquisicao) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataAquisicao = dataAquisicao;
		this.dataDevolucao = dataAquisicao.plusDays(30);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
		this.dataDevolucao = dataAquisicao.plusDays(30);
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public double getMultaTotal() {
		return multaTotal;
	}
	
	public void atualizarMultaTotal() {
		LocalDate dataAtual = LocalDate.now();
		if(dataAtual.isAfter(dataDevolucao)) {
			dataAtual = dataAtual.minusDays(dataDevolucao.getDayOfMonth()).minusMonths(dataDevolucao.getMonthValue()).minusYears(dataDevolucao.getYear());
			if (this.usuario instanceof Aluno) {
				this.multaTotal = (dataAtual.getDayOfYear() + dataAtual.getYear() * 365) * Aluno.MULTADIARIA;
			} else {
				this.multaTotal = (dataAtual.getDayOfYear() + dataAtual.getYear() * 365) * Professor.MULTADIARIA;
			}
		}
	}
	
	public void pagarMultaTotal() {
		this.multaTotal = 0;
		LocalDate dataAtual = LocalDate.now();
		this.dataDevolucao = dataAtual.plusDays(30);
	}
	
}
