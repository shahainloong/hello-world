package ant.zttc.itat;

public class HelloWorld {
	public static void main(String[] args) {
//		int p = calArea(30, 50);
		System.out.println(getDistance(0, 0, 5, 0));
	}
	
	public static int calArea(int width, int height) {
		return width*height;
	}
	
	public static int calPer(int width, int height) {
		return 2*(height+width);
	}
	
	public static int calFactorial(int n){
		int factorial = 1;
		for (int i = n; i >= 1; i--) {
			factorial*=i;
		}
		return factorial;
	}
	
	public static int calFactorialSum(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+=calFactorial(i);
		}
		return sum;
	}
	
	public static double getDistance(double x1, double y1,double x2,double y2){
		double d = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		
		return Math.sqrt(d);
	}
	
}
