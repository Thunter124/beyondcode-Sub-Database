import java.io.Serializable;


public class AdCompany extends Subscriber implements Serializable{

	private static final long serialVersionUID = -5924130455293319486L;
	private int adsPublished;
	
	public AdCompany(String companyName, String billingAddress, int startingCopies){
		
		super(companyName, billingAddress, startingCopies);
		
	}
	
	@Override
	public void addAddress(ShippingAddress address){
		throw new UnsupportedOperationException();
	}
	
	public void incAdsPublished(){
		++adsPublished;
	}
	
	public int getAdsPublished(){
		return adsPublished;
	}
	
	
	
	
}
