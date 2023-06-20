package Ch08;

//	클래스 선언 시 생성자 함수를 하나라도 명시하지 않았을 경우 디폴트 생성자가 주입이 되나
//	하나 이상의 생성자 함수가 명시되어 있을 경우 디폴트 생성자는 주입되지 않는다.
class C09Simple{
	
	C09Simple(){
		
	}
	C09Simple(int x){
		
	}
}

public class C09constructorMain {
	public static void main(String[] args) {
		C09Simple obj1 = new C09Simple();
	}
}
