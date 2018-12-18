package practice;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreams{

    public static void main(String[] args)  {
        Path path1 = Paths.get("E:\\habitat");
        Path path2 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        System.out.println();
        Path path3 = Paths.get("E:\\data");
        Path path4 = Paths.get("E:\\user\\home");
        Path relativePath = path3.relativize(path4);
        System.out.println("***********");
        System.out.println(path3);
        System.out.println(relativePath);
        System.out.println("***********");
        System.out.println(path3.resolve(relativePath));
        System.out.println(path3.resolve(relativePath).normalize());
    }
}
