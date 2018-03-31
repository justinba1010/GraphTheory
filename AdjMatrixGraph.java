import java.util.*;
/*
//  Justin Baum
//  Graphs using Adjacency Matrices
*/

//
public class AdjMatrixGraph<T> {
  ArrayList<T> nodes;
  int[][] adjMatrix;
  static int defaultSize = 25;
  static int resizeFactor = 5;
  int size;

  public AdjMatrixGraph() {
    nodes = new ArrayList<T>();
    size = defaultSize;
    adjMatrix = new int[size][size];
    size = 0;
  }//AdjMatrixGraph

  public AdjMatrixGraph(ArrayList<T> aNodes) {
    nodes = aNodes;
    size = nodes.size();
    adjMatrix = new int[size][size];
  }//AdjMatrixGraph

  public void editEdge(int i, int j, boolean directed, int value) {
    if(i >= 0 && i < size && j >= 0 && j < size) {
      adjMatrix[i][j] = value;//i-j is an edge
      if(!directed) {
        adjMatrix[j][i] = value;
      }//directed edge
    }//if legal
  }//editEdge
  public void addEdge(int i, int j, boolean directed) {
    editEdge(i,j,directed,1);
  }//addEdge

  public void addEdge(int i, int j) {//undirected
    addEdge(i,j,false);
  }//addEdge

  public void addEdge(T i, T j) {
    int i1 = getIndex(i);
    int j1 = getIndex(j);
    addEdge(i1,j1);
  }//addEdge

  public void addEdge(T i, T j, boolean directed) {
    int i1 = getIndex(i);
    int j1 = getIndex(j);
    addEdge(i1,j1,directed);
  }//addEdge

  public void removeEdge(int i, int j, boolean directed) {
    editEdge(i,j,directed,0);
  }//removeEdge

  public void removeEdge(int i, int j) {//undirected
    removeEdge(i,j,false);
  }//removeEdge

  public void removeEdge(T i, T j) {
    int i1 = getIndex(i);
    int j1 = getIndex(j);
    removeEdge(i1,j1);
  }//removeEdge
  public void removeEdge(T i, T j, boolean directed) {
    int i1 = getIndex(i);
    int j1 = getIndex(j);
    removeEdge(i1,j1,directed);
  }//removeEdge

  private int getIndex(T i) {
    return nodes.indexOf(i);
  }//getIndex

  public String toString() {
    String s = "Nodes = {";
    for(T node : nodes) {
      s += node.toString();
      s += ",";
    }
    s += "}\nAdjMatrix:\n";

    for(int[] row : adjMatrix) {
      for(int spot : row) {
        s += String.format("%1d,", spot);
      }
      s += "\n";
    }
    return s;
  }//toString

  public boolean isAdjacent(int i, int j) {
    if(i < 0 || i >= size || j < 0 || j >= size) return false;
    return adjMatrix[i][j] != 0;
  }//isAdjacent

  public boolean isAdjacent(T i, T j) {
    return isAdjacent(getIndex(i),getIndex(j));
  }//isAdjacent

  public ArrayList<T> getAdjacent(int i) {
    //n time
    if(i < 0 || i >= size) return null;
    ArrayList<T> adjacent = new ArrayList<T>();
    for(int j = 0; j < size; j++) {
      if(adjMatrix[i][j] != 0) adjacent.add(nodes.get(j));
    }
    return adjacent;
  }//getAdjacent

  public ArrayList<T> getAdjacent(T i) {
    return getAdjacent(getIndex(i));
  }//getAdjacent

  public void addNode(T node) {
    //n^2 time
    size++; //Indicate we are increasing our stuff

    if(size >= adjMatrix.length) {//Resize our array
      int newSize = adjMatrix.length + resizeFactor;
      int[][] newAdjMatrix = new int[newSize][newSize];
      for(int i = 0; i < size-1; i++) {
        for(int j = 0; j < size-1; j++) {
          newAdjMatrix[i][j] = adjMatrix[i][j];
        }//for j
      }//for i
      adjMatrix = newAdjMatrix;//This is our new matrix
    }// if
    nodes.add(node);
  }//addNode

  public void removeNode(int z) {
    //n^2 time
    if(z < 0 || z >= size) return;
    size--;
    int[][] newAdjMatrix = new int[adjMatrix.length][adjMatrix.length];
    int ioffset = 0;
    int joffset = 0;
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        newAdjMatrix[i][j] = adjMatrix[i+((i==z)? 1 : 0)][j+((j==z)? 1 : 0)];
      }//for j
    }//for i
  }//removeNode

  public AdjMatrixGraph<T[]> cartesianProduct(AdjMatrixGraph<T> graph2) {
    //n^~6 time lol
    ArrayList<T[]> vectors = new ArrayList<T[]>();
    //Make vectors list pairs of vectors from G1 and G2
    //(∀i∈V(G1))(∀j∈V(G1))((i,j)∈G1XG2)
    for(T nodeG1 : nodes) {
      for(T nodeG2 : graph2.nodes) {
        T[] newVector = (T[])( new Object[2]);
        newVector[0] = nodeG1;
        newVector[1] = nodeG2;
        vectors.add(newVector);
      }//for nodeG2
    }//for nodeG1

    public int size() {
      return size;
    }//size

    public int cardinality() {
      return size;
    }//cardinality

    private int degrees(int vertex, boolean strict, boolean inverse){
      //n time
      if(vertex < 0 || vertex >= size) return 0;
      int degree = 0;
      for(int i = 0; i < size; i++) {
        //if not strict, add 1 as long as either direction is an edge, otherwise only the direction according to if its inverted
        if(!inverse) {
          degree += (adjMatrix[i][vertex] != 0 || (adjMatrix[vertex][i] != 0 && !strict)) ? 1 : 0;
        } else {
          degree += (adjMatrix[vertex][i] != 0 || (adjMatrix[i][vertex] != 0 && !strict)) ? 1 : 0;
        }
      }//for i
      return degree;
    }//degrees

    public int degree(int vertex) {
      return degrees(vertex, true, false);
    }//degree int vertex

    public int degree(T vertex) {
      return degree(getIndex(vertex));
    }//degree T vertex

    public int degreeInv(int vertex) {//
      return degrees(vertex, true, true);
    }//degreeInv int vertex

    public int degreeInv(T vertex) {
      return degreeInv(getIndex(vertex));
    }//degreeInv T vertex

    public int degreeUndirected(int vertex) {
      return degrees(vertex, false, false);
    }//degreeUndirected int vertex

    public int degreeUndirected(T vertex) {
      return degreeUndirected(getIndex(vertex));
    }
    
    //(∀i∈V(G1))(∀j∈V(G2))(∀k∈V(G1))(∀l∈V(G2))((i,j)(k,l)∈E(G1XG2)↔(i=k	∧ jl ∈E(G2)∨(j==l ∧ ik ∈E(G2))))
    AdjMatrixGraph<T[]> newAdjMatrixGraph = new AdjMatrixGraph<T[]>(vectors);
    int cardinalityG1 = size;
    int cardinalityG2 = graph2.size;
    for(int i = 0; i < cardinalityG1; i++) {
      for(int j = 0; j < cardinalityG2; j++) {
        for(int k = 0; k < cardinalityG1; k++) {
          for(int l = 0; l < cardinalityG2; l++) {
            if(i == k) {
              if(graph2.isAdjacent(j,l)) {
                int spot1 = i*cardinalityG2 + j;
                int spot2 = k*cardinalityG2 + l;
                newAdjMatrixGraph.addEdge(spot1, spot2);
              }//if adjacent
            }//if i==k
            if(j == l) {
              if(isAdjacent(i,k)) {
                int spot1 = i*cardinalityG2 + j;
                int spot2 = k*cardinalityG2 + l;
                newAdjMatrixGraph.addEdge(spot1,spot2);
              }//if adjacent
            }//if j==l
          }//for l
        }//for k
      }//for j
    }//for i
    return newAdjMatrixGraph;
  }//cartesianProduct
}//AdjMatrixGraph
