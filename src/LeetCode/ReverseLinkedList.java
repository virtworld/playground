package LeetCode;

import ads.SinglyLinkedList;
import ads.SinglyLinkedListNode;

public class ReverseLinkedList {

	public ReverseLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for(int i = 0; i < 50000000; i++){
			list.insert(i);
		}
		
		reverseBetween(list.getHead(), 2, 20);
		
//		SinglyLinkedListNode<Integer> head = list.getHead();
//		
//		while(head != null){
//			System.out.print(head.getKey() + " ");
//			head = head.getNext();
//		}
	}

	public static SinglyLinkedListNode<Integer> reverseBetween(SinglyLinkedListNode<Integer> head, int m, int n) {
	     
        if(head == null) return null;
        if(head.getNext() == null) return head;
        
        // We have at least two nodes;
        
        SinglyLinkedListNode<Integer> before = null;
        SinglyLinkedListNode<Integer> first = null;
        
        SinglyLinkedListNode<Integer> index1 = head;
        SinglyLinkedListNode<Integer> index2 = head.getNext();
        
        int counter = 1;
        
        while(index2 != null){
        	SinglyLinkedListNode<Integer> index3 = index2.getNext();
            
            if(counter == m - 1){
                before = index1;
            }else if(counter == m){
                first = index1;
                index2.setNext(index1);
            }else if(counter > m && counter < n){
                index2.setNext(index1);
            }else if(counter == n){
                if(before != null)
                    before.setNext(index1);
                else
                    head = index1;
                first.setNext(index2);
            }else if(counter > n){
                break;
            }
            
            index1 = index2;
            index2 = index3;
            
            System.out.println(Runtime.getRuntime().maxMemory() / 1024);
            counter++;
        }   
        
        return head;
    }
}
