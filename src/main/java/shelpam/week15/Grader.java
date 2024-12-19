package shelpam.week15;

import java.util.Random;

/**
 * Grader
 */
public class Grader extends Thread {
    private static final double passMarkPercentage = 0.6;
    private int numberOfStudents;
    private Problem problem;
    private double passRate;
    int[] scores;

    public Grader(int numberOfStudents, Problem problem, double passRate) {
        this.numberOfStudents = numberOfStudents;
        this.problem = problem;
        this.passRate = passRate;
    }

    private int grade(Problem p) {
        Random random = new Random();
        boolean shouldPass = random.nextDouble(1) <= passRate;
        int base = (int) Math.ceil(problem.marks * passMarkPercentage);
        if (shouldPass) {
            int bonus = problem.marks - base;
            return base + random.nextInt(bonus + 1);
        }
        return random.nextInt(base);
    }

    @Override
    public void run() {
        scores = new int[numberOfStudents];
        for (int i = 0; i != numberOfStudents; ++i) {
            scores[i] = grade(problem);
        }
    }

    public int[] getScores() {
        return scores;
    }
}
