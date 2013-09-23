package doublylinkedlist;

public class Node {
	public Node prev;
	public Node next;
	private String text;

	public Node()
	{
		super();
		this.text = "";
	}

	/**
	 * Create a node and set it's text.
	 * @param strValue - string to set the text to.
	 */
	public Node(String strValue)
	{
		this.text = strValue;
	}

	/**
	 * @return the node's text
	 */
	public String getText()
	{
		return text;
	}
}
