package bibliotecagrafica;

public class DadosLivros {
	private static String nomeLivro;
	private static String codigoLivro;
	private static String classificacaoLivro;
	private static String anoLancamentoLivro;
	private static String generoLivro;
	private static String autorLivro;
	private static String editoraLivro;
	private static String numeroPaginasLivro;
	private static String numeroExemplaresLivro;
	private static String descricaoLivro;
	
	public DadosLivros(String nomeLivro2, String codigoLivro2, String anoLancamentoLivro2, String autorLivro2,
			String numeroPaginasLivro2, String generoLivro2, String editoraLivro2) {
	}

	public static String getNomeLivro() {
		return nomeLivro;
	}
	
	public static boolean setNomeLivro(String nomeLivro) {
		if(nomeLivro.matches("[a-z0-9]+")) { 
			DadosLivros.nomeLivro = nomeLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getCodigoLivro() {
		return codigoLivro;
	}
	
	public static boolean setCodigoLivro(String codigoLivro) {
		if(codigoLivro.matches("[0-9]+")) { 
			DadosLivros.codigoLivro = codigoLivro;
			return true;
		}
		else {
			return false;
		}

	}
	
	public static String getClassificacaoLivro() {
		return classificacaoLivro;
	}
	
	public static boolean setClassificacaoLivro(String classificacaoLivro) {
		if(classificacaoLivro.matches("[0-5]+")) { 
			DadosLivros.classificacaoLivro = classificacaoLivro;
			return true;
		}
		else {
			return false;
		}

	}
	
	public static String getAnoLancamentoLivro() {
		return anoLancamentoLivro;
	}
	
	public static boolean setAnoLancamentoLivro(String anoLancamentoLivro) {
		if(anoLancamentoLivro.matches("[0-9]+")) { 
			DadosLivros.anoLancamentoLivro = anoLancamentoLivro;
			return true;
		}
		else {
			return false;
		}

	}
	
	public static String getGeneroLivro() {
		return generoLivro;
	}
	
	public static boolean setGeneroLivro(String generoLivro) {
		if(generoLivro.matches("[a-z]+")) { 
			DadosLivros.generoLivro = generoLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getAutorLivro() {
		return autorLivro;
	}
	
	public static boolean setAutorLivro(String autorLivro) {
		if(autorLivro.matches("[a-z]+")) { 
			DadosLivros.autorLivro = autorLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getEditoraLivro() {
		return editoraLivro;
	}
	
	public static boolean setEditoraLivro(String editoraLivro) {
		if(editoraLivro.matches("[a-z]+")) { 
			DadosLivros.editoraLivro = editoraLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getNumeroPaginasLivro() {
		return numeroPaginasLivro;
	}
	
	public static boolean setNumeroPaginasLivro(String numeroPaginasLivro) {
		if(numeroPaginasLivro.matches("[0-9]+")) { 
			DadosLivros.numeroPaginasLivro = numeroPaginasLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getNumeroExemplaresLivro() {
		return numeroExemplaresLivro;
	}
	
	public static boolean setNumeroExemplaresLivro(String numeroExemplaresLivro) {
		if(numeroExemplaresLivro.matches("[0-9]+")) { 
			DadosLivros.numeroExemplaresLivro = numeroExemplaresLivro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getDescricaoLivro() {
		return descricaoLivro;
	}
	
	public static void setDescricaoLivro(String descricaoLivro) {
		DadosLivros.descricaoLivro = descricaoLivro;
	}

}
