package Projectpackage;

import java.io.*;
import java.util.*;

public class productlinkedlist implements productinterface{ //This class provides the methods for various tasks
	
	LLnode list;
	LLnode templist;                //Data members defined
	int n=0;
	String choices;
	Productclass[] products;
	final int def=30;
			
 productlinkedlist()                 //Contructor to inititae the list reference to null before adding elements
 { 
	list=null;
 }
	
public boolean mainmenu(Productclass[] arr) throws IOException     //The main menu is the primary menu from which the user can select the operation the user wants to perform.
{
	Scanner s = new Scanner(System.in);
	int choose=0;
	boolean bool=true;
	while(bool==true)
	{
	System.out.println("*****************");
    System.out.println("Main menu:");
	System.out.println("Enter your choice:");
	System.out.println("1.Add Coupons");
	System.out.println("2.Search coupons");
	System.out.println("3.Sort coupons");
	System.out.println("4.Exit the application");
	choose=s.nextInt();
	switch(choose)
	{
	case 1:
		System.out.println("****************");                 //Adding coupons
		firstoptions();
		bool=true;
		break;
	case 2:
		System.out.println("***************");                  //Seraching for the coupons based on the user requirements.
		searchingelement(arr);
		break;
	case 3:	
		System.out.println("***************");                  //Sorting and displaying the list based on user defined parameter.
		sortlist(arr);
		bool=true;
		break;
	case 4:
		bool=false;
		break;
	}
	}
	return bool;
}

public void firstoptions() throws IOException                  //This method allows the user to upload the file pr enter the details manually.
{
 int option=0;
 String path = "";
 Scanner s = new Scanner(System.in);
 System.out.println("Data feeding:");
 System.out.println("Enter your choice:");
 System.out.println("1.Enter details manually.");
 System.out.println("2.Upload a file");
 while(!s.hasNextInt())
 {
	 System.out.println("Enter a valid choice");
	 s.next();
 }
 option=s.nextInt(); 
 switch(option)
 {
 case 1:
	 morecoupons();
	 break;
 case 2:
	 System.out.println("File path:");
	 path=s.next();
	 productcouponmain prod1=new productcouponmain();
	 prod1.openfile(path);
	 break;
 }
 }


public boolean sortlist(Productclass[] arr)                      //This method sorts the list based on user requirement. The user can sort the list based on any of the parameters.
{                                                                // The user when specifying the choice inputs the parameter on which he wants to sort the list 
 	int sortoption=0;                                            //The underlying the system runs the code based on the case selected and then displays the output.
	Scanner s=new Scanner(System.in);
	boolean bool=true;
	while(bool==true)
	{
	productcouponmain pp1=new productcouponmain();
	System.out.println("Sorting Menu:");
	System.out.println("How do you want to sort the list");
	System.out.println("1.Coupon Provider");
	System.out.println("2.Product");
	System.out.println("3.Product price");
	System.out.println("4.Discount percentage");
	System.out.println("5.Expiration period");
	System.out.println("6.Coupon status");
	System.out.println("7.Final price");
	System.out.println("8.Exit to Main Menu");
	sortoption=s.nextInt();
	Productclass pro1=new Productclass();
	switch(sortoption)
	{
	case 1:
		System.out.println("**********************");
		ArrayList<Productclass> st=new ArrayList<Productclass>(Arrays.asList(arr));		
		Collections.sort(st, new Comparator<Productclass>() {
			   public int compare(Productclass b1, Productclass b2) {
			      return  b1.couponprovider.compareTo(b2.couponprovider);}});
				System.out.println("couponprovider productname productprice  discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:st)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
	    break;
	    
	case 2:
		System.out.println("**********************");
		ArrayList<Productclass> st1=new ArrayList<Productclass>(Arrays.asList(arr));		
		Collections.sort(st1, new Comparator<Productclass>() {
			   public int compare(Productclass b1, Productclass b2) {
			      return  b1.productname.compareTo(b2.productname);}});	
		System.out.println("couponprovider productname productprice  discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:st1)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
	    break;
	    
	case 3:
		System.out.println("**********************");
		bubblesortintpp(arr);
		System.out.println("couponprovider productname productprice discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:arr)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
		break;
		
	case 4: 
		System.out.println("**********************");
		bubblesortintdp(arr);
		System.out.println("couponprovider productname productprice discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:arr)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
		break;
	
	case 5:
		System.out.println("**********************");
		bubblesortintep(arr);
		System.out.println("couponprovider productname productprice  discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:arr)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
		break;
	
	case 6:
		System.out.println("**********************");
		ArrayList<Productclass> st2=new ArrayList<Productclass>(Arrays.asList(arr));		
		Collections.sort(st2, new Comparator<Productclass>() {
			   public int compare(Productclass b1, Productclass b2) {
			      return  b1.couponstatus.compareTo(b2.couponstatus);}});	
		System.out.println("couponprovider productname productprice  discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:st2)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
		break;
		
	case 7:
		System.out.println("**********************");
		bubblesortintfp(arr);
		System.out.println("couponprovider productname productprice  discountrate expirationperiod couponstatus   finalprice");
		for(Productclass x:arr)
		{
			printRowOutlined(x.couponprovider,x.productname,x.productprice,x.discountrate,x.expirationperiod,x.couponstatus,x.finalprice);
		}
		bool=true;
	    break;
	
	case 8:
		bool=false;
	    break;
}
	}
return bool;
}

public void bubblesortintpp(Productclass[] arr)                   //This method sorts the Productprice in Ascending and descending order based on user choice
{ System.out.println("How do you want to sort the list");
	System.out.println("1.Ascending.");
    System.out.println("2.Descending.");
    Scanner s=new Scanner(System.in);
    int d=s.nextInt();
    int n=arr.length;
    int temp=0;
    switch(d) { case 1: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) {
    if (arr[j-1].productprice > arr[j].productprice) { temp = arr[j-1].productprice;
    arr[j-1].productprice=arr[j].productprice; arr[j].productprice = temp;}}}break;
   case 2: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) { if (arr[j-1].productprice < arr[j].productprice) 
    { temp = arr[j-1].productprice; arr[j-1].productprice= arr[j].productprice; arr[j].productprice = temp; }}}break;}}


public void bubblesortintdp(Productclass[] arr)                  //This method sorts the Discount value in Ascending and descending order based on user choice
{ System.out.println("How do you want to sort the list");
	System.out.println("1.Ascending.");
    System.out.println("2.Descending.");
    Scanner s=new Scanner(System.in);
    int d=s.nextInt();
    int n=arr.length;
    int temp=0;
    switch(d) { case 1: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) {
    if (arr[j-1].discountrate > arr[j].discountrate) { temp = arr[j-1].discountrate;
    arr[j-1].discountrate=arr[j].discountrate; arr[j].discountrate = temp;}}}break;
   case 2: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) { if (arr[j-1].discountrate < arr[j].discountrate) 
    { temp = arr[j-1].discountrate; arr[j-1].discountrate= arr[j].discountrate; arr[j].discountrate = temp; }}}break;}}

public void bubblesortintep(Productclass[] arr)                  //This method sorts the Expiration value in Ascending and descending order based on user choice
{ System.out.println("How do you want to sort the list");
	System.out.println("1.Ascending.");
    System.out.println("2.Descending.");
    Scanner s=new Scanner(System.in);
    int d=s.nextInt();
    int n=arr.length;
    int temp=0;
    switch(d) { case 1: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) {
    if (arr[j-1].expirationperiod > arr[j].expirationperiod) { temp = arr[j-1].expirationperiod;
    arr[j-1].expirationperiod=arr[j].expirationperiod; arr[j].expirationperiod = temp;}}}break;
   case 2: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) { if (arr[j-1].expirationperiod < arr[j].expirationperiod) 
    { temp = arr[j-1].expirationperiod; arr[j-1].expirationperiod= arr[j].expirationperiod; arr[j].expirationperiod = temp; }}}break;}}

public void bubblesortintfp(Productclass[] arr)                   //This method sorts the Finalprice in Ascending and descending order based on user choice
{ System.out.println("How do you want to sort the list");
	System.out.println("1.Ascending.");
    System.out.println("2.Descending.");
    Scanner s=new Scanner(System.in);
    int d=s.nextInt();
    int n=arr.length;
    double temp=0;
    switch(d) { case 1: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) {
    if (arr[j-1].finalprice > arr[j].finalprice) { temp = arr[j-1].finalprice;
    arr[j-1].finalprice=arr[j].finalprice; arr[j].finalprice = temp;}}}break;
   case 2: for (int i = 0; i <n; i++) { for (int j = 1; j <n-i; j++) { if (arr[j-1].finalprice < arr[j].finalprice) 
    { temp = arr[j-1].finalprice; arr[j-1].finalprice= arr[j].finalprice; arr[j].finalprice = temp; }}}break;}}

public boolean searchingelement(Productclass[] arr)                   //Searching element is used when the user wants to search for an element inside te CIS
{                                                                     //The user initially selects the parameter of choice on what he wants to search.
	int choices;                                                      //Then the user should mention the value which he wants to search.
    Scanner s=new Scanner(System.in);
    productcouponmain pro2=new productcouponmain();
    Productclass prod3=new Productclass();
    boolean bool=true;
    while(bool==true)
    {
    	System.out.println("Search menu");
    System.out.println("Which parameter do you want to search:");
    System.out.println("1.Coupon Provider");
    System.out.println("2.Product");
	System.out.println("3.Product price");
	System.out.println("4.Discount percentage");
	System.out.println("5.Expiration period");
	System.out.println("6.Coupon status");
	System.out.println("7.Final price");
	System.out.println("8.Exit to Main Menu");
	choices=s.nextInt();
	switch(choices)
	{
	case 1:
		System.out.println("**********************");
	System.out.println("Enter the value to search:");
	String coup=s.next();
	pro2.linearsearchcp(arr,coup);
	System.out.println("Target found after "+pro2.linearsearchcp(arr,coup)+" searches in the list");
	bool=true;
	break;
		
	case 2:
		System.out.println("**********************");
		System.out.println("Enter the value to search:");
		String coup1=s.next();
		pro2.linearsearchpn(arr,coup1);
		System.out.println("Target found after "+pro2.linearsearchpn(arr,coup1)+" searches in the list");
		bool=true;
		break;
	
	case 3:
		System.out.println("**********************");
		System.out.println("Enter the value to search.");
	    int pric=s.nextInt();
	    pro2.linearsearchpp(arr,pric);
	    bubblesortintpp(arr);
	    pro2.binarysearchpp(arr, pric);
		System.out.println("Target found after "+pro2.linearsearchpp(arr,pric)+" linear searches and "+pro2.binarysearchpp(arr, pric)+" binary searches in the list");
		bool=true;
		break;
		
	case 4:
		System.out.println("**********************");
		System.out.println("Enter the value to search.");
	    int pric1=s.nextInt();
	    bubblesortintdp(arr);
	    pro2.binarysearchdp(arr, pric1);
		System.out.println("Target found after "+pro2.linearsearchdp(arr,pric1)+" linear searches and "+pro2.binarysearchdp(arr, pric1)+" binary searches in the list");
		bool=true;
		break;
		
	case 5:
		System.out.println("**********************");
		System.out.println("Enter the value to search.");
	    int pric2=s.nextInt();
	    pro2.binarysearchpp(arr, pric2);
		System.out.println("Target found after "+pro2.linearsearchep(arr,pric2)+" linear searches and "+pro2.binarysearchep(arr, pric2)+" binary searches in the list");
		bool=true;
		break;
		
	case 6:
		System.out.println("**********************");
		System.out.println("Enter the value to search:");
		String coup3=s.next();
		pro2.linearsearchcs(arr,coup3);
		System.out.println("Target found after "+pro2.linearsearchcs(arr,coup3)+" searches in the list");
		bool=true;
		break;
				
	case 7:
		System.out.println("**********************");
		System.out.println("Enter the value to search.");
	    int pric3=s.nextInt();
	    bubblesortintfp(arr);
	    pro2.binarysearchpp(arr, pric3);
		System.out.println("Target found after "+pro2.linearsearchfp(arr,pric3)+" linear searches and "+pro2.binarysearchfp(arr, pric3)+" binary searches in the list");
		bool=true;
		break;
		
	case 8:
		bool=false;
		break;
	}
}
    return bool;
}

//This method prints the output of the searches nd sorting methods in proper order

public  void printRowOutlined(String couponprovider,String productname,int productprice,int discountrate,int expirationperiod,String couponstatus,double finalprice) 
{
	System.out.printf("%10s", couponprovider);
    System.out.printf("%10s", productname);
    System.out.printf("%15d", productprice);
    System.out.printf("%15d", discountrate);
    System.out.printf("%15d", expirationperiod);
    System.out.printf("%15s", couponstatus);
    System.out.printf("%15f", finalprice);
    System.out.println();
}

// This method is to ask the user to add more data into the CIS either manually or uplaoding a file.
public boolean morecoupons() throws IOException
{
 Scanner s = new Scanner(System.in);
 boolean bool = true;
 while(bool==true)
 {
 String choice ="";
 System.out.println("Adding more coupons:");
  System.out.println("Do you wish to add coupons:");
  choice=s.next();
  int c,d,e;
  String a,b,f;
  choices=choice.toUpperCase();
  switch(choices)
 {
  case "YES":
	 System.out.println("Enter the Coupon provider to add (Alphabets only):");
	 a=s.next();
	  if(a.length()>20)
	  {
		  System.out.println("Limit exceeded!!!!!");
		  System.out.println("Enter lesser than 20 characters to proceed");
		  s.next();
		}
	  System.out.println("Enter the Product name to add (Alphabets only):");
	 b=s.next();
	 if(b.length()>20)
	  {
		  System.out.println("Limit exceeded!!!!!");
		  System.out.println("Enter lesser than 20 characters to proceed");
		  s.next();
	 }
	 do {
		 System.out.println("Enter the Product price to add :");
		 while(!s.hasNextInt())
		 {
			 System.out.println("Price should be in numbers!");
			 s.next();
		 }
		 c=s.nextInt();
	 }while(c<=0);
	 do {
		 System.out.println("Enter the Discount rate to add:");
		 while(!s.hasNextInt())
		 {
			 System.out.println("Discount rate should be in numbers!");
			 s.next();
		 }
		 d=s.nextInt();
	 }while(d<=0);
	 do {
		 System.out.println("Enter the Expiration period to add:");
		 while(!s.hasNextInt())
		 {
			System.out.println("Expiration period should be in numbers (months)!");
			s.next();
		 }
		 e=s.nextInt();
	 }while(e<=0);
	 System.out.println("Enter the Coupon status to add (Alphabets only):");
	 f=s.next();	 
	 BufferedWriter write=new BufferedWriter(new FileWriter("products1.txt",true));     //Bufferedwriter updates the data input'ed by the user to the existing file of contents. 
	 {
	 write.newLine();
	 write.write(a);
	 write.append(" ");
	 write.write(b);
	 write.write(" "+c);
	 write.write(" "+d);
	 write.write(" "+e);
	 write.append(" ");
	 write.write(f);
	 write.close();
	 System.out.println("List updated");
	 n++;
	 bool = true;
	 break;
	 }	  
case "NO":
	 System.out.println("Thank you");
	 bool=false;
	 break;
	 }  	
  }
 return bool;
}	

public void push(Productclass element)              //This is used to push the elements into the linked list.
{
	LLnode prod1=new LLnode(element);
	if(isEmpty())	
	{
	list=prod1;	
	}
	else
	{
		templist=list;
		while(templist.getLink()!=null)		
		templist=templist.getLink();		
		if(templist.getLink()==null)
		{
		templist.setLink(prod1);
		templist=prod1;
		}
	}
  n++;
}

public Productclass remove()                       //This is to remove the elements from the list
{
	Productclass temp=(Productclass) list.getInfo();
	list=list.getLink();
	return temp;
}

public boolean isFull()                            //Checks if the list is full
{
	return false;
}

public boolean isEmpty()                           //Checks if the list is empty
{
	if(list==null)
	return true;
	else
	return false;
}

public int size()                                 //Provides the size of the list
{
	return n;
}
}
