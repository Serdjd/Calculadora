import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class App extends JFrame {
    Container panel;
    JTextField pantalla = new JTextField();

    public App(){

        super("Calculadora");
        pantalla.setColumns(4);
        JPanel teclas = new JPanel(new GridLayout(4,4,2,2));

        for(int i=1;i<10;i++){
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new cuenta());
            teclas.add(button);
        }
        JButton cero = new JButton(Integer.toString(0));
        JButton coma = new JButton(",");
        JButton igual = new JButton("=");
        JButton division = new JButton(" ÷ ");
        JButton multiplicar = new JButton(" * ");
        JButton restar = new JButton(" - ");
        JButton sumar = new JButton(" + ");

        cero.addActionListener(new cuenta());
        coma.addActionListener(new cuenta());
        igual.addActionListener(new resultado());
        division.addActionListener(new cuenta());
        multiplicar.addActionListener(new cuenta());
        restar.addActionListener(new cuenta());
        sumar.addActionListener(new cuenta());

        teclas.add(cero);
        teclas.add(coma);
        teclas.add(igual);
        teclas.add(division,3);
        teclas.add(multiplicar,7);
        teclas.add(restar,11);
        teclas.add(sumar,15);

        panel = this.getContentPane();
        panel.setBackground(Color.darkGray);

        add(pantalla,BorderLayout.NORTH);
        add(teclas);
        pack();
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws Exception {
       App calculadora = new App();
    }
    class cuenta implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            JButton button = (JButton) evento.getSource();
            String cuenta = button.getText();
            pantalla.setText(pantalla.getText()+cuenta);
        }
    }
    class  resultado implements ActionListener{

        public void actionPerformed(ActionEvent evento) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            try{
                Object result = engine.eval(pantalla.getText());
                pantalla.setText(result.toString());
            }
            catch (ScriptException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
