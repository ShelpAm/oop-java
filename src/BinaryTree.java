import java.util.Scanner;

public class BinaryTree {
  Node root;

  public static interface Visitor {
    public void traverse(BinaryTree tree, Node.Visitor visitor);
  }

  public static class InOrderVisitor implements Visitor {
    @Override
    public void traverse(BinaryTree tree, Node.Visitor visitor) {
      traverseImpl(tree.root, visitor);
    }

    private void traverseImpl(Node node, Node.Visitor visitor) {
      if (node == null) {
        return;
      }

      traverseImpl(node.lchild, visitor);
      visitor.visit(node.data);
      traverseImpl(node.rchild, visitor);
    }
  }

  public static class NonRecursiveInOrderVisitor implements Visitor {
    private class Stack {
      private NeoVector<Node> vector = new NeoVector<Node>();

      public boolean empty() {
        return vector.empty();
      }

      public void push(Node node) {
        vector.pushBack(node);
      }

      public Node pop() {
        Node back = vector.back();
        vector.popBack();
        return back;
      }
    }

    @Override
    public void traverse(BinaryTree tree, Node.Visitor visitor) {
      Stack s = new Stack();
      Node cur = tree.root;
      while (!s.empty() || cur != null) {
        if (cur != null) {
          s.push(cur);
          cur = cur.lchild;
        } else {
          cur = s.pop();
          visitor.visit(cur.data);
          cur = cur.rchild;
        }
      }
    }
  }

  public static class PreOrderVisitor implements Visitor {
    @Override
    public void traverse(BinaryTree tree, Node.Visitor visitor) {
      traverseImpl(tree.root, visitor);
    }

    private void traverseImpl(Node node, Node.Visitor visitor) {
      if (node == null) {
        return;
      }

      visitor.visit(node.data);
      traverseImpl(node.lchild, visitor);
      traverseImpl(node.rchild, visitor);
    }
  }

  public static class NonRecursivePreOrderVisitor implements Visitor {
    private class Stack {
      NeoVector<Node> vector = new NeoVector<Node>();

      public boolean empty() {
        return vector.empty();
      }

      public void push(Node node) {
        vector.pushBack(node);
      }

      public Node pop() {
        Node back = vector.back();
        vector.popBack();
        return back;
      }
    }

    @Override
    public void traverse(BinaryTree tree, Node.Visitor visitor) {
      Stack s = new Stack();
      Node cur = tree.root;
      while (!s.empty() || cur != null) {
        if (cur != null) {
          visitor.visit(cur.data);
          s.push(cur);
          cur = cur.lchild;
        } else {
          cur = s.pop().rchild;
        }
      }
    }
  }

  public static class LevelOrderVisitor implements Visitor {
    @Override
    public void traverse(BinaryTree tree, Node.Visitor visitor) {
      Queue<Node> q = new Queue<Node>(100);
      q.push(tree.root);
      while (!q.empty()) {
        Node u = q.pop();
        if (u != null) {
          visitor.visit(u.data);
          q.push(u.lchild);
          q.push(u.rchild);
        }
      }
    }
  }

  public static class Node {
    private char data;
    private Node lchild;
    private Node rchild;

    public static interface Visitor {
      public void visit(char c);
    }

    private static Node fromChar(char c) {
      if (c == '#') {
        return null;
      }
      return new Node(c);
    }

    public Node(char data) {
      this.data = data;
    }
  }

  public static BinaryTree fromScanner(Scanner sc) {
    StringReader sr = new StringReader(sc.next());
    return new BinaryTree(fromScannerHelper(sr));
  }

  private static Node fromScannerHelper(StringReader sr) {
    Node root = Node.fromChar(sr.nextChar());

    if (root != null) {
      root.lchild = fromScannerHelper(sr);
      root.rchild = fromScannerHelper(sr);
    }

    return root;
  }

  public BinaryTree() {}

  public BinaryTree(Node root) {
    this.root = root;
  }

  public void visitInOrder(Node.Visitor visitor) {
    visitInOrderImpl(root, visitor);
  }

  private void visitInOrderImpl(Node node, Node.Visitor visitor) {
    if (node == null) {
      return;
    }

    visitInOrderImpl(node.lchild, visitor);
    visitor.visit(node.data);
    visitInOrderImpl(node.rchild, visitor);
  }
}
