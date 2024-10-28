package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Cars;
import utils.NumberGenerator;

class CarsTest {
	@DisplayName("자동차 이름 목록이 비어있으면 예외가 발생한다")
	@Test
	void createCarsWithEmptyNames() {
		assertThatThrownBy(() -> new Cars(List.of()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("우승자가 여러 명일 수 있다")
	@Test
	void multipleWinners() {
		Cars cars = new Cars(Arrays.asList("car1", "car2"));
		NumberGenerator stubGenerator = new NumberGenerator() {
			@Override
			public int generate() {
				return 4;
			}
		};

		cars.moveAll(stubGenerator);
		List<String> winners = cars.getWinners();
		assertThat(winners).containsExactly("car1", "car2");
	}
}
