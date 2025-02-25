package bibliotecagrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import usuario.Aluno;
import usuario.Professor;
import usuario.Titulo;
import usuario.Usuario;


public class AlterarInformacoesUsuarioPanel extends JPanel {
	 Usuario usuarioSelecionadoGeral;
	    SistemaBibliotecario sistema;

	    JFormattedTextField idade;
	    JTextField caixaNome;
	    JFormattedTextField especifico;
	    JFormattedTextField matriculaField;
	    JComboBox<Titulo> selecaoDeTitulo;
	    JLabel selecaoDeTipo;
	    JButton botaoDeCadastro;
	    

	    //contrutor ttera um cabeçallho e um painel de alterar
	    AlterarInformacoesUsuarioPanel(Usuario usuarioSelecionadoGeral, SistemaBibliotecario sistema){
	        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral;
	        this.sistema = sistema;
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
	        caixaNome = new JTextField("colocar nome");
	        caixaNome.setColumns(40);
	        caixaNome.setBorder(BorderFactory.createTitledBorder("Digite o nome do usuário"));

	        //criando retrição de somente deigitar numeros para matricula, idade e semestre/materias
	        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
	        NumberFormatter numberFormatter = new NumberFormatter(integerFormat);
	        numberFormatter.setValueClass(Integer.class);       // Define que o valor será um Integer
	        numberFormatter.setAllowsInvalid(false);              // Impede entrada inválida (não permite caracteres não numéricos)
	        numberFormatter.setMinimum(0);
	        
	        //caixa de idade
	        idade = new JFormattedTextField(numberFormatter);
	        idade.setColumns(15); 
	        idade.setBorder(BorderFactory.createTitledBorder("Digite a idade do usuário"));
	        idade.setValue(0);

	        //caixa de materias/semestre
	        especifico = new JFormattedTextField(numberFormatter);
	        especifico.setColumns(10); 
	        especifico.setValue(null);
	        especifico.setBorder(BorderFactory.createTitledBorder("semestre atual"));

	        numberFormatter.setMaximum(999999);
	        //matricula
	        matriculaField = new JFormattedTextField(numberFormatter);
	        matriculaField.setColumns(15); 
	        matriculaField.setBorder(BorderFactory.createTitledBorder("Digite a matricula do usuário"));
	        matriculaField.setValue(17);

	        //lista para escolher titulo
	        Titulo[] opcoesTitulo = {Titulo.GRADUANDO, Titulo.GRADUADO, Titulo.ESPECIALIZADO, Titulo.MESTRE, Titulo.DOUTOR};
	        selecaoDeTitulo = new JComboBox<>(opcoesTitulo);
	        selecaoDeTitulo.setBorder(BorderFactory.createTitledBorder("Escolha o titulo"));
	        selecaoDeTitulo.setSelectedItem("Graduado");

	        //lista para escolher tipo de usuario
	        
	        selecaoDeTipo = new JLabel();
	        selecaoDeTipo.setBorder(BorderFactory.createTitledBorder("o usuário é"));
	        selecaoDeTipo.setText("Aluno");
	        selecaoDeTipo.setPreferredSize(new Dimension(100, 50));
	        selecaoDeTipo.setOpaque(true);  
	        selecaoDeTipo.setBackground(Color.WHITE);

	        //botão de alterar
	        botaoDeCadastro = new JButton("Alterar");
	        botaoDeCadastro.setBackground(Color.GREEN);
	        botaoDeCadastro.addActionListener(e ->{
	            if(null == this.obterTexto(caixaNome) || null == this.obterTexto(matriculaField) || null == this.obterTexto(idade) || null == this.obterTexto(especifico) ){
	                JOptionPane.showMessageDialog(this, "Por favor, Digite as informações do usuario.", 
	                "Atenção", JOptionPane.WARNING_MESSAGE);
	            }
	            else if(selecaoDeTipo.getText().equals("Aluno")){
	                try{
	                    Titulo titulo = (Titulo) selecaoDeTitulo.getSelectedItem();
	                    Integer matricula = (Integer) matriculaField.getValue();
	                    Integer idadeNumero = (Integer) idade.getValue();
	                    Integer semestre = (Integer) especifico.getValue();

	                    Aluno aluno = new Aluno(this.obterTexto(caixaNome), matricula, idadeNumero, titulo, semestre);
	                    sistema.editarUsuario(usuarioSelecionadoGeral.getMatricula(), aluno);

	                    JOptionPane.showMessageDialog(this, "Aluno Editado Com Sucesso", 
	                    "Atenção", JOptionPane.INFORMATION_MESSAGE);              
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
	                    sistema.editarUsuario(usuarioSelecionadoGeral.getMatricula(), professor);
	                    JOptionPane.showMessageDialog(this, "Professor Adicionado Com Sucesso", 
	                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
	                    
	                }
	                catch(Exception ex){
	                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
	                    "Atenção", JOptionPane.WARNING_MESSAGE);
	                }
	            }
	        });

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

	    public void setUsuario(Usuario usuarioSelecionadoGeral){
	        

	        this.usuarioSelecionadoGeral = usuarioSelecionadoGeral;
	        caixaNome.setText(usuarioSelecionadoGeral.getNome());
	        //matricula
	         matriculaField.setText(Integer.toString(usuarioSelecionadoGeral.getMatricula()));  

	        //titulo
	        selecaoDeTitulo.setSelectedItem(usuarioSelecionadoGeral.getTitulo().getDescricao());
	        //diferença entre professor e usuario
	        String tipo; 
	        int especificoNumero;  
	        if(usuarioSelecionadoGeral instanceof Aluno){
	            tipo = "Aluno";
	            especificoNumero = ((Aluno)usuarioSelecionadoGeral).getSemestre(); 
	            especifico.setBorder(BorderFactory.createTitledBorder("Semestre atual"));
	        }
	        else{
	            tipo = "Professor";
	            especificoNumero = ((Professor)usuarioSelecionadoGeral).getQtdMaterias();
	            especifico.setBorder(BorderFactory.createTitledBorder("Quantidade de materias"));
	        }

	        //tipo de usuario
	        selecaoDeTipo.setText(tipo);

	        //Semestre/qnt de materias
	 
	        especifico.setText(Integer.toString(especificoNumero));  
	       

	        //idade
	        idade.setText(Integer.toString(usuarioSelecionadoGeral.getIdade()));
	        //quantidade de livros new JLabel(Integer.toString(sistema.consultarEmprestimo(usuarioSelecionadoGeral.getMatricula()).size()));
	       
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
