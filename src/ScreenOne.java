import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScreenOne extends JFrame{
    private JButton btn_red;
    private JButton btn_green;
    private JButton btn_blue;
    private JPanel main_panel;
    private JButton goToCalculatorButton;

    /*public ScreenOne() throws HeadlessException {
    }*/

    public ScreenOne(){
        setTitle("Hw1 Screen");
        setContentPane(main_panel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
        btn_red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_panel.setBackground(Color.RED);
            }
        });
        btn_green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_panel.setBackground(Color.GREEN);
            }
        });
        btn_blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_panel.setBackground(Color.BLUE);
            }
        });
        goToCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator_Screen calculator_screen = new Calculator_Screen();
            }
        });
    }

    public static void main(String[] args) {
        ScreenOne screenOne = new ScreenOne();
    }
}
