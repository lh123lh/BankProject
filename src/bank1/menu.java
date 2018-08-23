package bank1;

import java.util.Scanner;

class menu {

	public static void main(String[] args) throws AllException, StopException {

		Scanner input = new Scanner(System.in);

		user us = new user();

		int userFlag = 0; // 账号状态

		while (true) {
			System.out.println("**************************");
			System.out.println("\t银行管理系统");
			System.out.println("\t********");
			System.out.println("    1.开户\t2.存钱");
			System.out.println("    3.取钱\t4.退出");

			System.out.print("\n请输入选项:");

			String userChoose;

			try {
				userChoose = input.next();

				if (userChoose.equals("1")) {
					us.create();

					userFlag = 1;
				} else if (userChoose.equals("2")) {
					if (userFlag == 1)
						us.save();
					else {
						throw new AllException("账号不存在,请开户");
					}
				} else if (userChoose.equals("3")) {

					if (userFlag == 1)
						us.draw();
					else {
						throw new AllException("账号不存在,请开户");
					}
				} else if (userChoose.equals("4")) {

					System.out.println("欢迎下次光临,再见");

					break;
				} else {

					throw new StopException("您输入的序号不存在,请重新输入");
				}

			} catch (AllException e) {
				// TODO: handle exception

				System.out.println(e.getMessage());
			} catch (StopException e) {
				// TODO: handle exception

				System.out.println(e.getMessage());

				input.close();
			}

		}

	}
}
