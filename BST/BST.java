public class BST<T> {
		BSTNode<T> root, current;
		
		
		public BST() {
			root = current = null;
		}
		public boolean empty() {
			return root == null;
		}
		
		public boolean full() {
			return false;
		}
		
		public T retrieve () {
			return current.data;
		}
		public boolean findkey(String key) {
			BSTNode<T> p = root,q = root;
					
			if(empty())
				return false;
			
			while(p != null) {
				q = p;
				if(key.compareTo(p.key)==0) {
					current = p;
					return true;
				}
				if(key.compareTo(p.key)<0)
					p = p.left;
				else
					p = p.right;
			}
			
			current = q;
			return false;
		}
		public boolean insert(String k, T val) {
			BSTNode<T> p, q = current;
			
			if(findkey(k)) {
				current = q;  
				return false; 
			}
			
			p = new BSTNode<T>(k, val);
			if (empty()) {
				root = current = p;
				return true;
			}
			else {
				
				if (k.compareTo(p.key)<0)
					current.left = p;
				else
					current.right = p;
				current = p;
				return true;
			}
		}
		public boolean removeKey (String k) {
			String k1 =k;
			BSTNode<T> 	p = root;
			BSTNode<T>  q = null;
			while (p != null) {
				if (k1. compareTo(p.key)<0) {
					q = p;
					p = p.left;
			}else if (k.compareTo(p.key) >0) {
				q = p;
				p = p.right;
			} else {
				if ((p.left != null) && (p.right!= null)) {
					BSTNode<T> min = p.right;
					q = p;
					while (min. left != null) {
						q = min;
						min=min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
				}
				if (p.left != null) {
					p=p.left;
				}else {
					p=p.right;
				}
				if(q==null) {
					root=p;
				}else {
					if(k1.compareTo(q.key)<0) {
						q.left=p;
						
					}else {
						q.right=p;
					}
				}
				current=root;
				return true;
			}
				
		}
			return false;
			
		}
}
