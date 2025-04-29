package jswing_calculadora;
import javax.swing.*;
import java.awt.*;

public class calculadora_frame extends JFrame {
    private JTextField display;
    private JPanel panel;
//    private CalculadoraController controller;

    public calculadora_frame() {
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        JButton[] botonesArray = new JButton[botones.length];

        for (int i = 0; i < botones.length; i++) {
            botonesArray[i] = new JButton(botones[i]);
            botonesArray[i].setFont(new Font("Arial", Font.BOLD, 18));
            panel.add(botonesArray[i]);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

//        controller = new CalculadoraController(display, botonesArray);

        setTitle("Calculadora MVC");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
