package connectP;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class PrintTimer {
   
   public static void main(String[] args) {
	   
		
      ScheduledJob job = new ScheduledJob();
      Timer jobScheduler = new Timer();
      jobScheduler.scheduleAtFixedRate(job, 1000, 30000);
      try {
         Thread.sleep(200000);
         
      } catch(InterruptedException ex) {
         //
      }
      jobScheduler.cancel();
   }
   
}

class ScheduledJob extends TimerTask {
   
	public static boolean makeFile(String _fileName, ArrayList<String> alContent, boolean bAppend)	{
		
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
   public void run() {
	   
	   String logfile = "\\Users\\dawon-016\\Desktop\\hi.txt";

		ArrayList<String> al = new ArrayList<String>();
		System.out.println("log작성  ");
		al.add(new Date()+"잘되고있읍니다.");
		/*al.add(new Date()+"22222");
		al.add(new Date()+"33333");*/
	   
	   makeFile(logfile,al,true);
       System.out.println(new Date());
   }
   
   
}