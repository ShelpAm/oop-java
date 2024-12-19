package shelpam.week9;

import java.util.ArrayList;

interface Pluggable {
    default public void start() {
        System.out.println(this + " started.");
    }

    default public void run() {
        System.out.println(this + " is running.");
    }

    default public void stop() {
        System.out.println(this + " stopped.");
    }
}

class ChineseCabbage implements Pluggable {
    private static final String name = "Chinese cabbage";

    @Override
    public String toString() {
        return name;
    }
}

// 萝卜
class Carrot implements Pluggable {
    private static final String name = "Carrot";

    @Override
    public String toString() {
        return name;
    }
}

// 菜市场小程序
class WetMarketApplet {
    private ArrayList<Pluggable> plugins = new ArrayList<Pluggable>();

    public void add(Pluggable pluggable) {
        plugins.add(pluggable);
    }

    public void remove(Pluggable pluggable) {
        plugins.remove(pluggable);
    }

    public void run() {
        for (Pluggable plugin : plugins) {
            plugin.start();
            plugin.run();
            plugin.stop();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        WetMarketApplet applet = new WetMarketApplet();

        applet.add(new Carrot());
        applet.add(new ChineseCabbage());
        applet.run();
    }
}
