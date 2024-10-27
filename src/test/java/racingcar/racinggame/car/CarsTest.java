package racingcar.racinggame.car;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@DisplayName("자동차 이름을 가지고 목록을 생성할 수 있다")
	@Test
	void create() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc");

		// when
		Cars cars = Cars.create(carNames);

		// then
		assertThat(cars.getCars()).hasSize(3)
			.extracting("name", "moveDistance")
			.containsExactly(
				tuple("aaa", 0),
				tuple("bbb", 0),
				tuple("ccc", 0)
			);
	}

	@DisplayName("2대 이상의 자동차가 존재해야 자동차 목록이 생성된다")
	@Test
	void createWithSingleCar() {
		// given
		List<String> carNames = List.of("aaa");

		// when
		assertThatThrownBy(() -> Cars.create(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("2대 이상의 차량이 필요합니다.");
	}

	@DisplayName("자동차 목록에서 중복된 이름은 허용하지 않는다")
	@Test
	void createWithDuplicateName() {
		// given
		List<String> carNames = asList("aaa", "aaa", "bbb");

		// when
		assertThatThrownBy(() -> Cars.create(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 자동차 이름이 존재합니다.");
	}

	@Test
	void moveAll() {
	}

	@Test
	void getWinners() {
	}

	@Test
	void getCarCount() {
	}
}