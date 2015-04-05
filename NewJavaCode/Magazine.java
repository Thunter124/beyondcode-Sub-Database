import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Magazine implements Serializable{

	private static final long serialVersionUID = 7873871534936897269L;
	private String title;
	private int issueNum;
	private int volumeNum;
	private List<Article> articles;
	private List<Ad> ads;
	
	public Magazine(String title, int volumeNum, int issueNum){
		this.title = title;
		this.volumeNum = volumeNum;
		this.issueNum = issueNum;
		articles = new ArrayList<Article>();
	}
	
	//returns true if the article was added. returns false if the article was a duplicate
	//and not added
	public boolean addArticle(Article article){
		for(Article a : articles){
			if(a.getArticleName() == article.getArticleName()){
				return false;
			}
		}
		articles.add(article);
		return true;
	}
	
	//returns true if the article was removed, and false if it was not in the list
	public boolean removeArticle(Article article){
		int i = 0;
		for(Article a: articles){
			if(a.getArticleName() == article.getArticleName()){
				articles.remove(i);
				return true;
			}
			++i;
		}
		return false;
	}
	
	public List<Article> getArticles(){
		return articles;
	}
	
	//returns true if the ad was added. returns false if the ad was a duplicate
	//and not added
	public boolean addAd(Ad ad){
		for(Ad a : ads){
			if(a.getAdName() == ad.getAdName()){
				return false;
			}
		}
		ads.add(ad);
		return true;
	}
	
	//returns true if the article was removed, and false if it was not in the list
	public boolean removeAd(Ad ad){
		int i = 0;
		for(Ad a : ads){
			if(a.getAdName() == ad.getAdName()){
				ads.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Ad> getAds(){
		return ads;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setIssueNum(int num){
		issueNum = num;
	}
	
	public int getIssueNum(){
		return issueNum;
	}
	
	public void setVolumeNum(int num){
		volumeNum = num;
	}
	
	public int getVolumeNum(){
		return volumeNum;
	}
	
	@Override
	public String toString(){
		return "Vol. " + volumeNum + " Iss. " + issueNum + ", " + title;
	}
	
	
}
