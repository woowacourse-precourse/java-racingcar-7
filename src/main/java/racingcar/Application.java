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
	}

	public static String[] splitInput(String input) {
		if (input.contains(",")) {
			return input.split(",");
		}
		return new String[] { input };
	}

	
}
