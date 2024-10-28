package racingcar.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.fixture.CarFixture;

class CarRepositoryTest {

	private CarRepository carRepository;

	@BeforeEach
	void setUp() {
		carRepository = new CarRepository();
	}

	@DisplayName("자동차를 정상적으로 저장한다.")
	@ParameterizedTest
	@EnumSource(CarFixture.class)
	void saveSuccessTest(CarFixture carFixture) {
		Car car = carFixture.toCar();
		assertThatCode(() -> carRepository.save(car))
			.doesNotThrowAnyException();
	}

	@DisplayName("모든 자동차 조회에 성공한다.")
	@Test
	void findAllSuccessTest() {
		/* Given */
		for (CarFixture fixture : CarFixture.values()) {
			carRepository.save(fixture.toCar());
		}

		/* When */
		List<Car> findCars = carRepository.findAll();

		/* Then */
		assertThat(findCars).hasSizeGreaterThan(0);
	}

	@DisplayName("우승자 유무 조회에 성공한다.")
	@ParameterizedTest
	@ValueSource(ints = {3, 5, 10})
	void existWinnerSuccessTest(int tryCount) {
		/* Given */
		Car car = CarFixture.SEI.toCar();
		for (int i = 0; i < tryCount; i++) {
			car.move();
		}
		carRepository.save(car);

		/* When * Then */
		assertThat(carRepository.existWinner(tryCount)).isTrue();
	}

	@DisplayName("우승자 차량 조회에 성공한다.")
	@ParameterizedTest
	@ValueSource(ints = {3, 5, 10})
	void findWinnersByTryCountSuccessTest(int tryCount) {
		/* Given */
		Car car = CarFixture.SEI.toCar();
		for (int i = 0; i < tryCount; i++) {
			car.move();
		}
		carRepository.save(car);

		/* When */
		List<Car> winners = carRepository.findWinnersByTryCount(tryCount);

		/* Then */
		assertThat(winners).hasSizeGreaterThan(0);
	}
}