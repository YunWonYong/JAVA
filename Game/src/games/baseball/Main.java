package games.baseball;

import java.util.Scanner;

import games.Games;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Games baseball = new Baseball();
		baseball.init();
		System.out.println("중복되지 않게 1~9까지의 숫자를 조합하여 세자리 입력 하세요.");
		String input = null;
		String msg = null;
		while (true) {
			System.out.print("입력: ");
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
