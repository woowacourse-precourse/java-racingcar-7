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
			dash_print(car, time, result);
			System.out.println();
		}
		winner(car, result);
	}

	public static String[] input_name() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String name_input = Console.readLine();
		if (name_input.contains(",")) {
			String[] arr = name_input.split(",");
			check(arr);
			if (check(arr) == 1)
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

	public static int check(String arr[]) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i].length() > 5)
				throw new IllegalArgumentException("5글자 이하로 입력하세요.");
		return 1;
	}

	public static int[] random_value(String[] car, int time, int[] result) {
		int random = 0;
		for (int i = 0; i < result.length; i++) {
			random = Randoms.pickNumberInRange(0, 9);
			if (random > 3) {
				result[i] = result[i] + 1;
			}
		}
		return result;
	}

	public static void dash_print(String[] car, int time, int[] result) {
		int[] count = random_value(car, time, result);
		for (int i = 0; i < car.length; i++) {
			print_result(car[i], count[i]);
		}
	}

	public static void print_result(String car, int count) {
		System.out.print(car + " : ");
		for (int j = 0; j < count; j++) {
			System.out.print("-");
		}
		System.out.println();
	}
}