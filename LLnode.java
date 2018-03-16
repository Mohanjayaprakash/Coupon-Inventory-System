package Projectpackage;

public class LLnode //This class is used to create the Linked list node for the linked list
{
Productclass info;
LLnode link;

//Constructor for creating the node
LLnode(Productclass info)
{
   this.info=info;
   LLnode link=null;
}

//getters and setters for getting and setting the info and link
public Productclass getInfo() {
	return info;
}

public void setInfo(Productclass info) {
	this.info = info;
}

public LLnode getLink() {
	return link;
}

public void setLink(LLnode link) {
	this.link = link;
}
}

