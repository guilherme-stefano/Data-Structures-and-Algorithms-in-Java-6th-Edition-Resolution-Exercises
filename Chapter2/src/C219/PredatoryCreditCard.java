package C219;

import java.sql.Date;

public class PredatoryCreditCard extends CreditCard {
// Additional instance variable
private double apr; // annual percentage rate
private int charges = 0;
private int chargesLimit = 1;
private double minimumMountlyPayment = 10;
private double minimumMountlyPaymentFee = 10;
private double totalPayments = 0;

public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
   double initialBal, double rate) {
   super(cust, bk, acnt, lim, initialBal); // initialize superclass attributes
   apr = rate;
}

// A new method for assessing monthly interest charges
public void processMonth() {
	double balance = this.getBalance();
   if (balance > 0) { // only charge interest on a positive balance
	   double monthlyFactor = Math.pow(1 + apr, 1.0/12); // compute monthly rate
	   balance *= monthlyFactor; // assess interest
	   if(charges > chargesLimit ) {
		   setBalance(balance + (charges - chargesLimit));
	   }
	   
	   if(totalPayments < minimumMountlyPayment) {
		  setBalance( balance - minimumMountlyPaymentFee);
	   }
   }
}
public void makePayment(double amount) { 
	super.makePayment(amount);
	 totalPayments = totalPayments + amount;
}

// Overriding the charge method defined in the superclass
public boolean charge(double price) {
   charges++;
   boolean isSuccess = super.charge(price); // call inherited method
   if (!isSuccess)
	  
	  setBalance(getBalance() + 5); // assess a $5 penalty
	   return isSuccess;
   }
}
