package biblioteca;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;

public class ConsultarAlunoPanel extends JPanel{

    JButton BotaoDeConsulta = new JButton("consultar"); //botão que trocara o painel quando um usuario for selecionado

    JTextField pesquisa = new JTextField();//barra de pesquisa
    JButton botaoPesquisar = new JButton("Pesquisar");//botao de pesquisar
    //a ser trocado
    String[] alunosMestra = {"João da Silva\n\n", "Maria Oliveira\n\n", "Joãozinho Pereira\n\n", "Ana Souza"}; //exemplo de pesquisa
    String[] opcoes = {"pesquisa1", "pesquisa2"}; //tipo de pesquisa

    JComboBox<String> pesquisarPor = new JComboBox<>(opcoes);
    //configurando a pesquisa
    DefaultListModel<String> modelo = new DefaultListModel<>();
    JList<String> listaAlunos = new JList<>(modelo);

    private CardLayout cardLayout;
    private JPanel cardPanel;


    ConsultarAlunoPanel(){
        this.setLayout(new BorderLayout());

        //painel de troca entre pesquisa e informações de aluno
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel consultaPanel = new JPanel();
        consultaPanel.setLayout(new BorderLayout());
        JPanel informacoesPanel = new UsuarioEspecifico();

        cardPanel.add(consultaPanel, "consulta");
        cardPanel.add(informacoesPanel, "informacoes");

        consultaPanel.add(criarPainelCabecalho(), BorderLayout.NORTH);
        consultaPanel.add(criarPainelConsulta(), BorderLayout.CENTER); 
      
        this.add(cardPanel);;
        
        //ação para quando o boão de pesquisa for selecionado
        botaoPesquisar.addActionListener(e -> {
            String termoPesquisa = pesquisa.getText().toLowerCase();
            modelo.clear();
            for (String aluno : alunosMestra) {  // alunosMestra é sua lista mestra de alunos
                if (aluno.toLowerCase().contains(termoPesquisa)) {
                    modelo.addElement(aluno);
                }
            }
        });

        //ação para o botão de consulta
        BotaoDeConsulta.addActionListener(e -> {
            // Recupera o valor selecionado na lista
            String alunoSelecionado = listaAlunos.getSelectedValue();
            
            if (alunoSelecionado != null) {
                
                // Troca para o painel de informações usando o CardLayout
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
       
}
