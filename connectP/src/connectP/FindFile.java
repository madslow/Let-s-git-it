package connectP;

import java.io.File;
import java.util.Scanner;

public class FindFile {
    public static void main(String[] args) {
        find("C:\\Users\\dawon-016", "hello");
    }

    private static void find(String path, String msg) {
        File file = new File(path);
        if (file.isDirectory())
            for (File f : file.listFiles()) {
                if (f.isFile())
                    try {
                        Scanner sc = new Scanner(new File(f.getPath()));
                        while (sc.hasNextLine())
                            if (sc.nextLine().contains(msg)) {
                                System.out.println(f.getPath());
                                break;
                            }
                    } catch (Exception e) {}
                find(f.getPath(), msg);
            }
    }
}