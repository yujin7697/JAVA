package Ch11;

import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr1 = new int[4]; //idx 0,1,2,3
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		arr1[3] = 40;
		System.out.println("길이 : " + arr1.length); //길이 확인 .length
		for(int i = 0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		for(int el:arr1) {
			System.out.println(el);
		}
		System.out.println();
		
//		stream 매서드를 이용한 방식(매개변수 el, {} 논리 로직)
		Arrays.stream(arr1).forEach(el->{
			System.out.println(el);
		});
		System.out.println();
		double arr2[]; //배열형 참조 변수
		arr2=new double[5]; //배열형 참조변수에 배열 객체 연결
		
//		5개의 정수값을 입력받아 int형 배열에 저장하고
//		최대값,최소값,전체합 출력
		int arr[] = new int[5];
		int sum = 0;
		int max=arr[0];
		int min=arr[0];
		for(int el:arr) {
			arr[el] = sc.nextInt();
			sum+=arr[el];
		}
		for(int el:arr) {
			if(max<el) {
				max=el;
			}
			if(min>el){
				min=el;
			}
		}
		System.out.printf("%d %d\n",min,max);
		System.out.println(sum);
		System.out.println(Arrays.stream(arr).max().getAsInt());
		System.out.println(Arrays.stream(arr).min().getAsInt());
	}
}
