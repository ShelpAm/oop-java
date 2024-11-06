//假设a.txt已放置到d:\k目录中，
//下面代码无法编译
//要求-1：请使用异常处理的捕获机制（即try-catch），让代码正确编译、运行
//要求-2：请使用异常处理的传播机制（即throws），让代码正确编译、运行

package  a.b.x;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// 方法一
class TestException {
    void a() { b(); }
    void b() { c(); }
    void c() { d(); }
    void d() {
        try {
            Scanner sc=new Scanner(new File("d:/k/a.txt"));  //注：a.txt必须放在d:\k目录中
            System.out.println("a.txt的内容：\n"+sc.nextLine());
        } catch (FileNotFoundException e) {

        }
    }
}

// 方法二
class TestException2 {
    void a() throws FileNotFoundException { b(); }
    void b() throws FileNotFoundException { c(); }
    void c() throws FileNotFoundException { d(); }
    void d() throws FileNotFoundException {
        Scanner sc=new Scanner(new File("d:/k/a.txt"));  //注：a.txt必须放在d:\k目录中
        System.out.println("a.txt的内容：\n"+sc.nextLine());
    }
}
class App{
    public static void main(String[] args) throws FileNotFoundException {
        new TestException().a();
        new TestException2().a();
    }
}
//思考：new File("d:\k\a.txt")可能产生java.lang.NullPointerException，为何不影响编译，它是检查型异常吗，为什么？
//
//原因：java.lang.NullPointerException是非检查型异常，只会在运行期由java虚拟机检查、传播等。
