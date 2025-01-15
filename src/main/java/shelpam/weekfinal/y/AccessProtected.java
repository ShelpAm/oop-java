package shelpam.weekfinal.y;

import shelpam.weekfinal.x.A;

public class AccessProtected extends A {

    public void iLoveProtected() {
        System.out.println("I love protected.");
        g();
        A.protectedStatic();
    }

}
