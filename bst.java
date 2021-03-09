class bst { 
	class Node 
	{ 
		int data; 
		Node l, r; 

		public Node(int d) 
		{ 
			data = d; 
			l= r = null; 
		} 
	} 
	Node root; 
	bst() 
	{ 
		root = null; 
	} 
	void insert(int data) 
	{ 
		root = insert(root,data); 
	} 
	Node insert(Node root, int data) 
	{ 
		if (root == null) 
		{ 
			root = new Node(data); 
			return root; 
		} 
		if (data < root.data) 
			root.l = insert(root.l, data); 
		else if (data > root.data) 
			root.r = insert(root.r, data); 
		return root; 
	} 
	void pre() 
	{ 
		preorder(root); 
	} 
	void preorder(Node root) 
	{ 
		if (root != null) { 
            System.out.print(root.data+" ");
			preorder(root.l);  
			preorder(root.r); 
		} 
	} 
	public static void main(String[] args) 
	{ 
		bst tree = new bst(); 
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80);  
		tree.pre(); 
	} 
} 
	/*      50 
		 30	   70  
	   20 40 60  80 */