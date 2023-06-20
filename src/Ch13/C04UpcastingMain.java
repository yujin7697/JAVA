package Ch13;

class Super{
	int n1;
}

class Sub extends Super{
	int n2;
}

public class C04UpcastingMain {
	
	public static void main(String[] args) {
//		NoCasting
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 20; ob2.n2 = 20;
		
//		UpCasting
//		상위 클래스형 참조 변수에 하위 객체를 연결
//		자동형변환 
//		Super ob3 = (Super) new Sub();
		Super ob3 = new Sub();
		ob3.n1 = 30;
		
//		DownCasting
//		하위클래스형 참조 변수에 상위 클래스 객체를 연결
//		강제형변환
		Sub down = (Sub)ob3;
		down.n1 = 100; down.n2 = 200;
		
	}
	
}
