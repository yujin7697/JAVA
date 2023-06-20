package Ch13;

class Point2D{
	int x;
	int y;
	Point2D(){
		System.out.println("Point2D 생성자 호출");
	}
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	
} 

class Point3D{
	int z;
	Point3D(){
		super();
		System.out.println("Point3D 생성자 호출");
	}
	@Override
	public String toString() {
		return "Point3D [z=" + z + "]";
	}
	
}

public class C01InheritanceMain {
	public static void main(String[] args) {
		
	}
}
