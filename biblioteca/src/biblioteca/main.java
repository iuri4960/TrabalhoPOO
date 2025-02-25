package biblioteca;

import javax.swing.*;


public class main {
    public static void main(String[] args) {

        //codigo para testar cada painel
        SistemaBibliotecario sistema = new SistemaBibliotecario();
            Livro livro = new Livro("dom quixote", "123", 9999, "Dom roserante", 100, "Ficção", "anable", false);
            try {
                sistema.adicionarLivro(livro);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
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
            JPanel painel2 = new ConsultarAlunoPanel(sistema);
            tabela2.getContentPane().add(painel2);
            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela2.setVisible(true);
            tabela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFrame tabela3 = new JFrame("Meu segundo frame!");
            tabela2.setSize(600, 600); 
            
            tabela2.setTitle("nome");
            JPanel painel3 = new CadastrarEmprestimoPanel(sistema);
            tabela3.getContentPane().add(painel3);
            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela3.setVisible(true);
            tabela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tabela3.setSize(800,800);

            JFrame tabela4 = new JFrame("Meu segundo frame!");
            tabela4.setSize(600, 600); 
            
            tabela4.setTitle("nome");
            JPanel painel4 = new ConsultarEmprestimoPainel(sistema);
            tabela4.getContentPane().add(painel4);
            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela4.setVisible(true);
            tabela4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tabela4.setSize(800,800);
            System.out.println("aaaaaaaa");
            

        }
}
