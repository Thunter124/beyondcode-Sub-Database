package com.beyondcode.databases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beyondcode.core.AdCompany;


public class AdCompanyDatabase implements Serializable{
	
	private static final long serialVersionUID = -8040534924097812533L;
	
	private ArrayList<AdCompany> adCompanies;
	
	
	public AdCompanyDatabase(){
		adCompanies = new ArrayList<AdCompany>();
		
	}
	
	public void addNewCompany(AdCompany ac){
		adCompanies.add(ac);
	}
	
	
	public ArrayList<AdCompany> getAdCompanies(){
		return adCompanies;
	}
	
	
	
	
	
	
	
}
