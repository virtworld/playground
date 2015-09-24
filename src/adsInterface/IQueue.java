package adsInterface;

public interface IQueue<T> {
	
	public abstract T dequeue();
	
	public abstract T first();
	
	public abstract T last();
}
