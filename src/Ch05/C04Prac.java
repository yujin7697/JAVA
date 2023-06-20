package Ch05;

import java.util.Scanner;

public class C04Prac {
	public static void main(String[] args) {
//		국영수 점수 받아서
//		국어 40점,영어40점,수학 40점 이면서 평균이 60점 이상이면 합격
//		아니면 불합격
//		삼항연산자
		
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		int mat = sc.nextInt();
		int eng = sc.nextInt();
		double avg = (double)(kor+eng+mat)/3;
		
		String result = (kor>=40&&mat>=40&&eng>=40)&&avg>=60?"합격":"불합격";
		System.out.println(result);
	}
}
