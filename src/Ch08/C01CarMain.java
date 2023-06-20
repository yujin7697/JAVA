package Ch08;

public class C01CarMain {
	public static void main(String[] args) {	
		//	다음 main함수의 코드가 실행될 수 있도록 C01Car 클래스를 만드세요
			
		C01Car hongCar = new C01Car();
		hongCar.owner = "홍길동";
		hongCar.speed = 0;
		hongCar.fuel = 100;
		System.out.printf("%s %d %d\n",
				hongCar.owner,hongCar.speed,hongCar.fuel);	
		hongCar.Accel();	// owner + 님이 현재 속도 + speed + 에서 (speed+5)로 가속하다가 출력
		hongCar.Break();	// owner + 님이 현재 속도 + speed + 에서 (speed-5)로 감속하다가 출력
		hongCar.showInfo();
	}
}
