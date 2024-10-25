package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String readCarNames () {
		System.out.println("경주할 차의 이름을 쉼표로 구분해서 입력하시오 ");
		return Console.readLine();
	}
	
	public static String readTrialNum () {
		System.out.println("시도할 횟수를 입력하시오 ");
		return Console.readLine();
	}

}
