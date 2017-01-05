package cn.mhope.test;

public class TestStudent {
	public static void main(String[] args) {
		Noddle noddle = new Noddle("大碗", false);
		noddle.make();
		Noddle noddle2 = new Noddle();
		noddle2.make();
	}
}

class Noddle{
	String bowlType;
	boolean moreMeat;
	public Noddle(){
		bowlType = "小小碗";
		moreMeat = false;
	}
	public Noddle(String bowlType, boolean moreMeat){
		this.bowlType = bowlType;
		this.moreMeat = moreMeat;
		
	}
	public void make(){
		String s = "不加肉";
		if (moreMeat) {
			s = "加肉";
		}
		System.out.println("一碗热腾腾的"+bowlType+s+"羊肉米线好了");
	}
}

class Student{
	String name;
	int age;
	String furColor;
	
	public void study(){
		if (age<=1) {
			System.out.println("毛发为"+furColor+"的"+name+"正在叫");
		}else if (age<=10) {
			System.out.println("毛发为"+furColor+"的"+name+"正在叫");
		}else {
			System.out.println("毛发为"+furColor+"的"+name+"正在叫");
		}
	}
	
}

class Rectangle{
	int width;
	int height;
	
	public int calArea(){
		return width*height;
	}
}

class Point{
	
	int x;
	int y;
	
	public double getDistance(Point p){
		double r = Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
		return r;
	}
}

class Hunter{
	String name;
	int life;
	String weapon;
	boolean isLive;
	
	public void fight(Monster monster){
		System.out.println(name+"挥舞着"+weapon+"无情地打向"+monster.type+"类型的怪物");
		monster.injured();
		show();
	}
	public void show(){
		System.out.println(life);
	}
	public void injured(){
		life-=20;
		System.out.println("---->"+name+"：小样，敢打我<-----");
	}
}

class Monster{
	String type;
	boolean isLive;
	int life;
	 
	public void injured(){
		life-=20;
		if (life<=0) {
			dead();
			return;
		}
		System.out.println(type+"呜呜呜");
		show();
	}
	
	public void show(){
		System.out.println(life);
	}
	
	public void kill(Hunter hunter){
		if (!isLive) {
			return;
		}
		System.out.println(type+"呜呜呜扑向"+hunter.name);
		hunter.injured();
	}
	
	public void dead(){
		System.out.println("挂了挂了");
		isLive = false;
	}
}