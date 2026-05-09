//ryan williams jr; 1373857; CSCI-125; M07
//

abstract public class retirementAccount {
    //this will be the blueprint for the IRA and the 401k accounts
    //variables
    int age;
    int retAge;
    double startBal; //starting cash
    double endBal; //after everything is said and done
    int percent; //how much they grow
    boolean taxable; //to determine if its Roth

    //constructor to avoid future headaches
    public retirementAccount(int age, int retAge, double startBal, double endBal, int percent, boolean taxable) {
        this.age = age;
        this.retAge = retAge;
        this.startBal = startBal;
        this.endBal = endBal;
        this.percent = percent;
        this.taxable = taxable;
    }


    //methods
    abstract void calculateReturn();

}
