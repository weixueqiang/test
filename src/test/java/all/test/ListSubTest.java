package all.test;

import java.util.ArrayList;

public class ListSubTest {

	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list.subList(9, 10));
		
		
	}
	
}
