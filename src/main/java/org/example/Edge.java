package org.example;

public class Edge {
	Vertex u;
	Vertex v;
	public Edge(Vertex u, Vertex v) {
		this.u=u;
		this.v = v;
	}
	
	public boolean equals(Object ob) {
		if(ob ==null) return false;
		if(ob.getClass() != getClass()) return false;
		Edge other = (Edge)ob;
		return (u==other.u && v == other.v) || (u==other.v && v == other.u);
	}
}
