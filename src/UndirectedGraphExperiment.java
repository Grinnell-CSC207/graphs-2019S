import java.io.PrintWriter;

/**
 * A quick experiment with undirected graphs.
 */
public class UndirectedGraphExperiment {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Graph g = new UndirectedGraph();

    // Add a few edges
    g.addEdge("a", "b", 1);
    g.addEdge("a", "c", 2);
    g.addEdge("b", "c", 3);
    g.dumpWithNames(pen);
    
    // Change an edge, in the backwards direction
    pen.println("Changing edge b-a");
    g.addEdge("b", "a", 4);
    g.dumpWithNames(pen);

    // Remove a vertex
    pen.println("Removing b");
    g.removeVertex("b");
    g.dumpWithNames(pen);
    
    // Add another vertex
    pen.println("Adding an edge from a to d");
    g.addEdge("a", "d", 5);
    g.dumpWithNames(pen);
    
    // Remove an edge
    pen.println("Removing the edge from c to a");
    g.removeEdge("c", "a");
    g.dumpWithNames(pen);
  } // main(String[])

} // class UndirectedGraphExperiment
