package shelpam.week14;

import java.util.ArrayList;
import java.util.Random;
import shelpam.week13.Timer;
import shelpam.week14.FiniteStateMachine.DoesntExistException;

// Notes about `Thread.join`

// public class Main {
//     public static void main(String[] args) {
//         Thread longWork = new Thread(() -> {
//             for (int i = 0; i != 1 << 31; ++i) {
//                 int a = i * i;
//                 if (i % (1 << 28) == 0) {
//                     System.out.println("longWork: " + i);
//                 }
//             }
//         });
//
//         Thread longWork2 = new Thread(() -> {
//             for (int i = 0; i != 1 << 31; ++i) {
//                 int a = i * i;
//                 if (i % (1 << 28) == 0) {
//                     System.out.println("longWork2: " + i);
//                 }
//             }
//         });
//
//         longWork.start();
//         longWork2.start();
//
//         try {
//             // `Thread.join` only guarantees that join won't return until idxs
//             // work is finished, but still may be paused by other threads. So
//             // though called `Thread.join`, the control flow may transfer to
//             // other thread.
//             longWork.join();
//             longWork2.join();
//         } catch (InterruptedException e) {
//         }
//     }
// }

public class Main {
    private static void printing() {
        String[] doca = {
                "/* C code */",
                "#include <stdio.h>",
                "int main()", "{",
                "    printf(\"I love %s.\", \"zyx\");",
                "}",
                ""
        };
        String[] docb = {
                "# Python code",
                "loved = 'zyx'",
                "print(f\"I love {loved}.\"",
                ""
        };
        String[] docc = {
                "// Java code",
                "public class Main {",
                "    public static void main(String[] args)",
                "    {",
                "        System.out.println(\"I love zyx.\");",
                "    }",
                "}",
                ""
        };

        var tasks = new ArrayList<PrintingTask>();
        tasks.add(new PrintingTask("A", doca));
        tasks.add(new PrintingTask("B", docb));
        tasks.add(new PrintingTask("C", docc));

        PrintingWork work = new PrintingWork(tasks);
        work.start();
    }

    public static void notice() {
        NoticeBoard noticeBoard = new NoticeBoard();

        Runnable publish = () -> {
            for (int i = 0; i != 3; ++i) {
                noticeBoard.add(i + "");
            }
        };

        Thread[] threads = new Thread[4];
        for (int i = 0; i != threads.length; ++i) {
            threads[i] = new Thread(publish);
            threads[i].start();
        }

        for (int i = 0; i != threads.length; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }

        noticeBoard.printAll();
    }

    public static void cowork(String s1, String s2, String s3) throws DoesntExistException {
        State[] states = { new State(0, 1, s1), new State(1, 2, s3), new State(2, 0, s2) };

        var fsm = new FiniteStateMachine(states, 0);
        fsm.run();
    }

    private static void calculateSum() {
        Timer timer = new Timer();

        int[] data = new int[12345];
        for (int i = 0; i != data.length; ++i) {
            data[i] = i;
            data[i] = new Random().nextInt();
        }

        timer.measure("Single-threaded", () -> {
            Accumulator acc = new Accumulator(data, 0, data.length);
            acc.start();
            try {
                acc.join();
            } catch (InterruptedException e) {
            }
            int r1 = acc.getResult();
            System.out.println("Single-threaded result = " + r1);
        });

        timer.measure("Multi-threaded", () -> {
            final int batchSize = 10;

            int r2 = 0;
            Accumulator[] accumulators = new Accumulator[(data.length + batchSize - 1) / batchSize];
            for (int i = 0; i != accumulators.length; ++i) {
                accumulators[i] = new Accumulator(data, batchSize * i, Math.min(batchSize * (i + 1), data.length));
                accumulators[i].start();
            }

            for (var acc : accumulators) {
                try {
                    acc.join();
                } catch (InterruptedException e) {
                }
                r2 += acc.getResult();
            }
            System.out.println("Multi-threaded result = " + r2);
        });
    }

    public static void main(String[] args) throws Exception {
        printing();
        System.out.println();
        notice();
        System.out.println();
        cowork("13579", "24680", "abcde");
        System.out.println();
        calculateSum();
        System.out.println();
    }
}
