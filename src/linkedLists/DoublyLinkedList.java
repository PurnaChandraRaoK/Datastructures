package linkedLists;

public class DoublyLinkedList {
	Node head;

	class Node {
		int data;
		Node prev;
		Node next;

		Node(int n) {
			data = n;
			prev = null;
			next = null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		System.out.println("inserting at end");
		dll.insertAtEnd(1);
		dll.insertAtEnd(2);
		dll.insertAtEnd(3);
		dll.insertAtEnd(4);
		printList(dll.head);
		System.out.println("inserting at head");
		dll.insertAtHead(5);
		dll.insertAtHead(6);
		dll.insertAtHead(7);
		dll.insertAtHead(8);
		printList(dll.head);
		System.out.println("inserting at 2 pos");
		dll.insertAtPos(2, 10);
		printList(dll.head);
		System.out.println("inserting at 4 pos");
		dll.insertAtPos(4, 11);
		printList(dll.head);
		System.out.println("inserting at 6 pos");
		dll.insertAtPos(6, 12);
		printList(dll.head);
		System.out.println("deleting at head");
		dll.deleteAtHead();
		printList(dll.head);
		System.out.println("deleting at head");
		dll.deleteAtHead();
		printList(dll.head);
		System.out.println("deleting at tail");
		dll.deleteAtEnd();
		printList(dll.head);
		System.out.println("deleting at tail");
		dll.deleteAtEnd();
		printList(dll.head);
		System.out.println("deleting 12");
		dll.delete(12);
		printList(dll.head);
		System.out.println("deleting 5");
		dll.delete(5);
		printList(dll.head);
		System.out.println("reversing DLL");
		dll.reverseDLL();
		printList(dll.head);

	}

	void reverseDLL() {
		Node curr = head;
		Node node = null;
		while (curr != null) {
			node = curr.prev;
			curr.prev = curr.next;
			curr.next = node;
			curr = curr.prev;
		}
		if (node != null)
			head = node.prev;
	}

	void insertAtEnd(int n) {
		if (head == null) {
			head = new Node(n);
		} else {
			Node newNode = new Node(n);
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			temp.next = newNode;
			newNode.next = null;
		}
	}

	void insertAtHead(int n) {
		if (head == null) {
			head = new Node(n);
		} else {
			Node newNode = new Node(n);
			newNode.prev = head.prev;
			newNode.next = head;
			head = newNode;
		}
	}

	void deleteAtHead() {
		if (head == null) {
			return;
		} else {
			head.next.prev = null;
			head = head.next;
		}
	}

	void deleteAtEnd() {
		if (head == null) {
			return;
		} else {
			Node temp = head;
			Node prev = null;
			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = null;
		}
	}

	void delete(int n) {
		if (head == null) {
			return;
		} else {
			Node temp = head;
			Node prev = null;
			while (temp.data != n) {
				prev = temp;
				temp = temp.next;
			}
			temp.next.prev = prev;
			prev.next = temp.next;
		}
	}

	void insertAtPos(int pos, int n) {
		int i = 1;
		Node node = head;
		while (i < pos) {
			i++;
			node = node.next;
		}
		Node newNode = new Node(n);
		newNode.prev = node;
		newNode.next = node.next;
		node.next = newNode;
	}

	static void printList(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + "-->");
			node = node.next;
		}
		System.out.print(node.data);
	}

}
