package Ch08;

import java.util.Scanner;

class C03Person {
//	속성(멤버변수)
	String name;
	int age;
	float height;
	double weight;
//	기능(멤버함수,멤버매서드)
//	반환자료형(없으면 void) 함수명(파라미터)
//	{
//		수행 로직
//	}
	void talk() {
		System.out.println(name +" 말하는 중");
	}
	void walk() {
		System.out.println(name + " 걷는 중");
	}
	void showInfo() {
		System.out.printf("%s %d %f %f\n",name,age,height,weight);
	}
}

public class C03PersonMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C03Person hong = new C03Person();
		hong.name = sc.next();
		hong.age = sc.nextInt();
		hong.height = sc.nextFloat();
		hong.weight = sc.nextDouble();
		System.out.printf("%s %d %f %f\n",hong.name,hong.age,hong.height,hong.weight);
		hong.talk();
		hong.walk();
		hong.showInfo();
	
	}
}
