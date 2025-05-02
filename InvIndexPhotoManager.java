
public class InvIndexPhotoManager {
	BST<LinkedList<Photo>> index;
	BST<Photo> PhotosBST;
    
    public InvIndexPhotoManager() {
        index = new BST<LinkedList<Photo>>();
        PhotosBST = new BST<Photo>();
    }
    public void addPhoto(Photo p) {
        if (photoExists(p.path)) return;

        PhotosBST.insert(p.path, p);
        LinkedList<String> tags = p.getTags();
        if (tags.empty()) return;

        tags.findFirst();
        while (!tags.last()) {
            String oneTag = tags.retrieve();
            boolean exist = index.findKey(oneTag);
            if (!exist) {
                LinkedList<Photo> PhotosList = new LinkedList<Photo>();
                PhotosList.insert(p);
                index.insert(oneTag, PhotosList);
            } 
            else {
                LinkedList<Photo> PhotosList = index.retrieve();
                PhotosList.insert(p);
            }

            tags.findNext();
        }
        String oneTag = tags.retrieve();
        boolean exist = index.findKey(oneTag);

        if (!exist) {
            LinkedList<Photo> PhotosList = new LinkedList<Photo>();
            PhotosList.insert(p);
            index.insert(oneTag, PhotosList);
        } 
        else {
            LinkedList<Photo> PhotosList = index.retrieve();
            PhotosList.insert(p);
        }
    }
    
    public boolean photoExists(String path) {
        return PhotosBST.findKey(path);
    }


    public void removePhotoInList(LinkedList<Photo> L, Photo p) {
        if (L.empty()) return;
        L.findfirst();
        while (!L.empty() && !L.last()) {
            if (L.retrieve().path.equals(p.path)) {
                L.remove();
            } 
    	else {
                L.findnext();
            }
        }
        if (!L.empty() && L.retrieve().path.equals(p.path)) {
            L.remove();
        }
    }

	
    public void deletePhoto(String path);

    public BST<LinkedList<Photo>> getPhotos(){
	    return index ;    
    }

}
