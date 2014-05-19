package com.ddc.doublylinkedlist;

import javax.swing.text.html.InlineView;

public class ListTester
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		List<String> stringList = new List<String>();
		Node<String> c = stringList.insert(null, "one");
		stringList.printList();
		stringList.insert(null, "two");
		stringList.printList();
		c = stringList.insert(c, "three");
		stringList.printList();
		stringList.insert(c, "four");
		stringList.printList();
		stringList.insert(null, "five");
		
		stringList.printList(); // full list
		
		stringList.delete("one");
		stringList.printList();
		stringList.delete("four");
		stringList.printList();
		stringList.delete("five");
		stringList.printList();
		stringList.delete("two");
		stringList.printList();
		stringList.delete("three");
		stringList.printList();
	}
}

/*
OUTPUT
list = (one) {elements:1}
list = (two)<->(one) {elements:2}
list = (two)<->(one)<->(three) {elements:3}
list = (two)<->(one)<->(three)<->(four) {elements:4}
list = (five)<->(two)<->(one)<->(three)<->(four) {elements:5}
list = (five)<->(two)<->(three)<->(four) {elements:4}
list = (five)<->(two)<->(three) {elements:3}
list = (two)<->(three) {elements:2}
list = (three) {elements:1}
list is empty!
*/
