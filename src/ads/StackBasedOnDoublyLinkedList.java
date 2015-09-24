package ads;

import adsInterface.IStack;

public class StackBasedOnDoublyLinkedList<T> implements IStack<T>{

	DoublyLinkedList<T> list;
	
	public StackBasedOnDoublyLinkedList() {

		list = new DoublyLinkedList<T>();
	}
	
	@Override
	public T top(){
		
		return list.getHead().getKey();
	}
	
	@Override
	public T pop(){
		
		T ret = list.getHead().getKey();
		list.delete(list.getHead());
		return ret;
	}
	
	@Override
	public void push(T e){
		
		list.insert(e);
	}

}
