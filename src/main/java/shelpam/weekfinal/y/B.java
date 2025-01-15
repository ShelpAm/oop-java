package shelpam.weekfinal.y;

public class B {

    void f() {
        System.out.println("Calling Y.f()");
    }

    private void g() {
        System.out.println("Calling Y.g()");
    }

}

class RealAccessor extends B {

    public void access() {
        f();
    }

}
