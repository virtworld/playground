package ads;

public class DoublyLinkedList<T> {

	private DoublyLinkedListNode<T> head;
	private DoublyLinkedListNode<T> tail;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	public void insert(T key){
		
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(null, head, key);
		if(head != null)
			head.setPrev(node);
		head = node;
		if(tail == null)
			tail = node;
	}
	
	public void insert(DoublyLinkedListNode<T> node){
		
		node.setNext(head);
		node.setPrev(null);
		if(head != null)
			head.setPrev(node);
		
		head = node;
		if(tail == null)
			tail = node;
	}
	
	/**
	 * Delete the first found node that has content key
	 * @param key the content of the node
	 */
	public boolean delete(T key){
		
		DoublyLinkedListNode<T> node = search(key);
		if(node == null){
			return false;
		}else{
			delete(node);
			return true;
		}
	}
	
	
	/**
	 * Delete the given node in the list
	 * @param node the node to be deleted
	 */
	public void delete(DoublyLinkedListNode<T> node){
		
		if(node == null) return;
		
		if( node.getNextNode() != null)
			node.getNextNode().setPrev( node.getPrevNode());
		else
			tail = node.getPrevNode();
		
		if( node.getPrevNode() != null)
			node.getPrevNode().setNext( node.getNextNode());
		else 
			head = node.getNextNode();
	}
	/**
	 * Return the first node that has the content key 
	 * @param key the content
	 * @return the first node that has the content key
	 */
	public DoublyLinkedListNode<T> search(T key){
		
		DoublyLinkedListNode<T> index = head;
		while(index != null && !index.getKey().equals(key)){
			index = index.getNextNode();
		}
		return index;
	}

	public DoublyLinkedListNode<T> getHead() {
		return head;
	}

	public DoublyLinkedListNode<T> getTail() {
		return tail;
	}

	public void setHead(DoublyLinkedListNode<T> head) {
		this.head = head;
	}

	public void setTail(DoublyLinkedListNode<T> tail) {
		this.tail = tail;
	}
	
	

}
