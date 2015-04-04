import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Article implements Serializable {

	private static final long serialVersionUID = -8959608078712812022L;
	private List<Author> authors;
	private String articleName;
	
	public Article(String name){
		articleName = name;
		authors = new ArrayList<Author>();
	}
	
	public List<Author> getAuthors(){
		return authors;
	}
	
	public void addAuthor(Author author){
		authors.add(author);
	}
	
	public String getArticleName(){
		return articleName;
	}
	
	public void setArticleName(String name){
		articleName = name;
	}
}
