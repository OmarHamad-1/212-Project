
public class BSTNode <T> {
	public String key;
	public T data;
	public BSTNode <T>  left, right;
	
	public BSTNode(String key, T e) {
		this.key = key;
		this.data = e;
		left = right = null;
	}
	public BSTNode(String key, T e, BSTNode <T> l, BSTNode <T> r) {
		this.key = key;
		this.data = e;
		left = l;
		right = r;
}
	
}