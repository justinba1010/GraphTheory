import java.util.*;
/*
//  Justin Baum
//  Graphs using Adjacency Matrices
//  Now with graph coloring and search
*/

//

public class AdjNodeMatrixGraph<T extends Node> extends AdjMatrixGraph<T> {
  public AdjNodeMatrixGraph() {
    super();
  }

  public AdjNodeMatrixGraph(ArrayList<T> nodes) {
    super(nodes);
  }

  public void ColorGraphGreedy() {
    for(T node : this.nodes) {
      ArrayList<T> adjacents = this.getAdjacent(node);
      int color = 0;
      boolean matched = true;
      while(matched) {
        matched = false;
        for(T adjacentNode : adjacents) {
          if(color == adjacentNode.getColor()) {
            matched = true;
            color++;
            break;
          }//if
        }//for neighbor
      }//while
      node.setColor(color);
    }//for
  }//ColorGraphGreedy
}//AdjNodeMatrixGraph
