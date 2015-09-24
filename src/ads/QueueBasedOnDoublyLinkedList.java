package ads;

import adsInterface.IQueue;

public class QueueBasedOnDoublyLinkedList<T> implements IQueue<T>{

	private DoublyLinkedList<T> list;
	
	public QueueBasedOnDoublyLinkedList() {
		
		list = new DoublyLinkedList<T>();
	}
	
	public void enqueue(T e){
		list.insert(e);
	}
	
	@Override
	public T dequeue(){
		
		DoublyLinkedListNode<T> ret = list.getTail();
		if(ret == null){
			return null;
		}else{
			list.delete(ret);
			return ret.getKey();
		}
	}

	@Override
	public T first() {
		
		DoublyLinkedListNode<T> ret = list.getTail();
		return (ret != null) ? ret.getKey() : null;
	}

	@Override
	public T last() {
		
		DoublyLinkedListNode<T> ret = list.getHead();
		return (ret != null) ? ret.getKey() : null;
	}
	

}
