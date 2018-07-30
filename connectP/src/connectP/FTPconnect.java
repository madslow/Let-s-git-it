package connectP;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.*;

public class FTPconnect {
	public static void main (String[] args){
	Scanner scan;

		Process SSHD = null;
		InputStream is= null;
		BufferedReader stdInput = null;
		StringWriter sw = null;
		
		scan = new Scanner(System.in);
		
		System.out.println("IP :");
		String serverIp =scan.nextLine();
		
		String linuxpingFormat = "snmpwalk -v 2c -c public %s 1.3.6.1.2.1.25.4.2 |grep FreeSSHDService.exe";
		String windowpingFormat = "snmpwalk -v 2c -c public %s 1.3.6.1.2.1.25.4.2 |findstr FreeSSHDService.exe";
		String lcommand = String.format(linuxpingFormat, serverIp);
		String wcommand = String.format(windowpingFormat, serverIp);
			
			try {
				if (SystemUtils.IS_OS_WINDOWS) {
					String[] commandArray = { "cmd.exe", "/c", wcommand };
					SSHD = Runtime.getRuntime().exec(commandArray);
				} else if (SystemUtils.IS_OS_LINUX) {
					String[] commandArray = { "/bin/sh", "-c", lcommand };
					SSHD = Runtime.getRuntime().exec(commandArray);
				}

				is = SSHD.getInputStream();
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
				
				System.out.println(sw);
				String sws = sw.toString();

				if(sws.contains("FreeSSHDService.exe")){
					String swss = sw.toString();
					if (SystemUtils.IS_OS_WINDOWS) {
						swss = swss.substring(swss.indexOf("\"")-1, swss.indexOf("e\"")+2).trim();
					} else if (SystemUtils.IS_OS_LINUX) {
						swss = swss.substring(swss.indexOf("\""), swss.indexOf("\"")).trim();
					}
					String flg;
					
					if(swss.contains("FreeSSHDService.exe")){
						flg ="0";
						
					System.out.println(sw);
					System.out.println(swss);
					System.out.println(flg);

					
			    }
				}
				else {
					System.out.println("end");
					String flg ="1";
			}
			}
				catch (IOException e) {
				e.printStackTrace();
			}
	}
}
