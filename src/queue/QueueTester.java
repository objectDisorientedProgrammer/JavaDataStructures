package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Character> q = new LinkedList<Character>();
		
		q.add('f');
		q.add('i');
		q.add('f');
		q.add('o');
		
		while(!q.isEmpty())
			System.out.println(q.remove());
	}

}
