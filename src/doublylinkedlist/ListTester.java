package doublylinkedlist;

public class ListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List stringList = new List();
		Node c = stringList.insert(null, "one");
		stringList.insert(null, "two");
		c = stringList.insert(c, "three");
		
		stringList.insert(c, "four");
		stringList.insert(null, "five");
		
		stringList.printEntireList();
	}

}

/*
OUTPUT
five
two
one
three
four
*/