package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.LivroJaAdicionadoException;

public class Exemplares implements Serializable{
	private Map<String, List<Livro>> catalogo;
	
	public Exemplares(List<Livro> catalogo) {
		this.catalogo= new HashMap<>();
	}

	public Map<String, List<Livro>> getCatalogo() {
		return catalogo;
	}


	public void setCatalogo(Map<String, List<Livro>> catalogo) {
		this.catalogo = catalogo;
	}
}
