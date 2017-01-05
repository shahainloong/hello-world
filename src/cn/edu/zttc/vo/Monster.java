package cn.edu.zttc.vo;

public class Monster {
	String type;
	int life;
	boolean isLive;
	int attack;
	int defend;
	
	public Monster(int mt){
		isLive = true;
		
		if (mt==1) {
			type = "普通僵尸";
			life = 40;
			attack = 15;
			defend = 8;
		}else if (mt==2) {
			type = "魔法僵尸";
			life = 35;
			attack = 27;
			defend = 5;
		}else if (mt==3) {
			type = "钢盔僵尸";
			life = 40;
			attack = 10;
			defend = 5;
		}else if (mt==4) {
			type = "大僵尸";
			life = 60;
			attack = 30;
			defend = 10;
		}
	}
	public void injured(Hunter hunter) {
		System.out.println("test"+hunter.name);
		System.out.println(type+"嗷嗷嗷嗷");
		life-=hunter.attack-defend+7;
		int lostLife = hunter.attack-this.defend;
		int lostBasicLife = 7;
		if (lostLife<=0) {
			life = lostBasicLife;
		}else {
			life-=(lostLife+lostBasicLife);
		}
		if (life<=0) {
			dead();
			return;
		}
		System.out.println(type+"嗷嗷");
		kill(hunter);
		System.out.println(hunter.name);
	}
	public void kill(Hunter hunter){
		if (!isLive) {
			return;
		}
		if (!hunter.islive) {
			return;
		}
		System.out.println("呼呼呼");
		hunter.injured();
	}
	
	private void dead() {
		System.out.println("呜呜呜呜");
		isLive = false;
		
	}
	
}
