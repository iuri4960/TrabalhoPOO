package bibliotecagrafica;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import usuario.Emprestimo;
import usuario.Livro;
import usuario.Usuario;

import java.text.*;
import java.time.LocalDate;
import java.awt.*;
public class CadastrarEmprestimoPanel extends JPanel {

    SistemaBibliotecario sistema;
    JLabel descriçãoUsuario;
    JLabel descriçãoLivro;
    JFormattedTextField matriculaField;
    JTextField caixaLivro;
    JButton botaoDeCadastro;
    JButton botaoDeProcurarUsuario;
    JButton botaoDeProcurarLivro;
    Usuario usuarioEscolhido;
    Livro livroEscolhido;
    GerenciadorDataPainel dataCadastro;


    CadastrarEmprestimoPanel(SistemaBibliotecario sistema){
        this.sistema = sistema;
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelRegistro(), BorderLayout.CENTER);
    }

    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("CADASTRAR EMPRESTIMO", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setBackground(Color.GRAY);
        cabecalho.add(label);
        return cabecalho;
    }

    private JPanel criarPainelRegistro() {
        JPanel cadastro = new JPanel();
        cadastro.setLayout(new GridBagLayout());


        descriçãoUsuario = new JLabel("Descrição do usuario");
        descriçãoUsuario.setPreferredSize(new Dimension(300, 200));

        //definindo uma bornda para o nome
        descriçãoUsuario.setOpaque(true);  // Permite que o fundo seja desenhado
        descriçãoUsuario.setBackground(Color.WHITE);  // Define a cor de fundo desejada
        
        descriçãoUsuario.setBorder(BorderFactory.createTitledBorder("Descrição do usuário")); 

        descriçãoLivro = new JLabel("Descrição do livro");
        descriçãoLivro.setPreferredSize(new Dimension(300, 200));

        //definindo uma bornda para o nome
        descriçãoLivro.setOpaque(true);  // Permite que o fundo seja desenhado
        descriçãoLivro.setBackground(Color.WHITE);  // Define a cor de fundo desejada
        descriçãoLivro.setBorder(BorderFactory.createTitledBorder("Descrição do livro"));

        caixaLivro = new JTextField();
        caixaLivro.setColumns(40);
        caixaLivro.setBorder(BorderFactory.createTitledBorder("Digite o codigo do livro"));

        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(integerFormat);
        numberFormatter.setValueClass(Integer.class);       // Define que o valor será um Integer
        numberFormatter.setAllowsInvalid(false);              // Impede entrada inválida (não permite caracteres não numéricos)
        numberFormatter.setMinimum(0);
        
        numberFormatter.setMaximum(999999);

        matriculaField = new JFormattedTextField(numberFormatter);
        matriculaField.setColumns(40); 
        matriculaField.setBorder(BorderFactory.createTitledBorder("Digite a matricula do usuário"));

        dataCadastro = new GerenciadorDataPainel();

        botaoDeCadastro = new JButton("Cadastrar");
        botaoDeCadastro.setBackground(Color.GREEN);
        botaoDeCadastro.addActionListener(e ->{

            if(usuarioEscolhido == null || livroEscolhido == null){
                JOptionPane.showMessageDialog(this,"por favor, escolha um usuario e um livro", 
                "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            else{
                try {    
                    String dataString = dataCadastro.toString();
                    LocalDate data = LocalDate.parse(dataString);
                    Emprestimo emprestimo = new Emprestimo(usuarioEscolhido, livroEscolhido, data);
                    sistema.adicionarEmprestimo(emprestimo);
                    
                    limparSelecao();
                    JOptionPane.showMessageDialog(this, "Emprestimo Efetuado", 
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });

        botaoDeProcurarLivro = new JButton("Procurar livro");
        botaoDeProcurarLivro.setBackground(Color.CYAN);
        botaoDeProcurarLivro.addActionListener(e ->{
            try {
                livroEscolhido = sistema.consultarLivro(caixaLivro.getText());
                descriçãoLivro.setText(livroEscolhido.Descricao());
                caixaLivro.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), 
                "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
        botaoDeProcurarUsuario = new JButton("Procurar usuario");
        botaoDeProcurarUsuario.setBackground(Color.CYAN);
        botaoDeProcurarUsuario.addActionListener(e ->{
            Integer matricula = (Integer) matriculaField.getValue();
            try {
                usuarioEscolhido = sistema.consultarUsuario(matricula);
                descriçãoUsuario.setText(usuarioEscolhido.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), 
                "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campo de nome: ocupa a primeira linha, 3 colunas
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        cadastro.add(matriculaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        cadastro.add(caixaLivro, gbc);

        // Reset gridwidth para 1 para os demais componentes
        gbc.gridwidth = 1;
        
        // Linha 2, coluna 1: idade
        gbc.gridx = 2;
        gbc.gridy = 0;
        cadastro.add(botaoDeProcurarUsuario, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        cadastro.add(botaoDeProcurarLivro, gbc);
        
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        // Linha 2, coluna 2: matriculaField
        gbc.gridx = 0;
        gbc.gridy = 1;
        cadastro.add(descriçãoUsuario, gbc);
        
        // Linha 2, coluna 3: selecaoDeTipo
        gbc.gridx = 0;
        gbc.gridy = 4;
        cadastro.add(descriçãoLivro, gbc);
        
         // Linha 3, coluna 1: selecaoDeTitulo
         gbc.gridwidth = 1;
         gbc.gridheight = 1;
 
         gbc.gridx = 0;
         gbc.gridy = 6;
         cadastro.add(dataCadastro, gbc);
 
         gbc.gridx = 2;
         gbc.gridy = 6;
         cadastro.add(botaoDeCadastro, gbc);
        
        return cadastro;
    }

    public void limparSelecao(){
        usuarioEscolhido = null;
        livroEscolhido = null;
        descriçãoLivro.setText("Descrição do livro");
        descriçãoUsuario.setText("Descrição do usuario");
        caixaLivro.setText("");
        matriculaField.setText("0");

    }

}


