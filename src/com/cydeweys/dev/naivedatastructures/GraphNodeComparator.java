package com.cydeweys.dev.naivedatastructures;

import java.util.Comparator;

public class GraphNodeComparator implements Comparator<GraphNode> {
    @Override
    public int compare(GraphNode x, GraphNode y)
    {
        if (x.cost < y.cost) {
            return -1;
        } else if (x.cost > y.cost) {
            return 1;
        } else {
        	return 0;
        }
    }
}
