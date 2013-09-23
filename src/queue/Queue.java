package queue;

public class Queue {
	private int numberOfItems;
	private QNode front;
	private QNode rear;
	
	/**
	 * Create and empty queue.
	 */
	public Queue()
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
	public void insert(int newItem)
	{
		QNode newNode = new QNode(newItem);
		
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
	}
	
	/**
	 * Remove the first item from the queue
	 * @return if there are items in the queue, return the first item. Otherwise return -1.
	 */
	public int remove()
	{
		QNode temp;
		
		if(this.numberOfItems == 0)	// queue is empty, do nothing
			return -1;
		else
		{
			temp = front;
			front = temp.next;
			if(front == null)	// if not more items the queue is empty
				rear = null;
			numberOfItems--;
		}
		return temp.getItem();
	}

	/**
	 * @return the numberOfItems
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * @return the front
	 */
	public QNode getFront() {
		return front;
	}

	/**
	 * @return the rear
	 */
	public QNode getRear() {
		return rear;
	}
	
	

}
