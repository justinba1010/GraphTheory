import java.util.*;
public class AdjNodeMatrixGraphDriver {
  public static void main(String[] args) {
    Node<String> u1 = new Node<String>("u1");
    Node<String> u2 = new Node<String>("u2");
    ArrayList<Node> l = new ArrayList<Node>();
    l.add(u1);
    l.add(u2);
    AdjNodeMatrixGraph aGraph = new AdjNodeMatrixGraph(l);
    System.out.println(aGraph.nodes.get(0).getNode());
    //For debugging
    //Looks like it is working how I want it to.
  }
}
