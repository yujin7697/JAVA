package Ch03;

public class C04TypeChange {
	public static void main(String[] args) {
		
//		정수 연산식(int 보다 작은 변수자료형(short, char, byte))
//		int로 자동 형변환
//		byte x = 10;
//		byte y = 20;
//		byte result1 = (byte)(x+y);		//컴파일 에러 x,y는 각각 int형 자료로 담아서 처리가 
//										// 왼쪽 byte형으로 저장시 작은 공간에 큰 자료형 타입 넣으려
//		
////		int result1 = x+y;
//		System.out.println(result1);
		
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;
		int result = (int)var1 + (int)var2 + (int)var3;
		
		long result2 = var1 + var2 + var3;
		System.out.println(result2);
		
		int intvar = 10;
		float flvar = 3.3f;
		double dbvar = 5.5;
		double result3 = intvar + flvar + dbvar;
		
		System.out.println(result3);
	}
}
