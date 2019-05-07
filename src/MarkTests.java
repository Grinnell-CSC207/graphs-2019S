import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Some simple tests of the mark/unmark operations in graphs.
 */
class MarkTests {

  // +---------------+-----------------------------------------------
  // | Shared fields |
  // +---------------+

  /**
   * The marks, in an array for convenient use.
   */
  static final byte[] marks = {Graph.MARK01, Graph.MARK02, Graph.MARK03,
      Graph.MARK04, Graph.MARK05, Graph.MARK06, Graph.MARK07};

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The graph we're using.
   */
  Graph g;

  // +-------+-------------------------------------------------------
  // | Setup |
  // +-------+

  /**
   * Set up our graph.
   */
  @BeforeEach
  void setup() {
    g = new Graph();
  } // setup()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A few tests of the basic mark operations.
   */
  @Test
  void testBasicMarks() {
    int v1 = g.addVertex();
    int v2 = g.addVertex();

    // Check initial state
    assertFalse(g.isMarked(v1));
    assertFalse(g.isMarked(v2));

    // Mark one vertex
    g.mark(v1);
    assertTrue(g.isMarked(v1));
    assertFalse(g.isMarked(v2));

    // Unmark that vertex
    g.unmark(v1);
    assertFalse(g.isMarked(v1));
    assertFalse(g.isMarked(v2));

    // Unmark the other vertex
    g.unmark(v2);
    assertFalse(g.isMarked(v1));
    assertFalse(g.isMarked(v2));

    // Mark the second vertex
    g.mark(v2);
    assertFalse(g.isMarked(v1));
    assertTrue(g.isMarked(v2));

    // Unmark the second vertex
    g.unmark(v2);
    assertFalse(g.isMarked(v1));
    assertFalse(g.isMarked(v2));
  } // testBasicMarks()

  /**
   * Some tests of the named marks
   */
  @Test
  void testNamedMarksSingle() {
    int len = marks.length;
    int[] vertices = new int[len];
    for (int i = 0; i < len; i++) {
      vertices[i] = g.addVertex();
    } // for

    // Mark each vertex with the appropriate mark
    for (int i = 0; i < len; i++) {
      g.mark(vertices[i], marks[i]);
    } // for

    // Verify that the marks are correct
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        assertTrue(g.isMarked(vertices[i]));
        if (i == j) {
          assertTrue(g.isMarked(vertices[i], marks[j]),
              "Vertex " + i + " should be marked with mark " + j);
        } else {
          assertFalse(g.isMarked(vertices[i], marks[j]),
              "Vertex " + i + " should not be marked with mark " + j);
        } // if/else
      } // for j
    } // for i

    // Remove the marks
    for (int i = 0; i < len; i++) {
      g.unmark(vertices[i], marks[i]);;
    } // for i

    // Verify that nothing is marked
    for (int i = 0; i < len; i++) {
      assertFalse(g.isMarked(vertices[i]));
      for (int j = 0; j < len; j++) {
        assertFalse(g.isMarked(vertices[i], marks[i]));
      } // for
    }
  } // testNamedMarksSingle

  /**
   * Mark one vertex in multiple ways.
   */
  @Test
  void testNamedMarksMultiple() {
    int len = marks.length;
    int v = g.addVertex();

    // Add all the marks
    for (int i = 0; i < len; i++) {
      assertFalse(g.isMarked(v, marks[i]));
      g.mark(v, marks[i]);
    } // for i

    // Remove all of the marks
    for (int i = 0; i < len; i++) {
      assertTrue(g.isMarked(v, marks[i]));
      g.unmark(v, marks[i]);
      assertFalse(g.isMarked(v, marks[i]));
      for (int j = 0; j < i; j++) {
        assertFalse(g.isMarked(v, marks[j]));
      } // for j
      for (int j = i + 1; j < len; j++) {
        assertTrue(g.isMarked(v, marks[j]));
      } // for j
    } // for i
  } // testNamedMarksMultiple()
} // MarkTests
