package games.baseball;

import java.util.regex.Pattern;

import games.Games;

public final class Baseball extends Games {
	private int[] randomNumbers;
	private int ballCount;
	private int strikeCount;
	
	@Override
	public void init() {
		this.randomNumbers = new int[3];
		int index = 0;
		int range = 3;
		int randomNumber = -1;
		while(index < range) {
			randomNumber = (int) (Math.random() * 9 + 1);
			if (duplicateRandomNumber(randomNumber, index)) {
				continue;
			}
			randomNumbers[index++] = randomNumber;
		}
	}

	@Override
	public String getResult() {
		if (!super.errorFlag) {
			switch(this.ballCount) {
			case 0:
				super.msg = String.format("****%d 번째 맞췄습니다.****", super.executeCount);
				super.endFlag = true;
				break;
			case 3:
			case 2:
			case 1:
				super.msg = String.format("%dBall, %dStrike", this.ballCount, this.strikeCount);
				break;
			}
		}
		reset();
		return super.msg;
	}

	@Override
	public Games execute(final Object input) {
		executeCount++;
		super.msg = "중복되지 않게 1~9까지 3자리를 입력해주세요.";
		super.errorFlag = true;
		
		String str = String.valueOf(input);
		String[] strArr = str.split("");
		if (Pattern.matches("[1-9]{3}", str) && duplicate(strArr)) {
			super.errorFlag = false;
			int index = 0;
			int range = 3;
			int temp = -1;
			do {
				temp = Integer.parseInt(strArr[index]);
				if (randomNumbers[index] == temp) {
					strikeCount++;
					continue;
				}
				ballCount++;
			} while(++index < range);
		}
		return this;
	}

	@Override
	protected void reset() {
		this.ballCount = 0;
		this.strikeCount = 0;
	}
	
	private boolean duplicateRandomNumber(int randomNumber, int range) {
		int index = 0;
		do {
			if (this.randomNumbers[index] == randomNumber) {
				return true;
			}
		} while(++index < range);
		return false;
	}
	
	private boolean duplicate(String[] strArr) { // O(n2)인데?;;
		String temp = null;
		int index = 0;
		int index2 = 0;
		int range = strArr.length;
		while (index < range) {
			temp = strArr[index];
			while(true) { 
				if (index != index2 && temp.equals(strArr[index2])) {
					return false;
				}
				index2++;
				if (index2 == range) {
					index2 = 0;
					break;
				}
			}
			index++;
		}
		return true;
	}
}
