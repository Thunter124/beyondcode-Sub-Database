import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MagazineDatabase implements Serializable{
	
	private static final long serialVersionUID = -2392224217321253700L;
	private List<Magazine> magazines;
	
	public MagazineDatabase(){
		magazines = new ArrayList<Magazine>();
	}
	
	public boolean addMagazine(Magazine mag){
		for(Magazine m : magazines){
			if(m.getTitle() == mag.getTitle()){
				return false;
			}
		}
		magazines.add(mag);
		return true;
	}

	public boolean removeMagazine(Magazine mag){
		for(Magazine m : magazines){
			int i = 0;
			if(m.getTitle() == mag.getTitle()){
				magazines.remove(i);
				return true;
			}
			++i;
		}
		return false;
	}
	
	public List<Magazine> getMagazines(){
		return magazines;
	}
	
	public Magazine getMagazineByIssueNum(int num){
		
	}
	
	
	
}
