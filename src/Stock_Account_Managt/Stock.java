package Stock_Account_Managt;

public class Stock {
	
	String share_name;
	int num_of_shares;
	int share_price;
	int stock_value = 0;
	static int total_stocks_value = 0;
	
	public Stock(String share_name, int num_of_shares, int share_price) {
		this.share_name = share_name;
		this.num_of_shares = num_of_shares;
		this.share_price = share_price;
	}
	
	public String getShare_name() {
		return share_name;
	}

	public void setShare_name(String share_name) {
		this.share_name = share_name;
	}

	public int getNum_of_shares() {
		return num_of_shares;
	}

	public void setNum_of_shares(int num_of_shares) {
		this.num_of_shares = num_of_shares;
	}

	public int getShare_price() {
		return share_price;
	}

	public void setShare_price(int share_price) {
		this.share_price = share_price;
	}

	
	public int stock_value() {
		stock_value = share_price*num_of_shares;
		return stock_value;
	}
	
	public int total_stocks_value() {
		total_stocks_value = stock_value+total_stocks_value;
		return total_stocks_value;
	}

	@Override
	public String toString() {
		return "Stock [share_name=" + share_name + ", num_of_shares=" + num_of_shares + ", share_price=" + share_price
				+ ", stock_value()=" + stock_value + ", total_stocks_value()=" + total_stocks_value + "]";
	}
	
	
}