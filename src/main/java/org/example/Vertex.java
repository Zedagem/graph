package org.example;

public class Vertex {

	private Object data;
	
	
	public Vertex(Object data){
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public String toString() {
		return data.toString();
	}

	
	public boolean equals(Object ob){
		if(ob == null) return false;
		if(getClass() != ob.getClass()) return false;
		Vertex v = (Vertex)ob;
		return v.data.equals(data);
	}
	public int hashCode() {
		return data.hashCode();
	}

	
	

}
