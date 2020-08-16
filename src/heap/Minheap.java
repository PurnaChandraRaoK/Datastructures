package heap;

public class Minheap {

	int[] mh;
	int currentSize, capacity;

	public Minheap(int capacity) {
		this.capacity = capacity;
		mh = new int[capacity + 1];
		this.currentSize = 0;
	}

	public void createHeap(int[] arrA) {
		if (arrA.length > 0) {
			for (int i = 0; i < arrA.length; i++) {
				insert(arrA[i]);
			}
		}
	}

	void insert(int n) {
		if (this.currentSize == this.capacity) {
			System.out.println("heap is full");
		}
		this.currentSize++;
		this.mh[currentSize] = n;
		bubbleUp(currentSize);
	}

	void bubbleUp(int size) {
		int parent = size / 2;
		int cur = size;
		while (cur > 0 && this.mh[cur] < this.mh[parent]) {
			swap(cur, parent);
			cur = parent;
			parent = parent / 2;
		}
	}

	public void display() {
		for (int i = 1; i < this.mh.length; i++) {
			System.out.print(" " + this.mh[i]);
		}
		System.out.println("");
	}

	void swap(int a, int b) {
		int temp = this.mh[a];
		this.mh[a] = this.mh[b];
		this.mh[b] = temp;
	}

	public int extractMin() {
		int min = mh[1];
		mh[1] = mh[currentSize];
		mh[currentSize] = 0;
		sinkDown(1);
		currentSize--;
		return min;
	}

	public void sinkDown(int k) {
		int smallest = k;
		int leftChildIdx = 2 * k;
		int rightChildIdx = 2 * k + 1;
		if (leftChildIdx < heapSize() && mh[smallest] > mh[leftChildIdx]) {
			smallest = leftChildIdx;
		}
		if (rightChildIdx < heapSize() && mh[smallest] > mh[rightChildIdx]) {
			smallest = rightChildIdx;
		}
		if (smallest != k) {

			swap(k, smallest);
			sinkDown(smallest);
		}
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public int heapSize() {
		return currentSize;
	}

	public static void main(String args[]) {
		int arrA[] = { 3, 2, 1, 7, 8, 4, 10, 16, 12 };
		System.out.print("Original Array : ");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
		}
		Minheap m = new Minheap(arrA.length);
		System.out.print("\nMin-Heap : ");
		m.createHeap(arrA);
		m.display();
		System.out.print("Extract Min :");
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + m.extractMin());
		}
	}
}
