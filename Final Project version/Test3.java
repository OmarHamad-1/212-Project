public class Test3 {

	public static void main(String[] args) {
        InvIndexPhotoManager manager = new InvIndexPhotoManager();

        // Add photos
        Photo p1 = new Photo("a.jpg", Test.toTagsLinkedlist("cat, animal, cute"));
        Photo p2 = new Photo("b.jpg", Test.toTagsLinkedlist("dog, animal"));
        Photo p3 = new Photo("c.jpg", Test.toTagsLinkedlist("cat, cute"));
        Photo p4 = new Photo("d.jpg", Test.toTagsLinkedlist("nature, flower"));

        manager.addPhoto(p1);
        manager.addPhoto(p2);
        manager.addPhoto(p3);
        manager.addPhoto(p4);
        manager.deletePhoto("a.jpg");

        // Test album with "cat AND cute"
        InvIndexAlbum album1 = new InvIndexAlbum("Cats and Cuteness", "cat AND cute", manager);
        Linkedlist<Photo> result1 = album1.getPhotos();

        System.out.println("Photos in album: " + album1.getName());
        printPhotoList(result1);

        // Another test: "animal AND dog"
        InvIndexAlbum album2 = new InvIndexAlbum("Dog Lovers", "animal AND dog", manager);
        Linkedlist<Photo> result2 = album2.getPhotos();

        System.out.println("\nPhotos in album: " + album2.getName());
        printPhotoList(result2);

        // Another test: condition is blank (should return all)
        InvIndexAlbum album3 = new InvIndexAlbum("All Photos", "", manager);
        Linkedlist<Photo> result3 = album3.getPhotos();

        System.out.println("\nPhotos in album: " + album3.getName());
        printPhotoList(result3);
        
        System.out.println(album1.getNbComps());

    }

    public static void printPhotoList(Linkedlist<Photo> list) {
        if (list.empty()) {
            System.out.println("No photos found.");
            return;
        }

        list.findFirst();
        while (!list.last()) {
            System.out.println(list.retrieve().path);
            list.findNext();
        }
        System.out.println(list.retrieve().path); // Print last
    }
}