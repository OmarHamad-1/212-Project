public class Linkedlist<T> {
	private Node<T> head;
	private Node<T> current;
	
    public Linkedlist() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    } 
    
    
    
    
    
    
    // for testing
     public void display() {
    	 if(head==null)
    		System.out.println("list is empty");
    	 
    	 else {
    		 Node <T> p = head;
    		 
    		 while (p != null) {
    	    	System.out.println(p.data+"");
    	    	p = p.next;
    		 }
    	 }
     }
      
 }