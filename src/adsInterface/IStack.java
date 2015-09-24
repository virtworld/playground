package adsInterface;



public interface IStack<T> {

	public abstract void push(T e);
	
	public abstract T pop();
	
	public abstract T top();
}
