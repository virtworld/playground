package ads;

import adsInterface.IQueue;

public class QueueBasedOnArray<T> implements IQueue<T>{

	private int head;
	private int tail;
	private int size;
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public QueueBasedOnArray(int size) {

		this.size = size;
		head = tail = 0;
		array = (T[]) new Object[size]; 
	}
	
	public boolean enqueue(T e){
		
		if((tail + 1) % size == head){
			return false;
		}else{ 
			array[tail] = e;
			tail = (tail + 1) % size;
			return true;
		}
	}
	
	@Override
	public T dequeue(){
		
		if(head == tail){
			return null;
		}else{
			int oldHead = head;
			head = (head + 1) % size;
			return array[oldHead];
		}
	}
	
	@Override
	public T first(){
		
		if(head == tail){
			return null;
		}else{
			return array[head];
		}
	}
	
	@Override
	public T last(){
		
		if(head == tail){
			return null;
		}else{
			int last = (tail == 0) ? size - 1 : tail - 1;
			return array[last];
		}
	}

}
