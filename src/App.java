import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App extends JFrame {
    public App(){
        super("Calculadora");
        setLayout(new GridLayout(4,4,5,5));
        for(int i=1;i<10;i++){
            add(new JButton(Integer.toString(i)));
        }
        add(new JLabel(""));
        add(new JButton(Integer.toString(0)));
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) throws Exception {
       App calculadora = new App();
    }
}
