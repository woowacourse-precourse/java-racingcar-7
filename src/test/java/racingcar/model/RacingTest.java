package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.util.FixedNumberGenerator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class RacingTest {
    private final NumberGenerator randomGenerator = new RandomNumberGenerator();
    private final List<String> validCarNames = List.of(
            "car1",
            "car2",
            "car3"
    );
    private final Cars moveCars = Cars.of(FixedNumberGenerator.nineGenerator(), validCarNames);
    private final Cars notMoveCars = Cars.of(FixedNumberGenerator.zeroGenerator(), validCarNames);
    private final Cars validCars = Cars.of(randomGenerator, validCarNames);
    private final int validAttempt = 5;

    @Test
    void Racing_생성_성공() {
        assertDoesNotThrow(() ->
                Racing.of(validCars, validAttempt)
        );
    }

    @Test
    void 레이싱_시도횟수가_0으로_생성할수_없다() {
        int invalidAttempt = 0;

        assertThatThrownBy(() ->
                Racing.of(validCars, invalidAttempt)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시도횟수가_1이상이면_시도가능하다() {
        Racing racing = Racing.of(validCars, 1);

        assertDoesNotThrow(racing::makeAttempt);
    }

    @Test
    void 레이싱_시도횟수가_0인데_시도하면_예외가_발생한다() {
        Racing racing = Racing.of(validCars, 1);
        racing.makeAttempt();

        assertThatThrownBy(racing::makeAttempt)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시도횟수가_0이면_종료한다() {
        Racing racing = Racing.of(validCars, 1);

        assertThat(racing.isFinish()).isFalse();
        racing.makeAttempt();
        assertThat(racing.isFinish()).isTrue();
    }

    @Test
    void 레이싱의_상황을_반환한다() {
        Racing racing = Racing.of(moveCars, 2);
        Map<String, Integer> expect = Map.of(
                validCarNames.get(0), 1,
                validCarNames.get(1), 1,
                validCarNames.get(2), 1
        );

        racing.makeAttempt();
        Map<String, Integer> status = racing.status();

        assertThat(status).isEqualTo(expect);
    }

    @Test
    void 우승자들의_이름을_반환한다() {
        Racing racing = Racing.of(moveCars, 2);
        List<String> expect = new ArrayList<>(validCarNames);

        racing.makeAttempt();
        List<String> winnersNames = racing.winnersNames();

        assertThat(winnersNames).isEqualTo(expect);
    }
}