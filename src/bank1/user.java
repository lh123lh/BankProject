package bank1;

import java.util.Scanner;

class user {
	String userName = "Liu";
	String userCount = "12345";
	String userPass = "1234";

	int userMoney = 100;

	bankSystem bs = new bankSystem(userName);

	Scanner input = new Scanner(System.in);

	// 开户
	public void create() throws AllException, StopException {

		int errCnt = 0;

		boolean flag = bs.createCount(userCount, userPass, userMoney);

		try {

			if (flag == true) {

			} else {
				errCnt++;

				if (errCnt >= 3) {
					throw new StopException("账号或密码错误次数超过三次");
				}

				throw new AllException("账号或密码错误，剩余输入次数:" + errCnt + "次,请重新输入");
			}

		} catch (AllException e) {
			// TODO: handle exception

			System.out.println(e.getMessage());

			flag = bs.createCount(userCount, userPass, userMoney);

		} catch (StopException e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	// 存钱
	public void save() throws AllException, StopException {

		int errCnt = 0;

		System.out.println("本次服务需要验证您的身份");

		System.out.println("请输入您的账号:");
		String count = input.next();

		System.out.println("请输入您的密码:");
		String pass = input.next();

		System.out.println("请输入您要存入的金额:");
		int money = input.nextInt();

		boolean flag = bs.saveMoney(count, pass, money);

		while (true) {

			try {
				if (flag == true) {

					break;

				} else {

					errCnt++;

					if (errCnt > 3) {
						throw new StopException("输入失败的次数超过3次,账号已锁定");
					}

					throw new AllException("账号或密码错误，剩余输入次数:" + errCnt + "次,请重新输入");
				}
			} catch (AllException e) {
				// TODO: handle exception

				System.out.println(e.getMessage());

				System.out.println("请输入您的账号:");
				count = input.next();

				System.out.println("请输入您的密码:");
				pass = input.next();

				System.out.println("请输入您要存入的金额:");
				money = input.nextInt();

				flag = bs.saveMoney(count, pass, money);
			} catch (StopException e) {

				System.out.println(e.getMessage());

				break;
			}
		}
	}

	// 取钱
	public void draw() throws AllException, StopException {

		int errCnt = 0;

		System.out.println("本次服务需要验证您的身份");

		System.out.println("请输入您的账号:");
		String count = input.next();

		System.out.println("请输入您的密码:");
		String pass = input.next();

		System.out.println("请输入您要取出的金额:");
		int money = input.nextInt();

		boolean flag = bs.drawMoney(count, pass, money);

		while (true) {

			try {

				if (flag == true) {
					break;
				} else {

					errCnt++;

					if (errCnt >= 3) {
						throw new StopException("输入失败的次数超过3次,账号已锁定");
					}

					throw new AllException("账号或密码错误，剩余输入次数:" + errCnt + "次,请重新输入");
				}

			} catch (AllException e) {
				// TODO: handle exception

				System.out.println(e.getMessage());

				System.out.println("请输入您的账号:");
				count = input.next();

				System.out.println("请输入您的密码:");
				pass = input.next();

				System.out.println("请输入您要取出的金额:");
				money = input.nextInt();

				flag = bs.drawMoney(count, pass, money);

			} catch (StopException e) {
				// TODO: handle exception

				System.out.println(e.getMessage());

				break;
			}

		}
	}
}
