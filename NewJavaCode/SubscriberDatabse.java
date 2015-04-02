import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SubscriberDatabase implements Serializable{
	
	private static final long serialVersionUID = 310181458808638633L;
	private List<Subscriber> activeSubscribers;
	private List<Subscriber> inactiveSubscribers;
	private List<Subscriber> doNotMailSubscribers;
	
	
	public SubscriberDatabase(){
		activeSubscribers = new ArrayList<Subscriber>();
		inactiveSubscribers = new ArrayList<Subscriber>();
		doNotMailSubscribers = new ArrayList<Subscriber>();
	}
	
	public void addNewSubscriber(Subscriber sub){
		activeSubscribers.add(sub);
	}
	
	public boolean moveSubToDoNotMail(Subscriber sub){
		if(inactiveSubscribers.contains(sub)){
			doNotMailSubscribers.add(sub);
			inactiveSubscribers.remove(sub);
			return true;
		}
		return false;
	}
	
	public List<Subscriber> getActiveSubscribers(){
		return activeSubscribers;
	}
	
	public List<Subscriber> getInactiveSubscribers(){
		return inactiveSubscribers;
	}
	
	public List<Subscriber> getDoNotMailSubscribers(){
		return doNotMailSubscribers;
	}
	

}
