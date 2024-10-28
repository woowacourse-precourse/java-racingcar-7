package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceTest {

	private RandomNumberGenerator randomNumberGenerator;

	@BeforeEach
	void setUp() {
		randomNumberGenerator = new RandomNumberGenerator();
	}

	@Test
	void 경주_횟수만큼_자동차_전진() {
		List<Car> cars = List.of(new Car("suby"), new Car("busy"), new Car("ssuubbyy"));
		int round = 0;
		Race race = new Race(cars, round, randomNumberGenerator);
		race.proceedRound();
		cars.forEach(car -> assertTrue(car.getPosition() >= 0));
	}

	@Test
	void 경주_횟수에_도달하면_경주를_종료한다() {
		List<Car> cars = List.of(new Car("suby"), new Car("busy"), new Car("ssuubbyy"));
		Race race = new Race(cars, 5, randomNumberGenerator);
		Integer roundLimit = 6;
		assertTrue(race.isRaceFinished(roundLimit));
	}

	@Test
	void 경주_횟수는_1씩_증가한다() {
		List<Car> cars = List.of(new Car("suby"), new Car("busy"), new Car("ssuubbyy"));
		int round = 5;
		Race race = new Race(cars, round, randomNumberGenerator);
		race.proceedRound();
		assertEquals(race.getRound(), round + 1);
	}
}
