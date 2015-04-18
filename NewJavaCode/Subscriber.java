import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Subscriber implements Serializable{


	private static final long serialVersionUID = 1786967556061021051L;
	protected List<ShippingAddress> addresses;
	protected int copiesRemaining;
	protected String billingName;
	protected String billingAddress;
	
	public Subscriber(String billingName, String billingAddress, int startingCopies){
		 
		this.billingName = billingName;
		this.billingAddress = billingAddress;
		if(startingCopies < 0)
			startingCopies = 0;
		this.copiesRemaining = startingCopies;
		addresses = new ArrayList<ShippingAddress>();
	 }
	
	public void addAddress(ShippingAddress address){
		addresses.add(address);
	}
	public List<ShippingAddress> getAddresses(){
		return addresses;
	}

    public int getCopiesRemaining() {
        return copiesRemaining;
    }
    
    public void increaseCopiesRemainingBy(int val){
         this.copiesRemaining += val;
    }
    
    public void incCopiesRemaining(){
         copiesRemaining++;
    }
    
    public boolean decCopiesRemaining(){
         return --copiesRemaining == 0;
    }
    
    public void setBillingAddress(String billingAddress){
         this.billingAddress = billingAddress;
    }

    public String getBillingAddress(){
         return billingAddress;
    }

    public void setBillingName(String billingName){
         this.billingName = billingName;
    }

    public String getBillingName(){
         return billingName;
    }

    //to-do
    List<String> getShippingLables(){
    	return null;
    }
    public String toString(){
    	return billingName;
    }
	
	
}
