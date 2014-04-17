package com.cydeweys.dev.naivedatastructures;

public class GraphEdge {
	public GraphNode end1;
	public GraphNode end2;
	public int cost;
	
	public GraphEdge(GraphNode end1, GraphNode end2, int cost) {
		this.end1 = end1;
		this.end2 = end2;
		this.cost = cost;
		
		end1.edges.add(this);
		end2.edges.add(this);
	}
	
	public GraphNode otherEnd(GraphNode thisEdge) {
		if (thisEdge == this.end1) {
			return this.end2;
		} else {
			return this.end1;
		}
	}
}
