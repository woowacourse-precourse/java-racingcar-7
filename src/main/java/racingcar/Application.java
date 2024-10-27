package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력해주세요");
		System.out.println("이름은 5글자 이하 쉼표(,) 기준으로 구분");
		String input = Console.readLine();
		String[] arr = splitInput(input);
		n_lenCheck(arr);
		move(arr);
	}

	public static String[] splitInput(String input) {
		if (input.contains(",")) {
			return input.split(",");
		}
		return new String[] { input };
	}

	public static void n_lenCheck(String[] arr) {
		for (String name : arr) {
			checkNameLength(name);
		}
	}

	public static void checkNameLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요"); // 예외 발생
		}
	}

	public static int getMoveCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String number = Console.readLine();
		return Integer.parseInt(number);
	}

	public static void move(String[] arr) {
		System.out.println(String.join(",", arr));
		int moveNum = getMoveCount();
		System.out.println("실행 결과");
		racing(arr, moveNum);
	}

	public static void racing(String[] arr, int moveNum) {
		int[] result = new int[arr.length];
		for (int i = 0; i < moveNum; i++) {
			makeRand(result);
			addDash(result, arr);
		}
	}

	public static void makeRand(int[] result) {
		for (int i = 0; i < result.length; i++) {
			int randNum = Randoms.pickNumberInRange(0, 9);
			if (randNum > 3) {
				result[i] += 1;
			}
		}
	}

	public static void addDash(int[] result, String[] arr) {
		for (int i = 0; i < result.length; i++) {
			printCarStatus(arr[i], result[i]);
		}
		System.out.println();
	}

	public static void printCarStatus(String name, int dashCount) {
		System.out.print(name + " : ");
		for (int j = 0; j < dashCount; j++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static String findWinners(int[] result, String[] arr, int max) {
		StringBuilder winners = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (result[i] == max) {
				winners.append(arr[i]).append(", ");
			}
		}
		if (winners.length() > 0) {
			return winners.substring(0, winners.length() - 2);
		} else {
			return "";
		}
	}
}
