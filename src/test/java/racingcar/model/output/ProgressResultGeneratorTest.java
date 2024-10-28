package racingcar.model.output;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.car.Car;

class ProgressResultGeneratorTest {

	private final String carMovementSymbol = "-";
	private final String separator = " : ";
	private final int minRequiredValueForMovement = 4;

	@Test
	@DisplayName("하나의 자동차가 게임에 참여한 경우 중간 결과를 생성할 수 있다.")
	void 하나의_자동차의_중간_결과를_생성한다() {
		// given
		String carName = "name";
		List<Car> car = List.of(new Car(carName));
		car.getFirst().move(minRequiredValueForMovement);
		String expectedResult = carName + separator + carMovementSymbol;

		// when
		String progressResult = ProgressResultGenerator.generateProgressResult(car);

		// then
		assertEquals(expectedResult, progressResult);
	}
}