import java.io.Serializable;


public class Ad implements Serializable{

	private static final long serialVersionUID = 5270221566768503474L;
	
	private AdCompany owner;
	private String adName;
	
	public Ad(AdCompany owner, String adName){
		this.owner = owner;
		this.adName = adName;
	}
	
	public AdCompany getOwner(){
		return owner;
	}
	
	public String getAdName(){
		return adName;
	}
	
	public void setAdName(String adName){
		this.adName = adName;
	}
	
	@Override
	public String toString(){
		return adName + "(" + owner.getBillingName() + ")";
	}
}
