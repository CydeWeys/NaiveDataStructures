package com.cydeweys.dev.naivedatastructures;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	public String label;
	public List<GraphEdge> edges;
	public int cost;
	
	public GraphNode(String label) {
		this.label = label;
		this.edges = new ArrayList<GraphEdge>();
		this.cost = Integer.MAX_VALUE;
	}
	
	public GraphNode(String label, int cost) {
		this(label);
		this.cost = cost;
	}
}