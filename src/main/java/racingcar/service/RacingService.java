package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {
	private static final String DELIMITER = ",";

	private final CarRepository carRepository;

	public RacingService() {
		this.carRepository = new CarRepository();
	}

	public void saveAll(String carNames) {
		for (String carName : carNames.split(DELIMITER)) {
			validateDuplicate(carName);

			Car car = Car.create(carName);
			carRepository.save(car);
		}
	}

	private void validateDuplicate(String carName) {
		if (carRepository.existByName(carName)) {
			throw new IllegalArgumentException();
		}
	}

	public boolean canRacing(int tryCount) {
		return !carRepository.existWinner(tryCount);
	}

	public List<Car> race() {
		List<Car> findCars = carRepository.findAll();
		for (Car car : findCars) {
			moveCarIfPossible(car);
		}
		return findCars;
	}

	private void moveCarIfPossible(Car car) {
		if (car.canMove()) {
			car.move();
		}
	}

	public List<String> getWinnerNames(int tryCount) {
		List<Car> findWinners = carRepository.findWinnersByTryCount(tryCount);
		return findWinners.stream()
			.map(Car::getName)
			.toList();
	}
}
