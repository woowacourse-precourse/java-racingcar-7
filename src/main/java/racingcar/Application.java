package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";

	private static List<Car> inputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		String input = Console.readLine();

		List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
		Validator.validateCarNames(carNames);

		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name.trim()));
		}

		return cars;
	}

	private static int inputTryCount() {
		System.out.println(INPUT_TRY_COUNT_MESSAGE);
		String input = Console.readLine();

		Validator.validateNumericInput(input);
		int tryCount = Integer.parseInt(input);

		Validator.validatePositiveTryCount(tryCount);

		return tryCount;

	}

	private static void runRace(List<Car> cars, int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			playRound(cars);
			displayRoundResult(cars);
		}
		displayWinners(cars);
	}

	private static void playRound(List<Car> cars) {
		for (Car car : cars) {
			int randomValue = Randoms.pickNumberInRange(0, 9);
			car.move(randomValue);
		}
	}

	private static void displayRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.displayPosition());
		}
		System.out.println();
	}

	private static void displayWinners(List<Car> cars) {
		int maxPosition = 0;
		for(Car car : cars) {
			if(car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if(car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
	
	public static void main(String[] args) {
		List<Car> cars = inputCarNames();
		int tryCount = inputTryCount();

		runRace(cars, tryCount);
	}
}
