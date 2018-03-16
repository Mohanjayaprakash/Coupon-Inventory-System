package Projectpackage;

public class Productclass{	//The array and linked list 
	
	String couponprovider;
	String productname;
	int productprice;
	int discountrate;
	int expirationperiod;
	String couponstatus;
	int location;
	double finalprice;
	Productclass[] products;
	final int def=20;
	
	/*Default constructor*/
	
	public Productclass()
	{}	
	
	/*Getter and setters for the data members.This can be used to set the data and get the data of the various parameters/data members*/
	
	public String getCouponprovider() {
		return couponprovider;
	}
	public void setCouponprovider(String couponprovider) {
		this.couponprovider = couponprovider;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public int getDiscountrate() {
		return discountrate;
	}
	public void setDiscountrate(int discountrate) {
		this.discountrate = discountrate;
	}
	public int getExpirationperiod() {
		return expirationperiod;
	}
	public void setExpirationperiod(int expirationperiod) {
		this.expirationperiod = expirationperiod;
	}
	public String getCouponstatus() {
		return couponstatus;
	}
	public void setCouponstatus(String couponstatus) {
		this.couponstatus = couponstatus;
	}	
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public double getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(int finalprice) {
		this.finalprice = finalprice;
	}
}
	
	
	

