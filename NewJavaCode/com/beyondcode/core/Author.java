package com.beyondcode.core;

public class Author extends Subscriber{

	private static final long serialVersionUID = 1030994141561103644L;
	
	private int articlesPublished;
	
	
	public Author(String billingName, String billingAddress, int startingCopies) {
		super(billingName, billingAddress, startingCopies);
		articlesPublished = 0;
	}
	
	public int getArticlesPublished(){
		return articlesPublished;
	}
	
	public void incArticlesPublished(){
		++articlesPublished;
	}
	
	@Override
	public String toString(){
		return billingName;
	}
	

}
