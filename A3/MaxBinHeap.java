package MaxBinHeap_A3;

public class MaxBinHeap implements Heap_Interface{
	private double[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MaxBinHeap() {
		this.array = new double[arraySize];
		array[0] = Double.NaN;  //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	
	@Override
	public double[] getHeap() { 
		return this.array;
	}

	@Override
	public void insert(double element) {

		if(size == 0) {
			//if tree is empty, put it in index = 1
			array[1] = element;
			size++;
		}
		else {
			array[size+1] = element;
			size++;
			bubbleUp(size);


		}

	}

	public void bubbleUp(int index) {

		int root = size;
		while(hasParent(root) && parent(root) < array[root]) {
			// it needs to have a parent to be able to switch

			double temp = array[getParentIndex(root)];
			array[getParentIndex(root)] = array[root];
			array[root] = temp;
			
			// switching 2 values

			root = getParentIndex(root);
			// to keep going up the index 
		}

	}


	@Override
	public void delMax() {

		if(size == 0) {
			return;
			// returns void if it is an empty heap
		}

		array[1] = array[size];
		
		array[size] = 0;
		size--;
		
		
		
		int lastIndex = size;
		
		while( lastIndex> 0) {
			
			int temp = lastIndex/2;
			int child;
			
			while((temp*2) <= size) {
				
				
				if(hasRightLeaf(temp) &&( rightChild(temp) > leftChild(temp))) {
					child = getRightIndex(temp);
					// you need to check which child has a bigger value and this will automatically keep heap order
				}else {
				child = getLeftIndex(temp);
				// if there's no right child, then just switch left child
				}
				
				if(array[temp]<array[child]) {
					double temp1 = array[temp];
					array[temp] = array[child];
					array[child] = temp1;
					// swaps values
				} else {
					break;
					// gets out of loop
				}
				temp = child;
				// needs to keep going to next index
			}
			lastIndex = lastIndex-1;
		}
		
		
		
		

	}

	public void bubbleDown() {
		int root = 1;

		while(hasLeftLeaf(root)) {
			int BiggerChildIndex = getLeftIndex(root);

			if(hasRightLeaf(root) && rightChild(root) > leftChild(root)) {
				BiggerChildIndex = getRightIndex(root);

			}

			if(array[root] > array[BiggerChildIndex]) {
				break;
			} else {
				double temp = array[root];
				array[root] = array[BiggerChildIndex];
				array[BiggerChildIndex] = temp;
			}
			root = BiggerChildIndex;
		}



	}


	@Override
	public double getMax() {
		if(size == 0) {
			return Double.NaN;
		}
		return array[1];
		// this is parent node
	}

	@Override
	public void clear() {

		for(int i = 1; i<size; i++) {

			array[i] = 0;
		}

		size = 0;


	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(double[] elements) {
		clear();
		int lastIndex = 0;
		// empty the internal heap array first

		for(int j = 0; j<elements.length; j++) {
			this.array[j+1] = elements[j];
			size++;
			lastIndex = j+1;
		}
		// inserts every element from elements into array without
		// regard to heap order


	
		/*
		 * Start with parent of last element and bubble down
		 * go back one node toward root and repeat until you get
		 * to root
		 */


		while(lastIndex > 0) {
			
			int temp = lastIndex/2;
			int child;
			
			while((temp*2) <= size) {
				
				if(hasRightLeaf(temp) &&( rightChild(temp) > leftChild(temp))) {
					// you need to check which child has a bigger value and this will automatically keep heap order
					child = getRightIndex(temp);
				}else {
				child = getLeftIndex(temp);
				// if there's no right child, then just switch left child
				}
				
				if(array[temp]<array[child]) {
					double temp1 = array[temp];
					array[temp] = array[child];
					array[child] = temp1;
				} else {
					break;
				}
				temp = child;
			}
			lastIndex = lastIndex-1;
		}



	}

	@Override
	public double[] sort(double[] elements) {
		clear();
		
		build(elements);
		// gives u a heap
		
		int length = elements.length;
		
		double[] new_one = new double[length];
		// this will have values decreasing
		
		for(int i=0;i<length;i++) {
			double max = getMax();
			// get root
			new_one[i] = max;
			// add to array
			delMax();
			// delete root to get a new max value for the next loop
		}
		
		double[]final_one = new double[length];
		// final one array will have values increasing
		for(int j=0; j<length; j++) {
			final_one[length-1-j] = new_one[j];
		}
		
		return final_one;
		
		
		

	}

	
	/*
	 * Helper Functions to help make it easier to get certain values and indexes
	 */

	// these are getters to get index using math on how to get right and left children index from array
	public int getLeftIndex(int index) {
		return 2*index;
	}
	public int getRightIndex(int index) {
		return (2*index)+1;
	}
	public int getParentIndex(int index) {
		return index/2;
	}


	// boolean to check if a leaf is empty since you will check which leaf has bigger values
	public boolean hasLeftLeaf(int index) {
		return getLeftIndex(index) <= size;
	}
	public boolean hasRightLeaf(int index) {
		return getRightIndex(index) <= size;
	}
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}


	// getting values of the array at certain indexes
	public double leftChild(int index) {
		return array[getLeftIndex(index)];
	}
	public double rightChild(int index) {
		return array[getRightIndex(index)];
	}
	public double parent(int index) {
		return array[getParentIndex(index)];
	}


}
