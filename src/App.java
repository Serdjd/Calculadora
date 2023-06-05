import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

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
        JButton division = new JButton("/");
        JButton multiplicar = new JButton("*");
        JButton restar = new JButton("-");
        JButton sumar = new JButton("+");

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

        public void actionPerformed(ActionEvent igual) {
            StringBuilder cuentachar = new StringBuilder(pantalla.getText());
            ArrayList<Integer> lista_num = new ArrayList<>();
            ArrayList<Character> lista_simbols = new ArrayList<>();
            StringBuilder temporal = new StringBuilder();
            for(int i = 0;i<cuentachar.length();i++){
                if(Character.isDigit(cuentachar.charAt(i))){
                    temporal.append(cuentachar.charAt(i));
                }
                else{
                    if((cuentachar.charAt(i)=='+')||(cuentachar.charAt(i)=='-')||(cuentachar.charAt(i)=='*')||(cuentachar.charAt(i)=='/')){
                        lista_simbols.add(cuentachar.charAt(i));
                        lista_num.add(Integer.parseInt(String.valueOf(temporal)));
                        temporal.setLength(0);
                    }
            }
        }
            lista_num.add(Integer.parseInt(String.valueOf(temporal)));
            if(lista_simbols.get(0)=='+'){
                pantalla.setText(String.valueOf(lista_num.get(0)+lista_num.get(1)));
            }
            if(lista_simbols.get(0)=='-'){
                pantalla.setText(String.valueOf(lista_num.get(0)-lista_num.get(1)));
            }
            if(lista_simbols.get(0)=='*'){
                pantalla.setText(String.valueOf(lista_num.get(0)*lista_num.get(1)));
            }
            if(lista_simbols.get(0)=='/'){
                pantalla.setText(String.valueOf(lista_num.get(0)/lista_num.get(1)));
            }
    }

    }
}
