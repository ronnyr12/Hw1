import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Calculator_Screen extends JFrame{
    private JPanel calculator_panel;
    private JTextField textName;
    private JTextField textSubject;
    private JTextField textCode;
    private JButton btnAdd;
    private JTable table1;
    private JButton deleteButton;
    private JButton updateButton;
    private DefaultTableModel tableModel;
    public Calculator_Screen() {
        setContentPane(calculator_panel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createTable();
        tableModel = (DefaultTableModel) table1.getModel();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().trim().length()==0 ||
                        textSubject.getText().trim().length()==0 ||
                        textCode.getText().trim().length()==0){
                    showMessage("Please enter all data!");
                }else{
                  String[] data = { textName.getText(), textSubject.getText(), textCode.getText()};
                    tableModel.addRow(data);
                    showMessage("data added successfully!");
                    clearDataFields();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRowCount() == 1){
                  tableModel.removeRow(table1.getSelectedRow());
                }else{
                    if(table1.getRowCount() == 0){
                        showMessage("Table is empty");
                    }else{
                        showMessage("please select single row to delete");
                    }
                }
            }
        });


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String tableName = tableModel.getValueAt(table1.getSelectedRow(), 0).toString();
                String tableSubject = tableModel.getValueAt(table1.getSelectedRow(), 1).toString();
                String tableCode = tableModel.getValueAt(table1.getSelectedRow(), 2).toString();

                textName.setText(tableName);
                textSubject.setText(tableSubject);
                textCode.setText(tableCode);
            }
        });

        setVisible(true);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRowCount()==1){
                    String name = textName.getText();
                    String subject = textSubject.getText();
                    String code = textCode.getText();

                    tableModel.setValueAt(name, table1.getSelectedRow(), 0);
                    tableModel.setValueAt(subject, table1.getSelectedRow(), 1);
                    tableModel.setValueAt(code, table1.getSelectedRow(), 2);

                    showMessage("Update successfully!");
                }else{
                    if(table1.getRowCount()==0){
                        showMessage("Table is empty");
                    }else{
                        showMessage("Please select a single row to update");
                    }
                }
            }
        });
    }

    private void createTable() {
        //creates a mode of table= getsdata and column
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"Name", "Subject","Code"}
        ));
    }

    private void clearDataFields() {
        textName.setText("");
        textCode.setText("");
        textSubject.setText("");
    }

    public void showMessage(String text){
        JOptionPane.showMessageDialog(calculator_panel, text);

    }
    public static void main(String[] args) {
        Calculator_Screen calculator_screen = new Calculator_Screen();
    }


}
