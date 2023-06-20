package Ch10;

class 냉장고{
	디스플레이 display;
	냉장실 section1;
	냉동실 section2;
	제어컨트롤러 controller;
	냉장고(){
//		각 멤버인 참조변수들을 객체와 연결
	}
}

class 디스플레이{
	void showInfo() {
		System.out.println("냉장실 물건 개수 : " );
	}
}
class 냉장실{
	int cnt;
	void setInsert(String object) {
		cnt++;
	}
}
class 냉동실{
	int cnt;
	void setInsert(String object) {
		cnt++;
	}
}
class 제어컨트롤러{

	private int 냉장실온도;
	private int 냉동실온도;

	public int get냉장실온도() {
		return 냉장실온도;
	}
	public void set냉장실온도(int 냉장실온도) {
		this.냉장실온도 = 냉장실온도;
	}
	public int get냉동실온도() {
		return 냉동실온도;
	}
	public void set냉동실온도(int 냉동실온도) {
		this.냉동실온도 = 냉동실온도;
	}

	
}

public class C03FunctionRef {
	public static void main(String[] args) {
		냉장고 ref = new 냉장고();
		ref.display.showInfo(); //현재 냉장실온도/냉동실온도 출력
//		ref.section1.setObject();
	}
}
