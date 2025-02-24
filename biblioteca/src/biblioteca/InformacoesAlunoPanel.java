package biblioteca;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;
public class InformacoesAlunoPanel extends JPanel {
    //construtor separará o painel em cabeçalho e painel de informações
    InformacoesAlunoPanel(){
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelInformacoes(), BorderLayout.CENTER);
    }

    //painel de cabeçalho
    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.gray);
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("INFORMAÇÕES DO ALUNO", JLabel.CENTER);
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
        JLabel labelNome = new JLabel("Nome do Usuário");
        labelNome.setPreferredSize(new Dimension(300, 50));

        //definindo uma bornda para o nome
        labelNome.setOpaque(true);  // Permite que o fundo seja desenhado
        labelNome.setBackground(Color.WHITE);  // Define a cor de fundo desejada
        labelNome.setBorder(BorderFactory.createTitledBorder("Nome do usuário"));  // Adiciona uma borda preta
  
        //matricula
        JLabel labelMatricula = new JLabel("Matricula do Usuário");
        labelMatricula.setPreferredSize(new Dimension(150, 50));
        
        labelMatricula.setOpaque(true);  
        labelMatricula.setBackground(Color.WHITE);  
        labelMatricula.setBorder(BorderFactory.createTitledBorder("Matricula do usuário"));  

        //titulo
        JLabel labelTitulo = new JLabel("Titulo do Usuário");
        labelTitulo.setPreferredSize(new Dimension(150, 50));
        
        labelTitulo.setOpaque(true);  
        labelTitulo.setBackground(Color.WHITE);  
        labelTitulo.setBorder(BorderFactory.createTitledBorder("Titulo do usuário")); 
        
        //tipo de usuario
        JLabel labelTipo = new JLabel("Tipo de Usuário");
        labelTipo.setPreferredSize(new Dimension(150, 50));
        
        labelTipo.setOpaque(true);  
        labelTipo.setBackground(Color.WHITE);  
        labelTipo.setBorder(BorderFactory.createTitledBorder("Tipo de usuário")); 

        //idade
        JLabel labelIdade = new JLabel("idade do usuario");
        labelIdade.setPreferredSize(new Dimension(150, 50));
        
        labelIdade.setOpaque(true);  
        labelIdade.setBackground(Color.WHITE);  
        labelIdade.setBorder(BorderFactory.createTitledBorder("idade do usuario")); 

        //quantidade de livros
        JLabel labelQuantidadeLivros = new JLabel("livros emprestaddos");
        labelQuantidadeLivros.setPreferredSize(new Dimension(150, 50));
        
        labelQuantidadeLivros.setOpaque(true);  
        labelQuantidadeLivros.setBackground(Color.WHITE);  
        labelQuantidadeLivros.setBorder(BorderFactory.createTitledBorder("livros emprestaddos")); 

        //Multa
        JLabel labelMultaDoUsuario = new JLabel("Multa total");
        labelMultaDoUsuario.setPreferredSize(new Dimension(100, 50));
        
        labelMultaDoUsuario.setOpaque(true);  
        labelMultaDoUsuario.setBackground(Color.WHITE);  
        labelMultaDoUsuario.setBorder(BorderFactory.createTitledBorder("Multa total"));
        
        //Semestre/qnt de materias
        JLabel labelSemestre = new JLabel("Semestre do usuario");
        labelSemestre.setPreferredSize(new Dimension(150, 50));
        
        labelSemestre.setOpaque(true);  
        labelSemestre.setBackground(Color.WHITE);  
        labelSemestre.setBorder(BorderFactory.createTitledBorder("Semestre do usuario"));

        //criandeo a imagem
        ImageIcon icone = new ImageIcon("./assets/imagens/IconeUsuario.png");

        // Obtém a imagem e redimensiona
        Image imagem = icone.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon iconeRedimensionado = new ImageIcon(imagemRedimensionada);
        // Ajusta a posição do texto em relação ao ícone 
        JLabel labelIcone = new JLabel("Usuario", iconeRedimensionado, JLabel.CENTER);
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
        informacoes.add(labelTipo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        informacoes.add(labelMatricula, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        informacoes.add(labelIdade, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        informacoes.add(labelTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        informacoes.add(labelSemestre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        informacoes.add(labelQuantidadeLivros, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        informacoes.add(labelMultaDoUsuario, gbc);
        return informacoes;
    }
}
