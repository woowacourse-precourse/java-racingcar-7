package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.validator.ValidatingParser;

class CarsTest {

	@DisplayName("차 이름 목록으로 Cars 생성에 성공한다.")
	@Test
	void createCarsWithValidNames() {
		//given
		List<String> names = List.of("roy", "hana", "frod");

		//when
		Cars cars = Cars.from(names);

		//then
		assertThat(cars).isNotNull();
	}

	@DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"roy123,hana123,frod123",
		"roy,hana12,frod"
	})
	void parseValidatedCarNamesOverLength(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.parseValidatedCarNames(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("중복된 차 이름이 있으면 IllegalArgumentException 예외가 발생한다.")
	@Test
	void carsFromDuplicateCarName() {
		//given
		List<String> duplicateNames = List.of("roy", "hana", "hana");

		//when & then
		assertThatThrownBy(() -> Cars.from(duplicateNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 차 이름은 등록할 수 없습니다.");
	}

	@DisplayName("랜덤값에 따라 차량을 이동시킨다.")
	@Test
	void moveAll() {
		//given
		Cars cars = Cars.from(List.of("roy", "hana", "frod"));
		List<Integer> randomNumbers = List.of(3, 4, 5);

		//when
		cars.moveAll(randomNumbers);

		//then
		assertThat(cars.getStatus().get(0).getMoveDistance()).isEqualTo(0);
		assertThat(cars.getStatus().get(1).getMoveDistance()).isEqualTo(1);
		assertThat(cars.getStatus().get(2).getMoveDistance()).isEqualTo(1);
	}

	@DisplayName("차량들의 현재 상태를 반환한다.")
	@Test
	void getStatus() {
		//given
		Cars cars = Cars.from(List.of("roy", "hana", "frod"));
		cars.moveAll(List.of(5, 5, 5));

		//when
		List<CarStatus> carStatus = cars.getStatus();

		//then
		assertThat(carStatus).hasSize(3);
		assertThat(carStatus.get(0).getCarName()).isEqualTo("roy");
		assertThat(carStatus.get(0).getMoveDistance()).isEqualTo(1);
		assertThat(carStatus.get(1).getCarName()).isEqualTo("hana");
		assertThat(carStatus.get(1).getMoveDistance()).isEqualTo(1);
		assertThat(carStatus.get(2).getCarName()).isEqualTo("frod");
		assertThat(carStatus.get(2).getMoveDistance()).isEqualTo(1);
	}

	@DisplayName("가장 멀리 이동한 차를 우승자로 반환한다.")
	@Test
	void getWinner() {
		//given
		Cars cars = Cars.from(List.of("roy", "hana", "frod"));
		cars.moveAll(List.of(5, 5, 5));
		cars.moveAll(List.of(5, 1, 2));

		//when
		List<String> winners = cars.getWinners();

		//then
		assertThat(winners).containsExactly("roy");
	}

	@DisplayName("가장 멀리 이동한 차들을 우승자로 반환한다.")
	@Test
	void getWinners() {
		//given
		Cars cars = Cars.from(List.of("roy", "hana", "frod"));
		cars.moveAll(List.of(5, 5, 5));
		cars.moveAll(List.of(5, 5, 2));

		//when
		List<String> winners = cars.getWinners();

		//then
		assertThat(winners).containsExactly("roy", "hana");
	}
}