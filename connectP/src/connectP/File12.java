package connectP;

import java.io.*;
import java.util.*;

public class File12 {
/*	  public static void main(String args[])
	  {
	    try
	    {
	      FileWriter fw = new FileWriter("\\Users\\dawon-016\\Desktop\\hi.txt"); // 절대주소 경로 가능
	      BufferedWriter bw = new BufferedWriter(fw);
	      String str = "lllloooovvvveeee";
	 
	      bw.write(str);
	      bw.newLine(); // 줄바꿈
	       
	      bw.close();
	    }
	    catch (IOException e)
	    {
	      System.err.println(e); // 에러가 있다면 메시지 출력
	      System.exit(1);
	    }
	  }
	}

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.util.ArrayList;

*/
	public static void main(String[] args) {



		String logfile = "\\Users\\dawon-016\\Desktop\\hi.txt";

		ArrayList<String> al = new ArrayList<String>();
		System.out.println("log작성");
		al.add("11111");
		al.add("22222");
		al.add("33333");
		makeFile(logfile,al,true);

	}

	public static boolean makeFile(String _fileName, ArrayList<String> alContent, boolean bAppend)

	{

		boolean isOK;
		try
		{
			FileWriter fw=new FileWriter(_fileName, bAppend); 
			BufferedWriter bw=new BufferedWriter(fw); 
			
			String strContent;

			
			for(int i=0; i<alContent.size(); i++){
				strContent = alContent.get(i);		

				bw.write(strContent);
				bw.newLine(); 

			}

			bw.flush(); 
			bw.close(); 
			fw.close();

	

			isOK= true;

		}

		catch (Exception e)

		{

			e.printStackTrace();

			isOK = false;

		}

		return isOK;

	}



}


