import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AdCompanyDatabase implements Serializable{
	
	private static final long serialVersionUID = -8040534924097812533L;
	
	private ArrayList<AdCompany> activeCompanies;
	private ArrayList<AdCompany> inactiveCompanies;
	private ArrayList<AdCompany> doNotMailCompanies;
	
	public AdCompanyDatabase(){
		activeCompanies = new ArrayList<AdCompany>();
		inactiveCompanies = new ArrayList<AdCompany>();
		doNotMailCompanies = new ArrayList<AdCompany>();
	}
	
	public void addNewCompany(AdCompany ac){
		activeCompanies.add(ac);
	}
	
	public boolean moveCompanyToDoNotMail(AdCompany ac){
		if(inactiveCompanies.contains(ac)){
			doNotMailCompanies.add(ac);
			inactiveCompanies.remove(ac);
			return true;
		}
		return false;
	}
	

	public ArrayList<AdCompany> getActiveCompanies(){
		return activeCompanies;
	}
	
	public ArrayList<AdCompany> getInactiveCompanies(){
		return inactiveCompanies;
	}
	
	public ArrayList<AdCompany> getDoNotMailCompanies(){
		return doNotMailCompanies;
	}
	
	
	
	
	
	
}
