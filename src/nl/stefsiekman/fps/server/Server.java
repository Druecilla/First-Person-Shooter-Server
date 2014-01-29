package nl.stefsiekman.fps.server;

public class Server {
	
	
	public Server(){
		
	}
	
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args){
		new Server();
	}
}