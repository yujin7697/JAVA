package Ch03;

public class C05TypeChange {
	public static void main(String[] args) {
		int num1 = 10, num2 = 4;
		double dnum1 = num1 / num2; 			//피연산자 num1은 int형이기 때문에 연산후에 소수점
		
		double dnum2 = (double)num1/num2;		//나누는 수를 double형으로 강제 형변환함으로써 연산 결과
												//소수점을 표현할 공간을 마련 
		double dnum3 = (1.0*num1)/num2;
		System.out.println("dnum1 : "+dnum1);
		System.out.println("dnum1 : "+dnum2);
		System.out.println("dnum1 : "+dnum3);
	}
}
