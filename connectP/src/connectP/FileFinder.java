package connectP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileFinder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String filePath = "C:\\Users\\dawon-016\\Desktop\\";

        File file = new File(filePath);

        if(file.isDirectory()){

            for(String str : file.list()){
                File file2 = new File(filePath + "\\" + str);
                Scanner sc;
                try {
                    sc = new Scanner(file2);
                    while(sc.hasNextLine()){
                        String line = sc.nextLine();
                        if(line.contains("hello")){
                            System.out.println(str);
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }else{
            System.out.println("디렉토리가 아닙니다.");
        }
    }

}