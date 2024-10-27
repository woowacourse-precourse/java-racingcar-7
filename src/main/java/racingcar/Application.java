package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		String[] carName = extractCarNames(inputCarNames());
		String[] count = new String[carName.length];
		Arrays.fill(count, "");
		int round = inputRoundCount();
		System.out.println("실행결과");
		for (int i = 0; i < round; i++) {
			getAdvanceRandomNumber(count);
			displayRoundResults(carName, count);
		}
		String finalWinner = findFinalWinners(getMaxAdvanceCount(count), count, carName);
		System.out.println(finalWinner);

	}

	public static String inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		return carName;
	}

	public static String[] extractCarNames(String carName) {
		String[] names = carName.split(",");
		for (String name : names) {
			validateCarName(name);
		}
		return names;

	}












}
