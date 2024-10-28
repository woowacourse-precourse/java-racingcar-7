package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.model.message.ErrorMessage.INVALID_CAR_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

	@ParameterizedTest
	@DisplayName("이름의 길이가 1 이상 5 이하일 때 Car 객체를 생성한다.")
	@ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
	void 이름의_길이가_1_이상_5_이하일_때_Car_객체를_성공적으로_생성할_수_있다(String name) {
		// when
		Car car = new Car(name);

		// then
		assertEquals(name, car.getName());
	}

	@ParameterizedTest
	@DisplayName("이름의 길이가 0이거나 5 초과라면 에러를 발생시킨다.")
	@ValueSource(strings = {"", "abcdef"})
	void 이름의_길이가_0이거나_5_초과일_때_예외가_발생한다(String name) {
		// when, then
		assertThatThrownBy(() -> new Car(name))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(INVALID_CAR_NAME_LENGTH.getMessage());
	}
}