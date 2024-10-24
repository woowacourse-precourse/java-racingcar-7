package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import racingcar.fixture.CarFixture;

class CarTest {

	@DisplayName("자동차를 성공적으로 생성한다.")
	@ParameterizedTest
	@EnumSource(CarFixture.class)
	void carCreateSuccessTest(CarFixture carFixture) {
		Car car = carFixture.toCar();
		assertThat(car).isNotNull();
	}

	@DisplayName("자동차의 이름은 비어있거나 5글자를 초과하면 예외를 던진다.")
	@ParameterizedTest
	@EnumSource(CarFixture.CreateFailFixture.class)
	void carCreateFailTest(CarFixture.CreateFailFixture fixture) {
		assertThatThrownBy(fixture::toCar)
			.isInstanceOf(IllegalArgumentException.class);
	}
}