//ryan williams jr; 1373857; CSCI-125; M07
//last touched by ryan on at 11:23pm


import java.util.ArrayList; //needed to graph it later


public class four01k extends retirementAccount {
    int salary; //starting salary
    int contribution; //percentage of salary contributed
    int raise; //percentage salary increase, yearly, if any
    int match; //percentage employer will match
    int salaryMatch; // salary limit for employer match.

    //constructors, default and then fully loaded
    public four01k() {
        super(30, 65,0,0,7,false);
        this.salary = 75000;
        this.contribution = 4;
        this.raise = 5;
        this.match = 10;
        this.salaryMatch = 10;
    }

    public four01k (int age, int retAge, double startBal, double endBal, int percent, boolean taxable, int salary, int contribution,int raise, int match, int salaryMatch) {
        super(age, retAge, startBal, endBal, percent, taxable);
        this.salary = salary;
        this.contribution = contribution;
        this.raise = raise;
        this.match = match;
        this.salaryMatch = salaryMatch;
    }

    @Override
    public double dCalculateReturn(){
        double currentBal = startBal;
        double currentSal = salary;
        int years = retAge - age;
        //math bits
        for (int i = 0; i < years; i++){
            //employee contributions
            double empCont = currentSal * (contribution / 100.0);

            //employer matching
            double matchLimit = currentSal * (salaryMatch / 100.0);
            double actualMatch = Math.min(empCont, matchLimit) * (match / 100.0);

            //addition + actual growth
            currentBal += empCont + actualMatch;
            currentBal *= (1 + (percent / 100.0));

            //raise :D
            currentSal *= (1 + (raise / 100.0));
        }
        this.endBal = currentBal;
        return endBal;
    }

    public ArrayList<Double> yearlyBalances() {
        //make a new list to hold data
        ArrayList<Double> balances = new ArrayList<>();

        double currentBal = startBal;
        double currentSal = salary;
        int years = retAge - age;

        //year 0
        balances.add(currentBal);

        for (int i = 0; i < years; i++) {
            double empCont = currentSal * (contribution / 100.0);
            double matchLimit = currentSal * (salaryMatch / 100.0);
            double actualMatch = Math.min(empCont, matchLimit) * (match / 100.0);

            currentBal += empCont + actualMatch;
            currentBal *= (1 + (percent / 100.0));
            currentSal *= (1 + (raise / 100.0));

            //adds the result to the data list
            balances.add(currentBal);
        }

        return balances;
    }

    public ArrayList<Double> yearlyBalancesMissing() {
        //make a new list to hold data
        ArrayList<Double> balances = new ArrayList<>();

        double currentBal = startBal;
        double currentSal = salary;
        int years = retAge - age;

        //year 0
        balances.add(currentBal);

        for (int i = 0; i < years; i++) {
            double empCont = currentSal * (contribution / 100.0);
            double matchLimit = currentSal * (salaryMatch / 100.0);
            double actualMatch = 0;

            currentBal += empCont + actualMatch;
            currentBal *= (1 + (percent / 100.0));
            currentSal *= (1 + (raise / 100.0));

            //adds the result to the data list
            balances.add(currentBal);
        }

        return balances;
    }

    @Override
    public void calculateReturn(){
        double currentBal = startBal;
        double currentSal = salary;
        int years = retAge - age;
        //math bits
        for (int i = 0; i < years; i++){
            //employee contributions
            double empCont = currentSal * (contribution / 100.0);

            //employer matching
            double matchLimit = currentSal * (salaryMatch / 100.0);
            double actualMatch = Math.min(empCont, matchLimit) * (match / 100.0);

            //addition + actual growth
            currentBal += empCont + actualMatch;
            currentBal *= (1 + (percent / 100.0));

            //raise :D
            currentSal *= (1 + (raise / 100.0));
        }
        this.endBal = currentBal;
        System.out.println("Your balance is $" + String.format("%.2f", this.endBal));
    }

}
