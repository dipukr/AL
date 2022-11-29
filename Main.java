public class Main {
	public static void main(String[] args) throws Exception {
		var bh = new BinaryHeap<Integer>();
		bh.insert(100);
		bh.insert(200);
		bh.insert(10);
		System.out.println(bh.deleteMin());
	}
}