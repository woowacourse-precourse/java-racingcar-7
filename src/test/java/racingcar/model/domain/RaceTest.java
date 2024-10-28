package racingcar.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

	private List<Car> cars;
	private Race race;

	@BeforeEach
	void setUp() {
		cars = List.of(new Car("pobi"), new Car("woni"));
		race = new Race(cars);
	}

	@Test
	void 모든_자동차가_전진하지_않을_경우() {
		Assertions.assertRandomNumberInRangeTest(
			() -> race.raceOnce(),
			3, 3
		);

		cars.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
	}

	@Test
	void 한개의_자동차만_전진할_경우() {
		Assertions.assertRandomNumberInRangeTest(
			() -> race.raceOnce(),
			4, 3
		);

		assertThat(cars.get(0).getPosition()).isEqualTo(1);
		assertThat(cars.get(1).getPosition()).isEqualTo(0);
	}
}