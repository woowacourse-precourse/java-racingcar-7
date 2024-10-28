package racingcar.model.winner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.car.Car;

class WinnerDeterminerTest {

	private final int minRequiredValueForMovement = 4;

	@Test
	@DisplayName("단일 우승자를 결정하여 자동차 이름이 담긴 리스트로 반환할 수 있다.")
	void 단일_우승자를_결정하여_자동차_이름이_담긴_리스트를_반환한다() {
		// given
		String winnerCarName = "car1";
		String carName = "car2";
		Car car1 = new Car(winnerCarName);
		Car car2 = new Car(carName);
		car1.move(minRequiredValueForMovement);
		List<Car> cars = List.of(car1, car2);

		// when
		List<String> winner = WinnerDeterminer.determineWinner(cars);

		// then
		assertEquals(winnerCarName, winner.getFirst());
		assertEquals(1, winner.size());
	}

	@Test
	@DisplayName("다수 우승자를 결정하여 자동차 이름이 담긴 리스트로 반환할 수 있다.")
	void 다수_우승자를_결정하여_자동차_이름이_담긴_리스트를_반환한다() {
		// given
		String winnerCarName1 = "car1";
		String winnerCarName2 = "car2";
		String carName = "car3";
		Car car1 = new Car(winnerCarName1);
		Car car2 = new Car(winnerCarName2);
		Car car3 = new Car(carName);
		car1.move(minRequiredValueForMovement);
		car2.move(minRequiredValueForMovement);
		List<Car> cars = List.of(car1, car2, car3);
		List<String> winners = List.of(winnerCarName1, winnerCarName2);

		// when
		List<String> winner = WinnerDeterminer.determineWinner(cars);

		// then
		assertEquals(winners, winner);
	}
}