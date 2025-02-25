package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepetion.LivroJaAdicionadoException;

public class Exemplares {
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
