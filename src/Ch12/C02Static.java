package Ch12;

class C02Simple{
	int n1;
	static int n2;
	void Func1() {
		n1=10;
		n2=20;
	}
	static void Func2() {
		int n1=10;		// n1은 객체 생성 이후 접근 가능한 멤버, 컴파일 오류...
		n2=20;
		
	}
}

public class C02Static {

}
