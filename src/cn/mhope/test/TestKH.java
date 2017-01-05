package cn.mhope.test;

public class TestKH {

	public static void main(String[] args) {
		Studen stu1 = new Studen();
		stu1.name = "a";
		//以下调用方式不对，虽然不会报错
		//stu1.claId = 1;//应该使用以下方法调用
		Studen.claId = 1;//static说修饰的变量用类名调用
		Studen stu2 = new Studen();
		stu2.name = "b";
		//stu2.claId = 2;
		Studen.claId = 2;

		stu1.show();
		stu2.show();
	}
}

class Studen
{
	String name;
	//使用static修饰的关键字是属于整个类的
	//所以为static所修饰的属性赋值或者调用方法建议使用类名调用
	static int claId;
	static int speId;

	public void show() {
		System.out.println(name+","+claId);
	}
}