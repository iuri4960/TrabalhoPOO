package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import exception.LivroJaAdicionadoException;
import exception.LivroNaoEncontradoException;
import exception.NumeroPaginasInvalidoException;

public class GerenciarLivro implements Serializable {
	List<Livro> livros = new ArrayList<Livro>();
	private Exemplares exemplares;
	
	public GerenciarLivro() {
		this.exemplares= new Exemplares(livros);
	}

	//Método para adicionar livros
	public void adicionarLivro(Livro livro) throws LivroJaAdicionadoException, NumeroPaginasInvalidoException {
		Map<String, List<Livro>> catalogo = exemplares.getCatalogo();
		try {
			Livro l= consultarLivro(livro.getCodigo());
			throw new LivroJaAdicionadoException("Livro já adicionado");
		} catch (LivroNaoEncontradoException e){
	        catalogo.putIfAbsent(livro.getNome(), new ArrayList<>());
	        catalogo.get(livro.getNome()).add(livro);
			if (livro.getNumPaginas()<0) {throw new NumeroPaginasInvalidoException("Número de páginas invalido"); }
		}	
	}

	//Método para procurar um livro
	public Livro consultarLivro(String codigo) throws LivroNaoEncontradoException {
		Map<String, List<Livro>> catalogo = exemplares.getCatalogo();
		Livro l=null;
		for (List<Livro> exemplares : catalogo.values()) {
			for (Livro livro: exemplares) {
				if (livro.getCodigo().equalsIgnoreCase(codigo)) {
					l= livro;
					break;
				}
			}
		}
		if (l==null) { throw new LivroNaoEncontradoException("Livro não encontrado"); }
		return l;
	}

	//Método para remover um livro
	public void removerLivro(String codigo) throws LivroNaoEncontradoException {
		Map<String, List<Livro>> catalogo = exemplares.getCatalogo();
		Livro l = consultarLivro(codigo);
		List<Livro> exemplar = catalogo.get(l.getNome());
		exemplar.remove(l);
        	System.out.println(" Exemplar '" + l.getNome() +"com código"+l.getCodigo() + " removido com sucesso!");
        	if (exemplar.isEmpty()) {
            		catalogo.remove(l.getNome());
          	}           		
	}

	//Método para mostrar todos os livros
	public Livro[]  listaLivros() {
		Map<String, List<Livro>> catalogo = exemplares.getCatalogo();
		for (Map.Entry<String, List<Livro>> entry : catalogo.entrySet()) {
	        	System.out.println("Nome: " + entry.getKey() + " | Exemplares: " + entry.getValue().size());
	            	for (Livro livro : entry.getValue()) {
	                	System.out.println("  - " + livro);
	      		}
	   	}
		return null;
	}

	//Método para atualizar as informações de um livro
	public void atualizarInformacao(String codigo, Livro novoLivro) throws LivroNaoEncontradoException {
		Map<String, List<Livro>> catalogo = exemplares.getCatalogo();
		Livro livroAntigo = consultarLivro(codigo);
		List<Livro> listaLivros = catalogo.get(livroAntigo.getNome());
		if (livroAntigo!=null) {
			for (int i = 0; i < listaLivros.size(); i++) {
	            		if (listaLivros.get(i).getCodigo().equalsIgnoreCase(codigo)) {
	                	listaLivros.set(i, novoLivro);
	                	System.out.println("Livro atualizado com sucesso!");
	                	return;
	            		}
	        	}
		} 
	}
}
