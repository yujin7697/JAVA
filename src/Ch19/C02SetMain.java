package Ch19;

import java.util.HashSet;
import java.util.Set;

// set : 순서 상관없고 중복을 허용하지 않음
public class C02SetMain { 
	public static void main(String[] args) {
		Set<String> set = new HashSet();
		
		set.add("HTML/CSS/JS");
		set.add("React");
		set.add("Redux");  //중복 발생시 나중에 저장된 것은 삭제, 새로 들어온 것을 삽입
		set.add("Typescript");
		set.add("Mysql");
		System.out.println("개수 확인 : " + set.size());
		set.remove("React");
		System.out.println("개수 확인 : " + set.size());
		for(String el : set) {
			System.out.println(el);
		}
		set.clear();
	}
}
