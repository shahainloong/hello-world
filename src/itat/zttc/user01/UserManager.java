package itat.zttc.user01;



public class UserManager {
	User[] users;
	private int nums;
	public UserManager(int size){
		nums = 0;
		users = new User[size];
	}
	public void add(User user){
		if (nums>=users.length) {
			System.out.println("不能添加了");
			return;
		}
		/*for (int i = 0; i < nums; i++) {
			if (user.getUsername().equals(users[i].getUsername())) {
				System.out.println("用户存在");
				return;
			}
		}*/
		User u = this.load(user.getUsername());
		if (u!=null) {
			System.out.println("用户存在");
			return;
		}
		users[nums] = user;
		nums++;
	}
	public void update(User user){
		User u = load(user.getUsername());
		if (u==null) {
			System.out.println("用户不存在");
			return;
		}
		u.setNickname(user.getNickname());
		u.setPassword(user.getPassword());
		u.setAge(user.getAge());
	}
	public void delete(String username){}
	public User load(String username){
		for (int i = 0; i < nums; i++) {
			User user = users[i];
			if (username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}
	public void login(String username, String password){
		User u = this.load(username);
		if (u==null) {
			System.out.println("用户不存在");
			return;
		}
		if (!u.getPassword().equals(password)) {
			System.out.println("密码错误");
			return;
		}
		System.out.println("登录成功");
	}
	public User[] list(){
		User[] tus = new User[nums];
		for (int i = 0; i < nums; i++) {
			tus[i] = users[i];
		}
		return tus;
	}
}

