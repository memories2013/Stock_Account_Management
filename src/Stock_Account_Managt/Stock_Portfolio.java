package Stock_Account_Managt;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock_Portfolio {
	
	static int Num_of_Stocks;
	static ArrayList<Stock> stocksArray = new ArrayList<Stock>();
	
	public static void stock_portfolio() {
		
		Account my_account = new Account();
		StockAccount my_stockAccount = new StockAccount();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<Num_of_Stocks; i++)
		{
			int stock_num = i;
			System.out.println("Stock " +(++stock_num));
			System.out.println("Please enter the share name: ");
			String Share_Name = sc.next();
			
			System.out.println("Please enter the number of shares to be bought of the selected stock: ");
			int Num_of_Shares = sc.nextInt();
			
			System.out.println("Please enter the price of the shares to be bought: ");
			int Share_Price = sc.nextInt();
			
			Stock stock_obj = new Stock(Share_Name, Num_of_Shares, Share_Price);
			stocksArray.add(stock_obj);
			stock_obj.stock_value();
			stock_obj.total_stocks_value();
			
			//adding to the stock account
			my_stockAccount.buy(Num_of_Shares, Share_Name);
			StockAccount.CompanyShares.add(my_stockAccount);
			
		}
		
		//debiting amount from account
		my_account.debit(Stock.total_stocks_value);
		
		System.out.println(stocksArray);
		System.out.println(StockAccount.CompanyShares);
		
		System.out.println("Press 1 to sell a share or 2 to print report");
		int Num = sc.nextInt();
		if(Num==1)
		{
			System.out.println("Please enter the stock name to be sold: ");
			String Share_Name = sc.next();
			
			System.out.println("Please enter how many shares are to be sold of the selected stock: ");
			int Num_of_Shares = sc.nextInt();
			
			my_stockAccount.sell(Num_of_Shares, Share_Name);
			System.out.println(StockAccount.CompanyShares);
			
			//crediting amount to the account
			for(int i=0;i<stocksArray.size(); i++) {
				String selling_symbol = stocksArray.get(i).getShare_name();
				if(Share_Name.equals(selling_symbol)) {
					int credit_amount = Num_of_Shares*stocksArray.get(i).getShare_price();	
					my_account.credit(credit_amount);
				}
			}
		}
		
		System.out.println("Press 1 to sell a share or 2 to print report");
		Num = sc.nextInt();
		if(Num==2)
		{
			my_stockAccount.printReport();
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Number of stocks to buy: ");
		Num_of_Stocks = sc.nextInt();
		
		stock_portfolio();		
		
	}

}