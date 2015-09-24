package adsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import ads.QueueBasedOnArray;

public class QueueArrayBasedTest {

	private QueueBasedOnArray<Integer> q;
	private final int SIZE = 10;

	@Test
	public void underflow(){
		
		q = new QueueBasedOnArray<Integer>(SIZE);
		assertNull( q.dequeue());
	}
	
	@Test 
	public void overflow(){
		
		q = new QueueBasedOnArray<Integer>(SIZE);
		for(int i = 0; i < SIZE - 1; i++){
			assertTrue( q.enqueue(i));
			assertEquals( (Integer)i, (Integer)q.last());
			assertEquals( (Integer)0, (Integer)q.first());
		}
		
		assertFalse( q.enqueue(0));
	}
	
	@Test 
	public void op(){
		
		q = new QueueBasedOnArray<Integer>(SIZE);
		for(int i = 0; i < SIZE - 1; i++){
			assertTrue( q.enqueue(i));
			assertEquals( (Integer)i, (Integer)q.last());
			assertEquals( (Integer)0, (Integer)q.first());
		}
		
		assertEquals((Integer) (SIZE - 2), q.last());
		assertEquals((Integer) 0, q.dequeue());
		assertTrue( q.enqueue(5000));
		assertEquals((Integer)5000, q.last());
		
	}
}
