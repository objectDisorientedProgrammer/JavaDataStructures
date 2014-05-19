package com.ddc.doublylinkedlist;

public class List<T>
{
	private Node<T> top;
	private Node<T> current;
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
	 * Inserts a node with the given element after the given node.
	 * 
	 * @param after
	 *            - the new node will be inserted after this one. If after is
	 *            null, the new node will be inserted at the top of the list.
	 * @param ele
	 *            - element for the new node.
	 * @return a reference to the new node.
	 */
	public Node<T> insert(Node<T> after, T ele)
	{
		Node<T> newNode = new Node<T>(ele);

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
	public Node<T> delete(T name)
	{
		Node<T> nodeToDel = findNode(name);
		Node<T> returnNode;
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
	private Node<T> findNode(T name)
	{
		Node<T> found;
		for(found = top; found != null; found = found.next)
			if(found.getElement() == name)
				return found;
		return null;
	}
	
	/**
	 * Print the list from first to last.
	 */
	public void printList()
	{
		if(count == 0)
			System.out.println("list is empty!");
		else
		{
			StringBuilder sb = new StringBuilder("list = (");
			for(current = top; current != null; current = current.next)
				sb.append(current.getElement()+")<->(");
			
			sb.delete(sb.length() - 4, sb.length());
			sb.append(" {elements:"+count + "}");
			System.out.println(sb.toString());
		}
		
	}

	/**
	 * @return the top node
	 */
	public Node<T> getTop()
	{
		return top;
	}

	/**
	 * @return the current node
	 */
	public Node<T> getCurrent()
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
	
	/**
	 * Remove all nodes from the list.
	 */
	public void clear()
	{
		current = null;
		top = null;
		count = 0;
	}
}
