package queue;

public class QNode {
	private int item;
	public QNode next;
	
	public QNode()
	{
		super();
		this.next = null;
		this.setItem(0);
	}
	
	/**
	 * Create a QNode and set its value.
	 * @param number - item for the QNode
	 */
	public QNode(int number)
	{
		super();
		this.next = null;
		this.setItem(number);
	}

	/**
	 * @return the item
	 */
	public int getItem() {
		return item;
	}

	/**
	 * @param item - the item to set
	 */
	public void setItem(int item) {
		this.item = item;
	}

}
