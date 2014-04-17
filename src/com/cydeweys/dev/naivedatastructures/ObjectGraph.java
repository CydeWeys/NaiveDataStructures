package com.cydeweys.dev.naivedatastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ObjectGraph {

	public static void main(String[] args) {
		List<GraphNode> nodes = CreateSampleGraph();
		GraphNode origin = nodes.get(0);
		Set<GraphNode> minDistances = Dijkstra(origin, nodes);
		for (GraphNode node : minDistances) {
			System.out.println(node.label + ": " + node.cost);
		}
	}
	
	/**
	 * Calculates a minimum spanning tree from the origin node in a graph
	 * @param origin The origin node
	 * @param nodes A list of all nodes in the graph (used to initialize the frontier PriorityQueue)
	 * @return All of the nodes in the graph with attached total path costs
	 */
	public static Set<GraphNode> Dijkstra(GraphNode origin, List<GraphNode> nodes) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		PriorityQueue<GraphNode> frontier = new PriorityQueue<GraphNode>(10, new GraphNodeComparator());
		for (int i = 1; i < nodes.size(); i++) {
			frontier.add(nodes.get(i));
		}
		
		GraphNode current = origin;
		current.cost = 0;
		
		while (true) {
			visited.add(current);
			for (GraphEdge candidate : current.edges) {
				GraphNode otherEnd = candidate.otherEnd(current);
				if (!visited.contains(otherEnd)) {
					if (otherEnd.cost > current.cost + candidate.cost) {
						// TODO: It would be neat to store the path to this node as well.
						otherEnd.cost = current.cost + candidate.cost;
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

	private static List<GraphNode> CreateSampleGraph() {
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
		
		List<GraphNode> nodesList = Arrays.asList(a, b, c, d, e, f, g, h, i);
		return nodesList;
	}
}

