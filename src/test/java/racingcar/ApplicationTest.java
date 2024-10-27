package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @ParameterizedTest
    @ValueSource(strings = {"Ahn;Seong;Mo", "Ahn,Seong;Mo", "Ahn/Seong,Mo"})
    @DisplayName("자동차 이름들을 쉼표(,)로 구분하지 않았으면 예외 발생")
    void separateByComma_NotSeparatedByComma_ExceptionThrown(String carNames){
        //given
        final String expectedMessage = "쉼표(,)로 구분하여 자동차 이름들을 입력해주세요";
        final CarNameValidator carNameValidator = new CarNameValidator();

        //when & then
        assertThatThrownBy(() -> carNameValidator.separateByComma(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ahn;", ""})
    @DisplayName("자동차 이름을 두 개 이상으로 입력하지 않았으면 예외 발생")
    void inputMoreThanTwo_NotInputtedMoreThenTwo_ExceptionThrown(String carNames){
        //given
        final String expectedMessage = "자동차 이름을 두 개 이상으로 입력해주세요";
        final CarNameValidator carNameValidator = new CarNameValidator();

        //when & then
        assertThatThrownBy(() -> carNameValidator.inputMoreThanTwo(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
