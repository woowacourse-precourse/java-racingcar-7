package racingcar.racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.errormessage.ErrorMessage;
import racingcar.racingcar.service.create.RacingCarFactory;

import static org.assertj.core.api.Assertions.*;

public class RacingCarInfoFactoryTest {
    @Test
    @DisplayName("중복 에러")
    void duplicateTest() {
        String sentence = "123,123,456,789";
        assertThatThrownBy(() ->
                RacingCarFactory.create(sentence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_ERROR);
    }
}
