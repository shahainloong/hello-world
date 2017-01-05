package cn.mhope.test;


public class TestObj extends Object {
	public static void main(String[] args) {
		Book[] bs = new Book[5];
		bs[0] = new Book("JAVA");
		bs[1] = new Book("PHP");
		bs[2] = new Book("C");
		Stu stu = new Stu("刘德华", bs);
		stu.read(0);
	}

}

class Stu{
	String name;
	Book[] books;
	
	public Stu(String name, Book[] books) {
		super();
		this.name = name;
		this.books = books;
	}
	public void read(int num){
		System.out.println(this.name+"正在读"+books[num]);
	}
}

class Book{
	String name;

	public Book(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}