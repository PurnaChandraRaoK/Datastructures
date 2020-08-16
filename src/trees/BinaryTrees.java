package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTrees {
	int[] paths = new int[500];
	int pathLength = 0;
	static Node root;
	public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
	public ArrayList<Integer> al;
	public static TreeMap<Integer, Integer> tree = new TreeMap<>();
	public Queue<QueuePack> q;
	String path;

	static class Node {
		int data;
		Node left, right;

		Node(int value) {
			data = value;
			left = null;
			right = null;
		}
	}

	class QueuePack {
		int level;
		Node tnode;

		public QueuePack(int level, Node tnode) {
			this.level = level;
			this.tnode = tnode;
		}
	}

	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String args[]) {
		root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.print("Inorder traversal before insertion:");
		inorder(root);

		int key = 12;
		insert(root, key);

		System.out.print("\nInorder traversal after insertion:");
		inorder(root);

		System.out.print("\nHeight of tree:");

		int height = height(root);
		System.out.println(height);

		System.out.print("\nPostorder traversal after given inorder and preorder:");

		int in1[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		int n = in1.length;
		System.out.println("Postorder traversal ");
		givenInAndPreOrder(in1, pre, n);

		System.out.println("inorderWithoutRecursionStack traversal ");
		BinaryTrees tree = new BinaryTrees();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorderWithoutRecursionStack();

		BinaryTrees bst = new BinaryTrees();

		System.out.println("BST insert ");

		bst.insertbst(1);
		bst.insertbst(2);
		bst.insertbst(3);
		bst.insertbst(4);
		bst.insertbst(5);
		bst.insertbst(6);
		bst.insertbst(7);

		System.out.println("check BT is BST or not...");
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		System.out.println("Tree is ");
		inorder(root);

		boolean flag = isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(flag);

		System.out.println("converting to tree with min height");
		int[] arrA = { 2, 3, 6, 7, 8, 9, 12, 15, 16, 18, 20 };
		Node nodeA = convertToMinHeight(arrA, 0, arrA.length - 1);
		System.out.println("Tree Display : ");
		inorder(nodeA);

		System.out.println("levelOrderprinting");
		Node n1 = new Node(5);
		n1.left = new Node(10);
		n1.right = new Node(15);
		n1.left.left = new Node(20);
		n1.left.right = new Node(25);
		n1.left.right.right = new Node(40);
		n1.right.left = new Node(30);
		n1.right.right = new Node(35);
		levelOrderQueue(n1);

		System.out.println("linkedlists for each level");
		levelOrderLists(n1);
		ArrayList<ListNode> arr = levelOrderLists(n1);
		display(arr);

		System.out.println("right view");
		rightView(n1, 1);

		Node n3 = new Node(5);
		n3.left = new Node(10);
		n3.right = new Node(15);
		n3.left.left = new Node(20);
		n3.left.right = new Node(25);
		n3.right.left = new Node(30);
		n3.right.right = new Node(35);
		System.out.println(" Is Tree Balanced : " + isBalanced(n3));
		n3.right.right.right = new Node(40);
		n3.right.right.right.right = new Node(45);
		System.out.println(" Is Tree Balanced : " + isBalanced(n3));

		System.out.println("right view");
		inorder(n3);
		greaterTree(n3);
		inorder(n3);

		System.out.println("print paths...");

		Node n4 = new Node(1);
		n4.left = new Node(2);
		n4.right = new Node(3);
		n4.left.left = new Node(4);
		n4.left.left.left = new Node(7);
		n4.right.left = new Node(6);
		n4.right.left.left = new Node(8);
		n4.right.left.right = new Node(9);
		int[] path = new int[100];
		printPaths(n4, "");

//		n3.vertical(root, 0);
//        n3.printResult(ht);
	}

	static boolean areCousins(Node n, int x, int y) {
		if (getHeight(n, x, 1) != getHeight(n, y, 1)) {
			return false;
		} else {
			if (!sameParent(n, x, y)) {
				return true;
			} else
				return false;
		}
	}

	static int getHeight(Node n, int x, int h) {
		if (n == null)
			return 0;
		if (n.data == x)
			return h;

		int level = getHeight(n.left, x, h + 1);

		if (level != 0)
			return level;
		else
			return getHeight(n.right, x, h + 1);
	}

	static boolean sameParent(Node n, int x, int y) {
		if (n == null)
			return false;

		return ((n.left.data == x && n.left.data == y) || (n.left.data == x && n.left.data == y)
				|| sameParent(n.left, x, y) || sameParent(n.right, x, y));
	}

	static Node LCABT(Node n, int a, int b) {

		if (n == null)
			return null;
		if (n.left.data == a || n.left.data == b)
			return n;

		Node left = LCABT(n.left, a, b);
		Node right = LCABT(n.right, a, b);

		if (left != null && right != null)
			return n;

		return left != null ? left : right;
	}

	// head is LL
	public Node LLToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node leftChild = LLToBST(start, mid - 1);
//		Node root = new Node(head.data);
		root.left = leftChild;
//		head = head.next;
		root.right = LLToBST(mid + 1, end);
		return root;
	}

	static Node givenInPost(int[] in, int[] post, int iStart, int iEnd, int pStart, int pEnd) {

		if (iStart > iEnd || pStart > pEnd)
			return null;

		if (iStart == iEnd)
			return root;

		Node root = new Node(post[pEnd]);
		int index = search(in, post[pEnd], iEnd);

		root.left = givenInPost(in, post, iStart, index, pStart, pStart + index - (iStart + 1));
		root.right = givenInPost(in, post, index + 1, iEnd, pStart + index - iStart, pEnd - 1);

		return root;
	}

	static Node LCABST(Node n, int a, int b) {
		if (n == null)
			return null;
		if ((n.data > a) && (n.data > b)) {
			LCABST(n.left, a, b);
		} else if ((n.data < a) && (n.data < b)) {
			LCABST(n.right, a, b);
		}
		return n;
	}

	static void printPaths(Node n, String s) {
//		if (n == null)
//			return;
//		path[pathLength++] = n.data;
//		if (n.left == null && n.right == null) {
//			print(path, pathLength);
//		} else {
//			printPaths(n.left, path, pathLength);
//			printPaths(n.right, path, pathLength);
//		}

		if (n == null) {

			return;
		}
		printPaths(n.left, s + "-" + n.data);
		if (n.left == null && n.right == null)
			System.out.println(s + "-" + n.data);
		printPaths(n.right, s + "-" + n.data);

	}

	static void print(int[] path, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	static int temp = 0;
	static int sum = 0;

	static void greaterTree(Node node) {
		if (node != null) {
			greaterTree(node.right);
			temp = node.data;
			node.data = sum;
			sum = sum + temp;
		} else
			return;
	}

	void hasPath(Node node, int sum, String path) {
		if (node != null) {
			if (node.data > sum) {
				return;
			} else {
				path = " " + node.data;
				sum = sum - node.data;
				if (sum == 0) {
					System.out.println(path);
				}
				hasPath(node.left, sum, path);
				hasPath(node.right, sum, path);
			}
		}
	}

	void bottomView(Node node, int level) {
		if (node == null)
			return;
		q.add(new QueuePack(level, node));
		while (!q.isEmpty()) {
			QueuePack queue = q.remove();
			Node tnode = queue.tnode;
			int lvl = queue.level;

			tree.put(lvl, tnode.data);

			if (tnode.left != null) {
				q.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				q.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}

	static boolean isBalanced(Node node) {
		if (node == null)
			return true;
		int d = height(node.left) - height(node.right);
		if (Math.abs(d) > 1)
			return false;
		else
			return isBalanced(node.left) && isBalanced(node.right);
	}

	static int currLevel = 0;

	void verticalView(Node node, int level) {
		if (node == null)
			return;

		if (ht.containsKey(level)) {
			ArrayList<Integer> x = ht.get(level);
			x.add(root.data);
			ht.put(level, x);
		} else {
			al = new ArrayList<>();
			al.add(node.data);
			ht.put(level, al);
		}
		verticalView(node.left, level--);
		verticalView(node.right, level++);
	}

	public void printResult(TreeMap ht) {
		Set<Integer> i = ht.keySet();
		for (int keys : i) {
			System.out.println(ht.get(keys));
		}
	}

	static void leftView(Node node, int nextLevel) {
		if (node == null)
			return;
		if (currLevel < nextLevel) {
			System.out.println(node.data);
			currLevel = nextLevel;
		}
		leftView(node.left, nextLevel + 1);
		leftView(node.right, nextLevel + 1);
	}

	static void rightView(Node node, int nextLevel) {
		if (node == null)
			return;
		if (currLevel < nextLevel) {
			System.out.println(node.data);
			currLevel = nextLevel;
		}
		rightView(node.right, nextLevel + 1);
		rightView(node.left, nextLevel + 1);
	}

	static ArrayList<ListNode> levelOrderLists(Node n) {
		Queue<Node> q = new LinkedList<Node>();
		int level;
		q.add(n);
		ArrayList<ListNode> a = new ArrayList<BinaryTrees.ListNode>();
		while (!q.isEmpty()) {
			level = q.size();
			ListNode head = null, curr = null;
			while (level > 0) {
				Node temp = q.remove();
				if (head == null) {
					curr = new ListNode(temp.data);
					head = curr;
				} else {
					curr.next = new ListNode(temp.data);
					curr = curr.next;
				}
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				level--;
			}
			a.add(head);
		}
		return a;
	}

	static void display(ArrayList<ListNode> al) {
		Iterator<ListNode> it = al.iterator();
		while (it.hasNext()) {
			ListNode head = it.next();
			while (head != null) {
				System.out.print("->" + head.data);
				head = head.next;
			}
			System.out.println("");
		}
	}

	// For right view do level order traversal and print last element
	// For left view do level order traversal and print first element

	static void levelOrderQueue(Node node) {
		if (node == null)
			return;
		Queue<Node> q = new LinkedList<BinaryTrees.Node>();
		q.add(node);
		int level;
		while (!q.isEmpty()) {
			level = q.size();
			while (level > 0) {
				Node n = q.remove();
				System.out.print(" " + n.data);
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
				level--;
			}
			System.out.println("");
		}
	}

	static Node convertToMinHeight(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = convertToMinHeight(arr, start, mid - 1);
		node.right = convertToMinHeight(arr, mid + 1, end);
		return node;
	}

	static int diameter(Node node) {
		int diameter = 0;

		if (node == null)
			return 0;

		int lh = height(node.left);
		int rh = height(node.right);

		int ld = diameter(node.left);
		int rd = diameter(node.right);

		diameter = Math.max(lh + rh + 1, Math.max(ld, rd));
		return diameter;
	}

	static boolean isBst(Node node, int min, int max) {
		if (node == null)
			return true;
		else {
			if ((node.data > max) || (node.data < min))
				return false;

			return isBst(node.left, min, node.data) && isBst(node.right, node.data, max);
		}
	}

	void topView(Node node) {
		int count = 0;
		if (node.left != null && count >= 0) {
			count++;
			topView(node.left);
		}

		System.out.println(node.left);
		count--;
		if (node.right != null && count < 0) {
			count--;
			topView(node.right);
		}

	}

	static int minValue(Node node) {
		int val = 0;
		while (node != null) {
			val = node.data;
			node = node.left;
		}
		return val;
	}

	void insertbst(int key) {
		root = inserstBST(root, key);
	}

	static Node inserstBST(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (root.data < key) {
			root.right = inserstBST(root.right, key);
		}
		if (root.data > key) {
			root.left = inserstBST(root.left, key);
		}

		return root;
	}

	static Node deleteNode(Node node, int n) {
		if (node == null) {
			return null;
		}
		if (node.data < n) {
			node.left = deleteNode(node.left, n);
		} else if (node.data > n) {
			node.right = deleteNode(node.right, n);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				node.data = minValue(node.right);
				node.right = deleteNode(node.right, node.data);
			}
		}
		return node;
	}

	static int search(int[] arr, int key, int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	static void givenInAndPreOrder(int[] in, int[] pre, int n) {
		int root = search(in, pre[0], n);

		if (root != 0) {
			givenInAndPreOrder(in, Arrays.copyOfRange(pre, 1, n), root);
		}
		if (root != (n - 1)) {
			givenInAndPreOrder(Arrays.copyOfRange(in, 1 + root, n), Arrays.copyOfRange(pre, 1 + root, n), n - root - 1);
		}

		System.out.println(pre[0] + " ");
	}

	static int height(Node root) {
		int lheight = 0;
		int rheight = 0;
		if (root == null)
			return 0;

		if (root.left != null) {
			lheight = 1 + height(root.left);
		}
		if (root.right != null) {
			rheight = 1 + height(root.right);
		}

		if (lheight > rheight)
			return (lheight);
		else
			return (rheight);
	}

	static void inorderwithStack(Node node) {
		Stack<Node> stack = new Stack<Node>();

		Node curr = node;

		while ((curr != null) && (!stack.isEmpty())) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();

			System.out.println(curr.data);

			curr = curr.right;
		}

	}

	static void preorderwithStack(Node node) {
		Stack<Node> stack = new Stack<Node>();

		Node curr = node;

		while ((curr != null) && (!stack.isEmpty())) {

			while (curr != null) {
				System.out.println(curr.data);
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			curr = curr.right;
		}

	}

	static void postorderWithStacks(Node node) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(node);
		Node curr;
		while (!stack1.isEmpty()) {
			curr = stack1.pop();
			stack2.push(curr);

			if (curr.left != null) {
				stack1.push(curr.left);
			}
			if (curr.right != null) {
				stack1.push(curr.right);
			}
		}

		while (!stack2.isEmpty()) {
			System.out.println((stack2.pop()).data + " ");
		}
	}

	static void insert(Node node, int n) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			node = q.peek();
			q.remove();
			if (node == null) {
				node = new Node(n);
				return;
			}

			if (node.left == null) {
				node.left = new Node(n);
				break;
			} else {
				q.add(node.left);
			}
			if (node.right == null) {
				node.right = new Node(n);
				break;
			} else {
				q.add(node.right);
			}
		}

	}

	static Node search(Node node, int n) {
		if (node == null || (node.data == n)) {
			return node;
		}

		if (node.data > n) {
			return search(node.right, n);
		}
		return search(node.right, n);
	}

	void inorderWithoutRecursionStack() {
		Node node = root;
		Node pre = null;

		while (node != null) {
			if (node.left == null) {
				System.out.println(node.data);
				node = node.right;
			} else {
				pre = node.left;

				while ((pre.right != null) && (pre.right != node)) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = node;
					node = node.left;
				} else {
					pre.right = null;
					System.out.print(node.data + " ");
					node = node.right;
				}
			}
		}

	}

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data + " ");
		inorder(root.right);
	}

	static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data + " ");
		inorder(root.left);
		inorder(root.right);
	}

	static void postorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		inorder(root.right);
		System.out.println(root.data + " ");

	}
}
