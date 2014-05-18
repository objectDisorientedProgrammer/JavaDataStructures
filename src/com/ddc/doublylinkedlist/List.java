package com.ddc.doublylinkedlist;

public class List
{
	private Node top;
	private Node current;
	private int count;

	/**
	 * Create an empty list.
	 */
	public List()
	{
		super();
		this.top = null;
		this.current = null;
		this.count = 0;
	}

	/**
	 * Inserts a node with the given text after the given node.
	 * 
	 * @param after
	 *            - the new node will be inserted after this one. If after is
	 *            null, the new node will be inserted at the top of the list.
	 * @param text
	 *            - text for the new node.
	 * @return a reference to the new node.
	 */
	public Node insert(Node after, String text)
	{
		Node newNode = new Node(text);

		if(after != null) // not inserting at the top of the list
		{
			newNode.prev = after;
			newNode.next = after.next;
			after.next = newNode;
			if (newNode.next != null) // check if there is a node after newNode
				newNode.next.prev = newNode;
		} else // inserting at the top of the list
		{
			newNode.next = top;
			if(top != null)
				top.prev = newNode;
			top = newNode;
		}
		++count;
		return newNode;
	}

	/**
	 * Deletes the node passed in and returns either the next (if applicable) or
	 * the previous (if applicable) node.
	 * 
	 * @param nodeToDel
	 *            - node to be deleted
	 * @return returns either the next (if applicable) or the previous (if
	 *         applicable) node or null if there are no more nodes
	 */
	public Node delete(String name)
	{
		Node nodeToDel = findNode(name);
		Node returnNode;
		if(nodeToDel == null) // not in list
			return null;
		if(nodeToDel == top) // delete top
		{
			if(nodeToDel.next != null) // not the only node in the list
			{
				returnNode = nodeToDel.next;
				top = returnNode;
				returnNode.prev = null;
			} else // only node in the list
			{
				returnNode = null;
				top = null;
			}
		} else // not deleting top
		{
			if(nodeToDel.next != null) // not the last node in the list
			{
				returnNode = nodeToDel.next;
				returnNode.prev = nodeToDel.prev;
				nodeToDel.prev.next = returnNode;
			} else // deleting last node in list
			{
				returnNode = nodeToDel.prev;
				returnNode.next = null;
			}
		}
		--count;
		nodeToDel.prev = null;
		nodeToDel.next = null;
		return returnNode;
	}
	
	/**
	 * Find a node by name.
	 * @param name - the name of the node.
	 * @return the node if it exists in the list; otherwise null.
	 */
	private Node findNode(String name)
	{
		Node found;
		for(found = top; found != null; found = found.next)
			if(found.getText().equalsIgnoreCase(name))
				return found;
		return null;
	}
	
	/**
	 * Print the whole list from first to last.
	 */
	public void printList()
	{
		if(count == 0)
			System.out.println("list is empty!");
		else
		{
			StringBuilder sb = new StringBuilder("list = (");
			for(current = top; current != null; current = current.next)
				sb.append(current.getText()+")->(");
			
			sb.delete(sb.length() - 3, sb.length());
			sb.append(" {elements:"+count + "}");
			System.out.println(sb.toString());
		}
		
	}

	/**
	 * @return the top node
	 */
	public Node getTop()
	{
		return top;
	}

	/**
	 * @return the current node
	 */
	public Node getCurrent()
	{
		return current;
	}

	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}
}