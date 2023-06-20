package Ch07;

import java.util.Scanner;

public class C00While {
	public static void main(String[] args) {

//		01 반복문 

//		1 탈출용 변수
//		2 탈출 조건식
//		3 탈출을 위한 연산
//		int i=1;		// 1 탈출용 변수
//		while(i<=10) {	// 2 탈출 조건식
//			System.out.println("찌오찌오찌오");
//			i++;		// 3 탈출을 위한 연산
//		}
//		System.out.println("i : " + i);

//		02 1-10까지의 합
//		int i=1;	
//		int sum=0;
//		while(i<=10) {	
//			System.out.println("i : " + i);
//			sum+=i;
//			i++;	
//		}
//		System.out.println(sum);

//		03 1-n까지의 합
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		int sum = 0;
//		int i=1;
//		while(i<=num) {
//			System.out.println(i);
//			sum+=i;
//			i++;
//		}
//		System.out.println(sum);

//		문제
//		n-m까지의 합
		Scanner sc = new Scanner(System.in);
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();

//		if(n>m){
//			int tmp=num1;
//			num1=num2;
//			num2=tmp;
//		}
//		int sum=0;
//		while(num1<=num2) {
//			sum+=num1;
//			num1++;
//		}
//		System.out.println(sum);

//		1-n 까지의 수중에 짝수/홀수의 합을 각각 출력
//		int num = sc.nextInt();
//		int odd_sum=0,even_sum=0;
//		int i=0;
//		while(i<=num) {
//			if(i%2==0) {
//				even_sum+=i;
//			}
//			else if(i%2==1) {
//				odd_sum+=i;
//			}
//			i++;
//			System.out.println(i);
//		}
//		System.out.println("짝수의 합 : "+even_sum);
//		System.out.println("홀수의 합 : "+odd_sum);

//		1-n 까지의 수중에 3의 배수만 출력하고 그 합도 출력
//		int num = sc.nextInt();
//		int i=0;
//		int sum=0;
//		while(i<=num) {
//			if(i%3==0) {
//				sum+=i;
//			}
//			i++;
//		}
//		System.out.println(sum);

//		1-n 까지의 수중에 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합 출력
//		int num=sc.nextInt();
//		int i=1;
//		int sum=0;
//		while(i<=num) {
//			if(i%4==0) {
//				System.out.println(i);
//			}
//			else {
//				sum+=i;
//			}
//			i++;
//		}
//		System.out.println(sum);

//		구구단 2단 출력
//		int dan=2;
//		int i=1;
//		int result=0;
//		while(i<10) {
//			result=dan*i;
//			System.out.println("2 X " + i +" = " + result);
//			i++;
//		}

//		구구단 n 단출력
//		int dan = sc.nextInt();
//		int i=1;
//		int result=0;
//		while(i<10) {
//			result=dan*i;
//			System.out.println(dan + " X " + i + " = " + result);
//			i++;
//		}

//		구구단 역출력
//		int dan = sc.nextInt();
//		int i=9;
//		int result=0;
//		while(i>0) {
//			result=dan*i;
//			System.out.println(dan + " X " + i + " = " + result);
//			i--;
//		}

//		------------------------------------------------------------------------------------------
//		중첩 while
//		전체 구구단 출력
//		2-9단 출력
//		int dan=2;
//		int i=1;
//		int result=0;
//		
//		while(dan<10) {
//			i=1;
//			while(i<10) {
//				result=dan*i;
//				System.out.println(dan + " X " + i + " = " + result);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}

//		별찍기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("----------------------------------------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 4 - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("----------------------------------------------");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < 5; i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<=8-i*2;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------");
		int h = sc.nextInt();
		for(int i = 0; i<h;i++) {
			for(int j=0;j<=(h-1)-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}
}
