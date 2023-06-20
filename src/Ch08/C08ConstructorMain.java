package Ch08;

//	생성자 함수(메서드)
//	객체 생성시에 한 번 호출되는 특수한 메서드
//	객체 생성시에 1회 호출
//	객체 생성시 필요한 초기값을 부여
//	생성자 함수는 클래시명과 동일하며 반환자료형을 가지지 않는다.
//	생성자 함수를 명시하지 않으면 기본적으로 컴파일러에 의해 주입되는 생성자가 있음 -> 디폴트 생성자라고 함
//	컴파일러에 의해 주입받는 디폴트 생성자는 모든 멤버의 초기값을 0(or false or null) 지정

class C08Simple{
	int m1;
	double m2;
	boolean m3;
	String m4;
	// 디폴트 생성자 함수 
	C08Simple(){
		System.out.println("디폴트 생성자 호출!");
		this.m1 = 10;
		this.m2 = 20.2;
		this.m3 = true;
		this.m4 = "홍길동";
	}
	C08Simple(int x){
		System.out.println("C08Simple(int x) 생성자 호출");
		this.m1 = x;
	}
	C08Simple(int ...x){
		System.out.println("C08Simple(int ...x) 생성자 호출");
		for(int arg : x) {
			this.m1 += arg;
		}
	}
	@Override
	public String toString() {
		return "C08Simple [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 +
				", m4=" + m4 + "]";
	}

	
	
}

public class C08ConstructorMain {
	public static void main(String[] args) {
		C08Simple obj = new C08Simple();
		System.out.printf("%d %f %b %s\n",obj.m1,obj.m2,obj.m3,obj.m4);
		C08Simple obj2 = new C08Simple(20);
		System.out.printf("%d %f %b %s\n",obj2.m1,obj2.m2,obj2.m3,obj2.m4);
		C08Simple obj3 = new C08Simple(10,20,30,40,50);
		System.out.println(obj3.m1);
		System.out.println(obj.toString());
	}
}


