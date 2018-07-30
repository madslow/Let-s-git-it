package connectP;

import java.io.*;

public class File_Search {

    public static String currDir = null;

    public static void main(String[] args) {
        currDir = System.getProperty("user.dir");       
        find(currDir);
    }

    public static void find(String filename) {
        File f = new File(filename);
        if (f.isDirectory()) {
            System.out.println("Entering into Directory : " + filename);

            String path = f.getAbsolutePath();
            String[] lists = f.list();

            for (int i=0; i < lists.length; i++) {
                find(path + "\\" + lists[i]);
            }

        } else if (f.toString().endsWith(".txt")) {         
            String line = null;
            try {
                BufferedReader readFile = new BufferedReader(new FileReader(filename));
                while ((line = readFile.readLine()) != null) {
                    if (line.matches(".*LIFE IS TOO SHORT.*")) {
                        System.out.println("found in " + filename);
                        break;
                    }
                }               
                readFile.close();
            } catch (Exception e) {
                System.out.println("can't open a file : " + e.getMessage());
            }   
        }
    }
}
/*import java.io.*;

public class File_Search {

    public static String currDir = null;

    public static void main(String[] args) {
    	
        currDir = System.getProperty("user.home");
        System.out.println(currDir);
        find(currDir);
    }

    public static void find(String filename) {
        File f = new File(filename);
        if (f.isDirectory()) {
            System.out.println("Entering into Directory : " + filename);

            String path = f.getAbsolutePath();
            String[] lists = f.list();

            for (int i=0; i < lists.length; i++) {
                find(path + "\\" + lists[i]);
            }

        } else if (f.toString().endsWith(".txt")) {         
            String line = null;
            try {
                BufferedReader readFile = new BufferedReader(new FileReader(filename));
                while ((line = readFile.readLine()) != null) {
                    if (line.matches(".*hello.*")) {
                        System.out.println("found in " + filename);
                        break;
                    }
                }               
                readFile.close();
            } catch (Exception e) {
                System.out.println("can't open a file : " + e.getMessage());
            }   
        }
    }
}

*/