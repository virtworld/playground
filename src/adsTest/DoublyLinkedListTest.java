package adsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ads.DoublyLinkedList;
import ads.DoublyLinkedListNode;

public class DoublyLinkedListTest {

	@Test
	public void test1() {
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
		assertFalse(list.delete(0));
		
		int node1key = 0;
		assertNull(list.search(node1key));
		
		DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<Integer>(null, null, node1key);
		list.insert(node1);
		assertNotNull(list.search(node1key));
		
		list.delete(node1);
		assertNull(list.search(node1key));
		
		
	}
	
	@Test
	public void test2(){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		assertEquals(list.getHead().getKey(), (Integer)3);
		assertEquals(list.getTail().getKey(), (Integer)0);
		assertTrue(list.delete(3));
		assertEquals(list.getHead().getKey(), (Integer)2);
		assertTrue(list.delete(0));
		assertEquals(list.getTail().getKey(), (Integer)1);
	}

}
