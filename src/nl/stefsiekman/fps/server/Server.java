package nl.stefsiekman.fps.server;

import tk.bartbart333.logger.ConsoleHandler;
import tk.bartbart333.logger.Handler;
import tk.bartbart333.logger.Level;
import tk.bartbart333.logger.Logger;

public class Server {
	
	public static final String version = "v0.01";
	
	private boolean gui = false;
	private Handler handler;
	private long begintime;
	
	public Server(){
		init();
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
	
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args){
		new Server();
	}
}