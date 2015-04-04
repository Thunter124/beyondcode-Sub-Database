import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AdCompanyDatabase implements Serializable{
	
	private static final long serialVersionUID = -8040534924097812533L;
	
	private List<AdCompany> activeCompanies;
	private List<AdCompany> inactiveCompanies;
	private List<AdCompany> doNotMailCompanies;
	
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
	

	public List<AdCompany> getActiveCompanies(){
		return activeCompanies;
	}
	
	public List<AdCompany> getInactiveCompanies(){
		return inactiveCompanies;
	}
	
	public List<AdCompany> getDoNotMailCompanies(){
		return doNotMailCompanies;
	}
	
	
	
	
	
	
}
