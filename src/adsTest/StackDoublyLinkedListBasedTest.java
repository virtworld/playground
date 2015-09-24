package adsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ads.StackBasedOnDoublyLinkedList;

public class StackDoublyLinkedListBasedTest {

	@Test
	public void test() {
		
		StackBasedOnDoublyLinkedList<Integer> stack = new StackBasedOnDoublyLinkedList<Integer>();
		
		for(int i = 0; i < 100; i++){
			stack.push(i);
		}
		
		for(int i = 0; i < 100; i++){
			assertEquals(stack.top(), (Integer)(99 - i));
			assertEquals(stack.pop(), (Integer)(99 - i));
		}
		
	}

}
