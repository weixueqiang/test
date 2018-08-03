package copyshi;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Test {

	public static void main(String[] args) {
		String source="12345678";
		String salt="8af39e2253654814a1eceac33fd7ed0d";
		Md5Hash h = new Md5Hash(source, salt, 1);
		System.out.println(h.toString());
		//207acd61a3c1bd506d7e9a4535359f8a
		//f51703256a38e6bab3d9410a070c32ea
	}
	
}
