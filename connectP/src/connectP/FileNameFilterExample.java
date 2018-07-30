package connectP;

import java.io.*;

public class FileNameFilterExample {

    public static void main(String[] args) {
        String dir = "\\Users\\dawon-016\\Desktop";
        String ext = "hi.txt";
        findFiles(dir, ext);
    }
    
    private static void findFiles(String dir, String ext) {
        File file = new File(dir);
        if(!file.exists()) System.out.println(dir + " Directory doesn't exists");
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if(listFiles.length ==0){
            System.out.println(dir + "doesn't have any file with extension "+ext);
        }else{
            for(File f : listFiles)
                {System.out.println("File: "+dir+File.separator+f.getName());
                String dirtxt =(dir+File.separator+f.getName());
                System.out.println("파일의 마지막 수정날짜 " + f.lastModified()/1000/8640);
               /* System.out.println(dirtxt);*/
                // 버퍼 생성
                BufferedReader br = null;                
                // Input 스트림 생성
                InputStreamReader isr = null;         
                // File Input 스트림 생성
                FileInputStream fis = null;       
                // File 경로
                File file1 = new File(dirtxt);
                // 버퍼로 읽어들일 임시 변수
                String temp = "";
                // 최종 내용 출력을 위한 변수
                String content = "";
                 
                try {
                    // 파일을 읽어들여 File Input 스트림 객체 생성
                    fis = new FileInputStream(file1);
                    // File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
                    isr = new InputStreamReader(fis, "UTF-8");
                    // Input 스트림 객체를 이용하여 버퍼를 생성
                    br = new BufferedReader(isr);
                    // 버퍼를 한줄한줄 읽어들여 내용 추출
                    while( (temp = br.readLine()) != null) {
                        content += temp + "\n";
                    }
                     
                    System.out.println("================== 파일 내용 출력 ==================");
                    System.out.println(content);
                     
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                     
                } catch (Exception e) {
                    e.printStackTrace();
                     
                } finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        isr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
            }
        }
    }

    //FileNameFilter implementation
    public static class MyFileNameFilter implements FilenameFilter{
        
        private String ext;
        
        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
        
    }
}
