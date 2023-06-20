package Ch16;

class C03Simple{
	int id;
	int n;
	C03Simple(int id ,int n){
		this.n=n;
		this.id=id;
	}
	@Override
	public int hashCode() {
		
		return n;
	}
	
//	toString() 재정의
//	equals() 재정의
//	hashcode() 재정의
	
}
public class C03HashCodeMain {
	public static void main(String[] args) {
		C03Simple ob1 = new C03Simple(19123018,5);
		C03Simple ob2 = new C03Simple(19123018,6);
		
		System.out.println(ob1);
		System.out.println(ob1.toString());
		System.out.printf("%x\n",ob1.hashCode());
		System.out.println(ob1 == ob2);
		
		System.out.println();
		System.out.println(ob1.hashCode()); //재정의된 hashcode
		System.out.println(ob2.hashCode()); //재정의된 hashcode
		System.out.println(System.identityHashCode(ob1)); //실제 객체위치
		System.out.println(System.identityHashCode(ob2)); //실제 객체위치
		
	}
}
