package racingcar.interfaces.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.fake.FakeRacingStrategy;

class RandomRacingStrategyTest {

    @DisplayName("랜덤 숫자를 통해 자동차가 앞으로 전진하기 위한 조건을 제공하는 테스트")
    @Test
    void makeRandomNumberTest() {
        FakeRacingStrategy fakeRacingStrategy = new FakeRacingStrategy();
        assertThat(fakeRacingStrategy.determineCarToForward()).isEqualTo(true);
    }
}
