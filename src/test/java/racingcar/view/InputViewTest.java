package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    private InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    @DisplayName("올바른 이름 입력")
    void enterCorrectName() {
        //given
        String input = "pobi,lim";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        List<String> names = inputView.receiveName();

        //then
        assertEquals(List.of("pobi", "lim"), names);
    }

    @Test
    @DisplayName("올바른 카운트 입력")
    void enterCorrectCount() {
        //given
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        int count = inputView.receiveCount();

        //then
        assertThat(count).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,lim", "pobi,lim,", ",pobi,lim,"})
    @DisplayName("시작과 끝이 구분자일 경우 예외")
    void enterStartOrEndWithSeparatorException(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> inputView.receiveName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,lim,,", "pobi,,lim", ",,pobi,lim"})
    @DisplayName("연속 구분자 등장할 경우 예외")
    void enterContinuousSeparatorException(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> inputView.receiveName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "3#", "0", "-1", "1.2"})
    @DisplayName("카운트에 양의 정수를 제외한 문자가 올 경우 예외")
    void enterInvalidCountException(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> inputView.receiveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
