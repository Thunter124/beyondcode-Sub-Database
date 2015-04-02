import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Subscriber implements Serializable{


	private static final long serialVersionUID = 1786967556061021051L;
	private List<ShippingAddress> addresses;
	private int copiesRemaining;
	private String billingName;
	private String billingAddress;
	
	Subscriber(ShippingAddress address, String billingName, String billingAddress, int startingCopies){
		addresses = new ArrayList<SAChippingAddress>();
		addresses.add(address);
		 
		this.billingName = billingName;
		this.billingAddress = billingAddress;
		this.copiesRemaining = startingCopies;
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
    
    public void increaseCopRemBy(int val){
         this.copiesRemaining += val;
    }
    
    public void incCopiesRemaining(){
         copiesRemaining++;
    }
    
    public boolean decCopiesRemaining(){
         return --copiesRemaining == 0;
    }
    
    void setBillingAddress(String billingAddress){
         this.billingAddress = billingAddress;
    }

    String getBillingAddress(){
         return billingAddress;
    }

    void setBillingName(String billingName){
         this.billingName = billingName;
    }

    String getBillingName(){
         return billingName;
    }

    //to-do
    List<String> getShippingLables(){
    	return null;
    }
	
	
}
