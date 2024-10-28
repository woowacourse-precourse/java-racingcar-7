package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@DisplayName("자동차의 이름이 5자 미만이면 예외가 발생하지 않는다.")
	@Test
	void isNotCarNameLongTest() {
		// given
		CarName carName = CarName.from(List.of("name", "poni"));

		// when

		// then
		assertThatCode(() -> carName.isCarNameLengthValid())
			.doesNotThrowAnyException();
	}

	@DisplayName("자동차 이름이 1개만 존재한다.")
	@Test
	void onlyOneCarNameTest() {
		// given
		CarName carName = CarName.from(List.of("name"));

		// when

		// then
		assertThat(carName.hasOnlyOneCar())
			.isTrue();
	}

	@DisplayName("자동차 이름이 존재하지 않는다.")
	@Test
	void doesNotEnterCarName() {
		// given
		CarName carName = CarName.from(List.of(""));

		// when

		// then
		assertThat(carName.doesNotEnterCarName())
			.isTrue();
	}

}