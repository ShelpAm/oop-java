package shelpam.week16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import shelpam.week13.Stopwatch;
import shelpam.week13.Stopwatch.Unit;
import shelpam.week15.FileSystem;
import shelpam.week15.FileSystem.CopyMode;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws Exception {
        FileSystem.copyFile("bin/BanJi.class", "bin/dest.java.bin", CopyMode.LINE_WISE);
        FileSystem.copyFile("bin/BanJi.class", "bin/dest.java.bin", CopyMode.CHAR_WISE);

        // 2. 请基于字节缓冲流BuferedXxx实现例6.3的功能。（注：即BufferedInputStream、
        // BufferedInputStream）
        FileSystem.copyFile("bin/BanJi.class", "bin/dest.java.bin", CopyMode.BINARY_BUFFERED);

        // 3. 假定有一个压缩包data.rar（100M以上--或是找个电影），请基于①基于文件
        // 流复制文件，②基于缓冲字节流复制文件，缓冲区大小为4Kb，并列出各自所用时间
        // （毫秒级）。
        Stopwatch t = new Stopwatch();
        t.measure("Buffered copy", () -> {
            try {
                FileSystem.copyFile("/home/shelpam/Downloads/zoom_x86_64.rpm", "/tmp/zoom_x86_64.jpg",
                        CopyMode.BINARY_BUFFERED);
            } catch (Exception e) {
            }
        }, Unit.Millisecond);
        t.measure("Unbuffered copy", () -> {
            try {
                FileSystem.copyFile("/home/shelpam/Downloads/zoom_x86_64.rpm", "/tmp/zoom_x86_64.jpg",
                        CopyMode.BINARY_UNBUFFERED);
            } catch (Exception e) {
            }
        }, Unit.Millisecond);

        // 4. 从键盘初入一组数（数量未知），计算出所有数据的累加和，并借助缓冲流将其存
        // 入文本文件a.txt；之后从文本文件中读取所有数据，再计算数据的累加和。
        System.out.println("Input some numbers:");
        Scanner scanner = new Scanner(System.in);
        var nums = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }

        try (var os = new DataOutputStream(new FileOutputStream("./bin/a.txt"))) {
            int sum = 0;
            os.writeInt(nums.size());
            for (var num : nums) {
                sum += num;
                os.writeInt(num);
            }
            System.out.println("The input sum is: " + sum);
        }

        try (var is = new DataInputStream(new FileInputStream("./bin/a.txt"))) {
            int sum = 0;
            int size = is.readInt();
            for (int i = 0; i != size; ++i) {
                sum += is.readInt();
            }
            System.out.println("The sum of numbers in file is: " + sum);
        }

        // 5. 从键盘输入2个int、2个double、2个boolean、2个char型数据（每个数据对应1个变量），
        // 借助数据流将这组数据写入文件a.dat，继而借助数据流从文件中读取数据（对应到8个变量），
        // 对比这两组变量是否对应相等。
        Scanner scanner2 = new Scanner(System.in);
        var vars = new ArrayList<>();
        System.out.println("Please input two ints, two doubles, two booleans, and two chars in order.");
        vars.add(scanner2.nextInt());
        vars.add(scanner2.nextInt());
        vars.add(scanner2.nextDouble());
        vars.add(scanner2.nextDouble());
        vars.add(scanner2.nextBoolean());
        vars.add(scanner2.nextBoolean());
        scanner2.useDelimiter("");
        vars.add(scanner2.next().charAt(0));
        vars.add(scanner2.next().charAt(0));

        try (var os = new DataOutputStream(new FileOutputStream("./bin/a.dat"))) {
            for (var v : vars) {
                if (v instanceof Integer) {
                    os.writeInt((int) v);
                } else if (v instanceof Double) {
                    os.writeDouble((double) v);
                } else if (v instanceof Boolean) {
                    os.writeBoolean((boolean) v);
                } else if (v instanceof Character) {
                    os.writeChar((char) v);
                }
            }
        }

        var neoVars = new ArrayList<>();
        try (var is = new DataInputStream(new FileInputStream("./bin/a.dat"))) {
            neoVars.add(is.readInt());
            neoVars.add(is.readInt());
            neoVars.add(is.readDouble());
            neoVars.add(is.readDouble());
            neoVars.add(is.readBoolean());
            neoVars.add(is.readBoolean());
            neoVars.add(is.readChar());
            neoVars.add(is.readChar());
        }

        assert (vars.equals(neoVars));
        System.out.println("Read data:");
        for (var v : vars) {
            System.out.println(v);
        }
        System.out.println("---");
        System.out.println("Ok, asserted, all elements are the same.");
    }
}
