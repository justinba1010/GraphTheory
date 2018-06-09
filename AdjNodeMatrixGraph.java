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

  public void ColorGraphGreedy() {
    //Color all nodes -1
    for(T node : this.nodes) {
      node.setColor(-1);
    }
    //Greedy Algorithm
    for(T node : this.nodes) {
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
  }//ColorGraphGreedy
  public void ColorGraphGreedyRandom() {
    //Color all nodes -1
    for(T node : this.nodes) {
      node.setColor(-1);
    }
    //Randomize list
    ArrayList<T> randomOrderedNodes = new ArrayList<T>();
    for(T node : this.nodes) {
      randomOrderedNodes.add(node);
    }
    Collections.shuffle(randomOrderedNodes);
    ArrayList<T> originalOrdering = this.nodes;
    this.nodes = randomOrderedNodes;
    ColorGraphGreedy();
    this.nodes = originalOrdering;
  }//ColorGraphGreedy
}//AdjNodeMatrixGraph
