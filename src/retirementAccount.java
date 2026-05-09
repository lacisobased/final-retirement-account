//ryan williams jr; 1373857; CSCI-125; M07
//

abstract public class retirementAccount {
    //this will be the blueprint for the IRA and the 401k accounts
    //variables

    int age;
    int retAge;
    int input; //starting cash
    int balance; //after everything is said and done
    int percentage; //how much they grow
    boolean taxable; //to determine if its Roth


    //methods
    abstract void calculateReturn();

}
