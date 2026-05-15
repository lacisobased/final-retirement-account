//ryan williams jr; 1373857; CSCI-125; M07
//

import javax.swing.*;
import java.awt.*;

public class infoPane extends JPanel {
    public infoPane() {
        //layout of pane
        this.setLayout(new GridLayout(2,2,10, 10));

        JLabel roth4 = new JLabel("<html>Roth 401k: <br/>" +
                "<html> \u2058 A Roth 401(k) is an employer-sponsored retirement plan that allows employees to contribute after-tax dollars via payroll deduction, offering tax-free qualified withdrawals of both contributions and earnings in retirement.<br/>" +
                "<html> \u2058 No taxes on qualified distributions." +
                "<html> \u2058 Distributions and earnings are not taxed as long as the account has been held for at least five years and the distribution is on or after 59 ½ or due to disability or death.");

        JLabel four01k = new JLabel("<html>401k <br/>" +
                "<html> \u2058 A 401(k) is a type of that offers significant tax advantages. When you participate in a 401(k), you decide how much of each paycheck to contribute, and your employer automatically deducts this amount and invests it according to your choices. Many employers also match a percentage of your contributions, essentially providing free money toward your retirement. <br/>" +
                "<html> \u2058 Contributions are made pre-tax.<br/>" +
                "<html> \u2058 Withdrawals are taxed. Distributions before age 59 ½ may have penalties unless you meet an IRS exception.");
        //adding portion for the IRAS below
        JLabel  rothI = new JLabel("<html>Roth IRA: <br/>" +
                "<html> \u2058 A Roth IRA is funded with after-tax dollars, allowing both growth and qualified withdrawals to remain tax-free after age 59½ and after holding the IRA for at least five years. <br/>" +
                "<html> \u2058 You can withdraw your contributions at any time tax-free and without penalty, even if you haven’t met the five-year or age requirements."
        );
        JLabel ira = new JLabel("<html>Traditional IRA: <br/>" +
                "<html> \u2058 Traditional IRAs allow you to save on income taxes now and pay them later in retirement, when you could be in a lower tax bracket and therefore owe less in taxes. <br/>" +
                "<html> \u2058 Any investments in your IRA grow tax-deferred until withdrawal. <br/>" +
                "<html> \u2058 Withdrawals of earnings and deductible contributions are taxed like any other income you earn in the year they're taken, if they're qualified.");

        //add labels and whatnot
        this.add(rothI);
        this.add(ira);
        this.add(roth4);
        this.add(four01k);
    }
}
