package Ch19Ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ex2 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		Random rnd = new Random();
		while(true) {
			if(set.size()>=6) break;
			System.out.println(rnd.nextInt(45)+1);
			set.add(rnd.nextInt(45)+1);
		}
		for(Integer el:set) System.out.print(el+ " ");
		System.out.println();
		List<Integer> list = new ArrayList(set);
		Collections.sort(list); //오름차순
		for(Integer el : list) System.out.print(el + " ");
		System.out.println();
		Collections.sort(list,Collections.reverseOrder());
		for(Integer el : list) System.out.print(el + " ");
	}
}
