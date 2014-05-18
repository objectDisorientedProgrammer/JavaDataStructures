package com.ddc.queue;

public class QueueTester
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyQueue<Character> q = new MyQueue<Character>();
		
		q.insert('f');
		q.printQueue();
		q.insert('i');
		q.printQueue();
		q.insert('f');
		q.printQueue();
		q.insert('o');
		
		q.printQueue(); // full queue
		
		System.out.println("deleting "+q.remove());
		q.printQueue();
		System.out.println("deleting "+q.remove());
		q.printQueue();
		System.out.println("deleting "+q.remove());
		q.printQueue();
		System.out.println("deleting "+q.remove());
		q.printQueue(); // empty queue
	}
}

/* OUTPUT
queue = front->[f] {elements:1}
queue = front->[f, i] {elements:2}
queue = front->[f, i, f] {elements:3}
queue = front->[f, i, f, o] {elements:4}
deleting f
queue = front->[i, f, o] {elements:3}
deleting i
queue = front->[f, o] {elements:2}
deleting f
queue = front->[o] {elements:1}
deleting o
queue = front->[] {elements:0}
*/