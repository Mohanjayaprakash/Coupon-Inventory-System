package Projectpackage;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class productcouponmain {
	static Scanner S;
	static int count=0;
	
	public productcouponmain()                 //Constructor of the main function
	{}
	
	public static void main(String[] args) throws IOException {               //main method where all the functions are called and executed
		productlinkedlist test1=new productlinkedlist();
		Scanner s=new Scanner(System.in);
		System.out.println("Space Allocation:");                              //Creating the array based on user's input of other use default size or user defined size
		System.out.println("Enter your choice:");
		System.out.println("1.Default size.");
		System.out.println("2.Specify size.");
		int c=s.nextInt();
		switch(c)
		{
		case 1:
			System.out.println("Array created with default size "+test1.def);
			break;
		case 2:
			System.out.println("Enter the size");
			int d=s.nextInt();
			System.out.println("Array created with "+d+" size");
		   }
		System.out.println("******************");
		test1.firstoptions();                                         //The method to enter the details 
		Productclass p1;                                                    
		while(S.hasNext())
		{
			p1=new Productclass();                                        //The data from the file is being pushed to the linkedlist
			readfile(p1);
			test1.push(p1);
			if(test1.size()==test1.def)
			{
				System.out.println("Limit exceeded!!!.....Expanding array");
			}
		}
		test1.templist = test1.list;
		while(test1.templist!=null)                                             //Displaying the contents of the list.
		{
			System.out.print(((Productclass) test1.templist.getInfo()).getCouponprovider());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getProductname());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getProductprice());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getDiscountrate());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getExpirationperiod());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getCouponstatus());
			System.out.print(" "+((Productclass) test1.templist.getInfo()).getFinalprice());
			test1.templist=test1.templist.getLink();
			System.out.println();
		}
		System.out.println();
		System.out.println("**********************");
		System.out.println("Options:");
		Productclass[] prod=new Productclass[test1.size()];      //Creating an array of type Productclass and copying the contents of the linked list to the array
		test1.templist = test1.list;
		for(int i=0;i<test1.size();i++)
		{
			prod[i]= test1.templist.info;                                           
			test1.templist=test1.templist.getLink();           //Copying the contents of the linked list to the array
		}
		test1.mainmenu(prod);
		System.out.println("**************");
		System.out.println("Thank you");
}

	public static void openfile(String link)                     //Method to open the provided file
	{
		try {
			S=new Scanner(new File(link));
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}
	
	static void readfile(Productclass p)                         //Method to read the contents of the file and calculate the final price
	{
		p.couponprovider=S.next();
		p.productname=S.next();
		p.productprice=S.nextInt();
		p.discountrate=S.nextInt();
		p.expirationperiod=S.nextInt();
		p.couponstatus=S.next();
		p.finalprice=(p.productprice*(1-((double)(p.discountrate)/100)));
	}

	public int linearsearchcp(Productclass [] arr,String target)                  //Methods to do the linear search for the parameters preferred by the user
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].couponprovider.equals(target)){count=location;}
		else{location++;count++;}}}return count;}
	
	public int linearsearchpn(Productclass [] arr,String target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].productname.equals(target)){count=location;}
		else{location++;count++;}}}return count;}
	
	public int linearsearchcs(Productclass [] arr,String target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].couponstatus.equals(target)){count=location;}
		else{location++;count++;}}}return count;}
	
	public int linearsearchpp(Productclass [] arr,int target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].productprice==target){count=location;}
		else{location++;count++;}}}return count;}
		
	public int linearsearchdp(Productclass [] arr,int target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].discountrate==target){count=location;}
		else{location++;count++;}}}return count;}
	
	public int linearsearchep(Productclass [] arr,int target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].expirationperiod==target){count=location;}
		else{location++;count++;}}}return count;}
	
	public int linearsearchfp(Productclass [] arr,int target)
	{
		int count=0;int location=0;
		for(int i=0;i<arr.length;i++){{if(arr[location].finalprice==target){count=location;}
		else{location++;count++;}}}return count;}	
	
	public int binarysearchpp(Productclass arr[], int x)                                      //method to do the binary search on the parameter specified by the user
    {
        int f = 0,l = arr.length - 1,count1=0;while (f <= l){int p = f + (l-l)/2; if (arr[p].productprice == x)
{count1++;}if (arr[p].productprice < x){f = p + 1;count1++;}else{l = p - 1;count1++;}}return count1;}
	
	public int binarysearchdp(Productclass arr[], int x)
    {
        int f = 0,l = arr.length - 1,count1=0;while (f <= l){int p = f + (l-l)/2; if (arr[p].productprice == x)
{count1++;}if (arr[p].productprice < x){f = p + 1;count1++;}else{l = p - 1;count1++;}}return count1;}
	
	public int binarysearchep(Productclass arr[], int x)
    {
        int f = 0,l = arr.length - 1,count1=0;while (f <= l){int p = f + (l-l)/2; if (arr[p].productprice == x)
{count1++;}if (arr[p].productprice < x){f = p + 1;count1++;}else{l = p - 1;count1++;}}return count1;}
		public int binarysearchfp(Productclass arr[], int x)
    {
        int f = 0,l = arr.length - 1,count1=0;while (f <= l){int p = f + (l-l)/2; if (arr[p].productprice == x)
{count1++;}if (arr[p].productprice < x){f = p + 1;count1++;}else{l = p - 1;count1++;}}return count1;}
		
}

		
