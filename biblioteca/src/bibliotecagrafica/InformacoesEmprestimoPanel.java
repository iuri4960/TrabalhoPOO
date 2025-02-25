package bibliotecagrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import usuario.Aluno;
import usuario.Emprestimo;

public class InformacoesEmprestimoPanel extends JPanel {
	SistemaBibliotecario sistema;
    Emprestimo emprestimoGeral;

    JLabel labelNome;
    JLabel labelNomeDoUsuario;
    JLabel tipoDeUsuario;
    JLabel labelMatriculaDoUsuario;
    JLabel labelCodigoLivro;
    JLabel labelDataDeDevolucao;
    JLabel labelDataDeDoCadastro; //data do cadastro
    JLabel labelMultaDoEmprestimo;

    InformacoesEmprestimoPanel(SistemaBibliotecario sistema, Emprestimo emprestimoGeral){
        this.emprestimoGeral = emprestimoGeral;
        this.sistema = sistema;
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelInformacoes(), BorderLayout.CENTER);
    }

    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.gray);
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("INFORMAÇÕES DO EMPRESTIMO", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        cabecalho.add(label);
        return cabecalho;
    }

    //painel de informações
    private JPanel criarPainelInformacoes(){
        //configurando o painel
        JPanel informacoes = new JPanel();
        informacoes.setLayout(new GridBagLayout());
        informacoes.setBackground(Color.LIGHT_GRAY);

        //caixa de nome
        labelNome = new JLabel("Nome do Livro");
        labelNome.setPreferredSize(new Dimension(300, 50));

        //definindo uma bornda para o nome
        labelNome.setOpaque(true);  // Permite que o fundo seja desenhado
        labelNome.setBackground(Color.WHITE);  // Define a cor de fundo desejada
        labelNome.setBorder(BorderFactory.createTitledBorder("Nome do Livro"));  // Adiciona uma borda preta

        //matricula
        labelNomeDoUsuario = new JLabel("Nome do Usuário");
        labelNomeDoUsuario.setPreferredSize(new Dimension(150, 50));
        
        labelNomeDoUsuario.setOpaque(true);  
        labelNomeDoUsuario.setBackground(Color.WHITE);  
        labelNomeDoUsuario.setBorder(BorderFactory.createTitledBorder("Nome do Usuário"));  

        //titulo
        tipoDeUsuario = new JLabel("Tipo de Usuário");
        tipoDeUsuario.setPreferredSize(new Dimension(150, 50));
        
        tipoDeUsuario.setOpaque(true);  
        tipoDeUsuario.setBackground(Color.WHITE);  
        tipoDeUsuario.setBorder(BorderFactory.createTitledBorder("Tipo de usuário")); 
        
        //tipo de usuario
        labelMatriculaDoUsuario = new JLabel("Matricula do Usuário");
        labelMatriculaDoUsuario.setPreferredSize(new Dimension(150, 50));
        
        labelMatriculaDoUsuario.setOpaque(true);  
        labelMatriculaDoUsuario.setBackground(Color.WHITE);  
        labelMatriculaDoUsuario.setBorder(BorderFactory.createTitledBorder("Matricula do Usuário")); 

        //idade
        labelCodigoLivro = new JLabel("Codigo do Livro");
        labelCodigoLivro.setPreferredSize(new Dimension(150, 50));
        
        labelCodigoLivro.setOpaque(true);  
        labelCodigoLivro.setBackground(Color.WHITE);  
        labelCodigoLivro.setBorder(BorderFactory.createTitledBorder("Codigo do Livro")); 

        //quantidade de livros
        labelDataDeDevolucao = new JLabel("Data de Devolução");
        labelDataDeDevolucao.setPreferredSize(new Dimension(150, 50));
        
        labelDataDeDevolucao.setOpaque(true);  
        labelDataDeDevolucao.setBackground(Color.WHITE);  
        labelDataDeDevolucao.setBorder(BorderFactory.createTitledBorder("Data de Devolução")); 

        //Multa
        labelMultaDoEmprestimo = new JLabel("Multa total");
        labelMultaDoEmprestimo.setPreferredSize(new Dimension(100, 50));
        
        labelMultaDoEmprestimo.setOpaque(true);  
        labelMultaDoEmprestimo.setBackground(Color.WHITE);  
        labelMultaDoEmprestimo.setBorder(BorderFactory.createTitledBorder("Multa total"));
        
        //Semestre/qnt de materias
        labelDataDeDoCadastro = new JLabel("Data de Cadastro");
        labelDataDeDoCadastro.setPreferredSize(new Dimension(150, 50));
        
        labelDataDeDoCadastro.setOpaque(true);  
        labelDataDeDoCadastro.setBackground(Color.WHITE);  
        labelDataDeDoCadastro.setBorder(BorderFactory.createTitledBorder("Data de Cadastro"));

        //criandeo a imagem
        ImageIcon icone = new ImageIcon("../assets/imagens/livroEmprestimo.png");

        // Obtém a imagem e redimensiona
        Image imagem = icone.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon iconeRedimensionado = new ImageIcon(imagemRedimensionada);
        // Ajusta a posição do texto em relação ao ícone 
        JLabel labelIcone = new JLabel("Emprestimo", iconeRedimensionado, JLabel.CENTER);
        labelIcone.setHorizontalTextPosition(JLabel.CENTER); // Texto à direita do ícone
        labelIcone.setVerticalTextPosition(JLabel.TOP);   // Texto centralizado verticalmente
        labelIcone.setFont(new Font("Arial", Font.PLAIN, 32));




        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campo de nome: ocupa a primeira linha, 3 colunas
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 3;
        informacoes.add(labelIcone, gbc);
        
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        informacoes.add(labelNome, gbc);
        // Reset gridwidth para 1 para os demais componentes
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        informacoes.add(labelMatriculaDoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        informacoes.add(labelNomeDoUsuario, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        informacoes.add(labelCodigoLivro, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        informacoes.add(tipoDeUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        informacoes.add(labelDataDeDoCadastro, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        informacoes.add(labelDataDeDevolucao, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        informacoes.add(labelMultaDoEmprestimo, gbc);
        setEmprestimo(emprestimoGeral);
        return informacoes;
    }

    public void setEmprestimo(Emprestimo emprestimo){
        this.emprestimoGeral = emprestimo;
        labelNome.setText(emprestimoGeral.getLivro().getNome());

        //matricula
        labelNomeDoUsuario.setText(emprestimoGeral.getUsuario().getNome());

        //titulo
        String tipo;  
        if(emprestimoGeral.getUsuario() instanceof Aluno){
            tipo = "Aluno";
        }
        else{
            tipo = "Professor";
        }
        tipoDeUsuario.setText(tipo);
        
        //tipo de usuario
        labelMatriculaDoUsuario.setText(Integer.toString(emprestimoGeral.getUsuario().getMatricula()));
        
        labelCodigoLivro.setText(emprestimo.getLivro().getCodigo());

        labelDataDeDevolucao.setText(emprestimoGeral.getDataDevolucao().toString());

        //Multa
        emprestimoGeral.atualizarMultaTotal();
        labelMultaDoEmprestimo.setText(Double.toString(emprestimoGeral.getMultaTotal()));
        
        //Semestre/qnt de materias
        labelDataDeDoCadastro.setText(emprestimoGeral.getDataAquisicao().toString());

    }

}
