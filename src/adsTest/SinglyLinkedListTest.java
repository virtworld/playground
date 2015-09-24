package adsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ads.SinglyLinkedList;

public class SinglyLinkedListTest {

	@Test
	public void test() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		assertNotNull( list.search(0));
		assertNotNull( list.search(1));
		assertNotNull( list.search(2));
		assertNotNull( list.search(3));
		
		assertFalse(list.delete(5));
		assertTrue(list.delete(1));
		assertNull( list.search(1));
		
		assertTrue(list.delete(list.search(2)));
		assertNull(list.search(2));
		
		assertTrue(list.delete(3));
		assertNotNull(list.search(0));
		assertTrue(list.delete(0));
	}

}
