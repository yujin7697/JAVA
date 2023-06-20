package Ch13Ex;

class Employee {
	String name; String age; String addr; 
	Employee(String name, String age, String addr){
		super();
		this.name = name;
		this.age = age;
	}
}

class Parttimer extends Employee{
	Parttimer(){
		
	}
}
class Regular extends Employee{
	Regular(){
		
	}
}

public class C02UpDownCasting문제 {
	public static void ShowInfo(Employee emp) {
//		각 하위 클래스에 맞게 DownCasting 하기
		if(emp instanceof Regular) {
			Regular down = (Regular)emp;
		}else if(emp instanceof Parttimer) {
			Parttimer down = (Parttimer)emp;
		}
		
	}
	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동","25","대구",20000);
		Regular emp2 = new Regular("서길동","45","울산",50000000);
		ShowInfo(emp1);
		System.out.println("---------------------------------");
		ShowInfo(emp2);
	}
}
