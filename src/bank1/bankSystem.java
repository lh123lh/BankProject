package bank1;

class bankSystem {
	String userName;
	String userCount;
	String userPass;

	int userMoney;

	public bankSystem(String name) {
		userName = name;

		System.out.println("欢迎光临," + name);
	}

	// 创建账户
	public boolean createCount(String count, String pass, int money) {
		userCount = count;
		userPass = pass;
		userMoney = money;

		if (userMoney >= 10) {
			userMoney -= 10;

			System.out.println(userName + " 您好,您已开户成功,当前余额为" + userMoney + " RMB");

			return true;
		} else {
			System.out.println("您好,您的余额不足10 RMB,还差:" + (10 - userMoney) + " RMB");

			return false;
		}
	}

	// 存钱
	public boolean saveMoney(String count, String pass, int money) {

		if (count.equals(userCount) && pass.equals(userPass)) {
			userMoney += money;

			System.out.println("您的钱已存入银行账户,当前余额为:" + userMoney + " RMB");

			return true;
		} else {
			System.out.println("您输入的账号密码有误,请重试");

			return false;
		}

	}

	// 取钱
	public int drawMoney(String count, String pass, int money) {
		if (count.equals(userCount) && pass.equals(userPass)) {
			if (money <= userMoney) {
				userMoney -= money;

				System.out.println("您已取出" + money + " RMB,当前余额为:" + userMoney + "RMB");

				return 0;
			} else {
				System.out.println("您当前的余额为" + userMoney + " RMB, 不足" + money + "RMB, 请重新输入取款金额");

				return -1;
			}
		} else {
			System.out.println("您输入的账号密码有误,请重试");

			return -2;
		}
	}
}
