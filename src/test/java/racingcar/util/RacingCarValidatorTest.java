package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingCarValidatorTest extends NsTest {

    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    @Test
    @DisplayName("자동차의 이름이 일정 글자수를 넘으면 예외가 발생한다_성공")
    void t001() {
        //given
        String testInput = ("a").repeat(MAX_CAR_NAME_LENGTH);

        assertThatCode(() -> {
            racingCarValidator.validateCarName(testInput);  //when
        }).doesNotThrowAnyException();                      //then
    }

    @Test
    @DisplayName("자동차의 이름이 일정 글자수를 넘으면 예외가 발생한다_실패")
    void t002() {
        //given
        String testInput = ("a").repeat(MAX_CAR_NAME_LENGTH) + "a";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarValidator.validateCarName(testInput)) //when
                        .isInstanceOf(IllegalArgumentException.class)                   //then
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}