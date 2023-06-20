package Ch21;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C02FileCopy {
	public static void main(String[] args) throws Exception{
		for(String str:args) {
			System.out.println(str);
		}
		Reader in = new FileReader("c:\\iotest\\origin.txt");
		Writer out = new FileWriter("c:\\iotest\\copy.txt");
		
		while(true) {
			int data = in.read();
			if(data==-1) break;
			out.write((char)data);
			out.flush();
		}
		in.close();
		out.close();
	}
}
