import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

	private PriorityQueue<Integer> pq = new PriorityQueue<>();
	private DirectedGraph g;
	private double dist[];

	public Dijkstra(DirectedGraph g, int start) {
		this.g = g;
		dist = new double[g.size()];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		search(start);
	}

	public void search(int start) {
		pq.offer(start);
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int u = pq.poll();
			for (int v: g.adjacents(u))
				if (dist[v] > dist[u] + g.cost(u, v)) {
					dist[v] = dist[u] + g.cost(u, v);
					pq.offer(v);
				}
		}
	}

	public boolean hasPathTo(int v) {
		return dist[v] != Double.POSITIVE_INFINITY;
	}

	public double distanceTo(int v) {
		return dist[v];
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		for (double e: dist)
			b.append(e+", ");
		return b.toString();
	}

	public static void main(String[] args) throws Exception {
		DirectedGraph m = new DirectedGraph();
		m.addNode(0);
		m.addNode(1);
		m.addNode(2);
		m.addNode(3);
		m.addNode(4);
		m.addNode(5);
		m.addNode(6);
		m.addNode(7);
		m.addNode(8);
		m.addNode(9);
		m.addEdge(0, 1, 4);
		m.addEdge(0, 3, 13);
		m.addEdge(1, 2, 7);
		m.addEdge(2, 4, 12);
		m.addEdge(2, 5, 9);
		m.addEdge(3, 1, 11);
		m.addEdge(3, 0, 18);
		m.addEdge(4, 3, 15);
		m.addEdge(5, 4, 3);
		m.addEdge(3, 8, 6);
		m.addEdge(3, 9, 7);
		m.addEdge(5, 7, 8);
		m.addEdge(5, 6, 6);
		m.addEdge(8, 7, 12);
		m.addEdge(7, 4, 13);
		m.addEdge(6, 7, 5);
		Dijkstra di = new Dijkstra(m, 0);
		System.out.println(di);
		System.out.print(di.distanceTo(8));
	}
}