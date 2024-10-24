package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

	public static void run() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
	}

	public static List<String> inputName(String carNames) {
		List<String> names = Arrays.stream(carNames.split(",")).toList();
		Set<String> namevalid = new HashSet<>(names);
		if (namevalid.size() == names.size())
			return names;
		throw new IllegalArgumentException("이름이 중복됨");
	}
}
