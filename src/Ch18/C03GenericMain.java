package Ch18;

class Tiger{
	String name;
	
	public Tiger(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
}
class Panda{
	String name;

	public Panda(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
	
}
public class C03GenericMain {
	
	public static <T> void PrintInfo(T[] array) {
		for (T el : array) {
			System.out.println(el.toString());
		}
	}
	public static void main(String[] args) {
		Tiger[] arr1 = {new Tiger("tiger"),new Tiger("tiger2"), new Tiger("tiger3")};
		PrintInfo(arr1);
		System.out.println();
		Panda[] arr2 = {new Panda("panda"),new Panda("panda2"),new Panda("panda3")};
		PrintInfo(arr2);
	}
}
