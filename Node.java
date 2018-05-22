public class Node<T> {
  private T node;
  private int color;
  private boolean visited;


  public Node(T aNode) {
    node = aNode;
    color = -1;
    visited = false;
  }

  public void visit() {
    visited = true;
  }

  public void unvisit() {
    visited = false;
  }

  public void setColor(int aColor) {
    color = aColor;
  }

  public T getNode() {
    return node;
  }

}
