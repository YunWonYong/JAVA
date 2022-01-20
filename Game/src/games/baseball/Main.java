package games.baseball;

import java.util.Scanner;

import games.Games;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Games baseball = new Baseball();
		baseball.init();
		System.out.println("�ߺ����� �ʰ� 1~9������ ���ڸ� �����Ͽ� ���ڸ� �Է� �ϼ���.");
		String input = null;
		String msg = null;
		while (true) {
			System.out.print("�Է�: ");
			input = sc.nextLine();
			msg = baseball.execute(input).getResult();
			if (baseball.getErrorFlag()) {
				System.err.println(msg);
				continue;
			}
			System.out.println(msg);
			if (baseball.getEndFlag()) {
				sc.close();	
				break;
			}
		}
	}
}
