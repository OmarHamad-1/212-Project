public class InvIndexPhotoManager {
    BST<Linkedlist<Photo>> index;
    public Linkedlist<Photo> photos;

    public InvIndexPhotoManager() {
        index = new BST<Linkedlist<Photo>>();
        photos = new Linkedlist<Photo>();
    }

    public void addPhoto(Photo p) {
        if (photoExists(p.path)) {
            return; // Photo already exists
        }
        photos.insert(p); // Add to photo list

        Linkedlist<String> tags = p.getTags();
        if (tags == null || tags.empty()) return;

        tags.findFirst();
        while (true) {
            String oneTag = tags.retrieve();

            if (!index.findkey(oneTag)) {
                Linkedlist<Photo> tagPhotos = new Linkedlist<>();
                tagPhotos.insert(p);
                index.insert(oneTag, tagPhotos);
            } else {
                index.retrieve().insert(p);
            }

            if (tags.last()) break;
            tags.findNext();
        }
    }

    public void removePhotoInList(Linkedlist<Photo> L, Photo p) {
        if (L.empty()) return;
        L.findFirst();
        while (!L.empty() && !L.last()) {
            if (L.retrieve().path.equals(p.path)) {
                L.remove();
            } else {
                L.findNext();
            }
        }
        if (!L.empty() && L.retrieve().path.equals(p.path)) {
            L.remove();
        }
    }

    public void deletePhoto(String path) {
        if (!photoExists(path)) return;

        Photo photoToDelete = getPhotoByPath(path);
        if (photoToDelete == null) return;

        Linkedlist<String> tags = photoToDelete.getTags();
        if (tags != null && !tags.empty()) {
            tags.findFirst();
            while (true) {
                String tag = tags.retrieve();

                if (index.findkey(tag)) {
                    removePhotoInList(index.retrieve(), photoToDelete);
                    if (index.retrieve().empty()) {
                        index.remove_key(tag);
                    }
                }

                if (tags.last()) break;
                tags.findNext();
            }
        }

        removePhotoInList(photos, photoToDelete); // Remove from photo list
    }

    public boolean photoExists(String path) {
        if (photos.empty()) return false;
        photos.findFirst();
        while (!photos.last()) {
            if (photos.retrieve().path.equals(path)) return true;
            photos.findNext();
        }
        return photos.retrieve().path.equals(path);
    }

    public Photo getPhotoByPath(String path) {
        if (photos.empty()) return null;
        photos.findFirst();
        while (!photos.last()) {
            if (photos.retrieve().path.equals(path)) return photos.retrieve();
            photos.findNext();
        }
        if (photos.retrieve().path.equals(path)) return photos.retrieve();
        return null;
    }

    public BST<Linkedlist<Photo>> getPhotos() {
        return index;
    }

    
    
    
    
    
    // for testing
    public void display() {
        System.out.println("All photos in InvIndexPhotoManager:");
        if (photos.empty()) {
            System.out.println("No photos available.");
            return;
        }

        photos.findFirst();
        while (!photos.last()) {
            System.out.println(photos.retrieve().getPath());
            photos.findNext();
        }
        System.out.println(photos.retrieve().getPath()); // Print last photo
    }

}
