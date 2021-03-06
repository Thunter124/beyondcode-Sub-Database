package com.beyondcode.databases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beyondcode.core.Magazine;


public class MagazineDatabase implements Serializable{
	
	private static final long serialVersionUID = -2392224217321253700L;
	private ArrayList<Magazine> inProgressMagazines;
	private ArrayList<Magazine> publishedMagazines;
	
	public MagazineDatabase(){
		inProgressMagazines = new ArrayList<Magazine>();
		publishedMagazines = new ArrayList<Magazine>();
	}
	
	public boolean addMagazineToInProgress(Magazine mag){
		for(Magazine m : inProgressMagazines){
			if(m.getTitle() == mag.getTitle()){
				return false;
			}
		}
		inProgressMagazines.add(mag);
		return true;
	}
	

	public boolean addMagazineToPublished(Magazine mag){
		for(Magazine m : publishedMagazines){
			if(m.getTitle() == mag.getTitle()){
				return false;
			}
		}
		publishedMagazines.add(mag);
		return true;
	}

	public boolean removeMagazineFrominProgress(Magazine mag){
		for(Magazine m : inProgressMagazines){
			int i = 0;
			if(m.getTitle() == mag.getTitle()){
				inProgressMagazines.remove(i);
				return true;
			}
			++i;
		}
		return false;
	}
	
	public ArrayList<Magazine> getInProgressMagazines(){
		return inProgressMagazines;
	}
	
	public ArrayList<Magazine> getPublishedMagazines(){
		return publishedMagazines;
	}
	
	public Magazine getMagazineByVolumeIssue(int vol, int issue){
		
		for(Magazine m : publishedMagazines){
			if(m.getVolumeNum() == vol && m.getIssueNum() == issue){
				return m;
			}
		}
		for(Magazine m : inProgressMagazines){
			if(m.getVolumeNum() == vol && m.getIssueNum() == issue){
				return m;
			}
		}
		return null;
	}
	
	
	
}
