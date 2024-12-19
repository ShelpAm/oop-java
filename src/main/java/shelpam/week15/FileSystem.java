package shelpam.week15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * FileSystem
 */
public class FileSystem {

    public enum CopyMode {
        BINARY_BUFFERED,
        BINARY_UNBUFFERED,
        LINE_WISE,
        CHAR_WISE,
    }

    public static void copyFileBinary(String src, String dest, boolean buffered)
            throws FileNotFoundException, IOException {
        try (InputStream is = buffered
                ? new BufferedInputStream(new FileInputStream(src))
                : new FileInputStream(src);
                OutputStream os = buffered
                        ? new BufferedOutputStream(new FileOutputStream(dest))
                        : new FileOutputStream(dest)) {
            byte[] buffer = new byte[4 << 10];
            int length;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void copyFileLineWise(String src, String dest)
            throws FileNotFoundException, IOException {
        try (var br = new BufferedReader(new FileReader(src));
                var bw = new BufferedWriter(new FileWriter(dest))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static void copyFileCharWise(String src, String dest)
            throws FileNotFoundException, IOException {
        try (var br = new BufferedReader(new FileReader(src));
                var bw = new BufferedWriter(new FileWriter(dest))) {
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(ch);
            }
        }
    }

    public static void copyFile(String src, String dest, CopyMode method)
            throws FileNotFoundException, IOException {
        switch (method) {
            case BINARY_BUFFERED:
                copyFileBinary(src, dest, true);
                break;

            case BINARY_UNBUFFERED:
                copyFileBinary(src, dest, false);
                break;

            case LINE_WISE:
                copyFileLineWise(src, dest);
                break;

            case CHAR_WISE:
                copyFileCharWise(src, dest);
                break;

            default:
                break;
        }
    }

}
