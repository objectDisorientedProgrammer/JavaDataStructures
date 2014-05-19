package com.ddc.queue;

public class MyQueue<E>
{
	private int numberOfItems;
	private QNode<E> front;
	private QNode<E> rear;
	
	/**
	 * Create and empty queue.
	 */
	public MyQueue()
	{
		super();
		this.numberOfItems = 0;
		this.front = null;
		this.rear = null;
	}
	
	/**
	 * Add an item to the end of the queue.
	 * @param newItem - item to be added.
	 */
	public void insert(E newItem)
	{
		QNode<E> newNode = new QNode<E>(newItem);
		
		// insert at the end of the queue
		newNode.next = null;
		if(rear == null)	// first item in the queue
		{
			front = newNode;
			rear = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
		++numberOfItems;
	}
	
	/**
	 * Remove the first item from the queue
	 * @return if there are items in the queue, return the first item. Otherwise return null.
	 */
	public E remove()
	{
		if(this.numberOfItems != 0)	// queue is not empty, do something
		{
			QNode<E> temp;
			temp = front;
			front = temp.next;
			if(front == null)	// if not more items the queue is empty
				rear = null;
			--numberOfItems;
			return temp.getItem();
		}
		return null;
	}

	/**
	 * @return the numberOfItems
	 */
	public int getNumberOfItems()
	{
		return this.numberOfItems;
	}

	/**
	 * @return the front
	 */
	public QNode<E> getFront()
	{
		return front;
	}

	/**
	 * @return the rear
	 */
	public QNode<E> getRear()
	{
		return rear;
	}
	
	/**
	 * Clear the queue.
	 */
	public void clear()
	{
		this.numberOfItems = 0;
		this.front = null;
		this.rear = null;
	}
	
	/**
	 * Print a formatted text representation of the queue.
	 */
	public void printQueue()
	{
		if(numberOfItems == 0)
			System.out.println("queue = front->[] {elements:0}");
		else
		{
			StringBuilder sb = new StringBuilder("queue = front->[");
			
			for(QNode<E> iterator = front; iterator != null; iterator = iterator.next)
				sb.append(iterator.getItem()+", ");
			
			sb.delete(sb.length() - 2, sb.length());
			sb.append("] {elements:" + numberOfItems + "}");
			System.out.println(sb.toString());
		}
	}
}
