//ryan williams jr; 1373857; CSCI-125; M07
//



public class four01k extends retirementAccount {
    int salary; //starting salary
    int contribution; //percentage of salary contributed
    int raise; //percentage salary increase, yearly, if any
    int match; //percentage employer will match
    int salaryMatch; // salary limit for employer match.

    //constructors, default and then fully loaded
    public four01k() {
        super(30, 65,0,0,7,false);
        this.age = 21;
        this.retAge = 65;
        this.startBal = 0;
        this.endBal = 0;
        this.percent = 7;
        this.taxable = false;
    }

    public four01k (int age, int retAge, int startBal, int endBal, int percent, boolean taxable, int salary, int contribution,int raise, int match, int salaryMatch) {
        super(age, retAge, startBal, endBal, percent, taxable);
        this.salary = salary;
        this.contribution = contribution;
        this.raise = raise;
        this.match = match;
        this.salaryMatch = salaryMatch;
    }







    @Override
    public void calculateReturn(){

    }
}
