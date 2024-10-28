package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.DummyMoveStrategy;

import java.util.Arrays;
import java.util.List;

class RaceResultTest {

	private List<Car> cars;
	private RaceResult raceResult;

	@BeforeEach
	void setUp() {
		cars = Arrays.asList(
			new Car("CarA", new DummyMoveStrategy(true)),
			new Car("CarB", new DummyMoveStrategy(false)),
			new Car("CarC", new DummyMoveStrategy(true))
		);

		// 시뮬레이션을 위해 자동차 위치 설정
		cars.get(0).move();
		cars.get(2).move();
		raceResult = new RaceResult(cars);
	}

	@Test
	@DisplayName("RaceResult가 단일 우승자를 정확히 식별하는지 테스트")
	void testSingleWinner() {

		// 시뮬레이션을 위해 자동차 위치 설정
		cars.get(0).move();

		// Act
		List<Car> winner = raceResult.getWinners();

		// Assert
		assertThat(winner).hasSize(1);
		assertThat(winner.getFirst().getName()).isEqualTo("CarA");
	}

	@Test
	@DisplayName("RaceResult가 여러 우승자를 정확히 식별하는지 테스트")
	void testGetWinners() {
		// Act
		List<Car> winners = raceResult.getWinners();

		// Assert
		assertThat(winners).hasSize(2);
		assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("CarA", "CarC");
	}
}
