package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 자동차 이름은 공백 불가, 5자 이하)");
			String carName = Console.readLine();
			CarArrayCheck carCheck = new CarArrayCheck();
			carCheck.carNameCheck(carName);

			System.out.println("시도할 횟수는 몇 회인가요?");
			String playCnt = Console.readLine();
			PlayCntCheck playCntCheck = new PlayCntCheck();
			playCntCheck.playCntInt(playCnt);

			Racing racing = new Racing();
			racing.playRacing(carCheck.getCarMap(), playCntCheck.getPlayCnt());
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
