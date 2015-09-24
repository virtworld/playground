package ads;

import adsInterface.IStack;

public class StackBasedOnArray<T> implements IStack<T>{

	private int top;
	private int size;
	
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public StackBasedOnArray(int size) {
		
		this.size = size; 
		top = 0;
		array = (T[]) new Object[size];
	}
	
	@Override
	public T pop()  {
		if(top > 0){
			--top;
			return array[top];
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void push(T e){
		
		if(top >= size){
			T[] newArray = (T[]) new Object[size * 2];
			for(int i = 0; i < size; i++){
				newArray[i] = array[i];
			}
			size *= 2;
			array = newArray;
			
		}
		
		array[top++] = e;
	}
	
	@Override
	public T top(){
		return (top > 0) ? array[top - 1] : null;
	}
}
