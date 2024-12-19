package shelpam.week13;

import java.time.Instant;
import java.time.Duration;

public class Stopwatch {
    public enum Unit {
        Millisecond,
        Nanosecond,
    }

    private static String toString(Duration duration, Unit unit) {
        switch (unit) {
            case Millisecond:
                return duration.toMillis() + "ms";

            case Nanosecond:
                return duration.toNanos() + "ns";

            default:
                break;
        }

        // Unreachable
        return "";
    }

    public void measure(String taskName, Runnable f) {
        var begin = Instant.now();
        f.run();
        var end = Instant.now();
        System.out.println(taskName + " finished in " +
                Duration.between(begin, end).toNanos() + "ns");
    }

    public void measure(String taskName, Runnable f, Unit unit) {
        var begin = Instant.now();
        f.run();
        var end = Instant.now();
        System.out.println(taskName + " finished in " +
                toString(Duration.between(begin, end), unit));
    }
}
