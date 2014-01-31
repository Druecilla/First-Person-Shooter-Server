package nl.stefsiekman.fps.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import tk.bartbart333.logger.ConsoleHandler;
import tk.bartbart333.logger.Handler;
import tk.bartbart333.logger.Level;
import tk.bartbart333.logger.Logger;

public class Server {
	
	public static final String version = "v0.01";
	public static File serverfolder = new File("server");
	public static Properties properties = new Properties();
	
	private boolean gui = false;
	private Handler handler;
	private long begintime;
	private ServerSocket server;
	
	public Server(){
		init();
		
		try{
			serverfolder.mkdir();
			loadProperties();
			startServer();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void init(){
		Logger.init();
		
		if(gui){
			
		}else{
			handler = new ConsoleHandler();
		}
		
		Logger.addHandler(handler);
		Logger.log(Level.INFO, "Starting server " + version);
		
		begintime = getTime();
	}
	
	private void loadProperties() throws FileNotFoundException, IOException{
		File file = new File(serverfolder, "server.properties");
		if(!file.exists()){
			file.createNewFile();
			Logger.log(Level.INFO, "Creating server.properties");
		}
		
		properties.put("server-port", "3030");
		
		properties.load(new FileInputStream(file));
		Logger.log(Level.INFO, "Loaded server.properties");
	}
	
	private void startServer() throws NumberFormatException{
		int port = Integer.valueOf(properties.getProperty("server-port"));
		
		try{
			server = new ServerSocket(port);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args){
		new Server();
	}
}