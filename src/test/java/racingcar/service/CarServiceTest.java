package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.car.domain.Car;
import racingcar.car.repository.CarRepository;
import racingcar.car.service.CarService;
import racingcar.car.service.dto.CarCreateReqDto;
import racingcar.car.service.dto.WinnerRespDto;

public class CarServiceTest {
	private CarService carService = CarService.getInstance();
	private CarRepository carRepository = CarRepository.getInstance();

	@AfterEach
	public void rollback() {
		carRepository.clear();
	}

	@Test
	@DisplayName("자동차를 저장한다.")
	public void saveCars() {
		// GIVEN
		List<CarCreateReqDto> create = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			create.add(new CarCreateReqDto("car".concat(String.valueOf(i))));
		}

		// WHEN
		carService.saveCars(create);

		// THEN
		List<Car> cars = carRepository.findAll();
		assertThat(cars.size()).isEqualTo(10);
		for (int i = 0; i < 10; i++) {
			assertThat(cars.get(i).getName()).isEqualTo("car".concat(String.valueOf(i)));
		}
	}

	@Test
	@DisplayName("차의 이름이 5자가 넘을 경우, 예외를 발생시킨다.")
	public void nameRangeTest() {
	    // GIVEN
		CarCreateReqDto create = new CarCreateReqDto("overRange");


	    // WHEN - THEN
		assertThatThrownBy(() -> carService.saveCars(List.of(create))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("단독우승자를 계산한다.")
	public void calculateSoloWinner() {
		// GIVEN
		Car car1 = Car.from(new CarCreateReqDto("car1"));
		car1.move();
		Car car2 = Car.from(new CarCreateReqDto("car2"));
		carRepository.saveAll(List.of(car1, car2));

		// WHEN
		List<WinnerRespDto> winners = carService.calculateWinners();

		// THEN
		assertThat(winners.size()).isEqualTo(1);
		assertThat(winners.getFirst().getWinner()).isEqualTo("car1");
	}

	@Test
	@DisplayName("공동우승자를 계산한다.")
	public void calculateWinners() {
		// GIVEN
		Car car1 = Car.from(new CarCreateReqDto("car1"));
		car1.move();
		Car car2 = Car.from(new CarCreateReqDto("car2"));
		car2.move();
		carRepository.saveAll(List.of(car1, car2));

		// WHEN
		List<WinnerRespDto> winners = carService.calculateWinners();

		// THEN
		assertThat(winners.size()).isEqualTo(2);
		assertThat(winners.get(0).getWinner()).isEqualTo("car1");
		assertThat(winners.get(1).getWinner()).isEqualTo("car2");
	}

	@Test
	@DisplayName("시도 횟수가 0인 경우, 예외를 발생시킨다.")
	public void zeroCountTest() {
		// GIVEN
		Integer count = 0;

		// WHEN - THEN
		assertThatThrownBy(() -> carService.isPossibleCount(count)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도 횟수가 10000 이상인 경우, 예외를 발생시킨다.")
	public void overCountTest() {
		// GIVEN
		Integer count = 10000;

		// WHEN - THEN
		assertThatThrownBy(() -> carService.isPossibleCount(count)).isInstanceOf(IllegalArgumentException.class);
	}
}
