package com.telmex.demo.config;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SftpConfig {

    @Value("${remote.sftp.username}")
    private String username;
    @Value("${remote.sftp.host}")
    private String remoteHost;
    @Value("${remote.sftp.passwrod}")
    private String password;

    @Bean
    public Session setupJsch() throws JSchException {
        JSch jsch = new JSch();
        //jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
        Session jschSession = jsch.getSession(username, remoteHost, 22);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);
        jschSession.setPassword(password);
        jschSession.setTimeout(30000);
        return jschSession;
    }
}
