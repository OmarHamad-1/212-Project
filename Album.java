
public class Album {
	String name;
	String condition;
	PhotoManager manager;
	int NbComp = 0;
	
	public  Album(String name, String condition, PhotoManager manager) {
		this.name = name;
		this.condition = condition;
		this.manager = manager;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public PhotoManager getManager() {
		return this.manager;
	}
	
//	big O (num of photos x num of conditions x num of tags)
	public Linkedlist<Photo> getPhotos() {
		Linkedlist<Photo> photos = this.manager.getPhotos();
		Linkedlist<Photo> AlbumPhotos = new Linkedlist<Photo>();
		
		
		if (photos.empty() || condition == null || condition.isBlank())		
			return photos;
		
		String[] allCond = condition.trim().split("\\s*AND\\s*");
		
		photos.findFirst();
		while(!photos.last()) { 
			
			if(satisfyConditions(allCond, photos.retrieve()))
				AlbumPhotos.insert(photos.retrieve());
			
		        photos.findNext();
		}
		if(satisfyConditions(allCond, photos.retrieve()))
			AlbumPhotos.insert(photos.retrieve());
		
		return AlbumPhotos;
	}
	

	
	
// helper function for the getPhotos()
	// big O (num of conditions x num of tags) 
	public boolean satisfyConditions(String [] allCond, Photo photo) {
	    Linkedlist<String> tags = photo.getTags(); 

	    if (tags.empty()) return false; // if there is no tag then to tag satisfy Conditions

	    for (String cond : allCond) {// otherwise start with the first cond
	        boolean found = false;

	        tags.findFirst(); 
	        while (!tags.last()) { // loop on the photo tags from the beginning 
	        	NbComp++;
	        	
	            if (tags.retrieve().equals(cond)) {
	                found = true;
	                break; // Once cond in found, stop and go to the next cond 
	            }
	            tags.findNext();// else if not found keep looking
	        }

	        // check last element (loop exits before checking it)
	        if (!found) {
	            NbComp++;
	            if (tags.retrieve().equals(cond)) 
	                found = true;
	            }

	        if (!found) return false; // if this cond not found condition not satisfied
	    }

	    return true; // if none of the conditions are not found, all conditions satisfied
	}
	
	public int getNbComps() {
		return NbComp;
	}
}
