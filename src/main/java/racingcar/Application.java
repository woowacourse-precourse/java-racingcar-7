package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();

		Car[] cars = separateNames(carNames);
		int n = cars.length;

		System.out.println("시도할 횟수는 몇 회인가요?");
		int m = validateNumber(Console.readLine());

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int moveCounter = cars[j].move();
			}
		}

	}

	public static Car[] separateNames(String carNames) throws IllegalArgumentException {

		String[] names = carNames.split(",");
		Car[] cars = new Car[names.length];

		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i]);
		}

		return cars;
	}

	public static int validateNumber(String numStr) throws IllegalArgumentException {

		try {
			int number = Integer.parseInt(numStr);

			if (number < 0) {
				throw new IllegalArgumentException("이동 횟수는 음수일 수 없습니다.");
			}

			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효한 숫자가 아닙니다.", e);
		}
	}
}
