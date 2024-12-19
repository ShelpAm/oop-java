import java.util.Scanner;

public class Week4 {
  private static class NodePrinter implements BinaryTree.Node.Visitor {
    @Override
    public void visit(char c) {
      System.out.println("Visiting " + c);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input pre-order output string: (To represent empty node, use '#')");
    BinaryTree tree = BinaryTree.fromScanner(scanner);

    BinaryTree.Visitor visitor;
    BinaryTree.Node.Visitor nodeVisitor = new NodePrinter();

    System.out.println("In-order:");
    visitor = new BinaryTree.InOrderVisitor();
    visitor.traverse(tree, nodeVisitor);
    System.out.println();

    System.out.println("Pre-order:");
    visitor = new BinaryTree.PreOrderVisitor();
    visitor.traverse(tree, nodeVisitor);
    System.out.println();

    System.out.println("In-order (non-recursive):");
    visitor = new BinaryTree.NonRecursiveInOrderVisitor();
    visitor.traverse(tree, nodeVisitor);
    System.out.println();

    System.out.println("Pre-order (non-recursive):");
    visitor = new BinaryTree.NonRecursivePreOrderVisitor();
    visitor.traverse(tree, nodeVisitor);
    System.out.println();

    System.out.println("Level-order");
    visitor = new BinaryTree.LevelOrderVisitor();
    visitor.traverse(tree, nodeVisitor);


    Student s = new Student("LJH", 19);
    s.addCourse("Chinese", 100);
    System.out.println(s);

    Course c = new Course();
    c.append(s);
    c.append(s);
    System.out.println(c);
  }
}
