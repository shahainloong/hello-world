package cn.mhope.test;

import cn.edu.zttc.vo.Hunter;
import cn.edu.zttc.vo.Monster;

public class TestGame {
	public static void main(String[] args) {
		new MiddleSchool();
	}
}

class Animal{
	String name;
	public void breath(){
		System.out.println(name+" is breaking");
	}
}
class Dog extends Animal{
	String furColor;
}
class Persons{
	String name;
	int age;
	public void study(){
		System.out.println(name+"正在学习");
	}
}
class Teacher extends Persons{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println(name+"正在认真地学习");
	}
	
}
class Star extends Persons{
	
}
class School{
//	public School(){
//		System.out.println("school");
//	}
	public School(String str){
		System.out.println(str);
	}
}
class MiddleSchool extends School{
	Stude stude =  new Stude();
	public MiddleSchool(){
		super("abc");
		System.out.println("middle");
	}
}
class Stude{
	public Stude(){
		System.out.println("student");
	}
}