
public class Test2 {

	public static void main(String[] args) {
		 InvIndexPhotoManager invManager = new InvIndexPhotoManager() ;
		 
		 Photo photo1 = new Photo("hedgehog.jpg",Test.toTagsLinkedlist("animal, hedgehog, apple,grass, green"));
		 invManager.addPhoto(photo1);
		 // check what happen to duplicate photos -same path name-  
		 invManager.addPhoto(photo1);

    	 Photo photo2 = new Photo("bear.jpg",Test.toTagsLinkedlist("animal, bear, cab, grass,wind")); 
    	 invManager.addPhoto(photo2);
    	 
    	 Photo photo3 = new Photo("orange-butterfly.jpg",Test.toTagsLinkedlist("insect,butterfly, flower, color"));
    	 invManager.addPhoto(photo3);

    	 

		 // check what happen to photos with no tags -null or empty tags-   
    	 Photo photo4 = new Photo("cat.jpg", null);
    	 invManager.addPhoto(photo4);
    	 
    	 invManager.deletePhoto("cat.jpg");
    	 invManager.deletePhoto("orange-butterfly.jpg");
//    	 invManager.deletePhoto("hedgehog.jpg");

    	 
//    	 invManager.getPhotos().inOrder();
    	 invManager.display();
    	 
	}

}
