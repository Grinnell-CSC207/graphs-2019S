/**
 * A simple implementation of undirected graphs.
 *
 * @author Samuel A. Rebelsky
 */
public class UndirectedGraph extends Graph {
  // +-----------+---------------------------------------------------
  // | Overrides |
  // +-----------+

  @Override
  public void addEdge(String u, String v, int weight) throws Exception {
    int unum = this.safeVertexNumber(u);
    int vnum = this.safeVertexNumber(v);
    super.addEdge(unum, vnum, weight);
    super.addEdge(vnum, unum, weight);
  } // addEdge(String, String, int)

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
