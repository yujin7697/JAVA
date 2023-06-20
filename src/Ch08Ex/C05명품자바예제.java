package Ch08Ex;

import java.util.Scanner;

class TV{
	String tvName;
	int tvYear;
	int tvInch;
	TV(String tvName, int tvYear, int tvInch){
		this.tvName = tvName;
		this.tvYear = tvYear;
		this.tvInch = tvInch;
	}
	void show() {
		System.out.println(tvName + "에서 만든 " + tvYear + 
				"년형 " + tvInch + "인치 TV");
	}
}
class Grade{
	int math;
	int science;
	int english;
	Grade(int math,int science,int english){
		this.math = math;
		this.science = science;
		this.english = english;
	}
	double average() {
		return (math+science+english)/3;
	}
}
class Song{
	String title;
	String artist;
	int year;
	String country;
	Song(){
		
	}
	Song(String title,String artist,int year,String country){
		
	}
}
public class C05명품자바예제 {
	public static void main(String[] args) {
		//문제4장_1번();
		//문제4장_2번();
		문제4장_3번();
	}
	public static void 문제4장_1번() {
		TV myTV = new TV("LG",2017,32);
		myTV.show();
	}
	public static void 문제4장_2번() {
		Scanner sc = new Scanner(System.in);
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		Grade me = new Grade(math,science,english);
		System.out.println("평균은" + me.average());
	}
	public static void 문제4장_3번() {
		
	}
}
