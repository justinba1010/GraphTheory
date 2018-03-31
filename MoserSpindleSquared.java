import java.util.*;
public class MoserSpindleSquared{
  public static void main(String[] args) {
    String[] a = {"p0","p1","p2","p3","p4","p5","p6"};
    ArrayList<String> l = new ArrayList<String>(Arrays.asList(a));
    AdjMatrixGraph<String> moser = new AdjMatrixGraph(l);
    moser.addEdge(0,1);
    moser.addEdge(0,4);
    moser.addEdge(0,5);
    moser.addEdge(0,6);
    moser.addEdge(1,2);
    moser.addEdge(1,6);
    moser.addEdge(2,3);
    moser.addEdge(2,6);
    moser.addEdge(3,4);
    moser.addEdge(3,5);
    moser.addEdge(4,5);
    AdjMatrixGraph<String[]> moserSquared = moser.cartesianProduct(moser);
    System.out.println(moserSquared);

    for(Object[] node : moserSquared.nodes) {
      System.out.println("("+node[0]+","+node[1]+")");
    }
  }
}
