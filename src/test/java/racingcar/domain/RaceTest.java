package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.RaceConfig;
import racingcar.dto.CarMovementResponse;
import racingcar.dto.WinnerResponse;

class RaceTest {
	private Car car1;
	private Car car2;
	private Car car3;
	private List<Car> cars = new ArrayList<>();
	private Race race;

	@BeforeEach
	void setUp() {
		// given
		car1 = new Car("pobi");
		car2 = new Car("woni");
		car3 = new Car("jun");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		race = new Race(cars);
	}

	@Test
	@DisplayName("모든 자동차의 랜덤 숫자가 기준값 이상일 때, 모든 자동차가 이동한다.")
	void moveEachCar() {
		// given
		int randomNumber = RaceConfig.MOVE_CONDITION_NUMBER.getNumber();

		// when
		race.moveEachCars(randomNumber);

		// then
		assertThat(cars.stream()
			.map(Car::getDistance)
			.toList())
			.isEqualTo(List.of(1, 1, 1));
	}
}