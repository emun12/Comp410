package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	

	BST_Node(String data){ this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	// --- end used for testing -------------------------------------------

	public int height_of_tree() {
		int left_height = 0;
		int right_height = 0;
		// you need the right and left heights because they can have different
		// subtree lengths and you need to see which length is longer

		if (right != null) {
			right_height = right.height_of_tree();
			right_height++;
			// if the right branch isn't empty, then you need to recursively call
			// the height so that it can keep on adding its length.
			// The recursive call lets you only add 1 to the length when it is
			// actively showing that it is linked instead of just counting 
			// how many nodes are in one branch
		}

		if (left != null) {
			left_height = left.height_of_tree();
			left_height++;
			// if the left branch isn't empty, then you need to recursively call
			// the height so that it can keep on adding its length.
			// The recursive call lets you only add 1 to the length when it is
			// actively showing that it is linked instead of just counting 
			// how many nodes are in one branch
		}
		// don't do if else because you need to calculate right and left lengths
		// separately 



		int max_length = 0;
		// this will be used to compare which branch length is longer
		if(left_height > right_height) {
			max_length = left_height;
			return max_length;
		}

		else {
			// assume based on first if statement that right length is longer
			max_length = right_height;
			return max_length;
		}


	}
	
	
	

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}





}
