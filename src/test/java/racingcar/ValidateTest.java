package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGame;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;

class ValidateTest {
    RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(strings = {"pobi,javajigi,minju", "pobi,pobi,minju", "pobi,,minju", "", "pobi"})
    void 이름_예외_테스트(String input) {
        Assertions.assertThatThrownBy(() -> {
            Cars cars = racingGame.makeCars(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "A", "*", ""})
    void 경주횟수_예외_테스트(String input) {
        Assertions.assertThatThrownBy(() -> {
            Rounds rounds = new Rounds(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
