package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 경주에_참여하려면_최소_1라운드_이상_설정해야_한다(int round) {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame(round));
    }

}