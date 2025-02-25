package bibliotecagrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import usuario.Aluno;
import usuario.Titulo;
import usuario.Usuario;

public class ConsultarAlunoPanel extends JPanel implements PainelSwitcher {
	SistemaBibliotecario sistema;
    JButton BotaoDeConsulta = new JButton("consultar"); //botão que trocara o painel quando um usuario for selecionado
    Usuario usuarioSelecionadoGeral;

    JTextField pesquisa = new JTextField();//barra de pesquisa
    JButton botaoPesquisar = new JButton("Pesquisar");//botao de pesquisar
    //a ser trocado
    
    ArrayList<Usuario> listaUsuario = new ArrayList<>(); //exemplo de pesquisa
    String[] opcoes = {"por nome", "por matricula"}; //tipo de pesquisa
    int opcoesVar;

    JComboBox<String> pesquisarPor = new JComboBox<>(opcoes);
    //configurando a pesquisa
    DefaultListModel<Usuario> modelo = new DefaultListModel<>();
    JList<Usuario> listaAlunos = new JList<>(modelo);

    private CardLayout cardLayout;
    private JPanel cardPanel;
    JPanel informacoesPanel;

    ConsultarAlunoPanel(SistemaBibliotecario sistema1){
        usuarioSelecionadoGeral = new Aluno("", 0, 0, Titulo.GRADUANDO, 0);
        this.sistema = sistema1;
        this.setLayout(new BorderLayout());
        listaUsuario = sistema.getListaUsuarios();


        //painel de troca entre pesquisa e informações de aluno
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel consultaPanel = new JPanel();
        consultaPanel.setLayout(new BorderLayout());
        informacoesPanel = new UsuarioEspecifico(usuarioSelecionadoGeral, sistema, this);

        cardPanel.add(consultaPanel, "consulta");
        cardPanel.add(informacoesPanel, "informacoes");

        consultaPanel.add(criarPainelCabecalho(), BorderLayout.NORTH);
        consultaPanel.add(criarPainelConsulta(), BorderLayout.CENTER); 
      
        this.add(cardPanel);;
        
        //ação para quando o boão de pesquisa for selecionado
        botaoPesquisar.addActionListener(e -> {
            String termoPesquisa = pesquisa.getText().toLowerCase();
            modelo.clear();
            if(pesquisarPor.getSelectedItem() == "por nome"){
                for (Usuario usuario : listaUsuario) {  // nome
                    if (usuario.getNome().toLowerCase().contains(termoPesquisa)) {
                        modelo.addElement(usuario);
                    }
                }
            }
            else{
                for (Usuario aluno : listaUsuario) {  // matricula
                    String matriculaString = Integer.toString(aluno.getMatricula());
                    if (matriculaString.contains(termoPesquisa)) {
                        modelo.addElement(aluno);
                    }
                }
            } 
        });

        //ação para o botão de consulta
        BotaoDeConsulta.addActionListener(e -> {
            // Recupera o valor selecionado na lista
            Usuario usuarioSelecionado = listaAlunos.getSelectedValue();
            usuarioSelecionadoGeral = usuarioSelecionado;
            
            if (usuarioSelecionado != null) {
                
                // Troca para o painel de informações usando o CardLayout
                ((UsuarioEspecifico)informacoesPanel).setUsuario(usuarioSelecionadoGeral);
                cardLayout.show(cardPanel, "informacoes");
            } 
            else {
                // Se nenhum aluno estiver selecionado, exibe uma mensagem de aviso.
                JOptionPane.showMessageDialog(this, "Por favor, selecione um aluno para consultar.", 
                                              "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
        
    //painel de pesquisa
    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel(new BorderLayout());
        cabecalho.setLayout(new BorderLayout());

        //cabeçalho
        JLabel labelCabecalho = new JLabel("CONSULTAR ALUNO", JLabel.CENTER);
        labelCabecalho.setFont(new Font("Arial", Font.BOLD, 40));
        labelCabecalho.setBackground(Color.MAGENTA);
        
        //escolha a pesquisa
        pesquisarPor.setBorder(BorderFactory.createTitledBorder("Tipo de pesquisa"));
        pesquisarPor.setPreferredSize(new Dimension(200,10));

        //barra de pesquisa
        pesquisa.setBorder(BorderFactory.createTitledBorder("Barra de pesquisa"));

        botaoPesquisar.setBackground(Color.green);
        botaoPesquisar.setBorder(BorderFactory.createTitledBorder(""));
        botaoPesquisar.setPreferredSize(new Dimension(100,10));

        //adicionando
        cabecalho.add(labelCabecalho, BorderLayout.NORTH);
        cabecalho.add(pesquisarPor, BorderLayout.WEST);
        cabecalho.add(pesquisa, BorderLayout.CENTER);
        cabecalho.add(botaoPesquisar, BorderLayout.EAST);

        return cabecalho;
    }

    //painel que vai aparecer os usuarios
    private JPanel criarPainelConsulta() {
        JPanel consulta = new JPanel();
        consulta.setLayout(new FlowLayout());

        
        JScrollPane scrollPane = new JScrollPane(listaAlunos);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        consulta.add(scrollPane);
        consulta.add(BotaoDeConsulta);
        return consulta;
    }

    public void switchTo(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    @Override
    public void reset() {
        botaoPesquisar.doClick();
    }

}
