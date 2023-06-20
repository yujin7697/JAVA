package Ch24;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {
	public static void main(String[] args) throws Exception{
//		
		ServerSocket server = new ServerSocket(5000);
		System.out.println("Server Socket Listening...");
		Socket client = server.accept();
		System.out.println("[INFO] " +client.getInetAddress()+ " 접속되었습니다!");
		
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		dout.writeUTF(client.getInetAddress()+" 님 접속 확인되었습니다. by Server");
		dout.flush();
		dout.close();
		
		server.close();
		System.out.println("[INFO] 종료되었습니다.");
	}
}
