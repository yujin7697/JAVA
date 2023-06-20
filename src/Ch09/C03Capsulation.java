package Ch09;

class 라면Recipe{
//	순서
	private void step1() {};
	private void step2() {};
	private void step3() {};
	private void step4() {};
	void cooking() {
		step1();
		step2();
		step3();
		step4();
	}
}
class Cook{
	public 라면Recipe Recipe_ramen = new 라면Recipe();
}
public class C03Capsulation {
	public static void main(String[] args) {
		Cook hong = new Cook();
		hong.Recipe_ramen.cooking();
	}
}
