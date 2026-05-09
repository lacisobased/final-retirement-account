//ryan williams jr; 1373857; CSCI-125; M07
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {
        //set up for the GUI portion
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(5, 5, 10, 10));

        //components for selecting accounts
        JLabel selection = new JLabel("Select Account to Simulate:");
        String[] options = {"401k", "IRA"};
        JComboBox<String> optionBox = new JComboBox<>(options);



    }

}
