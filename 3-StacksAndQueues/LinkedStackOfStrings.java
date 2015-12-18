import java.util.*;

class LinkedStackOfStrings{

    private Node first = null;
    
    private class Node {
	String item;
	Node next;
    }

    public boolean isEmpty () {
	return first == null;
    }

    public void push(String s) {
	Node old = first;
	first = new Node();
	first.item = s;
	first.next = old;
    }

    public String pop() {
	String res = first.item;
	first = first.next;
	return res;
    }
}