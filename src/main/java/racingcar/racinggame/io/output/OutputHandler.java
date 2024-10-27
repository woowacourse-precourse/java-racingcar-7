package racingcar.racinggame.io.output;

import java.util.List;
import java.util.StringJoiner;

import racingcar.racinggame.race.car.Car;
import racingcar.racinggame.race.car.Cars;

public class OutputHandler {

	private static final String CAR_NAMES_INPUT_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRY_COUNT_INPUT_COMMENT = "시도할 횟수는 몇 회인가요?";
	private static final String RESULT_COMMENT = "실행 결과";
	private static final String DISTANCE_SIGN = "-";
	private static final String CAR_NAME_DISTANCE_DELIMITER_SIGN = " : ";
	private static final String WINNER_NAME_DELIMITER_SIGN = ",";
	private static final String WINNER_NAME_COMMENT = "최종 우승자 : ";

	public void showCarNamesInputComment() {
		System.out.println(CAR_NAMES_INPUT_COMMENT);
	}

	public void showTryCountInputComment() {
		System.out.println(TRY_COUNT_INPUT_COMMENT);
	}

	public void showResultComment() {
		System.out.println();
		System.out.println(RESULT_COMMENT);
	}

	public void showEachRound(Cars cars) {
		List<Car> racingCars = cars.getCars();

		for (Car racingCar : racingCars) {
			System.out.println(
				racingCar.getName() +
					CAR_NAME_DISTANCE_DELIMITER_SIGN +
					DISTANCE_SIGN.repeat(racingCar.getMoveDistance())
			);
		}

		System.out.println();
	}

	public void showWinner(List<String> carNames) {
		StringJoiner stringJoiner = new StringJoiner(WINNER_NAME_DELIMITER_SIGN);
		for (String carName : carNames) {
			stringJoiner.add(carName);
		}

		System.out.println(WINNER_NAME_COMMENT + stringJoiner);
	}

}
