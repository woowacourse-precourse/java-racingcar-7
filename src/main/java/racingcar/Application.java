package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		String car[] = input_name();
		int[] result = new int[car.length];
		int time = try_count();
		System.out.println("실행 결과");
		while (time > 0) {
			time--;
			System.out.println();
		}
	}

	public static String[] input_name() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String name_input = Console.readLine();
		if (name_input.contains(",")) {
			String[] arr = name_input.split(",");
			System.out.println(name_input);
			return arr;
		} else {
			String[] arr = { name_input };
			System.out.println(name_input);
			return arr;
		}
	}

	public static int try_count() {
		System.out.println("시도할 횟수를 입력하세요 : ");
		String count = Console.readLine();
		int number = Integer.parseInt(count);
		return number;
	}
}