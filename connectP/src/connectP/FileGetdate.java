package connectP;

import java.io.*;
import java.util.*;

public class FileGetdate {
	
	File file = new File("경로");
	Calendar cal = Calendar.getInstance();
	/*cal.setTimeInmillis();*/
	// 파일의 수정시간 알아내기
	 public String getFileModifyDateTime(File f) {
	  
	  try {
	   Calendar cal = Calendar.getInstance();
	   cal.setTimeInMillis(f.lastModified());
	   return getTodayDateTime(cal);
	   
	  } catch (Exception e) {
	   e.printStackTrace();
	   return "알 수 없는 날짜";
	  }
	 }
	 
	 private String getTodayDateTime(Calendar cal) throws Exception {
	  StringBuffer today = new StringBuffer();
	  today.append(String.format("%04d", cal.get(cal.YEAR)));
	  today.append("-");
	  today.append(String.format("%02d", cal.get(cal.MONTH) + 1));
	  today.append("-");
	  today.append(String.format("%02d", cal.get(cal.DAY_OF_MONTH)));
	  
	  today.append(" ");
	  
	  today.append(String.format("%02d", cal.get(cal.HOUR_OF_DAY)));
	  today.append(":");
	  today.append(String.format("%02d", cal.get(cal.MINUTE)));
	  today.append(":");
	  today.append(String.format("%02d", cal.get(cal.SECOND)));
	  return today.toString();
	 }

}
