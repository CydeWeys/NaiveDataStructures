package com.cydeweys.dev.naivedatastructures;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ObjectGraph {

	public static void main(String[] args) {
		GraphNode origin = CreateSampleGraph();
		Set<GraphNode> minDistances = Dijkstra(origin);
		for (GraphNode node : minDistances) {
			System.out.println(node.label + ": " + node.cost);
		}
	}
	
	public static Set<GraphNode> Dijkstra(GraphNode origin) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		PriorityQueue<GraphNode> frontier = new PriorityQueue<GraphNode>(10, new GraphNodeComparator());
		GraphNode current = origin;
		current.cost = 0;
		
		while (true) {
			visited.add(current);
			for (GraphEdge candidate : current.edges) {
				GraphNode otherEnd = candidate.otherEnd(current);
				if (!visited.contains(otherEnd)) {
					// TODO: frontier.contains() is not efficient.
					if ((frontier.contains(otherEnd) && (otherEnd.cost > current.cost + candidate.cost)) || !frontier.contains(otherEnd)) {
						otherEnd.cost = current.cost + candidate.cost;
						frontier.add(otherEnd);
					}
				}
			}
			if (!frontier.isEmpty()) {
				current = frontier.remove();
			} else {
				break;
			}
		}
		
		return visited;
	}

	private static GraphNode CreateSampleGraph() {
		// If this were to get any larger, it would help to have some helper to read in this data
		// from a more standardized format.
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		GraphNode f = new GraphNode("f");
		GraphNode g = new GraphNode("g");
		GraphNode h = new GraphNode("h");
		GraphNode i = new GraphNode("i");
		GraphEdge ab = new GraphEdge(a, b, 5);
		GraphEdge ae = new GraphEdge(a, e, 3);
		GraphEdge ad = new GraphEdge(a, d, 7);
		GraphEdge de = new GraphEdge(d, e, 2);
		GraphEdge be = new GraphEdge(b, e, 5);
		GraphEdge bc = new GraphEdge(b, c, 4);
		GraphEdge bf = new GraphEdge(b, f, 9);
		GraphEdge cf = new GraphEdge(c, f, 7);
		GraphEdge bg = new GraphEdge(b, g, 10);
		GraphEdge fg = new GraphEdge(f, g, 8);
		GraphEdge fi = new GraphEdge(f, i, 2);
		GraphEdge hf = new GraphEdge(h, f, 3);
		GraphEdge gi = new GraphEdge(g, i, 6);
		GraphEdge ei = new GraphEdge(e, i, 12);
		return a;
	}
}

