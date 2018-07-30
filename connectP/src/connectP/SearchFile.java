package connectP;

import java.io.*;
import java.util.*;

public class SearchFile {
	      public static void main(String[] args){ 
	    	  File f = new File("Desktop/hi.txt");
	    	  try {
	    	      System.out.println(f.getCanonicalPath());
	    	      System.out.println("파일의 존재 여부 " + f.exists());
	    	      System.out.println("파일의 크기 " + f.length());
	    	      System.out.println("파일의 마지막 수정날짜 " + f.lastModified()/1000/86400);
	    	    } catch (IOException e) {
	    	      System.err.println(e);
	    	      System.exit(1);
	    	    }
	         /* ArrayList<File> txtFiles= new ArrayList<File>(); 
	          File f= new File(“d:\\test”); 
	           
	          if(!f.exists()) 
	          { 
	              System.out.println(“존재하지 않는 디렉토리 입니다.”); 
	              return; 
	          } 
	           
	          File[] allFiles= f.listFiles(); 
	          for(File file : allFiles) 
	          { 
	              if(file.getName().endsWith(“.txt”)) 
	              { 
	                  txtFiles.add(file); 
	              } 
	          } 
	           
	          System.out.println(“txt 파일 목록”); 
	          System.out.println(“———————–“); 
	          for(File file : txtFiles) 
	          { 
	              System.out.println(“파일 이름 : “+file.getName()); 
	              System.out.println(“파일 크기 : “+file.length()); 
	              System.out.println(“———————–“); 
	          } 
	        */   
	      } 
	  }
