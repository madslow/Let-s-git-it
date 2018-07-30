package connectP;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next(); // 경로를 입력받는다
        try {
            getAns(path);
        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException e) {
            System.out.println("에러");
        }
    }

    public static void getAns(String path) throws IOException
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles)
        {
            if (file.isFile())
            {
                getStr(file);
            }
            else if(file.isDirectory())
            {
                getAns(file.getPath());
            }
        }
    }

    public static void getStr(File file) throws IOException {
        String name = file.getName();
        if(name.substring(name.length() - 3, name.length()).equals("txt"))
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st = "";
            while((st = br.readLine()) != null)
            {
                if(st.contains("LIFE IS TOO SHORT"))
                {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}