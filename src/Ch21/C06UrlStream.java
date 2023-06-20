package Ch21;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class C06UrlStream {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.pressian.com/pages/articles/2023061611071749959&amp;utm_source=naver&amp;utm_medium=mynews");
		InputStream bin = url.openStream(); //JAVA <- Browser출력내용
		BufferedInputStream buffIn = new BufferedInputStream(bin); //보조스트림추가
																   //버퍼공간을 둬서 한번에 받기
		Reader r = new InputStreamReader(buffIn);				   //보조스트림추가
																   //byte->char사이즈로 받아옴
		OutputStream out = new FileOutputStream("c:\\iotest\\index.html");
		Writer wout = new OutputStreamWriter(out);
		while(true) {
			int data = r.read();
			if(data==-1) break;
			System.out.print((char)data);
			wout.write(data);
		}
	}
}
