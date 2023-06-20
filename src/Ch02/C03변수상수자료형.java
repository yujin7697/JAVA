package Ch02;

public class C03변수상수자료형 {
	public static void main(String[] args) {
		
//		수 : 선 저장 / 후 처리
//		변수 : 개발자의 유지보수 측면에서 바뀔 예정인 큰 수
//		변수명 : 저장되어져 있는 변수 공간에 접근하기 위한 문자형태의 주소
//		자료형 : 수를 저장하기 위해 공간을 형성하는 예약어
//		상수 : 항상 같은 수
//		대입연산자(=)
//		lv(공간) = rv(값 - 먼저처리)
		
		int num1;					// 변수 타입이 int 인 num1의 변수 정의
		num1 = 10;					// num1이라는 변수에 상수 10을 대입
		int num2 = 4;				// 변수 타입이 int 인 num2 변수 지정 후 상수 4 대입
		int num3 = num1+num2;		// 변수 타입이 int 인 num2 변수 지정 후 num1과 num2의 대입된 값을 더해 num3에 초기화
		System.out.println(num3);	// num3에 대입된 값을 콘솔창에 출력
	}
}
