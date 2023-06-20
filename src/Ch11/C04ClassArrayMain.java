package Ch11;

class C04Person{
	String name;
	int age;
	
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
	
}


public class C04ClassArrayMain {
	public static void main(String[] args) {
		
		C04Person list[] = new C04Person[3];
		for(int i = 0;i<3;i++) {
			list[i]=new C04Person();
		}
		list[0].name = "홍길동";
		list[0].age = 55;
		
		list[1].name = "이정숙";
		list[1].age = 34;
		
		list[2].name = "정우성";
		list[2].age = 25;
	}
}
