import java.io.PrintWriter;

/**
 * A quick experiment with paths.
 */
public class PathExperiment {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Graph g = new Graph();

    g.addVertex("a");
    g.addVertex("b");
    g.addVertex("c");
    g.addVertex("d");
    g.addVertex("e");
    g.addVertex("f");
    g.addVertex("g");

    g.addEdge("a", "b", 0);
    g.addEdge("b", "c", 0);
    g.addEdge("c", "d", 0);
    g.addEdge("d", "e", 0);
    g.addEdge("e", "g", 0);
    g.addEdge("e", "a", 0);
    g.addEdge("c", "g", 0);
    g.addEdge("g", "e", 0);

    pen.println(g.path("a", "b"));
    pen.println(g.path("a", "c"));
    pen.println(g.path("a", "d"));
    pen.println(g.path("a", "e"));
    pen.println(g.path("a", "f"));
    pen.println(g.path("a", "g"));
    pen.println(g.path("a", "a"));
    pen.println("Done");
  } // main(String[])

} // PathExperiment
