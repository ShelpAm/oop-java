package shelpam.week13;

import shelpam.week13.threads.Thread1;
import shelpam.week13.threads.Thread2;
import shelpam.week13.threads.Task;

import java.util.Random;

public class Main {
    private static void task1() {
        System.out.println("Starting all threads...");
        var t1 = new Thread1(2, 70);
        var t2 = new Thread2(3, 70);
        var t3 = new Thread(new Task(5, 70));

        t1.start();
        t2.start();
        t3.start();
        System.out.println("All threads started.");

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // To answer the question: 假设给定2、3、5，下面是其中一次的输出结果，
        // 请指明：第1/2/3个30，是哪个线程输出的，为什么？
        //
        // Main 开始当前共有4个线程Main 结束3 6 9 2 4 6 8 10 12 14 16 18 20 12 15 18 5 10
        // 15 20 25 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 22 24 26 28 30 32 34 66
        // 69 B 结束.30 35 40 45 50 55 60 65 36 38 40 42 44 46 48 50 52 54 56 58 70 C 结束.
        // 60 62 64 66 68 70 A 结束.
        //
        // 【【强调：不存在一个结果，可能对应多个线程的情形，即：第1/2/3个30，
        // 只能对应唯一的线程】】
        //
        //
        // Result: The first, the second, and the third '30' were printed respectively
        // by the thread of x being 3, the thread of x being 2, and the thread of x
        // being 5.
        //
        // The reason is as follows.
        //
        // Firstly, there is only one number (30) between 27 and 33; since
        // statements should be executed one by one, the first 30 must be printed by
        // the thread of x being 3. Secondly, same as the first 30, the 30 between 28
        // and 32 must be printed by the thread of x being 2. Therefore, last 30 can
        // only be printed by the thread of x being 5.
    }

    private static void task2() {
        Timer timer = new Timer();

        var task = new Runnable() {
            public void run() {
                int testTimes = 1000000;
                Random r = new Random();
                for (int i = 0 ; i != testTimes / 4; ++i) {
                    r.nextInt();
                }
            }
        };

        Runnable t1 = () -> {
            Thread[] threads = new Thread[4];
            for (int i = 0; i != 4; ++i) {
                threads[i] = new Thread(task);
                threads[i].start();
            }
            for (int i = 0; i != 4; ++i) {
                try {
                threads[i].join();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };

        Runnable t2 = () -> {
            for (int i = 0; i != 4; ++i) {
                task.run();
            }
        };

        timer.measure("Four thread  ", t1);
        timer.measure("Single thread", t2);

        // When generating 1000000 random numbers, four-threaded version runs
        // slower than single-threaded version. This may be because of the
        // switch of the threads. When running with more numbers to be
        // generated, the four-threaded version runs 4 times faster than the
        // single-threaded version. And this is because the former utilizes more
        // CPU resources (4 times thread as single-threaded version).
    }

    private static void task3() {
        Account account = new Account();
        Atm atm = new Atm();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                atm.change(account, 200);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                atm.change(account, -100);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                atm.change(account, 100);
            }
        });
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("account.getBalance() is " + account.getBalance());
        assert(account.getBalance() == 200);
    }

    private static void task4() {
        Goods goods = new Goods();
        ShoppingCart[] carts = {
            new ShoppingCart("A", goods), new ShoppingCart("B", goods),
            new ShoppingCart("C", goods), new ShoppingCart("D", goods)
        };

        System.out.println("Before seckill, there're " + goods.getNumber() + " goods.");

        Thread[] threads = new Thread[carts.length];

        int idx = 0;
        for (var cart : carts) {
            Thread t = new Thread(() -> {
                synchronized (goods) {
                    cart.settle();
                }
            });
            t.start();
            threads[idx++] = t;
        }

        try {
            for (var t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("After the seckill, " + goods.getNumber() +
            " goods left.");
    }

    public static void main(String[] args) {
        task1();
        System.out.println("----------------");
        task2();
        System.out.println("----------------");
        task3();
        System.out.println("----------------");
        task4();
        System.out.println("----------------");
    }
}
