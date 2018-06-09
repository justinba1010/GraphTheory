import java.util.*;
public class AdjNodeMatrixGraphDriver {
  public static void main(String[] args) {
    Node<String> u1 = new Node<String>("u1");
    Node<String> u2 = new Node<String>("u2");
    ArrayList<Node> l = new ArrayList<Node>();
    l.add(u1);
    l.add(u2);
    AdjNodeMatrixGraph aGraph = new AdjNodeMatrixGraph(l);
    aGraph.addEdge(0,1);
    Node u3 = (Node)aGraph.nodes.get(0);
    System.out.println(u3.getColor());
    aGraph.ColorGraphGreedy();
    u3 = (Node)aGraph.nodes.get(0);
    System.out.println(u3.getColor());
    u3 = (Node)aGraph.nodes.get(1);
    System.out.println(u3.getColor());
    //For debugging
    //Looks like it is working how I want it to.
  }
}
