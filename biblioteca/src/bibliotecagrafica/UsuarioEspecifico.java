package bibliotecagrafica;
import javax.swing.*;

import usuario.Usuario;

import java.awt.*;


public class UsuarioEspecifico extends JPanel implements PainelTrocarUsuario{

    //painel que sera usado para trocar ente o painel de informações e o de alterar informações
    JPanel painelDeTroca = new JPanel();
    Usuario usuarioSelecionadoGeral;
    SistemaBibliotecario sistema;
    JPanel informacoes;
    JPanel alterarInformacoes;
    JButton remover;
    JButton voltar;
    JButton botaoInformacoes;

    private PainelSwitcher switcher;

    //construtor que dividira o painel em cabeçalho, botões e o painel que será trocavel
    UsuarioEspecifico(Usuario usuarioSelecionadoGeral, SistemaBibliotecario sistema1, PainelSwitcher switcher){
        sistema = sistema1;
        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral;
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
        JLabel label = new JLabel("GERENCIADOR DE ALUNOS", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        cabecalho.add(label);
        return cabecalho;
    }
    //painel que trocará entre informações e Alterar informações
    public JPanel criarPainelInformacoes(){
   
            painelDeTroca.setLayout(new CardLayout());//troca feita por cardLayout

            informacoes = new InformacoesAlunoPanel(usuarioSelecionadoGeral, sistema);
            alterarInformacoes = new AlterarInformacoesUsuarioPainel(usuarioSelecionadoGeral, sistema, this);
            painelDeTroca.add(informacoes, "Informações");
            painelDeTroca.add(alterarInformacoes, "Alterar informações do usuario");
            return painelDeTroca;
        
    }
    //botões
    public JPanel criarPainelBotoes(){
        JPanel butoes = new JPanel();
        butoes.setBackground(Color.BLUE);
        butoes.setLayout(new FlowLayout());

       
        botaoInformacoes = new JButton("INFORMAÇÕES");
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
        remover = new JButton("REMOVER");
        remover.setBackground(Color.GREEN);
        remover.addActionListener(e ->{
            int opcao = JOptionPane.showConfirmDialog(
                null,                    
                "Deseja remover o usuario?",      
                "Confirmação",          
                JOptionPane.YES_NO_OPTION 
            );

            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    sistema.removerUsuario(usuarioSelecionadoGeral.getMatricula());
                    usuarioSelecionadoGeral = null;
                    switcher.switchTo("consulta");
                    switcher.reset();
                    JOptionPane.showMessageDialog(this, "Aluno Removido Com Sucesso", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    
                    sistema.setTemAlteracao(true); //FLAG (Salvar)
                    
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

        
        butoes.add(botaoInformacoes);
        butoes.add(botaoAlterarInformacoes);
        butoes.add(remover);
        butoes.add(voltar);
        
        return butoes;

    }

    public void setUsuario(Usuario usuarioSelecionadoGeral){
        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral;
        ((AlterarInformacoesUsuarioPainel)alterarInformacoes).setUsuario(usuarioSelecionadoGeral);
        ((InformacoesAlunoPanel)informacoes).setUsuario(usuarioSelecionadoGeral);
    }
    @Override
    public void switchUsuario(Usuario usuario) {
        this.usuarioSelecionadoGeral = usuario;
        ((InformacoesAlunoPanel)informacoes).setUsuario(usuario);
        ((AlterarInformacoesUsuarioPainel)alterarInformacoes).setUsuario(usuario);
    }
    @Override
    public void reset() {
        botaoInformacoes.doClick();
    }
    
}
