package Stock_Account_Managt;

public class Account {
	
	static int balance = 100;
	
	public void debit(int debit_amount) {
		if(balance> debit_amount) {
			balance = balance - debit_amount;
			System.out.println("New Balance: " +balance);
		}
		else {
			System.out.println("Debit amount exceeded account balance");
		}
			
	}
	
	
	public void credit(int credit_amount) {
		balance = balance + credit_amount;
		System.out.println("New Balance: " +balance);
			
	}

}