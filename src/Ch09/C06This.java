package Ch09;

//	this
//	클래서 내에서 사용되는 예약어
//	생성되는 개체의 위치정보(메모리 주소)를 가져오는데 사용됨

//	this 활용
//	1) 멤버변수와 매개변수를 구별
//	- this.x = x;
//	2) 같은 클래스내의 다른 생성자 호출


class C06Simple{
	int x;
	int y;
	C06Simple(){
		this(123,123);
		System.out.println("C06Simple() 호출!");
//		this.x=123;this.y=123;
	}
	C06Simple(int x){
//		this.x=x;
//		this.y=0;
		this(x,0);
		System.out.println("C06Simple(int x) 호출!");
	}
	C06Simple(int x, int y){
		this.x=x;
		this.y=y;
		System.out.println("C06Simple(int x, int y) 호출!");
	}
}

public class C06This {
	public static void main(String[] args) {
		C06Simple ob1 = new C06Simple();
		C06Simple ob2 = new C06Simple(100);
		C06Simple ob3 = new C06Simple(100,200);
	}
}
