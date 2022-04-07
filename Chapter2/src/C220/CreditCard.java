package C220;

public class CreditCard {
    // Instance variables:
    private String customer; // name of the customer (e.g., ”John Bowman”)
    private String bank; // name of the bank (e.g., ”California Savings”)
    private String account; // account identifier (e.g., ”5391 0375 9387 5309”)
    private int limit; // credit limit (measured in dollars)
    protected double balance; // current balance (measured in dollars)
    // Constructors:
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }
    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0); // use a balance of zero as default
    }
    // Accessor methods:
    public String getCustomer() {
        return customer;
    }
    public String getBank() {
        return bank;
    }
    public String getAccount() {
        return account;
    }
    public int getLimit() {
        return limit;
    }
    
    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    public double getBalance() {
        return balance;
    }
    // Update methods:
    public boolean charge(double price) { // make a charge
        if (price + balance > limit) // if charge would surpass limit
            return false; // refuse the charge
        // at this point, the charge is successful
        balance += price; // update the balance
        return true; // announce the good news
    }
    public void makePayment(double amount) { // make a payment
    	if(amount < 0) {
    		return;
    	}
        balance -= amount;
    }

    public void printSummary() {
        System.out.println("Customer = " + this.customer);
        System.out.println("Bank = " + this.bank);
        System.out.println("Account = " + this.account);
        System.out.println("Balance = " + this.balance); 
        System.out.println("Limit = " + this.limit); 
    }
    
    public String ToString() {
    	String creditCardString =  "Customer = " + this.customer + "\n";
      	creditCardString =  creditCardString + "Bank = " + this.bank + "\n";
    	creditCardString =  creditCardString + "Account = " + this.account + "\n";
    	creditCardString =  creditCardString + "Balance = " + this.balance + "\n";
    	creditCardString =  creditCardString + "Limit = " + this.limit + "\n";
    	
    	return creditCardString;
    }



    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings",
            "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal",
            "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance",
            "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(5000 * val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }

        for (CreditCard card: wallet) {
        	//card.printSummary();
            System.out.println(card.ToString());
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }
}