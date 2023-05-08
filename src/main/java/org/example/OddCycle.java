package org.example;


/**
 * This class determines whether a given Graph
 * contains an odd cycle. It does this by keeping
 * track of the levels to which vertices belong in the
 * BFS rooted tree  -- if any vertex is examined that
 * has already been visited and is at same level as 
 * the current vertex, there must be an odd cycle; otherwise
 * not.
 *
 */
public class OddCycle extends BreadthFirstSearch {
    public boolean isOddCycle;

    public OddCycle(Graph g) {
        super(g);   
        isOddCycle = false;
    }
    
    @Override
    protected void checkCycle(Vertex w, int lebel) {
        if (getVerticesLebel(w) == lebel) {
            isOddCycle = true;
        }
    }

    public boolean isGraphContainsOddCycle() {
        this.start();
        return isOddCycle;
    }
    

}
