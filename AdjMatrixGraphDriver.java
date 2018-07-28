import java.util.*;
public class AdjMatrixGraphDriver {
  public static void main(String[] args) {
    String[] a = {"u1","u2"};
    ArrayList<String> l = new ArrayList<String>(Arrays.asList(a));
    AdjMatrixGraph<String> graph = new AdjMatrixGraph<String>(l);
    String[] b = {"v1","v2","v3"};
    ArrayList<String> k = new ArrayList<String>(Arrays.asList(b));
    AdjMatrixGraph<String> graph2 = new AdjMatrixGraph<String>(k);
    graph.addEdge(0,1);
    graph2.addEdge("v1","v2");
    graph2.addEdge("v2","v3");
    System.out.println(graph);
    System.out.println(graph2);
    AdjMatrixGraph<String[]> graph3 = graph.cartesianProduct(graph2);
    System.out.println(graph3);
    for(Object[] node : graph3.nodes) {
      System.out.println("("+node[0]+","+node[1]+")");
    }

    System.out.println(graph3.depthSearch(1,2));
  }
}
