package jswing_calculadora;
import javax.swing.*;
import java.awt.event.*;

public class CalculadoraController {
    private JTextField display;
    private double numero1, numero2, resultado;
    private String operacion;

    public CalculadoraController(JTextField display, JButton[] botones) {
        this.display = display;
        for (JButton boton : botones) {
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    manejarEvento(e.getActionCommand());
                }
            });
        }
    }

    private void manejarEvento(String comando) {
        if (comando.matches("[0-9.]")) {
            display.setText(display.getText() + comando);
        } else if (comando.matches("[+\\-*/]")) {
            try {
                numero1 = Double.parseDouble(display.getText());
                operacion = comando;
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (comando.equals("=")) {
            try {
                numero2 = Double.parseDouble(display.getText());
                switch (operacion) {
                    case "+": resultado = numero1 + numero2; break;
                    case "-": resultado = numero1 - numero2; break;
                    case "*": resultado = numero1 * numero2; break;
                    case "/": resultado = numero2 != 0 ? numero1 / numero2 : 0; break;
                }
                display.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (comando.equals("C")) {
            display.setText("");
            numero1 = numero2 = resultado = 0;
            operacion = "";
        }
    }
}
