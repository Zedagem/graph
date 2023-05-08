package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
public abstract class DepthFirstSearch {
	
	protected HashMap visitedVertices = new HashMap();
	Graph graph;
	Stack<Vertex> stack;
	List<Vertex> vertices = null;
	Iterator<Vertex> iterator = null;
	List<Edge> edges = null;
	List<Edge> edgesVisitedDuringDFS = new ArrayList<Edge>();
	protected int numVertices;
	protected int numEdges;
	public DepthFirstSearch(Graph graph){
		stack = new Stack<Vertex>();
		this.graph=graph;
		vertices =graph.vertices;
		iterator = vertices.iterator();
		edges = graph.edges;
		numVertices = vertices.size();
		numEdges = edges.size();
	}
	protected void resetVisitedVertices() {
		visitedVertices.clear();
	}
	protected void resetVertexIterator() {
		iterator = vertices.iterator();
	}
	public void start(){
		while(someVertexUnvisited()) {
			//process vertex and place on stack 
			handleInitialVertex();
		
			//search for deeper nodes and backtrack, in a loop
			//starts on  a new component after a component has been completely visited
			singleComponentLoop();
			
			//override this method if processing needs to occur here
			additionalProcessing();
		}
		
		
	}
	protected void additionalProcessing() {
		//by default do nothing
	}
	/*
	public void cleanup() {
		//cleanup vertices
		graph.resetVertexBookkeeping();
	}*/

	//inserts an initial vertex into the stack as preparation for
	//dfs for this component
	protected void handleInitialVertex() {
		Vertex v = nextUnvisited();
		if(v != null){
			setHasBeenVisited(v);
			processVertex(v);
			stack.push(v);
		}
	}
	
	protected void singleComponentLoop() {
		while(!stack.isEmpty()){
			Vertex v = nextUnvisitedAdjacent(stack.peek());
			
			if(v==null) stack.pop();
			else {
				setHasBeenVisited(v);
				processEdge(new Edge(stack.peek(),v));
				processVertex(v);
				stack.push(v);
			}
		}
	}
	protected void processEdge(Edge e) {
		//override for needed functionality
	}

	public boolean getHasBeenVisited(Vertex v) {
		return visitedVertices.containsKey(v);
	}
	public void setHasBeenVisited(Vertex v) {
		visitedVertices.put(v,v);
	}
	protected boolean someVertexUnvisited(){
		return visitedVertices.size() < numVertices;
	}
	protected void processVertex(Vertex w){
		//should be overridden; by default, do nothing
	}
	public Vertex nextUnvisited() {
		while(iterator.hasNext()){
			Vertex next = iterator.next();
			if(!visitedVertices.containsKey(next)){
				return next;
				
			}
		}
		return null;
	}
	
	public Vertex nextUnvisitedAdjacent(Vertex v) {
		List<Vertex> listOfAdjacent = graph.getListOfAdjacentVerts(v);
		Iterator<Vertex> it = listOfAdjacent.iterator();
		Vertex retVert = null;
		boolean found = false;
		while(it.hasNext() && !found){
			Vertex u = it.next();
			if(!visitedVertices.containsKey(u)) {
				found = true;
				retVert = u;
			}
			
		}
		return retVert;
	}



}
