package connectP;

import java.io.*;

import com.jcraft.jsch.*;

public class SFTPconnect {
	
	public static void main(String[] agrs){
		
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		
		FileInputStream in = null;
		
		String host ="192.168.1.15";
		String userName ="santa_user";
		String passwd = "imsi00";
		int port = 22;
		String dir ="/users/dawon-016/desktop/Test";
		String localfile ="/users/dawon-016/desktop/hi.txt";
		
		File file = new File(localfile);
		JSch jsch = new JSch();
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
 
            in = new FileInputStream(file);
 
            channelSftp.cd(dir);
            channelSftp.put(in, file.getName());
            
            System.out.println("=> Uploaded : " + file.getPath() + " at " + host);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                channelSftp.exit();
                channel.disconnect();
                session.disconnect();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
      	}
}
