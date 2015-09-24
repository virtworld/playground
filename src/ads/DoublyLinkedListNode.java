package ads;

public class DoublyLinkedListNode<T> {

	private DoublyLinkedListNode<T> prevNode;
	private DoublyLinkedListNode<T> nextNode;
	private T key;
	
	public DoublyLinkedListNode( DoublyLinkedListNode<T> prev, 
			DoublyLinkedListNode<T> next, T key) {
		setNext(next);
		setPrev(prev);
		setKey(key);
	}

	public void setNext(DoublyLinkedListNode<T> next){
		nextNode = next;
	}
	
	public void setPrev(DoublyLinkedListNode<T> prev){
		prevNode = prev;
	}
	
	public void setKey(T key){
		this.key = key;
	}

	public DoublyLinkedListNode<T> getPrevNode() {
		return prevNode;
	}

	public DoublyLinkedListNode<T> getNextNode() {
		return nextNode;
	}

	public T getKey() {
		return key;
	}	
}
