package ads;

public class SinglyLinkedListNode<T> {

	private SinglyLinkedListNode<T> next;
	private T key;
	
	public SinglyLinkedListNode(SinglyLinkedListNode<T> next, T key) {
		this.key = key;
		this.next = next;
	}

	public SinglyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}
}
