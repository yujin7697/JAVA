package Ch18;

class Person{
	String name;
	String age;
	char gender;
	public Person(String name, String age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
}
class Man extends Person{
	public Man(String name, String age, char gender) {
		super(name, age, gender);
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
class Woman extends Person{
	public Woman(String name, String age, char gender) {
		super(name, age, gender);
	}
	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}
class Couple<X,Y>{
	private X member1;
	private Y member2;
	Couple(X member1, Y member2){
		this.member1 = member1;
		this.member2 = member2;
	}
	void ShowInfo() {
		System.out.println("M1 : " + member1 );
		System.out.println("M2 : " + member2 );
	}
}
public class C02GenericMain {
	public static void main(String[] args) {
		Couple<Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수","20",'M'), new Woman("영희","24",'W'));
		couple1.ShowInfo();
	}
}
