class BSTNode <T> {
	public String key;
	public T data;
	public BSTNode<T> left, right;
	public BSTNode(String key, T val) {
		this.key = key;
		data = val;
		left = right = null;
	}
