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

	String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    
    String getAddress(){
        return address;
    }
    void setAddress(String address){
        this.address = address;
    }
    
    int getCopiesPerIssue(){
        return copiesPerIssue;
    }
    void setCopiesPerIssue(int copiesPerIssue){
        this.copiesPerIssue = copiesPerIssue;
    }
	
}
