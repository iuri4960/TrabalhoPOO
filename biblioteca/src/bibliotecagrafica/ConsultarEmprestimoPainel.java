package bibliotecagrafica;
import javax.swing.*;

import usuario.Aluno;
import usuario.Emprestimo;
import usuario.Titulo;

import biblioteca.Livro;

import java.time.LocalDate;
import java.awt.*;
import java.util.*;

public class ConsultarEmprestimoPainel extends JPanel implements PainelSwitcher{

    SistemaBibliotecario sistema;
    Emprestimo emprestimoSelecionado;
    JButton BotaoDeConsulta = new JButton("consultar"); //botão que trocara o painel quando um usuario for selecionado

    JTextField pesquisa = new JTextField();//barra de pesquisa
    JButton botaoPesquisar = new JButton("Pesquisar");//botao de pesquisar
    //a ser trocado
    String[] opcoes = {"codigo do Livro", "Matricula do usuario"}; //tipo de pesquisa
    int opcao;

    ArrayList<Emprestimo> listaEmprestimosTotal = new ArrayList<>();
    JComboBox<String> pesquisarPor = new JComboBox<>(opcoes);
    //configurando a pesquisa
    DefaultListModel<Emprestimo> modelo = new DefaultListModel<>();
    JList<Emprestimo> listaEmprestimos = new JList<>(modelo);


    private CardLayout cardLayout;
    private JPanel cardPanel;


    ConsultarEmprestimoPainel(SistemaBibliotecario sistema){
        this.sistema = sistema;
        Aluno aluno = new Aluno("", 0, 0, Titulo.GRADUANDO, 0);
        Livro livro = new Livro("", "", "1", "", "1", "", "");
        emprestimoSelecionado = new Emprestimo(aluno, livro, LocalDate.now());
        this.setLayout(new BorderLayout());
        listaEmprestimosTotal = sistema.getListaEmprestimo();
        

        //painel de troca entre pesquisa e informações de aluno
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel consultaPanel = new JPanel();
        consultaPanel.setLayout(new BorderLayout());
        JPanel informacoesPanel = new EmprestimoEspecifico(sistema, emprestimoSelecionado, this);

        cardPanel.add(consultaPanel, "consulta");
        cardPanel.add(informacoesPanel, "informacoes");

        consultaPanel.add(criarPainelCabecalho(), BorderLayout.NORTH);
        consultaPanel.add(criarPainelConsulta(), BorderLayout.CENTER); 
      
        this.add(cardPanel);;
        
        //ação para quando o boão de pesquisa for selecionado
        botaoPesquisar.addActionListener(e -> {
            String termoPesquisa = pesquisa.getText().toLowerCase();
            modelo.clear();
            if("Matricula do usuario".equals(pesquisarPor.getSelectedItem())){
                for (Emprestimo emprestimo : listaEmprestimosTotal) {  // alunosMestra é sua lista mestra de alunos
                    if ((Integer.toString(emprestimo.getUsuario().getMatricula())).toLowerCase().contains(termoPesquisa)) {
                        modelo.addElement(emprestimo);
                    }
                }
            }
            else{
                for (Emprestimo emprestimo : listaEmprestimosTotal) {  // alunosMestra é sua lista mestra de alunos
                    if (emprestimo.getLivro().getCodigo().toLowerCase().contains(termoPesquisa)) {
                        modelo.addElement(emprestimo);
                    }
                }
            }
            
        });

        //ação para o botão de consulta
        BotaoDeConsulta.addActionListener(e -> {
            // Recupera o valor selecionado na lista
            Emprestimo emprestimoGeral = listaEmprestimos.getSelectedValue();
            emprestimoSelecionado = emprestimoGeral;
            
            if (emprestimoGeral != null) {
                
                ((EmprestimoEspecifico)informacoesPanel).setEmprestimo(emprestimoSelecionado);;
                cardLayout.show(cardPanel, "informacoes");
            } 
            else {
                // Se nenhum aluno estiver selecionado, exibe uma mensagem de aviso.
                JOptionPane.showMessageDialog(this, "Por favor, selecione um Emprestimo para consultar.", 
                                              "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
        
    //painel de pesquisa
    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel(new BorderLayout());
        cabecalho.setLayout(new BorderLayout());

        //cabeçalho
        JLabel labelCabecalho = new JLabel("CONSULTAR EMPRESTIMO", JLabel.CENTER);
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

        
        JScrollPane scrollPane = new JScrollPane(listaEmprestimos);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        consulta.add(scrollPane);
        consulta.add(BotaoDeConsulta);
        return consulta;
    }


    @Override
    public void switchTo(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    @Override
    public void reset() {
        botaoPesquisar.doClick();
    }
}
