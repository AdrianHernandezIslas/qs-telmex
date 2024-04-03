package com.telmex.demo.service.external.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

@Service
public class FtpService {

    @Autowired
    private Session sessionSftp;
    private ChannelSftp channelSftp;

    public static final int PREFIX = 0;
    public static final int SUFFIX = 1;

    public File stream2file(InputStream in,String pathFile) throws IOException {
        String partFile[] = pathFile.split("\\.");
        final File tempFile = File.createTempFile(partFile[PREFIX],".".concat(partFile[SUFFIX]));
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(in, out);
        return tempFile;
    }

    public File getFile(String pathFile) throws JSchException, SftpException, IOException {
        channelSftp = openChanelSftp();
        channelSftp.connect();
        String remoteFile = "/"+pathFile;
        InputStream is = channelSftp.get(remoteFile);
        File file = stream2file(is,pathFile);
        return  file;
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
