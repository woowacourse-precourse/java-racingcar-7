package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JudgmentTest {

	private final JudgmentCarName judgment = new JudgmentCarName();

	@Test
	@DisplayName("이름 중복 판정 테스트")
	void 이름_중복_테스트() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car1");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);

		assertThat(judgment.judgmentCarNameDuplicate(
				cars.stream()
						.map(Car::getCarName)
						.toList())).isTrue();
	}

	@Test
	@DisplayName("이름 글자 수 제한 판정 테스트")
	void 이름_글자수_테스트() {
		assertThat(judgment.judgmentCarNameLength("pubi")).isTrue();
	}

	@Test
	@DisplayName("잘못된 입력 값 예외 처리 테스트")
	void 잘못된_입력값_예외_테스트() {

	}
}