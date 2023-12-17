package com.telmex.demo.utils;

import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Sftp {
	
	private static final String HOST = "quarksoft3.files.com";
	private static final String USER = "wauffebreppitou-8505@yopmail.com"; 
	private static final String PASS = "Quarksoft123!";
	private static final int PORT = 22;
	
	
	private ChannelSftp channelSFTP;
	
	private ChannelSftp createConnection() throws Exception {
		
		channelSFTP = null;
		Properties config;
		try {

			Session session= null;
			session = new JSch().getSession(USER, HOST, PORT);
			
			config = new Properties();
			config.setProperty("StrictHostKeyChecking", "no");
			config.setProperty("PreferredAuthentications", "password");
			

			session.setConfig(config);
			session.setPassword(PASS);
			session.connect(19000);
			Channel chann = session.openChannel("sftp");
			chann.connect(19000);
			channelSFTP= (ChannelSftp) chann;
			

		} catch(JSchException ex) {
			throw new Exception("Error al conectar con el SFTP: "+ex.getMessage());
		} 
		return channelSFTP;
	}

	public InputStream getFile(String fileName) throws Exception {
		ChannelSftp channelSFTP = createConnection();
		try {
			return channelSFTP.get(fileName);
		} catch (SftpException ex) {
			throw new Exception("Error al leer el archivo del SFTP: "+ex.getMessage());
		} 
	}
	
	public void disconect() throws Exception{
		try {
			
			if( channelSFTP == null)
				return;

			if(channelSFTP.isConnected())
				channelSFTP.disconnect();

			if(channelSFTP.getSession() != null)
				channelSFTP.getSession().disconnect();

		} catch(JSchException ex) {
			throw new Exception("Error al desconectar el archivo del SFTP: "+ex.getMessage());
		}
	}
}
