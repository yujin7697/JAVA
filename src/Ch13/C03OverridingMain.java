package Ch13;

//	매서드 오버라이딩(함수 재정의)
//	상송관계에서 상위클래스의 매서드를 하위클래스가 재정의(고쳐서 사용)하는 것을 허용하는 문법
//	매서드의 해더부분은 동일하게 두고 바디({})의 로직을 다르게 함으로써 같은 상위 클래스로부터
//	물려받은 매서드의 로직을 다양하게 둘 수 있다. (다형성)

class Animal{
	public void Sound() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog extends Animal{

	@Override
	public void Sound() {
		super.Sound();
	}
	
	
}

class Cat extends Animal{
	public void Sound() {
		System.out.println("야옹");
	}
}

public class C03OverridingMain {
	
	public static void main(String[] args) {
		Dog poppi = new Dog();
		Cat yummi = new Cat();
		
		poppi.Sound();
		yummi.Sound();
		
	}
	
}
