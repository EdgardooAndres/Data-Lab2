
package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;

public class SLFLList<E> 
implements LinkedList<E>
{

	private SNode<E> first, last; 
	int length = 0; 
	
	public SLFLList() { 
		first = last = null; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		
		((SNode<E>) nuevo).setNext(first); 
		first = (SNode<E>) nuevo; 
		length++; 
		
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		length++; 
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		
		if (target == first)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = getNodeBefore(target);  
			this.addNodeAfter(prevNode, nuevo); 
		}
		
	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException 
	{
		// TODO Auto-generated method stub
		
			if (first == null)
				throw new NodeOutOfBoundsException("getFirstNode() : linked list is empty..."); 
			
			// the linked list is not empty....
			return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (first == null)
			throw new NodeOutOfBoundsException("getLastNode(): Empty list."); 
		
		// the linked list is not empty....
		return last;
		}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		
		SNode<E> aNode = ((SNode<E>) target).getNext(); 
		if (aNode == null)  
			throw new NodeOutOfBoundsException("getNextNode(...) : target is the last node."); 
		else 
			return aNode;
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NodeOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (target == first)  
			throw new NodeOutOfBoundsException("getPrevNode(...) : target is the first node."); 
		else 
		{
			SNode<E> prev = first; 
		while (prev != null && prev.getNext() != target) 
			prev = prev.getNext();  
		return prev; 
		}
	}

	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		
		if (target == first) {
			// the list is not empty....
			SNode<E> ntr = first; 
			first = first.getNext(); 
			ntr.setNext(null);      //The node keeps its data.
		}
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		length--;
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}


	///////////////////////////////////////////////////
	// private and static inner class that defines the 
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T> {
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
	}

}
