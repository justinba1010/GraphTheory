import java.util.*;
public class PetersenGraphSquared{
  public static void main(String[] args) {
    String[] a = {"p0","p1","p2","p3","p4","p5","p6","p7","p8","p9"};
    ArrayList<String> l = new ArrayList<String>(Arrays.asList(a));
    AdjMatrixGraph<String> petersen = new AdjMatrixGraph(l);
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
    AdjMatrixGraph<String[]> petersenSquared = petersen.cartesianProduct(petersen);
    System.out.println(petersenSquared);

    for(Object[] node : petersenSquared.nodes) {
      System.out.println("("+node[0]+","+node[1]+")");
    }
  }
}
