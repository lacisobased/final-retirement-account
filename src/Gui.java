//ryan williams jr; 1373857; CSCI-125; M07
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame {

    public static void main(String[] args) {
        //set up for the GUI portion
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(1, 1, 10, 10));

        //components for selecting accounts
        JLabel selection = new JLabel("Select Account to Simulate:");
        String[] options = {"401k", "IRA"};
        JComboBox<String> optionBox = new JComboBox<>(options);

        //tabbed panes for the various settings
        JTabbedPane pane = new JTabbedPane();
        JComponent infoPan = new JPanel(new GridLayout(2, 2, 5, 05));
        JComponent fourPan = new JPanel(new GridLayout(2, 2, 20, 20));
        JComponent iraPan = new JPanel(new GridLayout(2, 2, 20, 20));

        //pane for information, roth vs non roth accounts
        pane.addTab("information", infoPan);
        pane.setTabComponentAt(0, new JLabel("401k vs IRA"));
        JLabel roth4 = new JLabel("<html>Roth 401k: <br/>" +
                "" );

        JLabel four01k = new JLabel("<html>401k <br/>" +
                "this is the description of a regular 401k. blah blah blah");
            //adding portion for the IRAS below
        JLabel  rothI = new JLabel("<html>Roth IRA: <br/>" +
                "<html> \u2058 A Roth IRA is funded with after-tax dollars, allowing both growth and qualified withdrawals to remain tax-free after age 59½ and after holding the IRA for at least five years. <br/>" +
                "<html> \u2058 You can withdraw your contributions at any time tax-free and without penalty, even if you haven’t met the five-year or age requirements."
                );
        JLabel ira = new JLabel("<html>IRA: <br/>" +
                "<html>");
            //adding them in order
        infoPan.add(rothI);
        infoPan.add(ira);
        infoPan.add(roth4);
        infoPan.add(four01k);
         //border
        //infoPan.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 30));


        frame.add(pane);

        frame.setVisible(true);
    }

}
