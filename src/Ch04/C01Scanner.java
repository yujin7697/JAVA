package Ch04;

import java.util.Scanner;

public class C01Scanner {
	public static void main(String[] args) {
//		system.out	: 표준 출력 스트림 생성 - 모니터
//		system.in	: 표준 입력 스트림 생성 - 키보드
//		new Scanner(system.in)
//		키보드로부터 전달되는 데이터를 받을 수 있는 Scanner장치 생성
//		Scanner sc = new Scanner(System.in);
//		참조변수 sc 연결
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();
		int sum=num1+num2+num3+num4;
		System.out.printf("%d + %d + %d + %d = %d\n",num1,num2,num3,num4,sum);
		sc.close();
	}
}
