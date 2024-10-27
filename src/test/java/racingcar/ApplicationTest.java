package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 기능_테스트() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni", "1");
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("pobi,javaji", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 자동차_이름_분리() {
		// Given
		String carNames = "car1,car2,car3";

		// When
		Car[] cars = Application.separateNames(carNames);

		// Then
		Assertions.assertEquals(3, cars.length);
		Assertions.assertEquals("car1", cars[0].getName());
		Assertions.assertEquals("car2", cars[1].getName());
		Assertions.assertEquals("car3", cars[2].getName());
	}

	@Test
	void 유효한_시도횟수() {
		// Given
		String m = "5";

		// When
		int result = Application.validateNumber(m);

		// Then
		Assertions.assertEquals(5, result);
	}

	@Test
	void 음수_시도횟수_예외() {
		// Given
		String m = "-3";

		// Then
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Application.validateNumber(m));
	}

	@Test
	void 숫자가_아닌_문자열_시도횟수_예외() {
		// Given
		String m = "abc";

		// Then
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Application.validateNumber(m));
	}

	@Test
	void 최대_이동횟수_찾기() {
		assertRandomNumberInRangeTest(
			() -> {
				// Given
				Car[] cars = {new Car("pobi"), new Car("woni")};

				// When
				int maxMoveCounter = Application.findMaxCounter(cars);

				// Then
				Assertions.assertEquals(1, maxMoveCounter);
			},
			MOVING_FORWARD, STOP
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
