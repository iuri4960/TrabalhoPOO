package biblioteca;

import javax.swing.*;


public class main {
    public static void main(String[] args) {

        //codigo para testar cada painel
        SistemaBibliotecario sistema = new SistemaBibliotecario();
            JFrame tabela = new JFrame("Meu primeiro frame!");
            tabela.setSize(600, 600); 
            
            tabela.setLocationRelativeTo(null);
            tabela.setTitle("nome");
            JPanel painel = new CadastrarAlunoPainel(sistema);
            tabela.getContentPane().add(painel);

            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela.setVisible(true);
            tabela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFrame tabela2 = new JFrame("Meu segundo frame!");
            tabela2.setSize(600, 600); 
            
            tabela2.setTitle("nome");
            JPanel painel2 = new ConsultarAlunoPanel();
            tabela2.getContentPane().add(painel2);
            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela2.setVisible(true);
            tabela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            

        }
}
