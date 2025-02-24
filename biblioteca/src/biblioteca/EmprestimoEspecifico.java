package biblioteca;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;


public class EmprestimoEspecifico extends JPanel {



    //construtor que dividira o painel em cabeçalho, botões e o painel que será trocavel
    EmprestimoEspecifico(){
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelInformacoes(), BorderLayout.CENTER);
        add(criarPainelBotoes(), BorderLayout.SOUTH);
    }
    //cabeçalho
    public JPanel criarPainelCabecalho(){
        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.MAGENTA);
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("GERENCIADOR DE EMPRESTIMOS", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        cabecalho.add(label);
        return cabecalho;
    }
    //painel que trocará entre informações e Alterar informações
    public JPanel criarPainelInformacoes(){
        JPanel informacoes = new InformacoesEmprestimoPainel();
        return informacoes;
    }
    //botões
    public JPanel criarPainelBotoes(){
        JPanel butoes = new JPanel();
        butoes.setBackground(Color.BLUE);
        butoes.setLayout(new FlowLayout());

       
        JButton botaoPagarMulta = new JButton("PAGAR MULTA");
        botaoPagarMulta.setBackground(Color.GREEN);
    
        //quando clicar no boão de Alterar informações acionara
        botaoPagarMulta.addActionListener(e -> {

        });

        //botão de remover
        JButton remover = new JButton("DEVOLVER LIVRO");
        remover.setBackground(Color.GREEN);

        botaoPagarMulta.addActionListener(e -> {
            
        });

        butoes.add(botaoPagarMulta);
        butoes.add(remover);
        return butoes;

    }
}