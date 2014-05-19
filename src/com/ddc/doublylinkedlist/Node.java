package com.ddc.doublylinkedlist;

public class Node<T>
{
	public Node<T> prev;
	public Node<T> next;
	private T element;

	public Node()
	{
		super();
		this.element = null;
	}

	/**
	 * Create a node and set it's element.
	 * @param element - element to set put in the node.
	 */
	public Node(T element)
	{
		this.element = element;
	}

	/**
	 * @return the node's element
	 */
	public T getElement()
	{
		return element;
	}
	
	/**
	 * Change the current element in the node.
	 * @param newElement - the new value.
	 */
	public void setElement(T newElement)
	{
		this.element = newElement;
	}
}
