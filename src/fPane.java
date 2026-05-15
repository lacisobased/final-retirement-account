//ryan williams jr; 1373857; CSCI-125; M07
//

import org.jfree.chart.*;
import org.jfree.data.xy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class fPane extends JPanel {
    JTabbedPane pane;

    public fPane(JTabbedPane pane) {
        this.pane = pane;

        this.setLayout(new GridLayout(10,2, 20, 20 ));
        
        //fields
        JLabel cAge = new JLabel("Enter current age: ");
        JTextField cAgeField = new JTextField("25");
        JLabel rAge = new JLabel("Enter retirement age: ");
        JTextField rAgeField = new JTextField("65");
        JLabel cBal = new JLabel("Amount in 401k currently: ");
        JTextField cBalField = new JTextField("0");
        JLabel salarY = new JLabel("Enter current salary: "); //has a different title to differenciate it frm other things in code elsewhere
        JTextField salaryField = new JTextField("40000");
        JLabel contributioN = new JLabel("Percentage you will contribute each month: ");
        JTextField contributionField = new JTextField("6");
        JLabel raisE = new JLabel("How much will your salary raise annually: ");
        JTextField raiseField = new JTextField("4");
        JLabel returN = new JLabel("Annual rate of return, in percentage: ");
        JTextField returnField = new JTextField("7");
        JLabel eMatch = new JLabel("How much will your employer match your contributions: ");
        JTextField eMatchField = new JTextField("50");
        JLabel eSalaryMatch = new JLabel("Percentage of salary you're employer will match: ");
        JTextField eSalaryField = new JTextField("10");
        JLabel output = new JLabel("Total Amount Saved: ");
        //buttons
        JButton clear = new JButton("Reset to Default");
        JButton calculate = new JButton("Calculate");
        
        //rinse repeat
        this.add(cAge);
        this.add(cAgeField);
        this.add(rAge);
        this.add(rAgeField);
        this.add(cBal);
        this.add(cBalField);
        this.add(salarY);
        this.add(salaryField);
        this.add(raisE);
        this.add(raiseField);
        this.add(contributioN);
        this.add(contributionField);
        this.add(returN);
        this.add(returnField);
        this.add(eMatch);
        this.add(eMatchField);
        this.add(eSalaryMatch);
        this.add(eSalaryField);
        this.add(calculate);
        this.add(clear);

        //calculations
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //getting things from the text fields
                    int cAge = Integer.parseInt(cAgeField.getText());
                    int rAge = Integer.parseInt(rAgeField.getText());
                    int cBal = Integer.parseInt(cBalField.getText());
                    int salary = Integer.parseInt(salaryField.getText());
                    int contribution = Integer.parseInt(contributionField.getText());
                    int raise = Integer.parseInt(raiseField.getText());
                    int returN = Integer.parseInt(returnField.getText());
                    int eMatch = Integer.parseInt(eMatchField.getText());
                    int eSalary = Integer.parseInt(eSalaryField.getText());

                    //parse text fields and put turn it into something usuable
                    four01k c = new four01k(cAge, rAge, cBal, 00, returN, false, salary, contribution, raise, eMatch, eSalary);

                    //popup
                    double FINAL = c.dCalculateReturn();
                    JOptionPane.showMessageDialog(null, "Total savings: " + String.format("%.2f", FINAL));

                    //CHART.
                        //data for chart
                    ArrayList<double[]> yearly = c.yearlyBalances();
                        //chart lines
                    XYSeries seriesCont = new XYSeries("Employee Contributions");
                    XYSeries seriesNoMatch = new XYSeries("Growth (No Match)");
                    XYSeries seriesWithMatch = new XYSeries("Growth (Yes Match)");
                        //get data for chart lines
                    for (int i = 0; i < yearly.size(); i++) {
                        double[] yearData = yearly.get(i);
                        seriesCont.add(i, yearData[0]);     // index 0 is cumulative contributions
                        seriesNoMatch.add(i, yearData[1]);  // index 1 is no match
                        seriesWithMatch.add(i, yearData[2]);// index 2 is with match
                    }
                        //smush em into one
                    XYSeriesCollection data = new XYSeriesCollection();
                    data.addSeries(seriesCont);
                    data.addSeries(seriesNoMatch);
                    data.addSeries(seriesWithMatch);
                        //actual graph
                    JFreeChart chart = ChartFactory.createXYLineChart(
                            "401k Growth Comparison",
                            "Years Working",
                            "Balance ($)",
                            data
                    );
                    //chart in new tab
                    ChartPanel chartPanel = new ChartPanel(chart);
                    if (pane.getTabCount() > 3) {
                        pane.removeTabAt(3);
                    }

                    pane.addTab("401k Growth Chart", chartPanel);
                    pane.setSelectedIndex(3);

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input Invalid! Enter whole numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cAgeField.setText("25");
                rAgeField.setText("65");
                salaryField.setText("40000");
                contributionField.setText("6");
                raiseField.setText("4");
                returnField.setText("7");
                eMatchField.setText("50");
                eSalaryField.setText("10");
                cBalField.setText("0");
            }
        });
    }
}






