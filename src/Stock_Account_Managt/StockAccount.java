package Stock_Account_Managt;

import java.time.LocalDate;
import java.util.ArrayList;

public class StockAccount {
	
	static ArrayList<StockAccount> CompanyShares = new ArrayList<StockAccount>();
	
	int balance;
	double valueOf() {
		return balance;
	}
	
	
	int shares;
	LocalDate datetime;
	String symbol;
	
	void buy(int amount, String symbol) {
		this.shares = amount;
		this.symbol = symbol;
		System.out.println("new " +symbol + " stock bought worth " +amount +" shares");
		this.datetime = LocalDate.now();
	}
	
	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	void sell(int amount, String symbol) {
		this.shares = amount;
		this.symbol = symbol;
		
		for(int i=0;i<CompanyShares.size(); i++) {
			String selling_symbol = CompanyShares.get(i).getSymbol();
			if(symbol.equals(selling_symbol)) {
				System.out.println("new " +symbol + " stock is sold worth " +amount +" shares");
				this.datetime = LocalDate.now();
				
				//removing/selling shares of the selected stock
				if(CompanyShares.get(i).shares>amount)
					CompanyShares.get(i).shares = CompanyShares.get(i).shares - amount;
				else if(CompanyShares.get(i).shares == amount)
					CompanyShares.remove(i);
			}
			else
				System.out.println("This stock does not exit ");
			}
	}
	
	
	void printReport() {
		
		for(int i=0;i<Stock_Portfolio.stocksArray.size(); i++) {
			System.out.println(Stock_Portfolio.stocksArray.get(i));
			System.out.println(CompanyShares.get(i).datetime);
		}
	}
	
	
	@Override
	public String toString() {
		return "StockAccount [symbol=" + symbol + ", shares=" + shares + ", transaction date =" + datetime + "]";
	}
	

}