import java.io.PrintWriter;

/**
 * A quick experiment with reading graphs from files.
 */
public class GraphFileExperiment {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    // A small graph so that we can force it to expand.
    Graph g = new UndirectedGraph();
    g.readEdges(args[0]);
    g.dump(pen);
    g.dumpWithNames(pen);
    g.write(pen);
  } // main(String[])

} // class GraphExperiment
