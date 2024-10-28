package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.DummyMoveStrategy;

import java.util.Arrays;
import java.util.List;

class RaceTest {

	private List<Car> cars;
	private Race race;

	@BeforeEach
	void setUp() {
		cars = Arrays.asList(
			new Car("CarA", new DummyMoveStrategy(true)),
			new Car("CarB", new DummyMoveStrategy(false)),
			new Car("CarC", new DummyMoveStrategy(true))
		);
		race = new Race(cars, 3);
	}

	@Test
	@DisplayName("cars의 초기화 여부 확인")
	void testCarsInitialization() {
		// Assert
		assertThat(race.getCars()).hasSize(3);
		assertThat(race.getCars().getFirst().getName()).isEqualTo("CarA");
	}

	@Test
	@DisplayName("moveCars() 호출 후 Cars의 위치 확인")
	void testMoveCars() {
		// Act
		race.moveCars();

		// Assert
		assertThat(cars.get(0).getPosition()).isEqualTo(1);
		assertThat(cars.get(1).getPosition()).isEqualTo(0);
		assertThat(cars.get(2).getPosition()).isEqualTo(1);
	}
}
