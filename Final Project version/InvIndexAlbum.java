
public class InvIndexAlbum {
		String name;
		String condition;
		InvIndexPhotoManager manager;
		
		public  InvIndexAlbum(String name, String condition, InvIndexPhotoManager manager) {
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
		
		public InvIndexPhotoManager getManager() {
			return this.manager;
		}
		
		
		public static boolean PhotoExist (Linkedlist<Photo> l , Photo p) {
			if(l.empty()) return false;
			l.findFirst();
			while(!l.last()) {
				
				if(l.retrieve().path.equals(p.path))
					return true;
				
				l.findNext();
			}

			if(l.retrieve().path.equals(p.path))
				return true;
			
			return false;
		}

		// big O( log(num of all tags) )
		public Linkedlist<Photo> getTagPhotos(String tag) {
			Linkedlist<Photo> photos = new Linkedlist<Photo>();
			
			boolean found = manager.getPhotos().findkeyNbComp(tag);
			if(found)
				photos = manager.getPhotos().retrieve();
			
			return photos;
		}
		
		
		// big O( num of conditions x (log(num of all tags)) + (avg num of photos in each tag of all tags)^2
		public Linkedlist<Photo> getPhotos() {
		    
		    
		    if (condition == null || condition.isBlank()) {
		        return  manager.photos;
		    }

		    
		    String[] allCond = condition.trim().split("\\s*AND\\s*");
		    

		    
		    Linkedlist<Photo> list1 = getTagPhotos(allCond[0]);

		    
		    for (int i = 1; i < allCond.length; i++) {

		        Linkedlist<Photo> list2 = getTagPhotos(allCond[i]);
		        list1 = intersect(list1, list2); // Intersect A and B
		    }

		    return list1;
		}  	
	
		// big O( (avg num of photos in each tag of all tags)^2 )
		public Linkedlist<Photo> intersect(Linkedlist<Photo> list1, Linkedlist<Photo> list2) {
		    	Linkedlist<Photo> result = new Linkedlist<Photo>();
		        
		        if (list1.empty() || list2.empty()) {
		            return result;
		        }
		        
		        list1.findFirst();
		        while (true) {
		            boolean found = PhotoExist(result, list2.retrieve());
		            if (!found) { // not found in result
		            	list2.findFirst();
		                while (true) {
		                    if (list2.retrieve().path.equals(list1.retrieve().path)) {
		                        result.insert(list1.retrieve());
		                        break;
		                    }
		                    if (!list2.last()) {
		                    	list2.findNext();
		                    } else {
		                        break;
		                    }
		                } 
		            } 
		            
		            if (!list1.last()) {
		            	list1.findNext();
		            } else {
		                break;
		            }
		        } // end outer while for A
		        
		        return result;
		    }
		
			
		public int getNbComps() {
			return manager.index.NbComp;
		}	
			
			
			
		       	
}