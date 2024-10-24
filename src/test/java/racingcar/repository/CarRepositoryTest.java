package racingcar.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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
}