package com.beyondcode.core;
import java.io.Serializable;


public class ShippingAddress implements Serializable{


	private static final long serialVersionUID = -5421644355485110154L;
	private String address;
	private String name;
	private int copiesPerIssue;
	
	public ShippingAddress(String name, String address, int copiesPerIssue){
        this.name = name;
        this.address = address;
        if(copiesPerIssue < 1)
        	copiesPerIssue = 1;
        this.copiesPerIssue = copiesPerIssue;
    }

	public String getName(){
        return name;
    }
	public void setName(String name){
        this.name = name;
    }
    
	public String getAddress(){
        return address;
    }
	public void setAddress(String address){
        this.address = address;
    }
    
	public int getCopiesPerIssue(){
        return copiesPerIssue;
    }
	public void setCopiesPerIssue(int copiesPerIssue){
        this.copiesPerIssue = copiesPerIssue;
    }
    
    public String toString(){
    	return address;
    }
	
}
