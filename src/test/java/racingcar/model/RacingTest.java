package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.FixedNumberGenerator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class RacingTest {
    private final NumberGenerator randomGenerator = new RandomNumberGenerator();
    private final NumberGenerator nineGenerator = FixedNumberGenerator.nineGenerator();
    private final NumberGenerator zeroGenerator = FixedNumberGenerator.zeroGenerator();
    private final List<String> validCarNames = List.of(
            "car1",
            "car2",
            "car3"
    );
    private final int validAttempt = 5;

    @Test
    void 레이스_생성_성공() {
        assertDoesNotThrow(() ->
                Racing.of(randomGenerator, validCarNames, validAttempt)
        );
    }

    @Test
    void 레이스_생성_실패_중복_이름() {
        List<String> duplicateCarNames = List.of(
                "car1",
                "car1"
        );

        assertThatThrownBy(() ->
                Racing.of(randomGenerator, duplicateCarNames, validAttempt)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이스_생성_실패_시도_횟수_오류() {
        int invalidAttempt = 0;

        assertThatThrownBy(() ->
                Racing.of(randomGenerator, validCarNames, invalidAttempt)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이스_성공() {
        Racing racing = Racing.of(randomGenerator, validCarNames, 1);

        assertDoesNotThrow(racing::race);
    }

    @Test
    void 레이스_실패() {
        Racing racing = Racing.of(randomGenerator, validCarNames, 1);
        racing.race();

        assertThatThrownBy(racing::race)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이스_시작_끝() {
        Racing racing = Racing.of(randomGenerator, validCarNames, 1);

        assertThat(racing.isFinish()).isFalse();
        racing.race();
        assertThat(racing.isFinish()).isTrue();
    }

    @Test
    void 상태_검증() {
        Racing racing = Racing.of(nineGenerator, validCarNames, 2);
        Map<String, Integer> expect = Map.of(
                validCarNames.get(0), 1,
                validCarNames.get(1), 1,
                validCarNames.get(2), 1
        );

        racing.race();
        Map<String, Integer> status = racing.status();

        assertThat(status).isEqualTo(expect);
    }

    @Test
    void 우승자_이름() {
        Racing racing = Racing.of(nineGenerator, validCarNames, 2);
        List<String> expect = new ArrayList<>(validCarNames);

        racing.race();
        List<String> winnersNames = racing.winnersNames();

        assertThat(winnersNames).isEqualTo(expect);
    }
}