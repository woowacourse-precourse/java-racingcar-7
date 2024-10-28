package racingcar.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
		assertThat(car.getName()).isEqualTo(name);
	}
}