package racingcar.random;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberProviderTest {

	@DisplayName("차 목록의 개수만큼 랜덤 값을 반환한다.")
	@Test
	void generateRandomNumbers() {
		//given
		RandomNumberProvider randomNumberProvider = RandomNumberProvider.create();
		int carsCount = 4;

		//when
		List<Integer> randomNumbers = randomNumberProvider.generateRandomNumbers(carsCount);

		//then
		assertThat(randomNumbers.size()).isEqualTo(carsCount);
	}
}