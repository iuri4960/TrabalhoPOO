package bibliotecagrafica;

import javax.swing.*;

import exception.LivroJaAdicionadoException;
import exception.LivroNaoEncontradoException;
import exception.NumeroPaginasInvalidoException;
import biblioteca.Livro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Screen extends JFrame {
	SistemaBibliotecario sistema = new SistemaBibliotecario();
	
	//Strings para o DASHBOARD, o intuito é que nao fique assim. calma.
	private String numeroLivrosCadastrados = "12";
	private String numeroLivrosPendentes = "4";
	private String numeroLivrosEmprestados = "9";
	private String numeroUsuariosAtivos = "52";
	
	//Strings para salvar os dados de um livro na aba CADASTRAR LIVROS;
	//Provavelmente vai ser útil também para a aba CONSULTAR LIVROS na seção INFORMAÇÕES e AlTERAR INFORMAÇÕES;
	//private String nomeLivro;
	//private String codigoLivro;
	//private String classificacaoLivro;
	//private String anoLancamentoLivro;
	//private String generoLivro;
	//private String autorLivro;
	//private String editoraLivro;
	//private String numeroPaginasLivro;
	//private String numeroExemplaresLivro;
	//private String descricaoLivro;
	
	//String para salvar o nome do Livro ao qual o usuário quer procurar em CONSULTAR LIVROS
	private String stringCodigoLivroConsultado;

	public Screen() {
							
			//--------------------------------------------------
			//Detalhes Iniciais
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerrar o código ao fechar a janela
			setLayout(null); //Não definido gerenciador, todos componentes tem posição manual
			
			setTitle("Biblioteca Online");
			//ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/image.png"));
			//setIconImage(icone.getImage()); //Icone da Janela
			setSize(1000, 550); //tamanho da Janela
			
			//setLocation(283, 134); //centro de um monitor comum;
			setLocationRelativeTo(null); //Janela inicia no centro do monitor
			setResizable(false); //não redimensionável; 
			
			//setVisible(true);
			
			
			//--------------------------------------------------
			//Paineis Iniciais
			
				//Painel Roxo Superior Contendo o Titulo e o Icone
			JPanel painelSuperior = new JPanel();
			painelSuperior.setLayout(null);
			painelSuperior.setBounds(0,0,1000,100);
			painelSuperior.setBackground(new Color(140,82,255));
			
				//Painel Lateral Contendo os Botões do Paineis Centrais
			JPanel painelLateral = new JPanel();
			painelLateral.setLayout(null);
			//painelLateral.setBounds(0,100,300,800);
			painelLateral.setPreferredSize(new Dimension(300, 550));
			painelLateral.setBackground(new Color(211,205,237));
			
				//Painel Central Inicial: Serve apenas como base para o CardLayout, que mostra um painel por vez
				//Para o respectivo botao clicado
			JPanel painelCentral = new JPanel(new CardLayout());
			painelCentral.setBounds(300,100,700,400);
			painelCentral.setBackground(new Color(147,144,144));
			
			CardLayout layoutCentral = (CardLayout) painelCentral.getLayout();
			
			//add(painelLateral);
			add(painelSuperior);
			add(painelCentral);
			
				//Barra de Rolagem do Painel Lateral
			JScrollPane scrollPane = new JScrollPane(painelLateral);
			scrollPane.setBounds(0,100,300,400);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        add(scrollPane);
	        
	        //--------------------------------------------------------
	        //Título:
	        
	        	//Titulo do Painel Superior
	        JLabel tituloPrincipal = new JLabel();
	        tituloPrincipal.setText("Biblioteca Online");
	        tituloPrincipal.setBounds(100,30,800,30);
	        tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 32));
	        tituloPrincipal.setForeground(new Color(255,255,255));	        
	        
	        /*
	        	//Imagem do Painel Superior
	        ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/image.png"));
	        Image imagemRedimensionada = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada);
	        JLabel labelImagem = new JLabel(novaImagem);
	        labelImagem.setBounds(365, 0, novaImagem.getIconWidth(), novaImagem.getIconHeight());
	        
	        painelSuperior.add(tituloPrincipal);
	        painelSuperior.add(labelImagem);
	        */
	        
	        
			//--------------------------------------------------------//
			//Botões Da Tela Inicial
			JButton botaoPaginaInicial = new JButton("Página Inicial");
			botaoPaginaInicial.setBounds(50,30,200,40);
			botaoPaginaInicial.setBackground(new Color(0,191,99));
			
			JButton botaoCadastrarLivro = new JButton("Cadastrar Livros");
			botaoCadastrarLivro.setBounds(50,100,200,40);
			botaoCadastrarLivro.setBackground(new Color(180,178,187));
			
			JButton botaoConsultarLivros = new JButton("Consultar Livros");
			botaoConsultarLivros.setBounds(50,170,200,40);
			botaoConsultarLivros.setBackground(new Color(180,178,187));
			
			JButton botaoCadastrarUsuario = new JButton("Cadastrar Usuário");
			botaoCadastrarUsuario.setBounds(50,240,200,40);
			botaoCadastrarUsuario.setBackground(new Color(180,178,187));
			
			JButton botaoConsultarUsuario = new JButton("Consultar Usuário");
			botaoConsultarUsuario.setBounds(50,310,200,40);
			botaoConsultarUsuario.setBackground(new Color(180,178,187));
			
			JButton botaoEmprestarlivro = new JButton("Cadastrar Empréstimo");
			botaoEmprestarlivro.setBounds(50,380,200,40);
			botaoEmprestarlivro.setBackground(new Color(180,178,187));
			
			JButton botaoGerenciarEmprestimo = new JButton("Gerenciar Empréstimo");
			botaoGerenciarEmprestimo.setBounds(50,450,200,40);
			botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
			
			painelLateral.add(botaoPaginaInicial);
			painelLateral.add(botaoCadastrarLivro);
			painelLateral.add(botaoConsultarLivros);
			painelLateral.add(botaoCadastrarUsuario);
			painelLateral.add(botaoGerenciarEmprestimo);
			painelLateral.add(botaoConsultarUsuario);
			painelLateral.add(botaoEmprestarlivro);
			
			//--------------------------------------------------------//
			//Pagina Inicial
			JPanel painelPaginaInicial = new JPanel();
			//painelPaginaInicial.setBounds(300,100,700,400);
			painelPaginaInicial.setBackground(new Color(147,144,144));
			//painelPaginaInicial.setVisible(false);
			painelPaginaInicial.setLayout(null);
			
			JLabel tituloDashboard = new JLabel("   Dashboard");
			tituloDashboard.setBounds(30,20,400,20);
			tituloDashboard.setBackground(new Color(211,205,237));
			tituloDashboard.setFont(new Font("Arial", Font.BOLD, 15));
	        tituloDashboard.setForeground(new Color(50,50,50));
	        tituloDashboard.setOpaque(true);
	        
	        JButton botaoLivrosCadastrados = new JButton("Livros Cadastrados");
	        botaoLivrosCadastrados.setBounds(30,60,175,40);
	        botaoLivrosCadastrados.setBackground(new Color(180,178,187));
	        
	        JButton botaoLivrosPendentes = new JButton("Livros Pendentes");
	        botaoLivrosPendentes.setBounds(255,60,175,40);
	        botaoLivrosPendentes.setBackground(new Color(180,178,187));
	        
	        JButton botaoLivrosEmprestados = new JButton("Livros Emprestados");
	        botaoLivrosEmprestados.setBounds(30,120,175,40);
	        botaoLivrosEmprestados.setBackground(new Color(180,178,187));
	        
	        JButton botaoUsuariosAtivos = new JButton("Usuários Ativos");
	        botaoUsuariosAtivos.setBounds(255,120,175,40);
	        botaoUsuariosAtivos.setBackground(new Color(180,178,187));
	     
	        //Botão de Salvamento -> Painel Roxo
	        
	        JButton botaoSalvar = new JButton("Salvar");
	        botaoSalvar.setBounds(890, 60, 100, 40);
	        botaoSalvar.setBackground(new Color(180, 178, 187));
	        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 14));
	 
	       
	        
	        JLabel tituloAssinatura = new JLabel("<html>&nbsp;&nbsp;Designers and Programmers<br>"
	        		+ "&nbsp;&nbsp;Álvaro    Iuri<br>&nbsp;&nbsp;Gustavo   Estevão<br>&nbsp;&nbsp;Victor</html>");
			tituloAssinatura.setBounds(30,190,400,80);
			tituloAssinatura.setBackground(new Color(211,205,237));
			tituloAssinatura.setFont(new Font("Arial", Font.PLAIN, 15));
	        tituloAssinatura.setForeground(new Color(50,50,50));
	        tituloAssinatura.setOpaque(true);
	        
	        painelPaginaInicial.add(tituloDashboard);
	        
	        painelPaginaInicial.add(botaoLivrosCadastrados);
	        painelPaginaInicial.add(botaoLivrosPendentes);
	        painelPaginaInicial.add(botaoLivrosEmprestados);
	        painelPaginaInicial.add(botaoUsuariosAtivos);
	        
	        painelPaginaInicial.add(tituloAssinatura);
			
	        painelSuperior.add(botaoSalvar);
	        
			painelCentral.add(painelPaginaInicial, "painelPaginaInicial");
			
			//botão de Salvamento
			botaoSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					salvarDados();
				}
			});
			
			carregarDados();
			
					//Esse botão define o Painel Central como o Painel Pagina Inicial
			botaoPaginaInicial.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoPaginaInicial) {
					layoutCentral.show(painelCentral, "painelPaginaInicial");
					botaoPaginaInicial.setBackground(new Color(0,191,99));
					
					//botaoPaginaInicial.setBackground(new Color(180,178,187));
					botaoCadastrarLivro.setBackground(new Color(180,178,187));
					botaoConsultarLivros.setBackground(new Color(180,178,187));
					botaoCadastrarUsuario.setBackground(new Color(180,178,187));
					botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
					botaoConsultarUsuario.setBackground(new Color(180,178,187));
					botaoEmprestarlivro.setBackground(new Color(180,178,187));
				}
			});
			
					//Esse botão define o Painel Central como o Painel de Livros Cadastrados
					//Nao implementado ainda
			botaoLivrosCadastrados.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoLivrosCadastrados) {
					tituloAssinatura.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ numeroLivrosCadastrados);
					
					botaoLivrosCadastrados.setBackground(new Color(0,191,99));
			        botaoLivrosPendentes.setBackground(new Color(180,178,187));
			        botaoLivrosEmprestados.setBackground(new Color(180,178,187));
			        botaoUsuariosAtivos.setBackground(new Color(180,178,187));
				}
			});
			
					//Esse botão define o Painel Central como o Painel de Livros Pendentes
					//Nao implementado ainda
			botaoLivrosPendentes.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoLivrosPendentes) {
					tituloAssinatura.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ numeroLivrosPendentes);
					
					botaoLivrosCadastrados.setBackground(new Color(180,178,187));
			        botaoLivrosPendentes.setBackground(new Color(0,191,99));
			        botaoLivrosEmprestados.setBackground(new Color(180,178,187));
			        botaoUsuariosAtivos.setBackground(new Color(180,178,187));
				}
			});
			
					//Esse botão define o Painel Central como o Painel de Livros Emprestados
					//Nao implementado ainda
			botaoLivrosEmprestados.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoLivrosEmprestados) {
					tituloAssinatura.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ numeroLivrosEmprestados);
					
					botaoLivrosCadastrados.setBackground(new Color(180,178,187));
			        botaoLivrosPendentes.setBackground(new Color(180,178,187));
			        botaoLivrosEmprestados.setBackground(new Color(0,191,99));
			        botaoUsuariosAtivos.setBackground(new Color(180,178,187));
				}
			});
			
					//Esse botão define o Painel Central como o Painel de Usuarios Ativos
					//Nao implementado ainda
			botaoUsuariosAtivos.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoUsuariosAtivos) {
					tituloAssinatura.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ numeroUsuariosAtivos);
					
					botaoLivrosCadastrados.setBackground(new Color(180,178,187));
			        botaoLivrosPendentes.setBackground(new Color(180,178,187));
			        botaoLivrosEmprestados.setBackground(new Color(180,178,187));
			        botaoUsuariosAtivos.setBackground(new Color(0,191,99));
				}
			});
			
			//--------------------------------------------------------//
			//Cadastrar Livro
			JPanel painelCadastrarLivro = new JPanel();
			//painelCadastrarLivro.setBounds(300,100,700,400);
			painelCadastrarLivro.setBackground(new Color(147,144,144));
			//painelCadastrarLivro.setVisible(false);
			painelCadastrarLivro.setLayout(null);
			
			JLabel tituloCadastrarLivro = new JLabel("   Cadastrar Livros");
			tituloCadastrarLivro.setBounds(30,20,400,20);
			tituloCadastrarLivro.setBackground(new Color(211,205,237));
			tituloCadastrarLivro.setFont(new Font("Arial", Font.BOLD, 15));
			tituloCadastrarLivro.setForeground(new Color(50,50,50));
			tituloCadastrarLivro.setOpaque(true);
			
					//Aqui eu estou criando os campos a serem preenchidos ao cadastramos um novo Livro:
			
			JTextField campoNomeLivro = new	JTextField();
			campoNomeLivro.setText("  Nome do Livro");
			campoNomeLivro.setBounds(30,50,400,20);
			
			JTextField campoCodigoLivro = new JTextField();
			campoCodigoLivro.setText("  Código do Livro");
			campoCodigoLivro.setBounds(30,80,175,20);
			
			JTextField campoClassificacao = new JTextField();
			campoClassificacao.setText("  Classificação");
			campoClassificacao.setBounds(255,80,175,20);
			
			JTextField campoAno = new JTextField();
			campoAno.setText("  Ano de Lançamento");
			campoAno.setBounds(30,110,175,20);
			
			JTextField campoGenero = new JTextField();
			campoGenero.setText("  Genero do Livro");
			campoGenero.setBounds(255,110,175,20);
			
			JTextField campoAutor = new JTextField();
			campoAutor.setText("  Autor do Livro");
			campoAutor.setBounds(30,140,175,20);
			
			JTextField campoEditora = new JTextField();
			campoEditora.setText("  Editora de Distribuição");
			campoEditora.setBounds(255,140,175,20);
			
			JTextField campoNumeroPaginas = new JTextField();
			campoNumeroPaginas.setText("  Número de Páginas");
			campoNumeroPaginas.setBounds(30,170,175,20);
			
			JTextField campoExemplares = new JTextField();
			campoExemplares.setText("  Número de Exemplares");
			campoExemplares.setBounds(255,170,175,20);
			
			JTextArea campoDescricao = new JTextArea();
			campoDescricao.setText("  Descrição do Livro");
			campoDescricao.setBounds(30,200,400,50);
			
					/////////////////////////////////////////////////////////////////////////
			
			JButton botaoCadastrar = new JButton("Cadastrar");
			botaoCadastrar.setBounds(30,285,400,20);
			botaoCadastrar.setBackground(new Color(0,191,99));
			
			
			painelCadastrarLivro.add(tituloCadastrarLivro);
			
			painelCadastrarLivro.add(campoNomeLivro);
			painelCadastrarLivro.add(campoCodigoLivro);
			painelCadastrarLivro.add(campoClassificacao);
			painelCadastrarLivro.add(campoAno);
			painelCadastrarLivro.add(campoGenero);
			painelCadastrarLivro.add(campoAutor);
			painelCadastrarLivro.add(campoEditora);
			painelCadastrarLivro.add(campoNumeroPaginas);
			painelCadastrarLivro.add(campoExemplares);
			painelCadastrarLivro.add(campoDescricao);
			
			painelCadastrarLivro.add(botaoCadastrar);
		
			painelCentral.add(painelCadastrarLivro, "painelCadastrarLivro");
			
					//Esse botão define o Painel Central como o Painel de Cadastro de Livros
			botaoCadastrarLivro.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoCadastrarLivro) {
					layoutCentral.show(painelCentral, "painelCadastrarLivro");
					botaoCadastrarLivro.setBackground(new Color(0,191,99));
					
					botaoPaginaInicial.setBackground(new Color(180,178,187));
					//botaoCadastrarLivro.setBackground(new Color(180,178,187));
					botaoConsultarLivros.setBackground(new Color(180,178,187));
					botaoCadastrarUsuario.setBackground(new Color(180,178,187));
					botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
					botaoConsultarUsuario.setBackground(new Color(180,178,187));
					botaoEmprestarlivro.setBackground(new Color(180,178,187));
				}
			});
			
			//Implementação do Cadastro de Livros
			//Aqui eu estou salvando os dados digitados nos campos de preenchimentos em suas respectivas Strings
			//Além disso eu retorno os campoes de preenchimentos ao texto inicial
			//E coloco uma mensagem flutuante de Sucesso na tela;
			
			botaoCadastrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaobotaoCadastrar) {
					
					boolean sucess = true;
					if(!DadosLivros.setNomeLivro(campoNomeLivro.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Nome Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setCodigoLivro(campoCodigoLivro.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Código Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					
					if(!DadosLivros.setAnoLancamentoLivro(campoAno.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Ano de Lançamento Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setGeneroLivro(campoGenero.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Gênero Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setAutorLivro(campoAutor.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Nome do Autor Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setEditoraLivro(campoEditora.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Editora Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setNumeroPaginasLivro(campoNumeroPaginas.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Número de Páginas Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					if(!DadosLivros.setNumeroExemplaresLivro(campoExemplares.getText().replaceAll("\\s+", "").toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Número de Exemplares Inválido",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						sucess = false;
					}
					
					//codigoLivro = campoCodigoLivro.getText().replaceAll("\\s+", "").toLowerCase();
					//classificacaoLivro = campoClassificacao.getText().replaceAll("\\s+", "").toLowerCase();
					//anoLancamentoLivro = campoAno.getText().replaceAll("\\s+", "").toLowerCase();
					//generoLivro = campoGenero.getText().replaceAll("\\s+", "").toLowerCase();
					//autorLivro = campoAutor.getText().replaceAll("\\s+", "").toLowerCase();
					//editoraLivro = campoEditora.getText().replaceAll("\\s+", "").toLowerCase();
					//numeroPaginasLivro = campoNumeroPaginas.getText().replaceAll("\\s+", "").toLowerCase();
					//numeroExemplaresLivro = campoExemplares.getText().replaceAll("\\s+", "").toLowerCase();
					DadosLivros.setDescricaoLivro(campoDescricao.getText().replaceAll("\\s+", "").toLowerCase());
					
					if(sucess) {
						
						
						Livro livroAdicionado = new Livro(
								DadosLivros.getNomeLivro(), 
								DadosLivros.getCodigoLivro(), 
								DadosLivros.getAnoLancamentoLivro(),
								DadosLivros.getAutorLivro(),
								DadosLivros.getNumeroPaginasLivro(),
								DadosLivros.getGeneroLivro(),
								DadosLivros.getEditoraLivro()
								);
						
						try {
							sistema.adicionarLivro(livroAdicionado);
							sistema.setTemAlteracao(true); //FLAG (Salvar)
							
							JOptionPane.showMessageDialog(null, "Livro Cadastrado Com Sucesso!",
									"Sucesso", JOptionPane.INFORMATION_MESSAGE);
							
							campoNomeLivro.setText("  Nome do Livro");
							campoCodigoLivro.setText("  Código do Livro");
							campoClassificacao.setText("  Classificação");
							campoAno.setText("  Ano de Lançamento");
							campoGenero.setText("  Genero do Livro");
							campoAutor.setText("  Autor do Livro");
							campoEditora.setText("  Editora de Distribuição");
							campoNumeroPaginas.setText("  Número de Páginas");
							campoExemplares.setText("  Número de Exemplares");
							campoDescricao.setText("  Descrição do Livro");
							
							
						} catch (LivroJaAdicionadoException | NumeroPaginasInvalidoException e) {
							JOptionPane.showMessageDialog(null, "Livro Existente",
									"Erro", JOptionPane.INFORMATION_MESSAGE);
						}
					}
	
				}
			});
			
			//--------------------------------------------------------//
			//Consultar Livros
			JPanel painelConsultarLivros1 = new JPanel();
			//painelConsultarLivros1.setBounds(300,100,700,400);
			painelConsultarLivros1.setBackground(new Color(147,144,144));
			//painelConsultarLivros1.setVisible(false);
			painelConsultarLivros1.setLayout(null);
			
			JLabel tituloConsultarLivro = new JLabel("   Consultar Livro:");
			tituloConsultarLivro.setBounds(30,20,400,20);
			tituloConsultarLivro.setBackground(new Color(211,205,237));
			tituloConsultarLivro.setFont(new Font("Arial", Font.BOLD, 15));
			tituloConsultarLivro.setForeground(new Color(50,50,50));
			tituloConsultarLivro.setOpaque(true);
			
			JTextField campoBarraPesquisa = new	JTextField();
			campoBarraPesquisa.setText("  Código do Livro");
			campoBarraPesquisa.setBounds(30,55,250,20);
			
			JButton botaoPesquisarLivro = new JButton("Pesquisar");
			botaoPesquisarLivro.setBounds(330,55,100,20);
			botaoPesquisarLivro.setBackground(new Color(0,191,99));
			
			
			painelConsultarLivros1.add(tituloConsultarLivro);
			
			painelConsultarLivros1.add(campoBarraPesquisa);
			
			painelConsultarLivros1.add(botaoPesquisarLivro);
			
			painelCentral.add(painelConsultarLivros1, "painelConsultarLivros1");
			
					//Esse botão define o Painel Central como o Painel de Consultar Livros
			botaoConsultarLivros.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoConsultarLivros) {
					layoutCentral.show(painelCentral, "painelConsultarLivros1");
					botaoConsultarLivros.setBackground(new Color(0,191,99));
					
					botaoPaginaInicial.setBackground(new Color(180,178,187));
					botaoCadastrarLivro.setBackground(new Color(180,178,187));
					//botaoConsultarLivros.setBackground(new Color(180,178,187));
					botaoCadastrarUsuario.setBackground(new Color(180,178,187));
					botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
					botaoConsultarUsuario.setBackground(new Color(180,178,187));
					botaoEmprestarlivro.setBackground(new Color(180,178,187));
				}
			});
			
			//Implementação do Painel de Consulta de Livros:
			
			JPanel painelLivroConsultado = new JPanel();
			painelLivroConsultado.setBounds(30,95,400,120);
			painelLivroConsultado.setBackground(new Color(211,205,237));
			painelLivroConsultado.setBorder(BorderFactory.createLineBorder(new Color(211,205,237)));
			painelLivroConsultado.setLayout(null);
			
			JLabel nomeLivroConsultado = new JLabel();
			nomeLivroConsultado.setBounds(20,10,380,20);
			nomeLivroConsultado.setFont(new Font("Arial", Font.BOLD, 12));
			nomeLivroConsultado.setForeground(new Color(50,50,50));
			
			JButton botaoInformacoesLivros = new JButton("Informações");
			botaoInformacoesLivros.setBounds(20,50,110,40);
			botaoInformacoesLivros.setBackground(new Color(180,178,187));
			
			JButton botaoAlterarInformacoesLivros = new JButton("<html>Alterar<br>Informações<html>");
			botaoAlterarInformacoesLivros.setBounds(145,50,110,40);
			botaoAlterarInformacoesLivros.setBackground(new Color(180,178,187));
			
			JButton botaoRemoverLivros = new JButton("Remover");
			botaoRemoverLivros.setBounds(270,50,110,40);
			botaoRemoverLivros.setBackground(new Color(180,178,187));
			
			painelLivroConsultado.add(nomeLivroConsultado);
			
			painelLivroConsultado.add(botaoInformacoesLivros);
			painelLivroConsultado.add(botaoAlterarInformacoesLivros);
			painelLivroConsultado.add(botaoRemoverLivros);
			
			painelConsultarLivros1.add(painelLivroConsultado);
			painelLivroConsultado.setVisible(false);
					
					//Aqui eu salvo a string de livro consultado com o nome do livro digitado na barra de pesquisa
					//Caso o livro exista, é exibido um painel com seu nome e três opções;
			botaoPesquisarLivro.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acaoBotaoPesquisarLivro) {
					try {
						stringCodigoLivroConsultado = campoBarraPesquisa.getText();
						sistema.consultarLivro(stringCodigoLivroConsultado);
						
						Livro livroConsultado = sistema.consultarLivro(stringCodigoLivroConsultado);
						
						nomeLivroConsultado.setText(livroConsultado.getNome());
						painelLivroConsultado.setVisible(true);
						
						
						//Implementação do Painel de Informações do Livro:
			
						JPanel painelConsultarLivros2 = new JPanel();
						painelConsultarLivros2.setBackground(new Color(147,144,144));
						painelConsultarLivros2.setLayout(null);
			
						JLabel tituloInformacaoLivro = new JLabel("  " + livroConsultado.getNome());
						tituloInformacaoLivro.setBounds(30,20,400,20);
						tituloInformacaoLivro.setBackground(new Color(211,205,237));
						tituloInformacaoLivro.setFont(new Font("Arial", Font.BOLD, 15));
						tituloInformacaoLivro.setForeground(new Color(50,50,50));
						tituloInformacaoLivro.setOpaque(true);
						
						JLabel codigoLivro = new JLabel(" Código: " + livroConsultado.getCodigo());
						codigoLivro.setBounds(30,80,175,20);
						codigoLivro.setBackground(new Color(211,205,237));
						codigoLivro.setFont(new Font("Arial", Font.BOLD, 15));
						codigoLivro.setForeground(new Color(50,50,50));
						codigoLivro.setOpaque(true);
						
						JLabel AnoLivro = new JLabel(" Publicação: " + livroConsultado.getAno());
						AnoLivro.setBounds(255,80,175,20);
						AnoLivro.setBackground(new Color(211,205,237));
						AnoLivro.setFont(new Font("Arial", Font.BOLD, 15));
						AnoLivro.setForeground(new Color(50,50,50));
						AnoLivro.setOpaque(true);
						
						JLabel GeneroLivro = new JLabel(" Gênero: " + livroConsultado.getGenero());
						GeneroLivro.setBounds(30,110,175,20);
						GeneroLivro.setBackground(new Color(211,205,237));
						GeneroLivro.setFont(new Font("Arial", Font.BOLD, 15));
						GeneroLivro.setForeground(new Color(50,50,50));
						GeneroLivro.setOpaque(true);
						
						JLabel AutorLivro = new JLabel(" Autor: " + livroConsultado.getAutor());
						AutorLivro.setBounds(255,110,175,20);
						AutorLivro.setBackground(new Color(211,205,237));
						AutorLivro.setFont(new Font("Arial", Font.BOLD, 15));
						AutorLivro.setForeground(new Color(50,50,50));
						AutorLivro.setOpaque(true);
						
						JLabel EditoraLivro = new JLabel(" Editora: " + livroConsultado.getEditora());
						EditoraLivro.setBounds(30,140,175,20);
						EditoraLivro.setBackground(new Color(211,205,237));
						EditoraLivro.setFont(new Font("Arial", Font.BOLD, 15));
						EditoraLivro.setForeground(new Color(50,50,50));
						EditoraLivro.setOpaque(true);
						
						JLabel numPagLivro = new JLabel(" Num Pág: " + livroConsultado.getNumPaginas());
						numPagLivro.setBounds(255,140,175,20);
						numPagLivro.setBackground(new Color(211,205,237));
						numPagLivro.setFont(new Font("Arial", Font.BOLD, 15));
						numPagLivro.setForeground(new Color(50,50,50));
						numPagLivro.setOpaque(true);
						
						JButton botaoVoltarInformacaoLivro = new JButton("⬅ Voltar");
						botaoVoltarInformacaoLivro.setBounds(30,300,400,20);
						botaoVoltarInformacaoLivro.setBackground(new Color(180,178,187));
						
						painelConsultarLivros2.add(tituloInformacaoLivro);
						
						painelConsultarLivros2.add(codigoLivro);
						painelConsultarLivros2.add(AnoLivro);
						painelConsultarLivros2.add(GeneroLivro);
						painelConsultarLivros2.add(AutorLivro);
						painelConsultarLivros2.add(EditoraLivro);
						painelConsultarLivros2.add(numPagLivro);
						
						painelConsultarLivros2.add(botaoVoltarInformacaoLivro);
						
						painelCentral.add(painelConsultarLivros2, "painelConsultarLivros2");
						
								//Esse botão define o Painel Central como o Painel de Informações do Livro Consultado
						botaoInformacoesLivros.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoInformacoesLivros) {
								layoutCentral.show(painelCentral, "painelConsultarLivros2");
							}
						});
						
								//Esse botão retorna ao Painel de Consultar Livros
						botaoVoltarInformacaoLivro.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoVoltarInformacaoLivro) {
								layoutCentral.show(painelCentral, "painelConsultarLivros1");
							}
						});
						
						//Implementação do Painel de Alterar Informações do Livro:
						
						JPanel painelConsultarLivros3 = new JPanel();
						painelConsultarLivros3.setBackground(new Color(147,144,144));
						painelConsultarLivros3.setLayout(null);
						
						JTextField tituloInformacaoLivro2 = new JTextField("  " + nomeLivroConsultado.getText());
						tituloInformacaoLivro2.setBounds(30,20,400,20);
						tituloInformacaoLivro2.setBackground(new Color(211,205,237));
						tituloInformacaoLivro2.setFont(new Font("Arial", Font.BOLD, 15));
						tituloInformacaoLivro2.setForeground(new Color(50,50,50));
						tituloInformacaoLivro2.setOpaque(true);
						
						JTextField campoCodigoLivro2 = new JTextField("  " + livroConsultado.getCodigo());
						campoCodigoLivro.setBounds(30,80,175,20);
						
//						JTextField campoClassificacao2 = new JTextField("  " + livroConsultado.getClassificacao());
//						campoClassificacao.setText("  Classificação");
//						campoClassificacao.setBounds(255,80,175,20);
						
						JTextField campoAno2 = new JTextField(" Publicação: " + livroConsultado.getAno());
						campoAno2.setBounds(30,110,175,20);
						
						JTextField campoGenero2 = new JTextField(" Gênero: " + livroConsultado.getGenero());
						campoGenero2.setBounds(255,110,175,20);
						
						JTextField campoAutor2 = new JTextField(" Autor:" + livroConsultado.getAutor());
						campoAutor2.setBounds(30,140,175,20);
						
						JTextField campoEditora2 = new JTextField(" Editora: " + livroConsultado.getEditora());
						campoEditora2.setBounds(255,140,175,20);
						
						JTextField campoNumeroPaginas2 = new JTextField(" Núm Pág: " + livroConsultado.getNumPaginas());
						campoNumeroPaginas2.setBounds(30,170,175,20);
						
//						JTextField campoExemplares2 = new JTextField("  " + livroConsultado.getNumExemplares());
//						campoExemplares.setText("  Número de Exemplares");
//						campoExemplares.setBounds(255,170,175,20);
						
//						JTextArea campoDescricao2 = new JTextArea("  " + livroConsultado.getNome());
//						campoDescricao.setText("  Descrição do Livro");
//						campoDescricao.setBounds(30,200,400,50);
						
						JButton botaoAtualizar = new JButton("Atualizar");
						botaoAtualizar.setBounds(30,270,400,20);
						botaoAtualizar.setBackground(new Color(0,191,99));
						
						JButton botaoVoltarAlterarInformacaoLivro = new JButton("⬅ Voltar");
						botaoVoltarAlterarInformacaoLivro.setBounds(30,300,400,20);
						botaoVoltarAlterarInformacaoLivro.setBackground(new Color(180,178,187));
						
						painelConsultarLivros3.add(tituloInformacaoLivro2);
						
						painelConsultarLivros3.add(campoCodigoLivro2);
//						painelConsultarLivros3.add(campoClassificacao2);
						painelConsultarLivros3.add(campoAno2);
						painelConsultarLivros3.add(campoGenero2);
						painelConsultarLivros3.add(campoAutor2);
						painelConsultarLivros3.add(campoEditora2);
						painelConsultarLivros3.add(campoNumeroPaginas2);
//						painelConsultarLivros3.add(campoExemplares2);
//						painelConsultarLivros3.add(campoDescricao2);
						
						painelConsultarLivros3.add(botaoAtualizar);
						painelConsultarLivros3.add(botaoVoltarAlterarInformacaoLivro);
						
						painelCentral.add(painelConsultarLivros3, "painelConsultarLivros3");
						
								//Esse botão define o Painel Central como o Painel de Alterar Informações do Livro Consultado
						botaoAlterarInformacoesLivros.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoAlterarInformacoesLivros) {
								
								layoutCentral.show(painelCentral, "painelConsultarLivros3");
							}
						});
						
						botaoAtualizar.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoAtualizar) {
								
								Livro livroAtualizado = new Livro(
										tituloInformacaoLivro2.getText(), 
										campoCodigoLivro2.getText(), 
										campoAno2.getText(),
										campoAutor2.getText(),
										campoNumeroPaginas2.getText(),
										campoGenero2.getText(),
										campoEditora2.getText()
										);
								stringCodigoLivroConsultado = campoCodigoLivro2.getText();
								
								try {
									sistema.atualizarInformacao(stringCodigoLivroConsultado, livroAtualizado);
								} catch (LivroNaoEncontradoException e) {
									JOptionPane.showMessageDialog(null, "Livro Não Encontrado",
											"Erro", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						
								//Esse botão retorna ao Painel de Consultar Livros
						botaoVoltarAlterarInformacaoLivro.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoVoltarAlterarInformacaoLivro) {
								layoutCentral.show(painelCentral, "painelConsultarLivros1");
							}
						});
						
						//Implementação do Botão de Remover:
						//ADENDO: ESSA NÃO É APLICAÇÃO REAL NO CÓDIGO, É APENAS ALGO GRÁFICO PRA FAZER GRAÇA!
						//Esse botão em tese deve remover um livro dos livros cadastrados
						botaoRemoverLivros.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent acaoBotaoRemoverLivros) {
								painelLivroConsultado.setVisible(false);
								campoBarraPesquisa.setText("");
								
								JOptionPane.showMessageDialog(null, "Livro Removido",
										"Sucesso", JOptionPane.INFORMATION_MESSAGE);
								try {
									sistema.removerLivro(stringCodigoLivroConsultado);
								} catch (LivroNaoEncontradoException e) {
									JOptionPane.showMessageDialog(null, "Livro Não Encontrado",
											"Erro", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						
						
						
						
						
						
					} catch (LivroNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, "Livro Não Cadastrado",
								"Erro", JOptionPane.INFORMATION_MESSAGE);
						
						campoBarraPesquisa.setText("  Código do Livro");
					}
				}
			});
			
			
			
			// Cadastrar Usuário -------------------------------------------
			// Criando o painel de cadastro de aluno e adicionando ao painelCentral
			CadastrarAlunoPainel painelCadastrarAluno = new CadastrarAlunoPainel(sistema);
			painelCentral.add(painelCadastrarAluno, "painelCadastrarAluno");

			// Criando botão para alternar para o painel de cadastro de aluno
			botaoCadastrarUsuario.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent acaoBotaoCadastrarUsuario) {
			        layoutCentral.show(painelCentral, "painelCadastrarAluno");
			        botaoCadastrarUsuario.setBackground(new Color(0,191,99));

			        // Resetando as cores dos outros botões para manter o estilo
			        botaoPaginaInicial.setBackground(new Color(180,178,187));
			        botaoCadastrarLivro.setBackground(new Color(180,178,187));
			        botaoConsultarLivros.setBackground(new Color(180,178,187));
			        botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
			     // botaoCadastrarUsuario.setBackground(new Color(180,178,187));
			        botaoConsultarUsuario.setBackground(new Color(180,178,187));
			        botaoEmprestarlivro.setBackground(new Color(180,178,187));
			    }
			});
			
			// Consultar Usuário -------------------------------------------
			// Criando o painel de cadastro de aluno e adicionando ao painelCentral
			ConsultarAlunoPanel painelConsultarAluno = new ConsultarAlunoPanel(sistema);
			painelCentral.add(painelConsultarAluno, "painelConsultarAluno");

			// Criando botão para alternar para o painel de cadastro de aluno
			botaoConsultarUsuario.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent acaoBotaoConsultarUsuario) {
			        layoutCentral.show(painelCentral, "painelConsultarAluno");
			        botaoConsultarUsuario.setBackground(new Color(0,191,99));

			        // Resetando as cores dos outros botões para manter o estilo
			        botaoPaginaInicial.setBackground(new Color(180,178,187));
			        botaoCadastrarLivro.setBackground(new Color(180,178,187));
			        botaoConsultarLivros.setBackground(new Color(180,178,187));
			        botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
			   //   botaoConsultarUsuario.setBackground(new Color(180,178,187));
			        botaoCadastrarUsuario.setBackground(new Color(180,178,187));
			        botaoEmprestarlivro.setBackground(new Color(180,178,187));
			    }
			});
			
			// Cadastrar Emprestimo -------------------------------------------
			// Criando o painel de cadastro de aluno e adicionando ao painelCentral
			CadastrarEmprestimoPanel painelCadastrarEmprestimo= new CadastrarEmprestimoPanel(sistema);
			painelCentral.add(painelCadastrarEmprestimo, "painelCadastrarEmprestimo");

			// Criando botão para alternar para o painel de cadastro de aluno
			botaoEmprestarlivro.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent acaoBotaoEmprestarLivro) {
			        layoutCentral.show(painelCentral, "painelCadastrarEmprestimo");
			        botaoEmprestarlivro.setBackground(new Color(0,191,99));

			        // Resetando as cores dos outros botões para manter o estilo
			        botaoPaginaInicial.setBackground(new Color(180,178,187));
			        botaoCadastrarLivro.setBackground(new Color(180,178,187));
			        botaoConsultarLivros.setBackground(new Color(180,178,187));
			        botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
			        botaoConsultarUsuario.setBackground(new Color(180,178,187));
			        botaoCadastrarUsuario.setBackground(new Color(180,178,187));
		   //       botaoEmprestarlivro.setBackground(new Color(180,178,187));
			    }
			});
			
			
			// Gerenciar Emprestimo -------------------------------------------
			// Criando o painel de cadastro de aluno e adicionando ao painelCentral
			ConsultarEmprestimoPainel painelConsultarEmprestimo = new ConsultarEmprestimoPainel(sistema);
			painelCentral.add(painelConsultarEmprestimo, "painelGerenciarEmprestimo");

			// Criando botão para alternar para o painel de cadastro de aluno
			botaoGerenciarEmprestimo.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent acaoBotaoGerenciarEmprestimo) {
			        layoutCentral.show(painelCentral, "painelGerenciarEmprestimo");
			        botaoGerenciarEmprestimo.setBackground(new Color(0,191,99));

			        // Resetando as cores dos outros botões para manter o estilo
			        botaoPaginaInicial.setBackground(new Color(180,178,187));
			        botaoCadastrarLivro.setBackground(new Color(180,178,187));
			        botaoConsultarLivros.setBackground(new Color(180,178,187));
			 //     botaoGerenciarEmprestimo.setBackground(new Color(180,178,187));
			        botaoConsultarUsuario.setBackground(new Color(180,178,187));
			        botaoCadastrarUsuario.setBackground(new Color(180,178,187));
			        botaoEmprestarlivro.setBackground(new Color(180,178,187));
			    }
			});

			
			
			//"Saindo com Segurança - Persistencia"	
			addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override 
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        // Evita o fechamento automático da janela
			        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			        if (sistema.getTemAlteracao()) {
			            int option = JOptionPane.showConfirmDialog(null,
			                "Você tem alterações não salvas. Deseja salvar antes de sair?",
			                "Salvar Alterações", JOptionPane.YES_NO_CANCEL_OPTION);

			            if (option == JOptionPane.YES_OPTION) {
			                salvarDados();
			                System.exit(0);
			            } else if (option == JOptionPane.NO_OPTION) {
			                System.exit(0);
			            } else {
			                // Se for CANCEL_OPTION ou fechar a caixa de diálogo, interrompe a execução
			                return;
			            }
			        } 
			        
			        // Se não houver alterações, fecha normalmente
			        System.exit(0);
			    }
			});
			
			
			//--------------------------------------------------------//
			//--------------------------------------------------------//
			//Aqui eu finalizo o código tornando a janela visível;
			//É muito importante na criação de uma interface gráfica que esse comando venha por último
			//Pois caso contrário alguns componentes podem exibir mal funcionamento;
			setVisible(true);
}
	
	

		private void carregarDados() {
		    try {
		        FileInputStream fis = new FileInputStream("Biblioteca.dat");
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        this.sistema = (SistemaBibliotecario) ois.readObject(); // Atribuição à variável de instância
		        ois.close();
		        fis.close();
		        sistema.setTemAlteracao(false);
		        JOptionPane.showMessageDialog(this, "Dados carregados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		    } catch (FileNotFoundException ex) {
		        ex.printStackTrace();
		    } catch (IOException | ClassNotFoundException e) {
		        e.printStackTrace();
		    }  
		}
		
		private void salvarDados() {
	    	try {
	        	FileOutputStream fos = new FileOutputStream("Biblioteca.dat");
	        	ObjectOutputStream oos = new ObjectOutputStream(fos);
	        	oos.writeObject(sistema);
	     		   oos.close();
	     		   fos.close();
	        	sistema.setTemAlteracao(false); // Marca os dados como salvos
	        	JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	    	} catch (IOException e) {
	        	e.printStackTrace();
	        	JOptionPane.showMessageDialog(this, "Erro ao salvar os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
	    	}
		}		
		
		
		public static void main(String[] args) {
	
				new Screen();
}

}
