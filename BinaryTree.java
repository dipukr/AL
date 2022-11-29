public class BinaryTree {
	
	private static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node (int data) {this(data,null,null);}
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	public boolean empty() {return root == null;}
	public int size() {return size(root);}
	public int height() {return height(root);}

	public void dfs() {
		var stack = new Stack<Node>();
		stack.push(root);
		while (!stack.empty()) {
			var node = stack.pop();
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
			System.out.print(node.data+"\t");
		}
	}

	public void bfs() {
		var queue = new Queue<Node>();
		queue.enqueue(root);
		while (!queue.empty()) {
			var node = queue.dequeue();
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
			System.out.print(node.data+"\t");
		}
	}

	public void bfsLevel() {
		var queue = new Queue<Node>();
		queue.enqueue(root);
		queue.enqueue(null);
		int level = 1;
		System.out.printf("Level %d: ", level);
		while (!queue.empty()) {
			var node = queue.dequeue();
			if (node != null) {
				System.out.print(node.data+"\t");
				if (node.left != null)
					queue.enqueue(node.left);
				if (node.right != null)
					queue.enqueue(node.right);
			} else if (!queue.empty()) {
				level++;
				queue.enqueue(null);
				System.out.printf("\nLevel %d: ", level);
			}
		}
	}

	public void leftView() {
		
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(size(node.left), size(node.right));
	}

	/***
	 *            20
	 *           /	\
	 *         40    10
	 *        /  \     \
	 *       70   30    60
	 *         \         \
	 *          50        80
	 *                     \
	 *                     90
	***/                     
	public static void main(String[] args) throws Exception {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		n2.left = n4;
		n2.right = n1;
		n4.left = n7;
		n4.right = n3;
		n7.right = n5;
		n1.right = n6;
		n6.right = n8;
		n8.right = n9;
		var tree = new BinaryTree(n2);
		tree.bfsLevel();	
	}
}