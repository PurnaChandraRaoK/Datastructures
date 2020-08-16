package linkedLists;

import java.util.HashSet;

public class SingleLinkedList {
	Node head;

	static class Node {
		int data;
		Node next, child;

		Node(int d) {
			data = d;
			next = null;
			child = null;
		}
	}

	public static void main(String[] args) {
		// SingleLinkedList list= new SingleLinkedList();
		// list.head=new Node(1);
		// Node second = new Node(2);
		// Node third = new Node(3);
		// list.head.next=second;
		// second.next=third;
		// printList(list.head);

		SingleLinkedList newList = new SingleLinkedList();
		System.out.println("----------inserting------------\n");
		newList.pushFirst(1);
		newList.pushEnd(2);
		newList.pushAfter(newList.head.next, 4);
		newList.pushEnd(3);
		newList.pushEnd(5);
		newList.pushEnd(6);
		newList.pushEnd(8);
		newList.pushEnd(9);
		newList.pushEnd(0);

		printList(newList.head);
		System.out.println("\n----------deleting------------\n");
		System.out.println("deleting 1");
		newList.delete(1);
		printList(newList.head);
		System.out.println("deleting 0");
		newList.delete(0);
		printList(newList.head);
		System.out.println("deleting 6");
		newList.delete(6);
		printList(newList.head);

		System.out.println("\n----------length of list------------\n");
		newList.length();

		System.out.println("\n----------reversing list------------\n");
		newList.reverseList(newList.head);
		printList(newList.head);

		System.out.println("\n----------print middle of list------------\n");
		printList(newList.head);
		newList.printMiddle();

		System.out.println("\n----------print Nth node of list 4------------\n");
		printList(newList.head);
		newList.printNthNode(4);

		System.out.println("\n----------print Nth node from last of list 4------------\n");
		printList(newList.head);
		newList.printNthNodeLast(4);

		System.out.println("\n----------removing duplicates from sorted list------------\n");
		newList.pushAfter(newList.head.next, 8);
		newList.pushAfter(newList.head.next.next, 8);
		newList.pushFirst(9);
		newList.pushFirst(9);
		newList.pushFirst(9);
		newList.pushEnd(2);
		newList.pushEnd(2);
		printList(newList.head);
		newList.removeDuplicatesSorted();
		printList(newList.head);

		System.out.println("\n----------detecting loop------------\n");
		newList.length();
		newList.head.next.next.next.next = newList.head.next; // uncomment to make loop
		newList.detectLoop();

		System.out.println("\n----------detecting loop length------------\n");
		int length = newList.detectLoopLength();
		System.out.println("loop length ::" + length);

		System.out.println("\n----------break loop------------\n");
		newList.breakLoop();
		printList(newList.head);
		newList.pushEnd(1);
		newList.pushEnd(2);
		newList.pushEnd(4);
		newList.pushEnd(6);
		newList.pushEnd(7);
		System.out.println("\n");
		printList(newList.head);

//		System.out.println("\n----------palindrome------------\n");
//		newList.checkPalindrome();

		System.out.println("\n----------removeDuplicatesUnsorted------------\n");
		newList.removeDuplicatesUnsorted();
		printList(newList.head);

		System.out.println("\n----------pairwiseSwap------------\n");
		newList.pairwiseSwap();
		printList(newList.head);

		System.out.println("\n----------rotating list------------\n");
		newList.rotate(2);
		newList.pushEnd(0);
		newList.pushEnd(10);
		printList(newList.head);

		System.out.println("\n----------reversing in group------------\n");
		newList.head = newList.reverseGroup(newList.head, 3);
		printList(newList.head);

		System.out.println("\n----------deleteAlternateNodes------------\n");
		newList.deleteAlternateNodes();
		printList(newList.head);

		System.out.println("\n----------deleting list------------\n");
		newList.deleteList();

//		newList.pushEnd(11);
//		newList.pushEnd(20);
//		newList.pushEnd(40);
//		newList.pushEnd(55);
//		newList.pushEnd(77);
//		newList.pushEnd(80);

		newList.pushEnd(10);
		newList.pushEnd(1);
		newList.pushEnd(2);
		newList.pushEnd(3);
		newList.pushEnd(5);
		newList.pushEnd(6);
		newList.pushEnd(7);
		newList.pushEnd(8);
		printList(newList.head);

		System.out.println("\n----------alternateOddEven------------\n");
		newList.alternateOddEven();
		printList(newList.head);

		newList.deleteList();

		newList.pushEnd(10);
		newList.pushEnd(20);
		newList.pushEnd(30);
		newList.pushEnd(40);
		newList.pushEnd(50);
		newList.pushEnd(60);
		newList.pushEnd(70);
		newList.pushEnd(80);

//		newList.pushEnd(12);
//		newList.pushEnd(15);
//		newList.pushEnd(11);
//		newList.pushEnd(10);
//		newList.pushEnd(9);
//		newList.pushEnd(90);
//		newList.pushEnd(70);
//		newList.pushEnd(80);
		printList(newList.head);

		System.out.println("\n----------deleting nodes with greater right side------------\n");
		newList.deleteGreaterRight();
		printList(newList.head);

		System.out.println("\n----------addTwoNumbers------------\n");

		SingleLinkedList newList1 = new SingleLinkedList();
		SingleLinkedList newList2 = new SingleLinkedList();

		newList1.pushEnd(5);
		newList1.pushEnd(6);
		newList1.pushEnd(3);

		newList2.pushEnd(8);
		newList2.pushEnd(4);
		newList2.pushEnd(7);

//		newList1.pushEnd(7);
//		newList1.pushEnd(5);
//		newList1.pushEnd(9);
//		newList1.pushEnd(4);
//		newList1.pushEnd(6);
//
//		newList2.pushEnd(8);
//		newList2.pushEnd(4);

		addTwoNumbers(newList1.head, newList2.head);

		System.out.println("\n----------reverse3alternate------------\n");
		newList.deleteList();
		newList.pushEnd(10);
		newList.pushEnd(20);
		newList.pushEnd(30);
		newList.pushEnd(40);
		newList.pushEnd(50);
		newList.pushEnd(60);
		newList.pushEnd(70);
		newList.pushEnd(80);
		printList(newList.head);
		newList.head = newList.reverseKalternate(newList.head, 3);
		System.out.println("\n");
		printList(newList.head);
		newList.pushEnd(90);
		System.out.println("\n----------alternatingSplit------------\n");
		newList.alternatingSplit();

		System.out.println("\n---------- triplet ------------\n");
		SingleLinkedList l1 = new SingleLinkedList();
		SingleLinkedList l2 = new SingleLinkedList();
		SingleLinkedList l3 = new SingleLinkedList();

		l1.pushEnd(12);
		l1.pushEnd(6);
		l1.pushEnd(29);

		l2.pushEnd(5);
		l2.pushEnd(8);
		l2.pushEnd(23);

		l3.pushEnd(90);
		l3.pushEnd(59);
		l3.pushEnd(20);
		printList(l1.head);
		System.out.println("\n");
		printList(l2.head);
		System.out.println("\n");
		printList(l3.head);
		triplet(l1.head, l2.head, l3.head, 101);

		System.out.println("\n----------flatteningMultiLevelLL------------\n");
		SingleLinkedList list = new SingleLinkedList();
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		int arr3[] = new int[] { 17, 6 };
		int arr4[] = new int[] { 9, 8 };
		int arr5[] = new int[] { 19, 15 };
		int arr6[] = new int[] { 2 };
		int arr7[] = new int[] { 16 };
		int arr8[] = new int[] { 3 };
		Node head1 = createList(arr1, arr1.length);
		Node head2 = createList(arr2, arr2.length);
		Node head3 = createList(arr3, arr3.length);
		Node head4 = createList(arr4, arr4.length);
		Node head5 = createList(arr5, arr5.length);
		Node head6 = createList(arr6, arr6.length);
		Node head7 = createList(arr7, arr7.length);
		Node head8 = createList(arr8, arr8.length);

		head1.child = head2;
		head1.next.next.next.child = head3;
		head3.child = head4;
		head4.child = head5;
		head2.next.child = head6;
		head2.next.next.child = head7;
		head7.child = head8;

		list.flatteningMultiLevelLL(list.head);
		printList(list.head);

		System.out.println("\n----------keepMdeleteN------------\n");
		SingleLinkedList list2 = new SingleLinkedList();
		list2.pushEnd(1);
		list2.pushEnd(2);
		list2.pushEnd(3);
		list2.pushEnd(4);
		list2.pushEnd(5);
		list2.pushEnd(6);
		list2.pushEnd(7);
		list2.pushEnd(8);
		list2.pushEnd(9);
		list2.pushEnd(10);
		printList(list2.head);
		list2.keepMdeleteN(1, 1);
		System.out.println("\n");
		printList(list2.head);

		System.out.println("\n----------sort012------------\n");
		list2.deleteList();
		list2.pushEnd(1);
		list2.pushEnd(2);
		list2.pushEnd(2);
		list2.pushEnd(2);
		list2.pushEnd(0);
		list2.pushEnd(2);
		list2.pushEnd(1);
		list2.pushEnd(0);
		list2.pushEnd(2);
		list2.pushEnd(0);
		list2.sort012();
		printList(list2.head);
	}

	void sort012() {
		Node node = head;
		Node temp = null;
		Node res = null;
		int n1 = 0, n2 = 0, n3 = 0;
		while (node != null) {
			if (node.data == 0) {
				n1++;
			} else if (node.data == 1) {
				n2++;
			} else if (node.data == 2) {
				n3++;
			}
			node = node.next;
		}

		while (n1 != 0) {
			if (res == null) {
				res = new Node(0);
				temp = res;
			} else {
				res.next = new Node(0);
				res = res.next;
			}
			n1--;
		}

		while (n2 != 0) {
			if (res == null) {
				res = new Node(1);
				temp = res;
			} else {
				res.next = new Node(1);
				res = res.next;
			}
			n2--;
		}

		while (n3 != 0) {
			if (res == null) {
				res = new Node(2);
				temp = res;
			} else {
				res.next = new Node(2);
				res = res.next;
			}
			n3--;
		}
		head = temp;

	}

	void keepMdeleteN(int m, int n) {
		Node curr = head;
		Node prev = null;
		int i = 0;
		boolean flag = true;
		while (curr != null) {
			if (flag) {
				while ((i < m - 1) && (curr != null)) {
					i++;
					curr = curr.next;
				}
				prev = curr;
				curr = curr.next;
				flag = false;
			} else {

				while ((i < n) && (curr != null)) {
					i++;
					prev.next = curr.next;
					curr = curr.next;

				}
				flag = true;
			}
			i = 0;
		}
	}

	static Node createList(int[] arr, int n) {

		Node node = null;
		Node p = null;

		int i;
		for (i = 0; i < n; ++i) {
			if (node == null) {
				node = p = new Node(arr[i]);
			} else {
				p.next = new Node(arr[i]);
				p = p.next;
			}
			p.next = p.child = null;
		}
		return node;
	}

	void flatteningMultiLevelLL(Node node) {

		if (node == null) {
			return;
		}

		Node tmp = null;
		Node tail = node;
		while (tail.next != null) {
			tail = tail.next;
		}
		Node cur = node;
		while (cur != tail) {
			if (cur.child != null) {

				tail.next = cur.child;
				tmp = cur.child;
				while (tmp.next != null) {
					tmp = tmp.next;
				}
				tail = tmp;
			}
			cur = cur.next;
		}

	}

	static void triplet(Node n1, Node n2, Node n3, int n) {
		// assume we sorted n2 in asc and n3 in descending
		Node a = n1;
		boolean flag = false;
		while (a != null) {
			Node b = n2;
			Node c = n3;
			while ((b != null) && (c != null)) {
				int ans = a.data + b.data + c.data;
				if (ans == n) {
					System.out.println("\n\npair found ::" + a.data + "," + b.data + "," + c.data + "\n");
					flag = true;
					break;
				} else if (ans < n) {
					b = b.next;
				} else {
					c = c.next;
				}
			}
			if (flag)
				break;
			a = a.next;
		}
	}

	void alternatingSplit() {
		Node head1 = null, head2 = null;
		Node h1 = null;
		Node h2 = null;
		Node curr = head;
		int i = 1;
		while (curr != null) {
			if ((i % 2) == 0) {
				if (h2 == null) {
					h2 = curr;
					head2 = h2;
				} else {
					h2.next = curr;
					h2 = h2.next;
				}
			} else {
				if (h1 == null) {
					h1 = curr;
					head1 = h1;
				} else {
					h1.next = curr;
					h1 = h1.next;
				}
			}
			curr = curr.next;
			i++;
		}
		if (h1 != null) {
			h1.next = null;
		}
		if (h2 != null) {
			h2.next = null;
		}
		System.out.println("\n list1 \n");
		print(head1);
		System.out.println("\n list2 \n");
		print(head2);
	}

	void print(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + "-->");
			node = node.next;
		}
		System.out.print(node.data);
	}

	Node reverseKalternate(Node head, int k) {
		Node curr = head;
		Node prev = null, next = null;
		int count = 0;

		while ((count < k) && (curr != null)) {
			count++;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if (head != null) {
			head.next = next;
		}
		count = 0;
		if (curr != null) {
			while (count < (k - 1)) {
				curr = curr.next;
				count++;
			}
		}
		if (curr != null) {
			curr.next = reverseKalternate(curr.next, k);
		}
		return prev;
	}

	static void addTwoNumbers(Node l1, Node l2) {
		int length1 = lengthOfListStatic(l1);
		int length2 = lengthOfListStatic(l2);
		Node res = null;
		int diff = 0;
		if (length1 > length2) {
			diff = length1 - length2;
			while (diff != 0) {
				addEnd(l2, 0);
				diff--;
			}
		} else if (length2 > length1) {
			diff = length2 - length1;
			while (diff == 0) {
				addEnd(l2, 0);
				diff--;
			}
		}

		res = add(l1, l2);
		printList(res);
	}

	static Node add(Node l1, Node l2) {
		Node res = null, finalHead = null;
		int rem = 0;
		int carry = 0;
		int add = 0;

		while (l1 != null && l2 != null) {
			if (carry == 0)
				add = l1.data + l2.data;
			else {
				add = l1.data + l2.data + carry;
				carry = 0;
			}

			if (add > 10)
				rem = add % 10;
			else if (add == 10) {
				rem = 0;
				carry = 1;
			} else
				rem = 0;

			if (rem > 0) {
				carry = 1;
				if (res == null) {
					res = new Node(rem);
					finalHead = res;
				} else {
					res.next = new Node(rem);
					res = res.next;
				}
			} else {
				if (carry == 1) {
					if (res == null) {
						res = new Node(0);
						finalHead = res;
					} else {
						res.next = new Node(0);
						res = res.next;
					}
				} else {
					carry = 0;
					if (res == null) {
						res = new Node(add);
						finalHead = res;
					} else {
						res.next = new Node(add);
						res = res.next;
					}
				}
			}

			l1 = l1.next;
			l2 = l2.next;
		}
		if (carry > 0) {
			res.next = new Node(carry);
		}

		return finalHead;
	}

	static void addEnd(Node head, int n) {
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(n);
	}

//	void deleteGreaterRight() {
//		Node curr = head;
//		Node prev = head;
//
//		while (curr != null && curr.next != null) {
//			if (curr.data < curr.next.data) {
//				if (prev == head) {
//					head = head.next;
//					prev = head;
//				} else {
//					prev.next = curr.next;
//				}
//				curr = curr.next.next;
//			} else {
//				prev = curr;
//				curr = curr.next.next;
//			}
//		}
//	}

	void deleteGreaterRight() {
		Node curr = head;
		Node prev = head;

		while (curr != null && curr.next != null) {
			if (curr.data < curr.next.data) {
				if (prev == head) {
					head = head.next;
					prev = head;
				} else {
					prev.next = curr.next;
				}
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
	}

	void alternateOddEven() {
		Node even = null, odd = null, res = null, curr = head, finalRes = null;
		int i = 1;
		while (curr != null) {
			if ((i % 2) != 0) {
				if (odd != null && odd.data > 0) {
					res.next = odd;
					odd = null;
					res = res.next;
					i++;
				} else if ((curr.data) % 2 != 0) {
					if (res == null) {
						res = curr;
						finalRes = res;
					} else {
						res.next = curr;
						res = res.next;
					}
					i++;
					curr = curr.next;
				} else {
					if (even == null) {
						even = curr;
					} else {
						even.next = curr;
						even = even.next;
					}
					curr = curr.next;
				}

			} else {
				if (even != null && even.data > 0) {
					res.next = even;
					even = null;
					res = res.next;
					i++;
				} else if ((curr.data) % 2 == 0) {
					if (res == null) {
						res = curr;
						finalRes = res;
					} else {
						res.next = curr;
						res = res.next;
					}
					i++;
					curr = curr.next;
				} else {
					if (odd == null) {
						odd = curr;
					} else {
						odd.next = curr;
						odd = odd.next;
					}
					curr = curr.next;
				}

			}
		}

		if (even == null && odd == null) {
			head = finalRes;
			return;
		} else if (even == null) {
			res.next = odd;
			odd.next = null;
		}

		else if (odd == null) {

			res.next = even;
			even.next = null;
		}

		head = finalRes;
		return;
	}

	Node reverseGroup(Node head, int k) {
		Node curr = head, next = null, prev = null, temp = head;
		int i = 1, j = 1;

		while ((j <= k) && (temp != null)) {
			j++;
			temp = temp.next;
		}

		if (j <= k) {
			return curr;
		} else {
			while ((i <= k) && (curr != null)) {
				i++;

				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;

			}

			if (next != null) {
				head.next = reverseGroup(next, k);
			}
			return prev;
		}

	}

	void deleteAlternateNodes() {
		Node curr = head;

		while (curr != null && curr.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
		}
	}

	void deleteList() {
		head = null;
	}

	void printNthNode(int n) {
		Node node = head;
		int i = 1;
		while (i < n) {
			i++;
			node = node.next;
		}
		System.out.println("\n" + node.data);
	}

	void printNthNodeLast(int n) {
		Node slow = head;
		Node fast = head;
		int i = 1;
		while (i < n) {
			i++;
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println("\n" + slow.data);
	}

	void pushFirst(int n) {
		if (head == null) {
			head = new Node(n);
			head.next = null;
		} else {
			Node newnode = new Node(n);
			newnode.next = head.next;
			head.next = newnode;
		}
		return;
	}

	void reverseList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return;
	}

	int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.next != n) {
			res++;
			temp = temp.next;
		}
		return res;
	}

	void removeDuplicatesSorted() {
		Node temp = head.next;
		Node node = head;
		if (temp == null) {
			System.out.println("LL donot contain any duplicates");
		}
		while (node != null && node.next != null) {
			while ((temp != null) && (temp.data == node.data)) {
				node.next = temp.next;
				temp = temp.next;
			}
			node.next = temp;
			node = node.next;
		}
		System.out.println("\nremoved duplicates\n");
	}

	void removeDuplicatesUnsorted() {
		HashSet<Integer> hs = new HashSet<>();

		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;

			if (hs.contains(curval)) {
				prev.next = current.next;
			} else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}

	}

	void pairwiseSwap() {
		Node node = head;

		while (node != null && node.next != null) {
			int temp = node.data;
			node.data = node.next.data;
			node.next.data = temp;
			node = node.next.next;
		}
	}

	void checkPalindrome() {
		Node temp = head;
		Node node = null;
		Node slow = head;
		Node fast = head;
		while (true) {
			fast = fast.next.next;
			if (fast == null) {
				node = slow.next;
				slow.next = null;
				break;
			}
			if (fast.next == null) {
				node = slow.next.next;
				slow.next = null;
				break;
			}
			slow = slow.next;
		}
		reverse(node);
		while (node != null) {
			if (temp.next == node.next) {
				temp = temp.next;
				node = node.next;
			} else {
				System.out.println("notPalindrome");
				return;
			}
		}
		System.out.println("Palindrome");
		return;
	}

	void reverse(Node node) {

		Node prev = null;
		Node current = node;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
	}

	void intersectionPoint(Node head1, Node head2) {
		int length1 = lengthOfList(head1);
		int length2 = lengthOfList(head2);
		int diff;
		boolean ll1 = false;
		if (length1 > length2) {
			ll1 = true;
			diff = length1 - length2;
		} else {
			ll1 = false;
			diff = length2 - length1;
		}
		if (ll1) {
			int j = 1;
			while (j < diff) {
				head1 = head1.next;
			}
		} else {
			int k = 1;
			while (k < diff) {
				head2 = head2.next;
			}
		}

		while (head1.next != null && head2.next != null) {
			if (head1.next != head2.next) {
				head1 = head1.next;
				head2 = head2.next;
			} else {
				break;
			}
		}
		System.out.println("intersection point is ::" + head1.next.data);
	}

	int lengthOfList(Node node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	static int lengthOfListStatic(Node node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	Node concatenateLists(Node A, Node B) {
		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.data < B.data) {
			A.next = concatenateLists(A.next, B);
			return A;
		} else {
			B.next = concatenateLists(A, B.next);
			return B;
		}
	}

	void printMiddle() {
		Node slow = head;
		Node fast = head;
		while ((slow != null) && (fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Mid element is " + slow.data);
		return;
	}

	void detectLoop() {
		Node slow = head;
		Node fast = head;
		while ((slow != null) && (fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("loop found at" + fast.data);
				return;
			}
		}
		System.out.println("No loop found");
		return;
	}

	void breakLoop() {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("loop found at" + fast.data);
				break;
			}
		}
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
		System.out.println("broke loop");
		return;
	}

	int detectLoopLength() {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("loop found at" + fast.data);
				return countNodes(slow);
			}
		}
		System.out.println("No loop found");
		return 0;
	}

	void length() {
		int length = 0;
		Node node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		System.out.println(length);
	}

	void pushAfter(Node prev, int n) {
		if (prev == null) {
			System.out.println("prev cannot be null");
			return;
		} else {
			Node newnode = new Node(n);
			newnode.next = prev.next;
			prev.next = newnode;
		}
		return;
	}

	void pushEnd(int n) {
		if (head == null) {
			head = new Node(n);
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node(n);
		}
		return;
	}

	void delete(int n) {
		if (head == null) {
			System.out.println("LL is empty");
		} else if (head.data == n) {
			head = head.next;
		} else {
			Node node = head;
			while (node.next.data != n) {
				node = node.next;
			}
			node.next = node.next.next;
		}

	}

	void rotate(int n) {
		Node a, b, newHead;
		a = head;
		while (a != null) {
			if (a.data == n) {
				break;
			}
			a = a.next;
		}
		newHead = a.next;
		a.next = null;
		b = newHead;
		while (b.next != null) {
			b = b.next;
		}
		b.next = head;
		head = newHead;
	}

	static void printList(Node head) {
		Node node = head;
		if (node != null) {
			while (node.next != null) {
				System.out.print(node.data + "-->");
				node = node.next;
			}
			System.out.print(node.data);
		}
	}
}

//while (even != null && odd != null) {
//if ((i % 2) != 0) {
//	res.next = odd;
//	odd = odd.next;
//} else {
//	res.next = even;
//	even = even.next;
//}
//i++;
//}
