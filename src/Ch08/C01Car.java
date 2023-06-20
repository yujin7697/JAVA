package Ch08;

public class C01Car {
	String owner;
	int speed;
	int fuel;
	void Accel() {
		System.out.println(owner + " 님이 현재 속도 " + speed +
				"에서"+(speed+5)+"로 가속하다.");
	}
	void Break() {
		System.out.println(owner + " 님이 현재 속도 " + speed +
				"에서"+(speed-5)+"로 감속하다.");
	}
	void showInfo() {
		System.out.println("owner : " + owner + " speed : "+ speed
				+ " fuel : " + fuel);
	}
}
