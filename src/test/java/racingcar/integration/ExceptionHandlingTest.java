package racingcar.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import error.ExceptionMessage;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ExceptionHandlingTest extends NsTest {

    @Test
    void 자동차_이름이_빈_문자열일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.CARS_INPUT_EMPTY)
        );
    }

    @Test
    void 시도할_횟수가_수가_아닌값이_들어올때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.COUNTS_INPUT_IS_NOT_NUMBER)
        );
    }


    @Test
    void 시도할_횟수가_빈_문자열일_때_예외_발생() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.COUNTS_INPUT_EMPTY)
        );
    }

    @Test
    void 시도할_횟수가_0일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.COUNTS_VALUE_INVALID)
        );
    }

    @Test
    void 시도할_횟수가_0이하일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.COUNTS_VALUE_INVALID)
        );
    }

    @Test
    void 자동차_이름이_1개만_들어올_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.ONLY_ONE_CAR)
        );
    }

    @Test
    void 자동차_이름_목록의_마지막이_쉼표일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.CARS_INPUT_END_ERROR)
        );
    }

    @Test
    void 자동차_이름_길이가_5자_넘을_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobipobi,pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.CAR_NAME_LENGTH_INVALID)
        );
    }

    @Test
    void 자동차_이름이_중복일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.CAR_ALREADY_EXIST)
        );
    }

    @Test
    void 자동차_이름_중간에_공백이_있을_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po b,po  b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.CAR_NAME_HAVE_WHITESPACE)
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
