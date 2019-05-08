/**
 * A simple implementation of undirected graphs.
 *
 * @author Samuel A. Rebelsky
 */
public class UndirectedGraph extends Graph {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a basic undirected graph.
   */
  public UndirectedGraph() {
    super();
  } // UndirectedGraph()

  /**
   * Create a basic undirected graph from a file.
   */
  public UndirectedGraph(String fname) throws Exception {
    super(fname);
  } // UndirectedGraph(fname)

  // +-----------+---------------------------------------------------
  // | Overrides |
  // +-----------+

  @Override
  public void addEdge(String u, String v, int weight) throws Exception {
    addEdge(this.safeVertexNumber(u), this.safeVertexNumber(v), weight);
  } // addEdge(String, String, int)
  
  public void addEdge(int u, int v, int weight) throws Exception {
    super.addEdge(u, v, weight);
    super.addEdge(v, u, weight);
  } // addEdge(int, int, int)

  @Override
  public void removeEdge(String u, String v) {
    super.removeEdge(u, v);
    super.removeEdge(v, u);
  } // removeEdge(String, String)

  @Override
  public void removeEdge(int u, int v) {
    super.removeEdge(u, v);
    super.removeEdge(v, u);
  } // removeEdge(int, int)

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Get the number of a vertex. If the vertex does not already exist, adds it.
   */
  int safeVertexNumber(String vertex) throws Exception {
    int num = this.vertexNumber(vertex);
    if (num == -1) {
      num = this.addVertex(vertex);
    } // if
    return num;
  } // safeVertexNumber(String)

} // class UndirectedGraph
