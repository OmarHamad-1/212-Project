
public class Photo {
	String path;
	Linkedlist<String>tags;
	public Photo(String path, Linkedlist<String> tags) {
		
		this.path = path;
		this.tags = tags;
	}
	public String getPath() {
		return path;
	}
	
	public Linkedlist<String> getTags() {
		return tags;
	}
	
	
	
	
	
	
	//for testing
	public void displayPhoto () {
		System.out.println("path = "+path) ;
		System.out.print("tags are: \n");
		tags.display();
	}

}
