package bibliotecagrafica;
import javax.swing.*;

import usuario.Aluno;
import usuario.Emprestimo;
import usuario.Professor;
import usuario.Usuario;

import java.awt.*;
import java.util.*;
public class InformacoesAlunoPanel extends JPanel {
    //construtor separará o painel em cabeçalho e painel de informações
    JLabel labelNome;
    JLabel labelMatricula;
    JLabel labelTitulo;
    JLabel labelTipo;
    JLabel labelSemestre;
    JLabel labelIdade;
    JLabel labelQuantidadeLivros;
    ArrayList<Emprestimo> livrosUsuario;
    double multaTotal;
    JLabel labelMultaDoUsuario;

    SistemaBibliotecario sistema;
    Usuario usuarioSelecionadoGeral;
    InformacoesAlunoPanel(Usuario usuarioSelecionadoGeral1, SistemaBibliotecario sistema1){
        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral1;
        this.sistema = sistema1;
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
        labelNome = new JLabel(usuarioSelecionadoGeral.getNome());
        labelNome.setPreferredSize(new Dimension(300, 50));

        //definindo uma bornda para o nome
        labelNome.setOpaque(true);  // Permite que o fundo seja desenhado
        labelNome.setBackground(Color.WHITE);  // Define a cor de fundo desejada
        labelNome.setBorder(BorderFactory.createTitledBorder("Nome do usuário"));  // Adiciona uma borda preta
  
        //matricula
         labelMatricula = new JLabel(Integer.toString(usuarioSelecionadoGeral.getMatricula()));
        labelMatricula.setPreferredSize(new Dimension(150, 50));
        
        labelMatricula.setOpaque(true);  
        labelMatricula.setBackground(Color.WHITE);  
        labelMatricula.setBorder(BorderFactory.createTitledBorder("Matricula do usuário"));  

        //titulo
        labelTitulo = new JLabel(usuarioSelecionadoGeral.getTitulo().getDescricao());
        labelTitulo.setPreferredSize(new Dimension(150, 50));
        
        labelTitulo.setOpaque(true);  
        labelTitulo.setBackground(Color.WHITE);  
        labelTitulo.setBorder(BorderFactory.createTitledBorder("Titulo do usuário")); 
        
        //diferença entre professor e usuario
        String tipo; 
        int especifico;       
        labelSemestre = new JLabel();
        if(usuarioSelecionadoGeral instanceof Aluno){
            tipo = "Aluno";
            especifico = ((Aluno)usuarioSelecionadoGeral).getSemestre(); 
            labelSemestre.setBorder(BorderFactory.createTitledBorder("Semestre do usuario"));
        }
        else{
            tipo = "Professor";
            especifico = ((Professor)usuarioSelecionadoGeral).getQtdMaterias();
            labelSemestre.setBorder(BorderFactory.createTitledBorder("quantidade de madterias"));
        }

        //tipo de usuario
        labelTipo = new JLabel(tipo);
        labelTipo.setPreferredSize(new Dimension(150, 50));
        
        labelTipo.setOpaque(true);  
        labelTipo.setBackground(Color.WHITE);  
        labelTipo.setBorder(BorderFactory.createTitledBorder("Tipo de usuário")); 

        //Semestre/qnt de materias
 
        labelSemestre.setText(Integer.toString(especifico));
        labelSemestre.setPreferredSize(new Dimension(150, 50));
        
        labelSemestre.setOpaque(true);  
        labelSemestre.setBackground(Color.WHITE);  
       

        //idade
        labelIdade = new JLabel(Integer.toString(usuarioSelecionadoGeral.getIdade()));
        labelIdade.setPreferredSize(new Dimension(150, 50));
        
        labelIdade.setOpaque(true);  
        labelIdade.setBackground(Color.WHITE);  
        labelIdade.setBorder(BorderFactory.createTitledBorder("idade do usuario")); 

        //quantidade de livros new JLabel(Integer.toString(sistema.consultarEmprestimo(usuarioSelecionadoGeral.getMatricula()).size()));
        livrosUsuario = new ArrayList<>();
        try {
            livrosUsuario = sistema.consultarEmprestimo(usuarioSelecionadoGeral.getMatricula());
        } catch (Exception e) {
            
        }
       labelQuantidadeLivros = new JLabel(Integer.toString((livrosUsuario).size()));

        labelQuantidadeLivros.setPreferredSize(new Dimension(150, 50));
        
        labelQuantidadeLivros.setOpaque(true);  
        labelQuantidadeLivros.setBackground(Color.WHITE);  
        labelQuantidadeLivros.setBorder(BorderFactory.createTitledBorder("livros emprestaddos")); 

        //Multa
        multaTotal = 0;
        for(Emprestimo emprestimo : livrosUsuario){
            emprestimo.atualizarMultaTotal();
            multaTotal = multaTotal + emprestimo.getMultaTotal();
            
        }
        labelMultaDoUsuario = new JLabel(Integer.toString((int)multaTotal));
        labelMultaDoUsuario.setPreferredSize(new Dimension(100, 50));
        
        labelMultaDoUsuario.setOpaque(true);  
        labelMultaDoUsuario.setBackground(Color.WHITE);  
        labelMultaDoUsuario.setBorder(BorderFactory.createTitledBorder("Multa total"));
        
        

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
    public void setUsuario(Usuario usuarioSelecionadoGeral){
        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral;
        labelNome.setText(usuarioSelecionadoGeral.getNome());
        //matricula
         labelMatricula.setText(Integer.toString(usuarioSelecionadoGeral.getMatricula()));  

        //titulo
        labelTitulo.setText(usuarioSelecionadoGeral.getTitulo().getDescricao());
        //diferença entre professor e usuario
        String tipo; 
        int especifico;  
        if(usuarioSelecionadoGeral instanceof Aluno){
            tipo = "Aluno";
            especifico = ((Aluno)usuarioSelecionadoGeral).getSemestre(); 
        }
        else{
            tipo = "Professor";
            especifico = ((Professor)usuarioSelecionadoGeral).getQtdMaterias();
        }

        //tipo de usuario
        labelTipo.setText(tipo);

        //Semestre/qnt de materias
 
        labelSemestre.setText(Integer.toString(especifico));  
       

        //idade
        labelIdade.setText(Integer.toString(usuarioSelecionadoGeral.getIdade()));
        //quantidade de livros new JLabel(Integer.toString(sistema.consultarEmprestimo(usuarioSelecionadoGeral.getMatricula()).size()));
        livrosUsuario = new ArrayList<>();
        try {
            livrosUsuario = sistema.consultarEmprestimo(usuarioSelecionadoGeral.getMatricula());
        } catch (Exception e) {
            
        }
       labelQuantidadeLivros.setText(Integer.toString((livrosUsuario).size())); 

        //Multa
        multaTotal = 0;
        for(Emprestimo emprestimo : livrosUsuario){
            emprestimo.atualizarMultaTotal();
            multaTotal = multaTotal + emprestimo.getMultaTotal();
            
        }
        labelMultaDoUsuario.setText(Integer.toString((int)multaTotal));
    }
    
}
