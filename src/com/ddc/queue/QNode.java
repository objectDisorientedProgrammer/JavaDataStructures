package com.ddc.queue;

public class QNode<E>
{
	private E item;
	public QNode<E> next;
	
	public QNode()
	{
		super();
		this.next = null;
	}
	
	/**
	 * Create a QNode and set its value.
	 * @param character - item for the QNode
	 */
	public QNode(E character)
	{
		super();
		this.next = null;
		this.setItem(character);
	}

	/**
	 * @return the item
	 */
	public E getItem()
	{
		return item;
	}

	/**
	 * @param item - the item to set
	 */
	public void setItem(E item)
	{
		this.item = item;
	}

}
