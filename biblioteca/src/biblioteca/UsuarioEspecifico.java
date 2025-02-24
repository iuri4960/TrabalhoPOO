package biblioteca;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;


public class UsuarioEspecifico extends JPanel {

    //painel que sera usado para trocar ente o painel de informações e o de alterar informações
    JPanel painelDeTroca = new JPanel();

    //construtor que dividira o painel em cabeçalho, botões e o painel que será trocavel
    UsuarioEspecifico(){
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
        JLabel label = new JLabel("GERENCIADOR DE ALUNOS", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        cabecalho.add(label);
        return cabecalho;
    }
    //painel que trocará entre informações e Alterar informações
    public JPanel criarPainelInformacoes(){
   
            painelDeTroca.setLayout(new CardLayout());//troca feita por cardLayout

            JPanel informacoes = new InformacoesAlunoPanel();
            JPanel alterarInformacoes = new AlterarInformacoesUsuarioPainel();
            painelDeTroca.add(informacoes, "Informações");
            painelDeTroca.add(alterarInformacoes, "Alterar informações do usuario");
            return painelDeTroca;
        
    }
    //botões
    public JPanel criarPainelBotoes(){
        JPanel butoes = new JPanel();
        butoes.setBackground(Color.BLUE);
        butoes.setLayout(new FlowLayout());

       
        JButton botaoInformacoes = new JButton("INFORMAÇÕES");
        botaoInformacoes.setBackground(Color.CYAN);
        JButton botaoAlterarInformacoes = new JButton("ALTERAR INFORMAÇÕES");
        botaoAlterarInformacoes.setBackground(Color.GREEN);

        //quando clicar no boão de informações acionara
        botaoInformacoes.addActionListener(e -> {
            CardLayout cl = (CardLayout) painelDeTroca.getLayout();
            cl.show(painelDeTroca, "Informações");  // Exibe o card "Informações"
            botaoInformacoes.setBackground(Color.CYAN);
            botaoAlterarInformacoes.setBackground(Color.GREEN);
        });
    
        
        //quando clicar no boão de Alterar informações acionara
        botaoAlterarInformacoes.addActionListener(e -> {
            CardLayout cl = (CardLayout) painelDeTroca.getLayout();
            cl.show(painelDeTroca, "Alterar informações do usuario");
            botaoInformacoes.setBackground(Color.GREEN);
            botaoAlterarInformacoes.setBackground(Color.CYAN);
        });

        //botão de remover
        JButton remover = new JButton("REMOVER");
        remover.setBackground(Color.GREEN);

        butoes.add(botaoInformacoes);
        butoes.add(botaoAlterarInformacoes);
        butoes.add(remover);
        return butoes;

    }
}
