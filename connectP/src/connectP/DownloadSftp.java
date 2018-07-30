package connectP;

import java.io.*;
import java.text.*;
import java.util.*;

import com.jcraft.jsch.*;

public class DownloadSftp {
	
	public static void main(String[] agrs){
		
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		
		FileOutputStream out = null;
		FileInputStream in = null;
		
		String host ="192.168.1.15";
		String userName ="santa_user";
		String passwd = "imsi00";
		int port = 22;
		String dir ="/Users/dawon-016/Desktop/Test/hello.txt";
		String localfile ="/users/dawon-016/desktop/hi.txt";
		String localfilels ="/users/dawon-016/desktop";
		
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd / HH:mm"); // 날짜 포맷을 지정해주면 됨(SimpleDateFormat 이용)
		Date today = new Date();
		File file = new File(dir);//저장할 이름과 패스 같이
		File file2 = new File(localfile);//가져올 원본 파일 패스
		JSch jsch = new JSch();
		
		System.out.println(sf.format(file2.lastModified())); // 파일의 마지막 수정 날짜가 출력됨
		System.out.println(sf.format(today)); // 파일의 마지막 수정 날짜가 출력됨
		
		if(sf.format(file2.lastModified()).equals(sf.format(today))){
		try{
			session = jsch.getSession(userName, host, port);
            session.setPassword(passwd);
         
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no"); // 인증서 검사를 하지 않음
            session.setConfig(config);
            session.connect();
 
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;
            System.out.println("=> Connected to " + host);
            channelSftp.cd(localfilels);
            
            out = new FileOutputStream(file);
            channelSftp.get(file2.getName(),out);
            
            System.out.println("=> Uploaded : " + file.getPath() + " at " + host);
            System.out.println(file.length()+"byte");
           
            
            System.out.println(sf.format(file2.lastModified())); // 파일의 마지막 수정 날짜가 출력됨
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                channelSftp.exit();
                channel.disconnect();
                session.disconnect();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
      	}
		else {
			System.out.println("수정한 날짜 일치 x");
		}
	}
}