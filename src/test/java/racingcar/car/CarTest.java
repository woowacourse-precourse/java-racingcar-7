package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@Nested
	class 이름_길이_검증Test {
		@Test
		void 성공() {
			String name = "pobi";

			assertThatNoException()
					.isThrownBy(() -> new Car(name));
		}

		@Test
		void 실패() {
			String name = "javajigi";

			assertThatIllegalArgumentException()
					.isThrownBy(() -> new Car(name));
		}
	}

	@Nested
	class 자동차_전진Test {

		@ParameterizedTest
		@ValueSource(ints = {4, 5, 6, 7, 8, 9})
		void 성공(int value) {
			Car car = new Car("test");
			int origin = car.getPosition();

			car.move(() -> value);
			assertThat(car.getPosition()).isEqualTo(origin + 1);
		}

		@ParameterizedTest
		@ValueSource(ints = {1, 2, 3})
		void 실패(int value) {
			Car car = new Car("test");
			int origin = car.getPosition();

			car.move(() -> value);
			assertThat(car.getPosition()).isEqualTo(origin);
		}
	}
}
