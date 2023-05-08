package org.example;

import org.example.DepthFirstSearch;
import org.example.Edge;

import java.util.*;

public class FindSpanningTree extends DepthFirstSearch {
	private ArrayList<Edge> tree = new ArrayList<Edge>();
	public FindSpanningTree(Graph graph) {
		super(graph);
	}
	protected void processEdge(Edge e) {
			tree.add(e);
	}
	
	public Graph computeSpanningTree() {
		start();
		//tree is loaded
		Object[] edges = tree.toArray();
		return new Graph(edges);
	}
	
	
	
}
