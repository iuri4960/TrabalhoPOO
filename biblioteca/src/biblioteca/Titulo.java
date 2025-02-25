package biblioteca;

public enum Titulo {
	GRADUANDO("graduando"),
	GRADUADO("graduado"),
	ESPECIALIZADO("especializado"),
	MESTRE("mestre"),
	DOUTOR("doutor");
	
	private String descricao;
	
	Titulo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
