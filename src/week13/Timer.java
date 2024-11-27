package shelpam.week13;

import java.time.Instant;
import java.time.Duration;

public class Timer {
    public void measure(String taskName, Runnable f) {
        var begin = Instant.now();
        f.run();
        var end = Instant.now();
        System.out.println(taskName + " finished in " +
            Duration.between(begin, end).toNanos() + "ns");
    }
}
