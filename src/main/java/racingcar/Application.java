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

	public static int inputRoundCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String roundCount = Console.readLine();
		return Integer.parseInt(roundCount);
	}

	public static void getAdvanceRandomNumber(String[] count) {
		for (int i = 0; i < count.length; i++) {
			int randomValue = Randoms.pickNumberInRange(0, 9);
			checkAndMoveCar(randomValue, count, i);
		}
	}

	public static void checkAndMoveCar(int randomValue, String[] count, int i) {
		if (randomValue > 3) {
			count[i] += "-";
		}

	}

	public static void displayRoundResults(String[] carName, String[] count) {
		for (int i = 0; i < carName.length; i++) {
			System.out.println(carName[i] + " : " + count[i]);
		}
		System.out.println();
	}

	public static int getMaxAdvanceCount(String[] count) {
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i].length())
				max = count[i].length();
		}
		return max;

	}

	private static String findFinalWinners(int max, String[] count, String[] carName) {
		String finalWinner = "최종 우승자 : ";
		for (int i = 0; i < count.length; i++) {
			if (max == count[i].length())
				finalWinner += carName[i] + ", ";

		}
		if (finalWinner.endsWith(", ")) {
			finalWinner = finalWinner.substring(0, finalWinner.length() - 2);
		}
		return finalWinner;

	}

	public static void validateCarName(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름을 5자이하로 입력해주세요 : " + carName);
		}
	}

}
