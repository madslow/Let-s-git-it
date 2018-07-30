package connectP;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.SystemUtils;


public class command {
	public static void main(String[] args){
		Process p = null;
		InputStream is= null;
		BufferedReader stdInput = null;
		StringWriter sw = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("IP :");
		String serverIp =scan.nextLine();
		
		String linuxpingFormat = "ping -c 2 %s |grep loss";
		String windowpingFormat = "ping -n 2 %s |findstr \"손실\"";
		String lcommand = String.format(linuxpingFormat, serverIp);
		String wcommand = String.format(windowpingFormat, serverIp);
			
			try {
				if (SystemUtils.IS_OS_WINDOWS) {
					String[] commandArray = { "cmd.exe", "/c", wcommand };
					p = Runtime.getRuntime().exec(commandArray);
				} else if (SystemUtils.IS_OS_LINUX) {
					String[] commandArray = { "/bin/sh", "-c", lcommand };
					p = Runtime.getRuntime().exec(commandArray);
				}

				is = p.getInputStream();
				if(SystemUtils.IS_OS_WINDOWS){
					stdInput = new BufferedReader(new InputStreamReader(is,"MS949"));
				}else if(SystemUtils.IS_OS_LINUX){
					stdInput = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				}
				sw = new StringWriter();
				char[] buffer = new char[1024 * 4];
				int n = 0;
				while (-1 != (n = stdInput.read(buffer))) {
					sw.write(buffer, 0, n);
				}

				String sws = sw.toString();
				if (SystemUtils.IS_OS_WINDOWS) {
					sws = sws.substring(sws.indexOf("(")+1, sws.indexOf("% 손실")).trim();
				} else if (SystemUtils.IS_OS_LINUX) {
					sws = sws.substring(sws.indexOf("received,")+9, sws.indexOf("% packet loss")).trim();
				}
				
				String flg = "0";
				if("100".equals(sws)){
					flg = "1";
				} else {
					flg = "0";
				}
				
				
				
				System.out.println(sw);
				System.out.println(sws);
				System.out.println(flg);
			} catch (IOException e) {
				e.printStackTrace();
				
			}	
			
		
	}

}
