package R24R25;

public class PredatoryCreditCard extends CreditCard {
    // Additional instance variable
    private double apr; // annual percentage rate
   
   // Constructor for this class
    public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
    double initialBal, double rate) {
    super(cust, bk, acnt, lim, initialBal); // initialize superclass attributes
    apr = rate;
   }
   
    // A new method for assessing monthly interest charges
 // public void processMonth() {
//  if (balance > 0) { // only charge interest on a positive balance
//      double monthlyFactor = Math.pow(1 + apr, 1.0/12); // compute monthly rate
//      balance *= monthlyFactor; // assess interest
//  }
//}
   
    // Overriding the charge method defined in the superclass
	public boolean charge(double price) {
		boolean isSuccess = super.charge(price); // call inherited method
		if (!isSuccess)
			charge(5); // whe need to charge withou validation and needs a super	
	    return isSuccess;
	}
}