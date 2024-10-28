package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "         "})
	void 빈_차량_이름_테스트(String input) {
		assertThatThrownBy(() -> Car.fromCarName(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("차량 이름은 비어있을 수 없습니다.");
	}

	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = {"이거어디까지지어지는거에요", "ChristopherNolan"})
	void 이름이_5자_초과할_때_테스트(String input) {
		assertThatThrownBy(() -> Car.fromCarName(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("차량 이름은 5자를 초과할 수 없습니다.");
	}

	@Test
	void 자동차_이름_중복_테스트() {
		//given
		String[] inputs = new String[] {"벤츠", "포르쉐", "벤츠"};

		assertThatThrownBy(() -> new Cars(inputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("차량 이름은 중복될 수 없습니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"벤츠,폭스바겐,도요타", "david,chris,patra", "1,2,3"})
	void 이름이_5글자_미만이고_비어있지_않음(String input) {
		String[] split = input.split(",");
		Assertions.assertDoesNotThrow(() -> new Cars(split));
	}

	@Test
	void 기준점_넘을_경우_움직이는지_확인() {
		// given
		int standard = 4;
		String delim = "-";
		Car car = Car.fromCarName("벤츠");

		// when
		String res = "벤츠 : -";
		car.moveIfSatisfyStandard(() -> 4, 4);

		// then
		assertThat(car.showStatus(delim)).isEqualTo(res);
	}

	@Test
	void 기준점_못넘을_경우_움직이지_않음() {
		// given
		int standard = 4;
		String delim = "-";
		Car car = Car.fromCarName("벤츠");

		// when
		String res = "벤츠 : ";
		car.moveIfSatisfyStandard(() -> 3, 4);

		// then
		assertThat(car.showStatus(delim)).isEqualTo(res);
	}

	@Test
	void 한_라운드_진행() {
		// given
		Supplier<Integer> numberSupplier = new Supplier<Integer>() {
			private int[] numbers = {3, 4};
			private int idx = 0;
			@Override
			public Integer get() {
				return numbers[idx++ % numbers.length];
			}
		};

		Cars cars = new Cars(new String[] {"벤츠", "포르쉐"});
		String expected = "벤츠 : \n포르쉐 : -\n";

		// when
		String res = cars.startRound(numberSupplier);

		// then
		assertThat(res).isEqualTo(expected);
	}
}
