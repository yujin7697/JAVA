package Ch16;

class A{
	int x;
	int y;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x = " + x + " y = " + y;
	}
	
}

public class C01APIMain {
	public static void main(String[] args) {
		
		Object obj = new Object();
		System.out.println(obj);
		System.out.println(obj.toString());
		A obj2 = new A();
		System.out.println(obj2);
		System.out.println(obj2.toString());
		
	}
}
