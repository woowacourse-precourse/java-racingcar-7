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
	}

}
