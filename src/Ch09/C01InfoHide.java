package Ch09;

//	접근한정자
//	public		: 모든 클래스에서 접근 가능
//	default		: 동일 패키지에 속한 클래스에서만 접근 가능
//	protected	: 동일 패키지 or 상속관계의 하위클래스에서만 접근 가능
//	private		: 현재 클래스에서만 접근 가능

class C01Person{
//	속성
	String name;			//이름
	private String id;		//주민등록번호
	private int age;				//나이
	private float weight;			//몸무게
	private double height;			//신장
	private int salary;		//연봉
	
//	생성자
	public C01Person(String name, String id, int age, float weight, double height, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
//	기능
//	Getter and Setter 
//	salary getter and setter
//	void setSalary(int salary) {
//		this.salary=salary; //setter를 통해 만들어진 함수로 private int salary의 값을 변경 가능
//	}
//	int getSalary() {
//		return salary;
//	}
////	id getter and setter
//	void setId(String id) {
//		this.id=id;
//	}
//	String getId() {
//		
//		return id;
//	}
////	age getter and setter
//	int getAge() {
//		return age;
//	}
//	void setAge(int age) {
//		this.age=age;
//	}
////	weight getter and setter
//	float getWeight() {
//		return weight;
//	}
//	void setWeight(float weight) {
//		this.weight=weight;
//	}
////	height getter and setter
//	double getHeight() {
//		return height;
//	}
//	void setHeight(double height) {
//		this.height=height;
//	}
	
}

public class C01InfoHide {
	public static void main(String[] args) {
		C01Person hong = new C01Person("홍길동","1111-1111",44,77.5f,177.7,8000);
		hong.name = "장유진";
		hong.setSalary(9000);
		hong.setAge(20);
		hong.setHeight(160);
		hong.setWeight(50);
		System.out.println(hong.getId());
		System.out.println(hong.getAge());
		System.out.println(hong.getHeight());
	}
}






