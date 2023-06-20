package Ch21;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriterMain{
	public static void main(String[] args) {
		try {
//			Writer out = new FileWriter("c:\\iotest\\test1.txt"); //덮어쓰기
			Writer out = new FileWriter("c:\\iotest\\test1.txt",true); //추가하기
			out.write("찌오\n");
			out.write("찌오찌오\n");
			out.write("찌오찌오찌오\n");
			out.flush(); //버퍼 초기화
			out.close(); //스트림 종료
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
