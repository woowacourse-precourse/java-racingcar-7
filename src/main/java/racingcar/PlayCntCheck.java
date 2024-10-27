package racingcar;

public class PlayCntCheck {

	int playCnt = 0;

	public void playCntInt(String playCnt) {
		try {
			this.playCnt = Integer.parseInt(playCnt);
			playCntCheck();
		} catch (NumberFormatException ne) {
			System.err.println("숫자를 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}

	private void playCntCheck() {
		if (playCnt <= 0) {
			System.err.println("0보다 큰 양수만 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}

	public int getPlayCnt() {
		return playCnt;
	}

}
