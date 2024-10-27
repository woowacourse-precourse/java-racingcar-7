package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 자동차_전진_테스트() {
		assertRandomNumberInRangeTest(
			() -> {
				Car car = new Car("name");
				car.move();

				assertThat(car.getMoveCounter()).isEqualTo(1);
			},
			4, 9);
	}

	@Test
	void 최대_이동횟수_갱신_테스트() {
		String[] carNames = {"pobi", "woni"};
		CarList carList = new CarList(carNames);

		assertRandomNumberInRangeTest(
			() -> {
				carList.startRace();

				assertThat(carList.getMaxMoveCounter()).isGreaterThan(0);
			},
			4, 9
		);
	}
}
