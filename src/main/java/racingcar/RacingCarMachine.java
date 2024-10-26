package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarMachine {

	public void run() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		List<String> carList = Arrays.asList(Console.readLine().split(","));

		System.out.println("시도할 횟수는 몇 회인가요?");


	}
}
