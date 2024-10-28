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

	@Test
	@DisplayName("모든 자동차의 랜덤 숫자가 기준값 미만일 때, 모든 자동차가 정지한다.")
	void stopEachCar() {
		// given
		int randomNumber = RaceConfig.MOVE_CONDITION_NUMBER.getNumber() - 1;

		// when
		race.moveEachCars(randomNumber);

		// then
		assertThat(cars.stream()
			.map(Car::getDistance)
			.toList())
			.isEqualTo(List.of(0, 0, 0));
	}

	@Test
	@DisplayName("모든 자동차들의 전진 상태를 이름과 이동 거리를 통해 반환한다.")
	void findRaceStatus() {
		// given
		int randomNumber = RaceConfig.MOVE_CONDITION_NUMBER.getNumber();

		// when
		race.moveEachCars(randomNumber);
		List<CarMovementResponse> carMovementResponses = race.findRaceStatus();

		// then
		assertThat(carMovementResponses.stream()
			.map(CarMovementResponse::name)
			.toList())
			.containsExactly("pobi", "woni", "jun");

		assertThat(carMovementResponses.stream()
			.map(CarMovementResponse::distance)
			.toList())
			.containsExactly(1, 1, 1);
	}

	@Test
	@DisplayName("최대 이동거리를 가진 자동차들의 이름을 우승자 응답으로 반환된다.")
	void selectWinners() {
		// given
		int randomNumber = RaceConfig.MOVE_CONDITION_NUMBER.getNumber();

		// when
		car1.move(randomNumber);
		car2.move(randomNumber);
		List<WinnerResponse> winnerResponses = race.selectWinners();

		// then
		assertThat(winnerResponses.stream()
			.map(WinnerResponse::name)
			.toList())
			.containsExactly("pobi", "woni");
	}
}