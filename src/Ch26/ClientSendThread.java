package Ch26;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendThread implements Runnable{

	Scanner sc = new Scanner(System.in);
	DataOutputStream dout;
	Socket client;
	ClientSendThread(Socket clinet){
		this.client = client;
	}
	@Override
	public void run() {
		String send;
		try {
			dout = new DataOutputStream(client.getOutputStream());
			while (true) {
//				송신
				System.out.print("[Client(q:종료)] ");
				send = sc.nextLine();
				dout.writeUTF(send);
				dout.flush();
				if(send.equals("q")) 
					System.exit(-1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
