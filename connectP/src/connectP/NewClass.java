package connectP;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class NewClass {

    public static void main(String[] args) {
        
        String SFTPHOST = "192.168.1.15";
        int SFTPPORT = 22;
        String SFTPUSER = "santa_user";
        String SFTPPASS = "imsi00";
        String SFTPWORKINGDIR = "/users/dawon-016/desktop/Test";
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            int timeOutMilliseconds = 80000;
            session.connect(timeOutMilliseconds);
            
            System.out.println("connect to : "+SFTPHOST);
            
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("connet channel");
            
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);

            byte[] buffer = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("hi.txt"));
            File newFile = new File("hi.i88.ca.txt");
            OutputStream os = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
            while ((readCount = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, readCount);
            }
            bis.close();
            bos.close();
            channel.disconnect();
            session.disconnect();
            //return;
        } catch (JSchException | SftpException | IOException ex) {
            ex.printStackTrace();
        }
    }

}