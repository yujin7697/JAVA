package Ch08Ex;


class Member {
	String name;
	String id;
	String password;
	int age;
	
	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
}
class MemberService{
	boolean login(String id,String password) {
		if(id == "hong") {
			if(password == "12345")
				return true;
		}
		return false;
	}
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
class Printer{
	Printer(){}
	void println(int x) {
		System.out.println(x);
	}
	void println(boolean x) {
		System.out.println(x);
	}
	void println(double x) {
		System.out.println(x);
	}
	void println(String x) {
		System.out.println(x);
	}
}
public class C05이것이자바다예제 {
	public static void main(String[] args) {
		//문제14번();
		//문제15번();
		문제16번();
	}
	public static void 문제14번() {
		Member user1 = new Member("홍길동","hong");
		Member user2 = new Member("강자바","java");
		System.out.println("user1의 이름 : "+ user1.name
				+ " user1의 아이디 : " + user1.id);
		System.out.println("user2의 이름 : "+ user2.name
				+ " user2의 아이디 : " + user2.id);
	}
	public static void 문제15번() {
		MemberService memberservice = new MemberService();
		boolean result = memberservice.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberservice.logout("hong");
		}
		else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
	public static void 문제16번() {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}
