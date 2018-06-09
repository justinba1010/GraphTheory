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

  public AdjNodeMatrixGraph(ArrayList<T> aNodes) {
    super(aNodes);
  }

  private void ColorGraphGreedy(ArrayList<T> aNodes) {
    //Color all nodes -1
    for(T node : aNodes) {
      node.setColor(-1);
    }
    //Greedy Algorithm
    for(T node : aNodes) {
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

  public boolean validColoring() {
    for(T node : this.nodes) {
      ArrayList<T> adjacents = this.getAdjacent(node);
      for(T adjacent : adjacents) {
        if(adjacent.getColor() == node.getColor()) return false;
      }//for adjacent
    }//for nodes
    return false;
  }//validColoring
}//AdjNodeMatrixGraph
