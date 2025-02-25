package bibliotecagrafica;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.NumberFormatter;



public class CadastrarEmprestimoPanel extends JPanel {
	SistemaBibliotecario sistema;
	
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
    
    
        JTextField caixaNome = new JTextField();
        caixaNome.setColumns(40);
        caixaNome.setBorder(BorderFactory.createTitledBorder("Digite o nome do usuário"));

        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(integerFormat);
        numberFormatter.setValueClass(Integer.class);       // Define que o valor será um Integer
        numberFormatter.setAllowsInvalid(false);              // Impede entrada inválida (não permite caracteres não numéricos)
        numberFormatter.setMinimum(0);
        
        
        JFormattedTextField idade = new JFormattedTextField(numberFormatter);
        idade.setColumns(15); 
        idade.setBorder(BorderFactory.createTitledBorder("Digite a idade do usuário"));

        JFormattedTextField especifico = new JFormattedTextField(numberFormatter);
        especifico.setColumns(10); 
        
        numberFormatter.setMaximum(999999);
        JFormattedTextField matriculaField = new JFormattedTextField(numberFormatter);
        matriculaField.setColumns(15); 
        matriculaField.setBorder(BorderFactory.createTitledBorder("Digite a matricula do usuário"));

        
        String[] opcoesTitulo = {"Ensino médio", "Graduado", "Especializado", "Mestre", "Doutor"};
        JComboBox<String> selecaoDeTitulo = new JComboBox<>(opcoesTitulo);
        selecaoDeTitulo.setBorder(BorderFactory.createTitledBorder("Escolha o titulo"));


        String[] opcoesTipo = {"Professor", "Aluno"};
        JComboBox<String> selecaoDeTipo = new JComboBox<>(opcoesTipo);
        selecaoDeTipo.setBorder(BorderFactory.createTitledBorder("o usuário é"));

        JButton botaoDeCadastro = new JButton("Cadastrar");
        botaoDeCadastro.setBackground(Color.GREEN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campo de nome: ocupa a primeira linha, 3 colunas
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
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

}
