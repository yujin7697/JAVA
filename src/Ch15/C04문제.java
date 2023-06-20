package Ch15;

class ex_TV{
	int size;
	String manufacturer;
	public ex_TV() {
		size = 32;
		manufacturer = "LG";
		System.out.println(size + "인치 " + manufacturer);
	}
	public ex_TV(String manufacturer) {
		this.size = 32;
		this.manufacturer = manufacturer;
		System.out.println(size + "인치 " + manufacturer);
	}
	public ex_TV(int size, String manufacturer) {
		this.size = size;
		this.manufacturer = manufacturer;
		System.out.println(size + "인치 " + manufacturer);
	}
}


public class C04문제 {
	//명품자바 4장 클래스 기본
	//https://security-nanglam.tistory.com/212
	
	//명품자바 5장 상속
	//https://security-nanglam.tistory.com/215
	
	public static void main(String[] args) {
		
	}
}
