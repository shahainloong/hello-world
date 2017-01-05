package cn.edu.zttc.vo;

public class Game {
	Hunter hunter;
	Monster m1,m2,m3,m4,m5;
	
	public Game(){
		hunter = new Hunter("S", "大睫毛刷");
		m1 = new Monster(1);
		m2 = new Monster(2);
		m3 = new Monster(3);
	}
	public void start(){
//		1、一直进行判断，
		while (true) {
//			判断是否结束，如果hunter dead执行end，break；
//			3、判断monster是否全部死亡，如果死亡，调用end，break；
//			生成一个随机数，1表示战斗1
			if (hunter.islive) {
//				end();
				break;
			}
			if (!m1.isLive&&!m2.isLive&&!m3.isLive) {
				break;
			}
			int ran = randomRange(1, 4);
			if (ran==1) {
				hunter.fight(m1);
			}else if (ran==2) {
				hunter.fight(m2);
			}else if (ran==3) {
				hunter.fight(m3);
				
			}
			try {
				System.out.println("对手寻找中");
				Thread.sleep(3000);
			} catch (Exception e) {
			}
		}
		end();
		
	}
	/**
	 * 判断hunter没有死，输入恭喜，过关了，否则输出
	 * 大侠不要气馁，要不要重新来过
	 */
	public void end(){
//		判断hunter是否死亡，死亡输出，恭喜大侠
	}
	
	public static int randomRange(int start, int end){
		return (int)(Math.random()*(end-start)+start);
	}
	
}
