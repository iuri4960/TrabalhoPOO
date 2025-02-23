package trabalho;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

public class Screen extends JFrame {
	
		private String numeroLivrosCadastrados = "12";
		private String numeroLivrosPendentes = "4";
		private String numeroLivrosEmprestados = "9";
		private String numeroUsuariosAtivos = "52";
	
		private String stringNomeLivroConsultado;
	
		public Screen() {
			
				//--------------------------------------------------
				//Detalhes Iniciais
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLayout(null);
				
				setTitle("Biblioteca Online");
				ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/image.png"));
				setIconImage(icone.getImage());
				setSize(800, 500);
				
				//setLocation(283, 134); //centro de um monitor comum;
				setLocationRelativeTo(null);
				setResizable(false); //não redimensionável; 
				
				//setVisible(true);
				
				//--------------------------------------------------
				//Paineis Iniciais
				JPanel painelSuperior = new JPanel();
				painelSuperior.setLayout(null);
				painelSuperior.setBounds(0,0,800,100);
				painelSuperior.setBackground(new Color(140,82,255));
				
				JPanel painelLateral = new JPanel();
				painelLateral.setLayout(null);
				//painelLateral.setBounds(0,100,300,800);
				painelLateral.setPreferredSize(new Dimension(300, 550));
				painelLateral.setBackground(new Color(211,205,237));
				
				JPanel painelCentral = new JPanel(new CardLayout());
				painelCentral.setBounds(300,100,700,400);
				painelCentral.setBackground(new Color(147,144,144));
				
				CardLayout layoutCentral = (CardLayout) painelCentral.getLayout();
				
				//add(painelLateral);
				add(painelSuperior);
				add(painelCentral);
				
				JScrollPane scrollPane = new JScrollPane(painelLateral);
				scrollPane.setBounds(0,100,300,400);
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        add(scrollPane);
		        
		        //--------------------------------------------------------
		        //Título:
		        JLabel tituloPrincipal = new JLabel();
		        tituloPrincipal.setText("Biblioteca Online");
		        tituloPrincipal.setBounds(100,30,800,30);
		        tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 32));
		        tituloPrincipal.setForeground(new Color(255,255,255));	        
		        
		        ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/image.png"));
		        Image imagemRedimensionada = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada);
		        JLabel labelImagem = new JLabel(novaImagem);
		        labelImagem.setBounds(365, 0, novaImagem.getIconWidth(), novaImagem.getIconHeight());
		        
		        painelSuperior.add(tituloPrincipal);
		        painelSuperior.add(labelImagem);
		        
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
				
				painelCentral.add(painelPaginaInicial, "painelPaginaInicial");
				
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
				campoBarraPesquisa.setText("  Memórias Póstumas de Brás Cubas");
				campoBarraPesquisa.setBounds(30,55,250,20);
				
				JButton botaoPesquisarLivro = new JButton("Pesquisar");
				botaoPesquisarLivro.setBounds(330,55,100,20);
				botaoPesquisarLivro.setBackground(new Color(0,191,99));
				
				
				painelConsultarLivros1.add(tituloConsultarLivro);
				
				painelConsultarLivros1.add(campoBarraPesquisa);
				
				painelConsultarLivros1.add(botaoPesquisarLivro);
				
				painelCentral.add(painelConsultarLivros1, "painelConsultarLivros1");
				
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
				
				botaoPesquisarLivro.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoPesquisarLivro) {
						stringNomeLivroConsultado = campoBarraPesquisa.getText().trim();
						nomeLivroConsultado.setText(stringNomeLivroConsultado);
						painelLivroConsultado.setVisible(true);
					}
				});
				
				//addMouseListener(new MouseAdapter() {
				//	public void mousePressed(MouseEvent e) {
				//		if (!painelLivroConsultado.getBounds().contains(e.getPoint())) {
				//			painelLivroConsultado.setVisible(false);
				//		}
				//	}
				//});
				
				//Implementação do Painel de Informações do Livro:
				JPanel painelConsultarLivros2 = new JPanel();
				painelConsultarLivros2.setBackground(new Color(147,144,144));
				painelConsultarLivros2.setLayout(null);
				
				JLabel tituloInformacaoLivro = new JLabel();
				tituloInformacaoLivro.setBounds(30,20,400,20);
				tituloInformacaoLivro.setBackground(new Color(211,205,237));
				tituloInformacaoLivro.setFont(new Font("Arial", Font.BOLD, 15));
				tituloInformacaoLivro.setForeground(new Color(50,50,50));
				tituloInformacaoLivro.setOpaque(true);
				
				JButton botaoVoltarInformacaoLivro = new JButton("⬅ Voltar");
				botaoVoltarInformacaoLivro.setBounds(30,300,400,20);
				botaoVoltarInformacaoLivro.setBackground(new Color(180,178,187));
				
				painelConsultarLivros2.add(tituloInformacaoLivro);
				
				painelConsultarLivros2.add(botaoVoltarInformacaoLivro);
				
				painelCentral.add(painelConsultarLivros2, "painelConsultarLivros2");
				
				botaoInformacoesLivros.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoInformacoesLivros) {
						tituloInformacaoLivro.setText("  " + stringNomeLivroConsultado);
						layoutCentral.show(painelCentral, "painelConsultarLivros2");
					}
				});
				
				botaoVoltarInformacaoLivro.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoVoltarInformacaoLivro) {
						layoutCentral.show(painelCentral, "painelConsultarLivros1");
					}
				});
				
				//Implementação do Painel de Alterar Informações do Livro:
				JPanel painelConsultarLivros3 = new JPanel();
				painelConsultarLivros3.setBackground(new Color(147,144,144));
				painelConsultarLivros3.setLayout(null);
				
				JLabel tituloInformacaoLivro2 = new JLabel();
				tituloInformacaoLivro2.setBounds(30,20,400,20);
				tituloInformacaoLivro2.setBackground(new Color(211,205,237));
				tituloInformacaoLivro2.setFont(new Font("Arial", Font.BOLD, 15));
				tituloInformacaoLivro2.setForeground(new Color(50,50,50));
				tituloInformacaoLivro2.setOpaque(true);
				
				JButton botaoVoltarAlterarInformacaoLivro = new JButton("⬅ Voltar");
				botaoVoltarAlterarInformacaoLivro.setBounds(30,300,400,20);
				botaoVoltarAlterarInformacaoLivro.setBackground(new Color(180,178,187));
				
				painelConsultarLivros3.add(tituloInformacaoLivro2);
				
				painelConsultarLivros3.add(botaoVoltarAlterarInformacaoLivro);
				
				painelCentral.add(painelConsultarLivros3, "painelConsultarLivros3");
				
				botaoAlterarInformacoesLivros.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoAlterarInformacoesLivros) {
						tituloInformacaoLivro2.setText("  " + stringNomeLivroConsultado);
						layoutCentral.show(painelCentral, "painelConsultarLivros3");
					}
				});
				
				botaoVoltarAlterarInformacaoLivro.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoVoltarAlterarInformacaoLivro) {
						layoutCentral.show(painelCentral, "painelConsultarLivros1");
					}
				});
				
				//Implementação do Botão de Remover:
				//ADENDO: ESSA NÃO É APLICAÇÃO REAL NO CÓDIGO, É APENAS ALGO GRÁFICO PRA FAZER GRAÇA!
				
				botaoRemoverLivros.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent acaoBotaoRemoverLivros) {
						painelLivroConsultado.setVisible(false);
						campoBarraPesquisa.setText("");
					}
				});
				
				//--------------------------------------------------------//
				//--------------------------------------------------------//
				setVisible(true);
	}
	
		public static void main(String[] args) {
		
				new Screen();
	}
}
