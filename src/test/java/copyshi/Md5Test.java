package copyshi;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Test {

	public static void main(String[] args) {
		String source="123456";
		String salt="salt";
		Md5Hash h = new Md5Hash(source, salt, 1);
		System.out.println(h.toString());//f51703256a38e6bab3d9410a070c32ea
	}
	
}
