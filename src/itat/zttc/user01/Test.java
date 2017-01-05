package itat.zttc.user01;

import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		UserManager um = new UserManager(10);
		um.add(new User("ldh", "123", "刘德华", 43));
		um.add(new User("zxy", "123", "张学友", 43));
		um.add(new User("s", "123", "小s", 43));
		um.add(new User("S", "123", "大s", 43));
		
		User u = um.load("ldh");
		System.out.println(u);
		
		um.login("ldh", "1234");
		String str = "mian.html";
		String str1 = "hello world";
		for (int i = 0; i < 10; i++) {
			str1+=i;
		}
		System.out.println(str1);
		StringBuilder sb = new StringBuilder("abc");
		for (int i = 0; i < 10; i++) {
			sb.append(i);
		}
		System.out.println(sb.charAt(0));
		System.out.println(str1.startsWith("hello"));
		System.out.println(str.substring(str.indexOf(".")+1));
	}
}
