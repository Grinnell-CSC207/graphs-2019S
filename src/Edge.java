/**
 * An edge in a simple weighted, directed graph.  See Graph.java for
 * some details of how they are used.
 *
 * @author Samuel A. Rebelsky
 */
public class Edge {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The start of the edge.
   */
  private int from;

  /**
   * The end of the edge.
   */
  private int to;

  /**
   * The weight of the edge.
   */
  private Integer weight;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new edge with a specified weight.
   */
  public Edge(int from, int to, Integer weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  } // Edge(int, int, Integer)

  /**
   * Create a new, unweighted edge.
   */
  public Edge(int from, int to) {
    this(from, to, null);
  } // Edge

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /**
   * Convert the edge to a string.
   */
  public String toString() {
    if (this.weight == null) {
      return "<" + this.from + "," + this.to + ">";
    } else {
      return "<" + this.from + "," + this.to + "," + this.weight + ">";
    } // if/else
  } // toString

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the from part of the node.
   */
  public int from() {
    return this.from;
  } // int from()

  /**
   * Get the to part of the node.
   */
  public int to() {
    return this.to;
  } // to()

  /**
   * Get the weight of the edge.  Returns 0 for an unweighted edge.
   * (Also returns 0 for an edge with weight 0.)
   */
  public int weight() {
    if (this.weight == null) {
      return 0;
    } else {
      return this.weight;
    } // if/else
  } // weight()
} // class Edge
