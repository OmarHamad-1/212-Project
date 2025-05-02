public class PhotoManager{

LinkedList<Photo> Photos;  
  
  public PhotoManager(){
    Photos = new LinkedList<Photo>();
  }

  public LinkedList<Photo> getPhotos(){
	  return Photos;
  }

  public void addPhoto(Photo p){
    if (Photo_Exist(p.path)) {
	        	System.out.println("Already exist!");
	        	return;
	        }
	        Photos.insert(p);

  }

  public void deletePhoto(String path){
    if (!Photo_Exist(path)) {
	        	System.out.println("Photo is not exist!");
	   		return;
	           }
	        
	        Photos.remove();
  }

  public boolean Photo_Exist(String path){
    String p =path;
	        
	    	if (Photos.empty()) 
	        	return false;
	        Photos.findFirst();
	        while (!Photos.last()) {
	            if (Photos.retrieve().path.equals(p)) 
	                return true;
	            Photos.findNext();
	        }
	        if (Photos.retrieve().path.equals(p)) 
	            return true;
	        return false;
  }
  
}
