package cn.edu.zttc.vo;

public class Hunter {
	String name;
	int life;
	boolean islive;
	String weapon;
	int attack;
	int defend;
	
	public Hunter(String name, String weapon){
		this.name = name;
		this.weapon = weapon;
		life = 100;
		islive = true;
		attack = 25;
		defend = 8;
		
	}
	public void fight(Monster monster) {
		if (!islive) {
			return;
		}
		if (!monster.isLive) {
			return;
		}
		System.out.println(name+"挥舞着"+weapon+"杀向"+monster.type);
		monster.injured(this);
	}
	public void injured() {
		life-=20;
		System.out.println(name+"：小样，敢打我");
		if (life<=0) {
			dead();
			return;
		}
	}
	private void dead() {
		System.out.println("天妒英才");
		islive = false;
	}
}
