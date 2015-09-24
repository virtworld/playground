package adsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ads.StackBasedOnArray;

public class StackArrayBasedTest {

	private final int SIZE = 10;
	private StackBasedOnArray<Integer> s;
	
	@Test
	public void underflow() {
		s = new StackBasedOnArray<Integer>(SIZE);
		assertNull( s.pop());
	}
	
	@Test
	public void overflow() {
		s = new StackBasedOnArray<Integer>(SIZE);
		for(int i = 0; i < SIZE; i++){
			s.push(i);
		}
		
		s.push(-1);
		assertEquals(s.top(), (Integer)(-1));
	}
	
	@Test
	public void popValue() {

		s = new StackBasedOnArray<Integer>(SIZE);
		for(int i = 0; i < SIZE; i++){
			s.push(i);
		}
		
		for(int i = 0; i < SIZE; i++){
			assertEquals( (Integer)s.pop(), (Integer)(SIZE - 1 - i));
		}
	}
	
	@Test
	public void top(){
		
		s = new StackBasedOnArray<Integer>(SIZE);
		
		final int max = SIZE / 2;
		for(int i = 0; i < max; i++){
			s.push(i);
		}
		
		assertEquals((Integer)s.top(), (Integer) (max - 1));
		assertEquals((Integer)s.top(), (Integer) (max - 1));
	}
}
