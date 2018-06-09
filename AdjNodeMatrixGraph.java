import java.util.*;
/*
//  Justin Baum
//  Graphs using Adjacency Matrices
//  Now with graph coloring and search
*/

//

public class AdjNodeMatrixGraph<T extends Node> extends AdjMatrixGraph<T> {
  private int chromaticNumber;
  public AdjNodeMatrixGraph() {
    super();
    this.chromaticNumber = 0;
  }

  public AdjNodeMatrixGraph(ArrayList<T> nodes) {
    super(nodes);
  }

  private void ColorGraphGreedy(ArrayList<T> nodes) {
    //Color all nodes -1
    for(T node : nodes) {
      node.setColor(-1);
    }
    //Greedy Algorithm
    for(T node : nodes) {
      ArrayList<T> adjacents = this.getAdjacent(node);
      int color = -1;
      boolean matched = true;
      while(matched) {
        color++;
        matched = false;
        for(T adjacentNode : adjacents) {
          matched |= adjacentNode.getColor() == color;
        }//for neighbor
      }//while

      //Chromatic Number check
      if(color > this.chromaticNumber) this.chromaticNumber = color;
      node.setColor(color);
    }//for
  }

  public void ColorGraphGreedy() {
    ColorGraphGreedy(this.nodes);
  }//ColorGraphGreedy

  public void ColorGraphGreedyRandom() {
    //Randomize list
    ArrayList<T> randomOrderedNodes = new ArrayList<T>();
    for(T node : this.nodes) {
      randomOrderedNodes.add(node);
    }
    Collections.shuffle(randomOrderedNodes);
    ColorGraphGreedy(randomOrderedNodes);
  }//ColorGraphGreedy
}//AdjNodeMatrixGraph
