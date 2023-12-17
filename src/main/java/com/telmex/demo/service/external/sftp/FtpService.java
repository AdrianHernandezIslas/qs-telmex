package com.telmex.demo.service.external.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Vector;

@Service
public class FtpService {

    @Autowired
    private Session sessionSftp;
    private ChannelSftp channelSftp;

    public String getFile(String pathFile) throws JSchException, SftpException {
        channelSftp = openChanelSftp();
        channelSftp.connect();
        String remoteFile = "/EdoCta-2023-12-17.xlsx";
        String localDir = "src/main/resources";
        channelSftp.get(remoteFile,localDir+remoteFile);
        return  localDir+remoteFile;
    }

    public void chanelExit(){
        channelSftp.exit();
    }

    private ChannelSftp openChanelSftp() throws JSchException {
        if(!sessionSftp.isConnected()){
            sessionSftp.connect();
        }
        return  (ChannelSftp) sessionSftp.openChannel("sftp");
    }
}
