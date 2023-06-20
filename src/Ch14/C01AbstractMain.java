package Ch14;

class Par1{
	void Func() {
		
	}
}
class Son1 extends Par1{
	void Func() {
		System.out.println("Son1에서 자율적으로 재정의한 Func() 호출!");
	}
}
abstract class Par2{
	abstract void Func(); //추상메서드(미완성 메서드) - 강제성부여/작업미루기
}
class Son2 extends Par2{
	void Func() {
		System.out.println("Son2에서 강제로 재정의한 Func() 호출!");
	}
}
public class C01AbstractMain {
	public static void main(String[] args) {
		Par1 ob1 = new Par1(); // 상위클래스 객체 생성 o
		Son1 ob2 = new Son1(); // 하위클래스 객체 생성 o
		Par1 ob3 = ob2;		   // Upcasting
		ob3.Func();			   // 상위 참조변수로 재정의한 하위객체 매서드 접근 o
		
//		Par2 ob4 = new Par2(); // 추상클래스 객체 생성 x
		Son2 ob5 = new Son2(); // 하위클래스 객체 생성 o (추상매서드를 재정의해야 가능)
		Par2 ob6 = ob5; 	   // Upcasting
		ob6.Func();
	}
}		
