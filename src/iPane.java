import org.jfree.chart.*;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class iPane extends JPanel {

    JTabbedPane pane;

    public iPane(JTabbedPane pane) {

        this.pane = pane;

        this.setLayout(new GridLayout(9, 2, 20, 20));

        //labels + fields
        JLabel cAge = new JLabel("Current Age:");
        JTextField cAgeField = new JTextField("25");

        JLabel rAge = new JLabel("Retirement Age:");
        JTextField rAgeField = new JTextField("65");

        JLabel startBal = new JLabel("Current IRA Balance:");
        JTextField startBalField = new JTextField("0");

        JLabel contribution =
                new JLabel("Annual Contribution:");

        JTextField contributionField =
                new JTextField("7000");

        JLabel returnRate =
                new JLabel("Expected Return (%):");

        JTextField returnField =
                new JTextField("7");

        JCheckBox rothBox =
                new JCheckBox("Roth IRA");

        JCheckBox maxBox =
                new JCheckBox("Max Contribution");

        JButton calculate =
                new JButton("Calculate");

        JButton clear =
                new JButton("Reset");

        JLabel output =
                new JLabel("Total amount saved: ");

        JLabel output2 =
                new JLabel("");

        //add components
        this.add(cAge);
        this.add(cAgeField);

        this.add(rAge);
        this.add(rAgeField);

        this.add(startBal);
        this.add(startBalField);

        this.add(contribution);
        this.add(contributionField);

        this.add(returnRate);
        this.add(returnField);

        this.add(rothBox);
        this.add(maxBox);

        this.add(output);
        this.add(output2);

        this.add(calculate);
        this.add(clear);

        //CALCULATE BUTTON
        calculate.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {

                            int age =
                                    Integer.parseInt(
                                            cAgeField.getText());

                            int retAge =
                                    Integer.parseInt(
                                            rAgeField.getText());

                            double balance =
                                    Double.parseDouble(
                                            startBalField.getText());

                            int contribution =
                                    Integer.parseInt(
                                            contributionField.getText());

                            int percent =
                                    Integer.parseInt(
                                            returnField.getText());

                            boolean roth =
                                    rothBox.isSelected();

                            boolean max =
                                    maxBox.isSelected();

                            //create IRA object
                            IRA ira = new IRA(
                                    age,
                                    retAge,
                                    balance,
                                    0,
                                    percent,
                                    roth,
                                    contribution,
                                    max
                            );

                            double FINAL =
                                    ira.dCalculateReturn();

                            output2.setText("$" + String.format("%.2f", FINAL));

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Estimated IRA Savings: $"
                                            + String.format("%.2f", FINAL)
                            );

                            //chart stuff
                            ArrayList<double[]> yearly =
                                    ira.yearlyBalances();

                            XYSeries contributionSeries =
                                    new XYSeries(
                                            "Contributions");

                            XYSeries growthSeries =
                                    new XYSeries(
                                            "IRA Growth");

                            for(int i = 0;
                                i < yearly.size();
                                i++) {

                                double[] data =
                                        yearly.get(i);

                                contributionSeries.add(
                                        i,
                                        data[0]);

                                growthSeries.add(
                                        i,
                                        data[1]);
                            }

                            XYSeriesCollection dataset =
                                    new XYSeriesCollection();

                            dataset.addSeries(
                                    contributionSeries);

                            dataset.addSeries(
                                    growthSeries);

                            JFreeChart chart =
                                    ChartFactory
                                            .createXYLineChart(
                                                    "IRA Growth Chart",
                                                    "Years",
                                                    "Balance ($)",
                                                    dataset
                                            );

                            //save button
                            ChartPanel chartPanel = new ChartPanel(chart);
                            JButton saveBtn = new JButton("Save as PNG"); //save button

                            JPanel chartContainer = new JPanel(new BorderLayout());
                            chartContainer.add(chartPanel, BorderLayout.CENTER);
                            chartContainer.add(saveBtn, BorderLayout.SOUTH);

                            //save button fuctionality
                            //save button functionality
                            saveBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    //save file window
                                    JFileChooser fileChooser = new JFileChooser();
                                    fileChooser.setDialogTitle("Save Chart As");

                                    //when user clicks save
                                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                        File fileToSave = fileChooser.getSelectedFile();

                                        //append .png
                                        if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                                            fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".png");
                                        }

                                        try {
                                            //save the image
                                            ChartUtils.saveChartAsPNG(fileToSave, chart, 1000, 1000);
                                            JOptionPane.showMessageDialog(null, "chart saved successfully!", "success", JOptionPane.INFORMATION_MESSAGE);
                                        } catch (Exception ex) {
                                            JOptionPane.showMessageDialog(null, "error saving chart.", "error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            });

                            //remove old chart tab
                            if(pane.getTabCount() > 3) {
                                pane.removeTabAt(3);
                            }

                            pane.addTab(
                                    "IRA Chart",
                                    chartContainer);

                            pane.setSelectedIndex(3);

                        }

                        catch(NumberFormatException ex) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Invalid Input!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                });

        //RESET BUTTON
        clear.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cAgeField.setText("25");
                        rAgeField.setText("65");
                        startBalField.setText("0");
                        contributionField.setText("7000");
                        returnField.setText("7");

                        rothBox.setSelected(false);
                        maxBox.setSelected(false);
                        output2.setText("");
                    }
                });
    }


}