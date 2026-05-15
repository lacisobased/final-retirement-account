//ryan williams jr; 1373857; CSCI-125; M07
//last worked on by ryan 5:14pm

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.data.*;
import org.jfree.chart.*;

public class Gui {

    public static void main(String[] args) {
        //set up for the GUI portion
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(1, 1, 10, 10));


        //tabbed panes for the various settings
        JTabbedPane pane = new JTabbedPane();
        infoPane infoPan = new infoPane();
        fPane fourPan = new fPane();
        /** JComponent iraPan = new JPanel(new GridLayout(2, 2, 20, 20)); why the FUCK did i do this */

        //pane for information, roth vs non roth accounts
        pane.addTab("information", infoPan);
        pane.setTabComponentAt(0, new JLabel("401k vs IRA"));

        //pane for the 401k calculator
        pane.addTab("401k calculator", fourPan);
        pane.setTabComponentAt(1, new JLabel("401k calculator"));


        frame.add(pane); //adding the tabbed pane

        frame.setVisible(true); //setting it visible
    }

}