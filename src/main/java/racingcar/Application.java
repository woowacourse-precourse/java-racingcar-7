package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();

		Car[] cars = separateNames(carNames);

		/*
		 * 이동 시작 ~
		 */

	}

	public static Car[] separateNames(String carNames) {

		String[] names = carNames.split(",");
		Car[] cars = new Car[names.length];

		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i]);
		}

		return cars;
	}
}
