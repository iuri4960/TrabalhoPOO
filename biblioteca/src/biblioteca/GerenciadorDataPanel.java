package biblioteca;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.text.*;
import java.awt.*;
import java.util.*;


public class GerenciadorDataPanel extends JPanel {
    InnerGerenciadorDataPanel ano;
    InnerGerenciadorDataPanel mes;
    InnerGerenciadorDataPanel dia;

    public GerenciadorDataPanel() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Data do cadastro"));
        ano = new InnerGerenciadorDataPanel(2025, "Ano");
        mes = new InnerGerenciadorDataPanel(12, "Mes");
        dia = new InnerGerenciadorDataPanel(31, "Dia");
        ano.setValue(2025);
        mes.setValue(1);
        dia.setValue(1);
        this.add(ano);
        this.add(mes);
        this.add(dia);
    }

    @Override
    public String toString() {
        String anoString = String.format("%04d", ano.getValue());
        String mesString = String.format("%02d", mes.getValue());
        String diaString = String.format("%02d", dia.getValue());
        return anoString + "-" + mesString + "-" + diaString;  
    }


    public static void main(String[] args) {
        JFrame tabela = new JFrame("Meu primeiro frame!");
            tabela.setSize(600, 600); 
            
            tabela.setLocationRelativeTo(null);
            tabela.setTitle("nome");
            JPanel painel = new GerenciadorDataPanel();
            tabela.getContentPane().add(painel);

            //SwingUtilities.invokeLater(() -> new MeuFrame("jogo"));
            tabela.setVisible(true);
            tabela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } 
    public boolean verificarData() {
        if(ano.getText() == null || mes.getText() == null|| dia.getText() == null){
            return true;
        }
        else{
            return false;
        }
    }
}

class InnerGerenciadorDataPanel extends JFormattedTextField {
    InnerGerenciadorDataPanel(int valorMaximo, String nome){
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        integerFormat.setGroupingUsed(false); 
        NumberFormatter numberFormatterAno = new NumberFormatter(integerFormat) {
            @Override
            public Object stringToValue(String text) throws ParseException {
                if (text == null || text.trim().isEmpty()) {
                    return null;
                }
                return super.stringToValue(text);
            }
        };
        numberFormatterAno.setValueClass(Integer.class); 
        numberFormatterAno.setAllowsInvalid(false); 
        numberFormatterAno.setMinimum(0);
        
        numberFormatterAno.setMaximum(valorMaximo);  // Você pode usar o parâmetro valorMaximo
        
        // Aqui é onde você "seta" o formatter:
        this.setFormatterFactory(new DefaultFormatterFactory(numberFormatterAno));
        
        this.setColumns(10);
        this.setBorder(BorderFactory.createTitledBorder(nome));
    }
   
}


    
