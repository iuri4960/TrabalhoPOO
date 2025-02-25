package bibliotecagrafica;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import exception.UsuarioJaAdicionadoException;
import usuario.Aluno;
import usuario.Professor;
import usuario.Titulo;

public class CadastrarAlunoPanel extends JPanel {
	SistemaBibliotecario sistema; 
    //construindo o painel com um cabeçalho e um registro, que seraõ organizados por BorderLAyot
    CadastrarAlunoPanel(SistemaBibliotecario sistema){
        this.sistema = sistema;
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelRegistro(), BorderLayout.CENTER);
    }

    //Criando cabeçalho
    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("CADASTRAR ALUNO", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setBackground(Color.GRAY);
        cabecalho.add(label);
        return cabecalho;
    }

    //painel onde o usuario vai registrar
    private JPanel criarPainelRegistro() {
        JPanel cadastro = new JPanel();
        cadastro.setLayout(new GridBagLayout());
    
        //caixa de nome
        JTextField caixaNome = new JTextField();
        caixaNome.setColumns(40);
        caixaNome.setBorder(BorderFactory.createTitledBorder("Digite o nome do usuário"));

        //criando uma restrição para só digitar numeros em matricula, idade, e semestre/materias
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(integerFormat);
        numberFormatter.setValueClass(Integer.class);       // Define que o valor será um Integer
        numberFormatter.setAllowsInvalid(false);              // Impede entrada inválida (não permite caracteres não numéricos)
        numberFormatter.setMinimum(0);
        
        //caixa de idade
        JFormattedTextField idade = new JFormattedTextField(numberFormatter);
        idade.setColumns(15); 
        idade.setBorder(BorderFactory.createTitledBorder("Digite a idade do usuário"));

        //caixa de semestre/materias
        JFormattedTextField especifico = new JFormattedTextField(numberFormatter);
        especifico.setColumns(10); 
        
        numberFormatter.setMaximum(999999);
        //matricula
        JFormattedTextField matriculaField = new JFormattedTextField(numberFormatter);
        matriculaField.setColumns(15); 
        matriculaField.setBorder(BorderFactory.createTitledBorder("Digite a matricula do usuário"));

        //caixa de titulo, somente escolhas possiveis
        JComboBox<Titulo> selecaoDeTitulo = new JComboBox<>(Titulo.values());
        selecaoDeTitulo.setBorder(BorderFactory.createTitledBorder("Escolha o titulo"));

        //caixa de tipo, somente escolhas possiveis
        String[] opcoesTipo = {"Professor", "Aluno"};
        JComboBox<String> selecaoDeTipo = new JComboBox<>(opcoesTipo);
        selecaoDeTipo.setBorder(BorderFactory.createTitledBorder("o usuário é"));

        //boão para cadastrar
        JButton botaoDeCadastro = new JButton("Cadastrar");
        botaoDeCadastro.setBackground(Color.GREEN);
        botaoDeCadastro.addActionListener(e ->{
            if(null == this.obterTexto(caixaNome) || null == this.obterTexto(matriculaField) || null == this.obterTexto(idade) || null == this.obterTexto(especifico) ){
                JOptionPane.showMessageDialog(this, "Por favor, Digite as informações do usuario.", 
                "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            else if(selecaoDeTipo.getSelectedItem() == "Aluno"){
                try{
                    Titulo titulo = (Titulo) selecaoDeTitulo.getSelectedItem();
                    Integer matricula = (Integer) matriculaField.getValue();
                    Integer idadeNumero = (Integer) idade.getValue();
                    Integer semestre = (Integer) especifico.getValue();

                    Aluno aluno = new Aluno(this.obterTexto(caixaNome), matricula, idadeNumero, titulo, semestre);
                    sistema.adicionarUsuario(aluno);
                    JOptionPane.showMessageDialog(this, "Aluno Adicionado Com Sucesso", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);   
                    sistema.setTemAlteracao(true);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                try{
                    Titulo titulo = (Titulo) selecaoDeTitulo.getSelectedItem();
                    Integer matricula = (Integer) matriculaField.getValue();
                    Integer idadeNumero = (Integer) idade.getValue();
                    Integer semestre = (Integer) especifico.getValue();

                    Professor professor = new Professor(this.obterTexto(caixaNome), matricula, idadeNumero, titulo, semestre);
                    sistema.adicionarUsuario(professor);
                    JOptionPane.showMessageDialog(this, "Professor Adicionado Com Sucesso", 
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    sistema.setTemAlteracao(true);
                }
                catch(UsuarioJaAdicionadoException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        //organizando o layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campo de nome: ocupa a primeira linha, 3 colunas
        gbc.gridx = 0; //posição x
        gbc.gridy = 0; //posição y
        gbc.gridwidth = 3; //intervalo de colunas
        cadastro.add(caixaNome, gbc);
        
        // Reset gridwidth para 1 para os demais componentes
        gbc.gridwidth = 1;
        
        // Linha 2, coluna 1: idade
        gbc.gridx = 0;
        gbc.gridy = 1;
        cadastro.add(matriculaField, gbc);
        
        // Linha 2, coluna 2: matriculaField
        gbc.gridx = 1;
        cadastro.add(selecaoDeTipo, gbc);
        
        // Linha 2, coluna 3: selecaoDeTipo
        gbc.gridx = 2;
        cadastro.add(especifico, gbc);
        
        // Linha 3, coluna 1: selecaoDeTitulo
        gbc.gridx = 0;
        gbc.gridy = 2;
        cadastro.add(idade, gbc);
        
        // Linha 3, coluna 2: botaoDeCadastro
        gbc.gridx = 2;
        cadastro.add(botaoDeCadastro, gbc);
        
        // Linha 3, coluna 3: pode deixar vazia ou adicionar outro componente
        gbc.gridx = 1;
        cadastro.add(selecaoDeTitulo, gbc);
        return cadastro;
    }

    public String obterTexto(JTextField texto){
        String digitado = texto.getText().trim();
        if(digitado.isEmpty()){
            return null;
        }
        else{
            return digitado;
        }
    }

}
