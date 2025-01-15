package shelpam.weekfinal.x;

import shelpam.weekfinal.y.B;

public class A {

    public void f() {
        System.out.println("Calling X.f()");
    }

    protected void g() {
        System.out.println("Calling X.g()");
    }

    public static void protectedStatic() {
    }

}

class Accessor extends B {

    public void access() {
        // f(); // Doesn't compile
    }

}

class Comforter extends A {
    public void comfort() {
        g();
    }
}
