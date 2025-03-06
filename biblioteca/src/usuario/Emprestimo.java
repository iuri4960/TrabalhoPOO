package usuario;

import java.io.Serializable;
import java.time.LocalDate;

import biblioteca.Livro;

public class Emprestimo implements Serializable {
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
			int diaAtraso = dataAtual.getDayOfYear() - dataDevolucao.getDayOfYear();
			int anoAtraso = dataAtual.getYear() - dataDevolucao.getYear();
			if (this.usuario instanceof Aluno) {
				this.multaTotal = (diaAtraso + (anoAtraso * 365)) * Aluno.MULTADIARIA;
			} else {
				this.multaTotal = (diaAtraso + (anoAtraso * 365)) * Professor.MULTADIARIA;
			}
		}
	}
	
	public void pagarMultaTotal() {
		this.multaTotal = 0;
		LocalDate dataAtual = LocalDate.now();
		this.dataDevolucao = dataAtual.plusDays(30);
	}

	
	public String toString(){
		return "aluno: " +this.getUsuario().getNome() + " /  livro: " + this.getLivro().getNome() + "(" +this.getLivro().getCodigo() +")";
	}

}
