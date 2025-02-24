package biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;
//painel de alterar informações
public class AlterarInformacoesUsuarioPainel extends JPanel {

    //contrutor ttera um cabeçallho e um painel de alterar
    AlterarInformacoesUsuarioPainel(){
        this.setLayout(new BorderLayout());
        add(criarPainelCabecalho(), BorderLayout.NORTH);
        add(criarPainelAlterar(), BorderLayout.CENTER);
    }

    //criando cabeçalho
    private JPanel criarPainelCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.gray);
        cabecalho.setLayout(new FlowLayout());
        JLabel label = new JLabel("ALTERAR INFORMAÇÕES DO ALUNO", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        cabecalho.add(label);
        return cabecalho;
    }


    //painel de alteraar informações
     private JPanel criarPainelAlterar(){
        JPanel alterar = new JPanel();
        //layout
        alterar.setLayout(new GridBagLayout());
        alterar.setBackground(Color.LIGHT_GRAY);
    
        //caixa de nome
        JTextField caixaNome = new JTextField("colocar nome");
        caixaNome.setColumns(40);
        caixaNome.setBorder(BorderFactory.createTitledBorder("Digite o nome do usuário"));

        //criando retrição de somente deigitar numeros para matricula, idade e semestre/materias
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(integerFormat);
        numberFormatter.setValueClass(Integer.class);       // Define que o valor será um Integer
        numberFormatter.setAllowsInvalid(false);              // Impede entrada inválida (não permite caracteres não numéricos)
        numberFormatter.setMinimum(0);
        
        //caixa de idade
        JFormattedTextField idade = new JFormattedTextField(numberFormatter);
        idade.setColumns(15); 
        idade.setBorder(BorderFactory.createTitledBorder("Digite a idade do usuário"));
        idade.setValue(0);

        //caixa de materias/semestre
        JFormattedTextField especifico = new JFormattedTextField(numberFormatter);
        especifico.setColumns(10); 
        especifico.setValue(null);

        numberFormatter.setMaximum(999999);
        //matricula
        JFormattedTextField matriculaField = new JFormattedTextField(numberFormatter);
        matriculaField.setColumns(15); 
        matriculaField.setBorder(BorderFactory.createTitledBorder("Digite a matricula do usuário"));
        matriculaField.setValue(17);

        //lista para escolher titulo
        String[] opcoesTitulo = {"Ensino médio", "Graduado", "Especializado", "Mestre", "Doutor"};
        JComboBox<String> selecaoDeTitulo = new JComboBox<>(opcoesTitulo);
        selecaoDeTitulo.setBorder(BorderFactory.createTitledBorder("Escolha o titulo"));
        selecaoDeTitulo.setSelectedItem("Graduado");

        //lista para escolher tipo de usuario
        String[] opcoesTipo = {"Professor", "Aluno"};
        JComboBox<String> selecaoDeTipo = new JComboBox<>(opcoesTipo);
        selecaoDeTipo.setBorder(BorderFactory.createTitledBorder("o usuário é"));
        selecaoDeTipo.setSelectedItem("Aluno");

        //botão de alterar
        JButton botaoDeCadastro = new JButton("Alterar");
        botaoDeCadastro.setBackground(Color.GREEN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        //organização de layout
        // Campo de nome: ocupa a primeira linha, 3 colunas
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        alterar.add(caixaNome, gbc);
        
        // Reset gridwidth para 1 para os demais componentes
        gbc.gridwidth = 1;
        
        // Linha 2, coluna 1: idade
        gbc.gridx = 0;
        gbc.gridy = 1;
        alterar.add(matriculaField, gbc);
        
        // Linha 2, coluna 2: matriculaField
        gbc.gridx = 1;
        alterar.add(selecaoDeTipo, gbc);
        
        // Linha 2, coluna 3: selecaoDeTipo
        gbc.gridx = 2;
        alterar.add(especifico, gbc);
        
        // Linha 3, coluna 1: selecaoDeTitulo
        gbc.gridx = 0;
        gbc.gridy = 2;
        alterar.add(idade, gbc);
        
        // Linha 3, coluna 2: botaoDeCadastro
        gbc.gridx = 2;
        alterar.add(botaoDeCadastro, gbc);
        
        // Linha 3, coluna 3: pode deixar vazia ou adicionar outro componente
        gbc.gridx = 1;
        alterar.add(selecaoDeTitulo, gbc);

        return alterar;
    }
}
