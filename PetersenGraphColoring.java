import java.util.*;
public class PetersenGraphColoring{
  public static void main(String[] args) {
    String[] a = {"p0","p1","p2","p3","p4","p5","p6","p7","p8","p9"};
    ArrayList<Node<String>> nodes = new ArrayList<Node<String>>();

    for(String b : a) {
      Node<String> newNode = new Node<String>(b);
      nodes.add(newNode);
    }

    AdjNodeMatrixGraph<Node<String>> petersen = new AdjNodeMatrixGraph<Node<String>>(nodes);
    petersen.addEdge(0,1);
    petersen.addEdge(0,4);
    petersen.addEdge(0,5);
    petersen.addEdge(1,2);
    petersen.addEdge(1,6);
    petersen.addEdge(2,3);
    petersen.addEdge(2,7);
    petersen.addEdge(3,4);
    petersen.addEdge(3,8);
    petersen.addEdge(4,9);
    petersen.addEdge(5,7);
    petersen.addEdge(5,8);
    petersen.addEdge(6,8);
    petersen.addEdge(6,9);
    petersen.addEdge(7,9);
    System.out.println(petersen);

    petersen.ColorGraphGreedy();

    for(Node n : petersen.nodes) {
      System.out.println(n.getColor());
    }
  }
}
