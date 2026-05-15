//Jeremiah Black; 138324; CSCI-125; M07
//

import java.util.ArrayList;

public class IRA extends retirementAccount {

    int annualContribution;
    boolean maxContribution;

    //default constructor
    public IRA() {
        super(25, 65, 0, 0, 7, false);

        this.annualContribution = 7000;
        this.maxContribution = false;
    }

    //full constructor
    public IRA(int age,
               int retAge,
               double startBal,
               double endBal,
               int percent,
               boolean taxable,
               int annualContribution,
               boolean maxContribution) {

        super(age, retAge, startBal, endBal, percent, taxable);

        this.annualContribution = annualContribution;
        this.maxContribution = maxContribution;
    }

    @Override
    public double dCalculateReturn() {

        double currentBal = startBal;

        int years = retAge - age;

        //2025 IRA contribution limit
        int contributionLimit = 7000;

        for(int i = 0; i < years; i++) {

            double contribution;

            //if max contribution selected
            if(maxContribution) {
                contribution = contributionLimit;
            }
            else {

                //prevent exceeding limit
                contribution = Math.min(
                        annualContribution,
                        contributionLimit
                );
            }

            currentBal += contribution;

            //growth
            currentBal *= (1 + (percent / 100.0));
        }

        this.endBal = currentBal;

        return endBal;
    }

    @Override
    public void calculateReturn() {

        double finalBal = dCalculateReturn();

        System.out.println(
                "Your IRA balance is $"
                        + String.format("%.2f", finalBal)
        );
    }

    //for graphing/chart later
    public ArrayList<double[]> yearlyBalances() {

        ArrayList<double[]> yearly =
                new ArrayList<>();

        double currentBal = startBal;

        double cumulativeContributions =
                startBal;

        int years = retAge - age;

        int contributionLimit = 7000;

        yearly.add(new double[] {
                cumulativeContributions,
                currentBal
        });

        for(int i = 0; i < years; i++) {

            double contribution;

            if(maxContribution) {
                contribution = contributionLimit;
            }
            else {
                contribution = Math.min(
                        annualContribution,
                        contributionLimit
                );
            }

            cumulativeContributions +=
                    contribution;

            currentBal += contribution;

            currentBal *=
                    (1 + (percent / 100.0));

            yearly.add(new double[] {
                    cumulativeContributions,
                    currentBal
            });
        }

        return yearly;
    }
}