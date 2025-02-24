package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exemplares {
	private Map<String, List<Livro>> catalogo;
	
	public Exemplares() {
		this.catalogo= new HashMap<>();
	}
	
	public void colocarLivro(Livro livro) {
		catalogo.putIfAbsent(livro.getNome(), new ArrayList<>());
        	catalogo.get(livro.getNome()).add(livro);
	}
	
	public List<Livro> obterExemplares(String nomeLivro) {
		return catalogo.getOrDefault(nomeLivro, Collections.emptyList());
	}
	public void exibirCatalogo() {
	    for (Map.Entry<String, List<Livro>> entry : catalogo.entrySet()) {
	        System.out.println("Nome: " + entry.getKey() + " | Exemplares: " + entry.getValue().size());
	            for (Livro livro : entry.getValue()) {
	                System.out.println("  - " + livro);
	      }
	   }
	}
}
