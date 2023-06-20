package Ch13;

class C06Super{
	void SuperFunc() {
		System.out.println("SuperFunc 호출!!");
	}
}
class C06Sub extends C06Super{
	void SubFunc() {
		System.out.println("SubFunc 호출!!");
		System.out.println("Sub클래스에서 재정의한 SuperFunc 호출!!");
	}
}

public class C06UpCastingOverridingMain {
	public static void main(String[] args) {
		C06Super ob = new C06Sub(); //UpCasting
		ob.SuperFunc();	//물려받은 멤버는 접근 가능
//		ob.Sub(); //확장된 멤버는 접근 불가
//		Upcasting을 사용하면
//		확장된 멤버에 접근 가능? x -> Downcasting을 통해 확장된 멤버에 접근
//		오버라이딩된 멤버에 접근 가능? o -> 
	}
}
