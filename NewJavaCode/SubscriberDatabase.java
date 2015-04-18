import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SubscriberDatabase implements Serializable{
	
	private static final long serialVersionUID = 310181458808638633L;
	private ArrayList<Subscriber> activeSubscribers;
	private ArrayList<Subscriber> inactiveSubscribers;
	private ArrayList<Subscriber> doNotMailSubscribers;
	private ArrayList<Author> authors;
	
	
	public SubscriberDatabase(){
		activeSubscribers = new ArrayList<Subscriber>();
		inactiveSubscribers = new ArrayList<Subscriber>();
		doNotMailSubscribers = new ArrayList<Subscriber>();
		authors = new ArrayList<Author>();
	}
	
	public void addNewAuthor(Author author){
		if(authors == null)
			System.out.println("authors in null");
		authors.add(author);
	}
	
	public ArrayList<Author> getAuthors(){
		return authors;
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
	
	public ArrayList<Subscriber> getActiveSubscribers(){
		return activeSubscribers;
	}
	
	public ArrayList<Subscriber> getInactiveSubscribers(){
		return inactiveSubscribers;
	}
	
	public ArrayList<Subscriber> getDoNotMailSubscribers(){
		return doNotMailSubscribers;
	}
	

}
