package biblioteca;
import java.util.ArrayList;
import excepetion.UsuarioJaAdicionadoException;
import excepetion.UsuarioNaoEncontradoException;

public class GerenciadorUsuario {
	private ArrayList<Usuario> listaUsuario;
	
	/*Construtores da classe um para caso não haja uma lista ja sendo usada
	e outro pra caso ja haja uma lista*/
	public GerenciadorUsuario() {
		listaUsuario = new ArrayList();
	}
	
	public GerenciadorUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	/*O metodo chama o consultar o usuario para checar se ja existe um usuario
	por que ja existir ele vai prosseguir o codigo normalmente e lançara uma exceão
	porem caso não exista o metodo consultar vai lançar uma exceção e executara a adição*/
	public void adicionarUsuario(Usuario usuario) throws UsuarioJaAdicionadoException {
		try {
			this.consultarUsuario(usuario.getMatricula());
			System.out.println(" levantada ");
			throw new UsuarioJaAdicionadoException(usuario.getMatricula());
			
		} catch (UsuarioNaoEncontradoException e) {
			System.out.println(" awaaaaaa ");
			listaUsuario.add(usuario);
		}
	}
	
	//O metodo consultar tentara  ver se existe o usuario se não existir vai lançar a exceção
	public Usuario consultarUsuario(int matricula) throws UsuarioNaoEncontradoException {
			for(int i=0; i < listaUsuario.size(); i++) {
				if(listaUsuario.get(i).getMatricula() == matricula) {
					System.out.println(listaUsuario.get(i).getMatricula() + " " + matricula + " " + "usuario");
					return listaUsuario.get(i);
					
				}
			}
			System.out.println(" " + matricula + " " + "usuario2");
			throw new UsuarioNaoEncontradoException(matricula);
	}
	
	/*O metodo alterar tentara ver se existe o usuario se existir ele trocara o usuario
	pela sua versão alterada se não lançara uma exceção*/
	public void editarUsuario(int matricula, Usuario usuario) throws UsuarioNaoEncontradoException {
		int controller = 0;
		for(int i=0; i < listaUsuario.size(); i++) {
			if(listaUsuario.get(i).getMatricula() == matricula) {
				listaUsuario.add(i, usuario);
				controller++;
			}
		}
		if (controller == 0) {
			throw new UsuarioNaoEncontradoException(matricula);
		}
	}
	
	/*O metodo remover tentara ver se existe o usuario se existir ele excluira da lista se
	não lançara uma exceção*/
	public void removerUsuario(int matricula) throws UsuarioNaoEncontradoException {
		int controller =0;
		for(int i=0; i < listaUsuario.size(); i++) {
			if(listaUsuario.get(i).getMatricula() == matricula) {
				listaUsuario.remove(i);
				controller++;
			}
		}
		if (controller == 0) {
			throw new UsuarioNaoEncontradoException(matricula);
		}
	}


}
