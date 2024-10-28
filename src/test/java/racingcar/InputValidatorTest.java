package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.io.RacingInput;
import racing.validation.InputValidator;

import java.util.List;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();
    private final RacingInput racingInput = new RacingInput();
    @Test
    @DisplayName("유효 하지않은 입력 - 빈 자동차 이름 목록")
    void  예외_테스트_0(){
        // given
        List<String> emptyCarNames = List.of();

        // when
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(emptyCarNames)
                // then
                ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("유효 하지않은 자동차 이름 - 5자 초과")
    void  예외_테스트1(){
        // given
        String longCarName = "loooooooooong";

        // when
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(longCarName))
                // then
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효 하지않은 자동차 이름 - 빈문자열")
    void  예외_테스트_2(){
        // given
        String invalidCarName = "";

        // when
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(invalidCarName))
                // then
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효 하지않은 시도 횟수 - 0이하")
    void  예외_테스트_3(){
        // given
        int gameRound = 0;

        // when
        Assertions.assertThatThrownBy(() -> inputValidator.validateGameRound(gameRound))
        // then
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효 하지않은 시도 횟수 - 문자")
    void  예외_테스트_4(){
        // given
        String gameRound = "a";

        // when
        Assertions.assertThatThrownBy(() -> racingInput.parseGameRound(gameRound))
                // then
                .isInstanceOf(IllegalArgumentException.class);
    }

}
