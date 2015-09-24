package adsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ads.QueueBasedOnDoublyLinkedList;

public class QueueDoublyLinkedListBasedTest {

	@Test
	public void test() {
		
		QueueBasedOnDoublyLinkedList<Integer> q = new QueueBasedOnDoublyLinkedList<Integer>();
		
		assertNull(q.dequeue());
		
		q.enqueue(0);
		assertEquals(q.first(), (Integer)0);
		assertEquals(q.last(), (Integer)0);
		assertEquals(q.dequeue(), (Integer)0);
		
		q.enqueue(0);
		q.enqueue(1);
		assertEquals(q.first(), (Integer)0);
		assertEquals(q.last(), (Integer)1);
		assertEquals(q.dequeue(), (Integer)0);
		assertEquals(q.first(), (Integer)1);
		assertEquals(q.last(), (Integer)1);
		assertEquals(q.dequeue(), (Integer)1);
		assertNull(q.first());
		assertNull(q.last());
	}

}
