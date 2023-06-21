package Ch26;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerRecvThread implements Runnable{
	
	Socket client;
	DataInputStream din;
	
	ServerRecvThread(Socket client){
		this.client = client;
	}
	@Override
	public void run() {
		try {
			din = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String recv = null;
		while(true) {
			
			try {
				recv = din.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(recv.equals("q") || recv==null) 
				System.exit(-1);	//종료
			System.out.println("[Client] " + recv);
		}
		
	}

}
