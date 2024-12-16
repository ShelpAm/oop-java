package shelpam.week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String[] args) throws Exception {
        ticketsBooking();
        shelpam.week14.Main.notice();
        copyFile("bin/BanJi.class", "bin/dest.java.bin", "char-wise");
        shelpam.week14.Main.cowork("135", "2468", "abcde");
        doGrading();
    }

    private static void ticketsBooking() throws Exception {
        TicketService service = new TicketService();
        Random r = new Random();

        Thread[] threads = new Thread[5];
        for (int i = 0; i != threads.length; ++i) {
            var t = new Thread(() -> {
                int count = r.nextInt(5) + 1;
                service.book(count);
                System.out.println("Someone booked " + count + " tickets.");
            });
            t.start();
            threads[i] = t;
        }
        for (var t : threads) {
            t.join();
        }
    }

    private static void copyFile(String src, String dest, String method) throws FileNotFoundException, IOException {
        try (var br = new BufferedReader(new FileReader(src));
                var bw = new BufferedWriter(new FileWriter(dest))) {
            if (method.equals("line-wise")) {
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
            } else if (method.equals("char-wise")) {
                int ch;
                while ((ch = br.read()) != -1) {
                    bw.write(ch);
                }
            }
        }
    }

    // Note the difference between marking and grading here.
    private static void doGrading() throws InterruptedException {
        final int numberOfStudents = 10;
        int[] scores = new int[numberOfStudents];

        Problem[] problems = {
                new Problem(30), new Problem(10), new Problem(10),
                new Problem(30), new Problem(20)
        };

        Grader[] graders = new Grader[problems.length];
        for (int i = 0; i != graders.length; ++i) {
            graders[i] = new Grader(numberOfStudents, problems[i], 0.7);
            graders[i].start();
        }

        for (Grader grader : graders) {
            grader.join();
        }

        for (Grader grader : graders) {
            for (int i = 0; i != grader.scores.length; ++i) {
                scores[i] += grader.scores[i];
            }
        }
        System.out.println("Scores of students:");
        System.out.println(Arrays.toString(scores));
    }
}
