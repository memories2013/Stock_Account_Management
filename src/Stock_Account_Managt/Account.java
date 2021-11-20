package Stock_Account_Managt;

public class Account {
	
	int balance = 100;
	
	public void debit(int debit_amount) {
		if(this.balance> debit_amount) {
			balance = balance - debit_amount;
			System.out.println("New Balance: " +balance);
		}
		else {
			System.out.println("Debit amount exceeded account balance");
		}
			
	}

}