package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 이름_길이_검증_성공() {
		String name = "pobi";

		assertThatNoException()
				.isThrownBy(() -> new Car(name));
	}

	@Test
	void 이름_길이_검증_실패() {
		String name = "javajigi";

		assertThatIllegalArgumentException()
				.isThrownBy(() -> new Car(name));
	}
}
