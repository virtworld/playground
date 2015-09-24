package ads;

public class SinglyLinkedList<T> {

	private SinglyLinkedListNode<T> head;
	
	public SinglyLinkedList() {
		head = null;
	}
	
	public void insert(T key){
		
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(head, key);
		head = node;
	}
	
	public void insert(SinglyLinkedListNode<T> node){
		
		node.setNext(head);
		head = node;
	}
	
	public SinglyLinkedListNode<T> search(T key){
		
		SinglyLinkedListNode<T> index = head;
		
		while(index != null && !index.getKey().equals(key)){
			index = index.getNext();
		}
		
		return index;
	}
	
	public boolean delete(T key){
	
		if(key == null){
			return false;
		}else{
			SinglyLinkedListNode<T> index = search(key);
			if(index == null){
				return false;
			}else{
				return delete(index);
			}
		}
	}
	
	public boolean delete(SinglyLinkedListNode<T> node){
		
		if(node == null) return false;
		if(head == null) return false;
		
		if(head.equals(node)){
			head = head.getNext();
			return true;
		}else{
			SinglyLinkedListNode<T> node1 = head;
			SinglyLinkedListNode<T> node2 = head.getNext();
			
			while(node2 != null && !node2.equals(node)){
				node1 = node2;
				node2 = node2.getNext();
			}
			
			if(node2 == null){
				return false;
			}else{
				node1.setNext(node2.getNext());
				return true;
			}
		}
	}

	public SinglyLinkedListNode<T> getHead() {
		return head;
	}
	
	

}
