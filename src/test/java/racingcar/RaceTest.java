package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * class: RaceTest.
 *
 * @author JBum
 * @version 2024/10/28
 */
@DisplayName("Race 클래스 테스트")
class RaceTest {
    private static final String POBI = "pobi";
    private static final String WONI = "woni";

    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
    @Test
    void createRaceWithInvalidTryCount() {
        List<String> carNames = Arrays.asList(POBI, WONI);
        assertThatThrownBy(() -> Race.create(carNames, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @DisplayName("정상적으로 레이스가 생성된다")
    @Test
    void createRaceSuccess() {
        List<String> carNames = Arrays.asList(POBI, WONI);
        Race race = Race.create(carNames, 5);
        assertThat(race).isNotNull();
    }

    @DisplayName("레이스가 정상적으로 시작되고 완료된다")
    @RepeatedTest(100)
    void raceCompletes() {
        // given
        List<String> carNames = Arrays.asList(POBI, WONI);
        Race race = Race.create(carNames, 5);

        // when & then
        assertThatNoException().isThrownBy(() -> race.start());
    }
}