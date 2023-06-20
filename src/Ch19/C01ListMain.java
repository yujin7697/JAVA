package Ch19;

import java.util.ArrayList;
import java.util.List;

// CRUD (Create, Read, Update, Delete)
// 삽입
// 조회
// 수정
// 삭제

public class C01ListMain {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("HTML/CSS/JS");
		list1.add("React");
		list1.add("Redux");
		list1.add("Typescript");
		list1.add("Mysql");
		list1.add("JAVA");
		
//		조회
		System.out.println("개수 확인 : " + list1.size());
		System.out.println("1 idx : " + list1.get(1));
		System.out.println("JAVA가 지정된 idx : " + list1.indexOf("JAVA"));
//		삭제
		list1.remove(0);  //HTML/CSS/JS 삭제
		list1.remove("Mysql");
		System.out.println("--------------------------------");
		for(String el : list1) {
			System.out.println(el);
		}
//		전체삭제
		list1.clear();
		
	}
}
