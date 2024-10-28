package racingcar.racinggame.race.car;

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

		// when // then
		assertThatThrownBy(() -> Cars.create(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 자동차 이름이 존재합니다.");
	}

	@DisplayName("자동차 목록의 차량을 이동시킬 수 있다.")
	@Test
	void moveAll() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc");
		Cars cars = Cars.create(carNames);

		List<Integer> randomValues = List.of(3, 4, 9);

		// when
		cars.moveAll(randomValues);

		// then
		assertThat(cars.getCars()).hasSize(3)
			.extracting("name", "moveDistance")
			.containsExactly(
				tuple("aaa", 0),
				tuple("bbb", 1),
				tuple("ccc", 1)
			);
	}

	@DisplayName("자동차의 개수와 무작위 값의 개수가 일치해야 이동시킬 수 있다.")
	@Test
	void moveAllWithoutEqualsCount() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc");
		Cars cars = Cars.create(carNames);

		List<Integer> randomValues = List.of(3, 4);

		// when // then
		assertThatThrownBy(() -> cars.moveAll(randomValues))
			.isInstanceOf(IllegalStateException.class)
			.hasMessage("랜덤 값과 자동차의 개수가 일치하지 않습니다.");
	}

	@DisplayName("우승 자동차의 이름을 조회할 수 있다")
	@Test
	void getWinners() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc");
		Cars cars = Cars.create(carNames);

		List<Integer> randomValues = List.of(3, 4, 0);
		cars.moveAll(randomValues);

		// when
		List<String> winners = cars.getWinners();

		// then
		assertThat(winners).hasSize(1)
			.containsExactly("bbb");
	}

	@DisplayName("우승 자동차는 1명 이상일 수 있다")
	@Test
	void getWinnersWithCowinner() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc");
		Cars cars = Cars.create(carNames);

		List<Integer> randomValues = List.of(3, 4, 9);
		cars.moveAll(randomValues);

		// when
		List<String> winners = cars.getWinners();

		// then
		assertThat(winners).hasSize(2)
			.containsExactly("bbb", "ccc");
	}

	@DisplayName("자동차의 개수를 조회할 수 있다")
	@Test
	void getCarCount() {
		// given
		List<String> carNames = asList("aaa", "bbb", "ccc", "ddd", "eee");
		Cars cars = Cars.create(carNames);

		// when
		int carCount = cars.getCarCount();

		// then
		assertThat(carCount).isEqualTo(5);
	}
}