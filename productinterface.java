package Projectpackage;

public interface productinterface { //This interface is used to provide the basic and mandatory functions to used by the implementing class 
	
	public void push(Productclass element);
	public Productclass remove();
	public boolean isFull();
	public boolean isEmpty();
	public int size();
    
}