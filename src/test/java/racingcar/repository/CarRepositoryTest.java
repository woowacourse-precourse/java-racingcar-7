package racingcar.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.car.domain.Car;
import racingcar.car.repository.CarRepository;
import racingcar.car.service.dto.CarCreateReqDto;

public class CarRepositoryTest {
	private CarRepository carRepository = CarRepository.getInstance();

	@AfterEach
	public void rollback() {
		carRepository.clear();
	}

	@Test
	@DisplayName("자동차를 저장한다.")
	public void save() {
		// GIVEN
		Car car1 = Car.from(new CarCreateReqDto("Car1"));
		Car car2 = Car.from(new CarCreateReqDto("Car2"));
		List<Car> cars = List.of(car1, car2);

		// WHEN
		carRepository.saveAll(cars);

		// THEN
		List<Car> find = carRepository.findAll();
		Assertions.assertThat(find).contains(car1, car2);
	}

	@Test
	@DisplayName("단독 우승자를 계산한다.")
	public void soloWinner() {
		// GIVEN
		Car car = Car.from(new CarCreateReqDto("Car"));
		Car winner = Car.from(new CarCreateReqDto("Winner"));
		winner.move();
		carRepository.saveAll(List.of(car, winner));

		// WHEN
		List<Car> winners = carRepository.findTopOrderByPosition();

		// THEN
		Assertions.assertThat(winners).contains(winner);
		Assertions.assertThat(winners).doesNotContain(car);
	}

	@Test
	@DisplayName("공동 우승자를 계산한다.")
	public void manyWinner() {
		// GIVEN
		Car winner1 = Car.from(new CarCreateReqDto("Winner1"));
		Car winner2 = Car.from(new CarCreateReqDto("Winner2"));
		winner1.move();
		winner2.move();
		carRepository.saveAll(List.of(winner1, winner2));

		// WHEN
		List<Car> winners = carRepository.findTopOrderByPosition();

		// THEN
		Assertions.assertThat(winners).contains(winner1, winner2);
	}
}
