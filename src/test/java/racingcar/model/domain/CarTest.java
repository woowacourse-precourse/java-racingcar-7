package racingcar.model.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.Assertions;

class CarTest {

	@ParameterizedTest
	@ValueSource(strings = { "", " " })
	void 자동차_이름이_비어있을_경우_예외(String carNames) {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateCarNames(carNames))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "pobi", "woni", "jun" })
	void 자동차가_한대일_경우_예외(String carNames) {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateCarNames(carNames))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.SINGLE_CAR_NAME.getMessage());
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "pobiii,woni,jun", "javajigi,jun", "woowacourse,woni" })
	void 자동차_이름이_5자_초과일_경우_예외(String carNames) {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateCarNames(carNames))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.OVER_CAR_NAME_LENGTH.getMessage());
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "pobi,pobi,jun", "woni,woni,pobi", "jun,jun,pobi" })
	void 자동차_이름이_중복되었을_경우_예외(String carNames) {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateCarNames(carNames))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
		});
	}

	@ParameterizedTest
	@ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
	void 무작위값이_4_이상일_경우_전진_O(int randomNumber) {
		Assertions.assertSimpleTest(() -> {
			Car car = new Car("pobi,woni");
			car.move(randomNumber);
			assertThat(car.getPosition()).isEqualTo(1);
		});
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3 })
	void 무작위값이_4_미만일_경우_전진_X(int randomNumber) {
		Assertions.assertSimpleTest(() -> {
			Car car = new Car("pobi,woni");
			car.move(randomNumber);
			assertThat(car.getPosition()).isEqualTo(0);
		});
	}
}