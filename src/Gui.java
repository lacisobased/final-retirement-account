//ryan williams jr; 1373857; CSCI-125; M07
//last worked on by ryan 5:14pm

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.*;

public class Gui {

    public static void main(String[] args) {
        //set up for the GUI portion
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(1, 1, 10, 10));


        //tabbed panes for the various settings
        JTabbedPane pane = new JTabbedPane();
        JComponent infoPan = new JPanel(new GridLayout(2, 2, 5, 5));
        JComponent fourPan = new JPanel(new GridLayout(10, 2, 20, 20));
        /** JComponent iraPan = new JPanel(new GridLayout(2, 2, 20, 20)); why the FUCK did i do this */

        //pane for information, roth vs non roth accounts
        pane.addTab("information", infoPan);
        pane.setTabComponentAt(0, new JLabel("401k vs IRA"));
        JLabel roth4 = new JLabel("<html>Roth 401k: <br/>" +
                "test string 1" );

        JLabel four01k = new JLabel("<html>401k <br/>" +
                "this is the description of a regular 401k. blah blah blah");
            //adding portion for the IRAS below
        JLabel  rothI = new JLabel("<html>Roth IRA: <br/>" +
                "<html> \u2058 A Roth IRA is funded with after-tax dollars, allowing both growth and qualified withdrawals to remain tax-free after age 59½ and after holding the IRA for at least five years. <br/>" +
                "<html> \u2058 You can withdraw your contributions at any time tax-free and without penalty, even if you haven’t met the five-year or age requirements."
                );
        JLabel ira = new JLabel("<html>Traditional IRA: <br/>" +
                "<html> \u2058 Traditional IRAs allow you to save on income taxes now and pay them later in retirement, when you could be in a lower tax bracket and therefore owe less in taxes. <br/>" +
                "<html> \u2058 Any investments in your IRA grow tax-deferred until withdrawal. <br/>" +
                "<html> \u2058 Withdrawals of earnings and deductible contributions are taxed like any other income you earn in the year they're taken, if they're qualified.");
            //adding them in order
        infoPan.add(rothI);
        infoPan.add(ira);
        infoPan.add(roth4);
        infoPan.add(four01k);

        //pane for the 401k calculator
        pane.addTab("401k calculator", fourPan);
        pane.setTabComponentAt(1, new JLabel("401k calculator"));
            //fields
        JLabel cAge = new JLabel("Enter current age: ");
        JTextField cAgeField = new JTextField(1);
        JLabel rAge = new JLabel("Enter retirement age: ");
        JTextField rAgeField = new JTextField(1);
        JLabel salarY = new JLabel("Enter current salary: "); //has a different title to differenciate it frm other things in code elsewhere
        JTextField salaryField = new JTextField(1);
        JLabel contributioN = new JLabel("Percentage you will contribute each month: ");
        JTextField contributionField = new JTextField(1);
        JLabel raisE = new JLabel("How much will your salary raise annually: ");
        JTextField raiseField = new JTextField(1);
        JLabel returN = new JLabel("Annual rate of return, in percentage: ");
        JTextField returnField = new JTextField(1);
        JLabel eMatch = new JLabel("How much will your employer match your contributions: ");
        JTextField eMatchField = new JTextField(1);
        JLabel eSalaryMatch = new JLabel("Percentage of salary you're employer will match: ");
        JTextField eSalaryField = new JTextField(1);
        JLabel output = new JLabel("Total Amount Saved: ");
        //JLabel
        JButton clear = new JButton("Clear");
        JButton calculate = new JButton("Calculate");

        //adding things to pane
        fourPan.add(cAge);
        fourPan.add(cAgeField);
        fourPan.add(rAge);
        fourPan.add(rAgeField);
        fourPan.add(salarY);
        fourPan.add(salaryField);
        fourPan.add(raisE);
        fourPan.add(raiseField);
        fourPan.add(contributioN);
        fourPan.add(contributionField);
        fourPan.add(returN);
        fourPan.add(returnField);
        fourPan.add(eMatch);
        fourPan.add(eMatchField);
        fourPan.add(eSalaryMatch);
        fourPan.add(eSalaryField);
        fourPan.add(calculate);
        fourPan.add(clear);



        frame.add(pane); //adding the tabbed pane

        frame.setVisible(true); //setting it visible
    }

}