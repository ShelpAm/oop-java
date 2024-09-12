import java.util.Scanner;

class Week2 {
  public static void main(String[] args) {
    // Car c = new Car("a", "b", "c");
    //
    // System.out.println("Car info: " + c);
    //
    // c.stop();
    // c.start();
    // c.start();
    // c.stop();
    // c.stop();

    System.out.println("Empty list:");
    Vector list = new Vector();
    list.show();

    System.out.println("User input list:");
    Scanner scanner = new Scanner(System.in);
    list = Vector.fromScanner(scanner);
    list.show();

    System.out.println("l2:");
    Vector l2 = Vector.fromScanner(scanner);
    l2.show();

    System.out.println("Merge list: list.merge(l2);");
    list.merge(l2);
    System.out.println("Merged:");
    list.show();
  }

  private class Car {
    Car(String owner, String brand, String color) {
      this.owner = owner;
      this.brand = brand;
      this.color = color;
    }

    public String toString() {
      return owner + ' ' + brand + ' ' + color + " Status (started): " + started;
    }

    public void start() {
      if (this.started) {
        System.out.println("This car has been started before. Cannot start.");
        return;
      }
      started = true;
      System.out.println("The car was started successfully");
    }

    public void stop() {
      if (!this.started) {
        System.out.println("This car has not been started. Cannot stop.");
        return;
      }
      started = false;
      System.out.println("The car was stopped successfully");
    }

    private String owner, brand, color;
    private boolean started;
  }
}
