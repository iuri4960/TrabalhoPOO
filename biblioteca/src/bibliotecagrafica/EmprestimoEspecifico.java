package bibliotecagrafica;
import javax.swing.*;

import usuario.Emprestimo;

import java.awt.*;

public class EmprestimoEspecifico extends JPanel {

    SistemaBibliotecario sistema;
    Emprestimo emprestimoGeral;
    PainelSwitcher switcher;
    JPanel informacoes;

    JButton remover;
    JButton voltar;
    JButton botaoPagarMulta;
    //construtor que dividira o painel em cabeçalho, botões e o painel que será trocavel
    EmprestimoEspecifico(SistemaBibliotecario sistema, Emprestimo emprestimoGeral, PainelSwitcher switcher){
        this.sistema = sistema;
        this.emprestimoGeral = emprestimoGeral;
        this.switcher = switcher;

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
        informacoes = new InformacoesEmprestimoPainel(sistema, emprestimoGeral);
        return informacoes;
    }
    //botões
    public JPanel criarPainelBotoes(){
        JPanel butoes = new JPanel();
        butoes.setBackground(Color.BLUE);
        butoes.setLayout(new FlowLayout());

       
        botaoPagarMulta = new JButton("PAGAR MULTA");
        botaoPagarMulta.setBackground(Color.GREEN);
    
        //quando clicar no boão de Alterar informações acionara
        botaoPagarMulta.addActionListener(e -> {
            if(emprestimoGeral.getMultaTotal() == 0){
                JOptionPane.showMessageDialog(this, "Emprestimo Sem multa", 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            else{
                emprestimoGeral.pagarMultaTotal();
                JOptionPane.showMessageDialog(this, "Multa paga com sucesso", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //botão de remover
        remover = new JButton("DEVOLVER LIVRO");
        remover.setBackground(Color.GREEN);

        remover.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(
                null,                    
                "Deseja devolver o emprestimo?",      
                "Confirmação",          
                JOptionPane.YES_NO_OPTION 
            );

            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    sistema.removerEmprestimo(emprestimoGeral.getLivro());
                    emprestimoGeral = null;
                    switcher.switchTo("consulta");
                    switcher.reset();
                    JOptionPane.showMessageDialog(this, "Emprestimo devolvido com sucesso", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } 
            
        });

        voltar = new JButton("VOLTAR");
        voltar.setBackground(Color.GREEN);
        voltar.addActionListener(e -> {
            switcher.switchTo("consulta");
            switcher.reset();
        });



        butoes.add(botaoPagarMulta);
        butoes.add(remover);
        butoes.add(voltar);
        return butoes;

    }
    public void setEmprestimo(Emprestimo emprestimo){
        this.emprestimoGeral = emprestimo;
        ((InformacoesEmprestimoPainel)informacoes).setEmprestimo(emprestimo);
    }
}