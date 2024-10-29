package racingcar.service;

import static racingcar.common.Constants.INIT_NUMBER;
import static racingcar.common.Message.CAR_MOVEMENT;
import static racingcar.common.Message.SEPARATE_COL;
import static racingcar.common.Message.SEPARATE_COM;
import static racingcar.common.Message.SEPARATE_COM_SPACE;
import static racingcar.common.Message.WINNER_MESSAGE;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SystemService {
	private static final SystemService INSTANCE = new SystemService();
	private final JudgmentCarName judgment = JudgmentCarName.getInstance();

	private SystemService() {}

	public List<Car> splitCarsString(String carsName) {
		return Arrays.stream(carsName.split(SEPARATE_COM))
				.map(String::trim)
				.map(this::generateCar)
				.collect(Collectors.toList());
	}

	private Car generateCar(String carName) {
		if(judgment.judgmentCarNameLength(carName)) {
			return new Car(carName);
		}

		throw new IllegalArgumentException();
	}

	public void printCarMovement(Car car) {
		System.out.print(car.getCarName() + SEPARATE_COL);

		for (int i = INIT_NUMBER; i < car.getMovement(); i++) {
			System.out.print(CAR_MOVEMENT);
		}

		System.out.println();
	}

	private List<Car> getWinner(List<Car> cars) {
		return cars.stream()
				.filter(car -> car.getMovement() == findMaxMovement(cars))
				.collect(Collectors.toList());
	}

	private int findMaxMovement(List<Car> cars) {
		return cars.stream()
				.mapToInt(Car::getMovement)
				.max()
				.orElse(INIT_NUMBER);
	}

	public void printWinner(List<Car> cars) {
		String winner = getWinner(cars).stream()
				.map(Car::getCarName)
				.collect(Collectors.joining(SEPARATE_COM_SPACE));

		System.out.print(WINNER_MESSAGE + winner);
	}

	public static SystemService getInstance() {
		return INSTANCE;
	}

}
