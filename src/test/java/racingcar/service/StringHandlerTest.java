package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CustomException;
import racingcar.exception.ErrorCode;

class StringHandlerTest {

    private StringHandler stringHandler;

    @BeforeEach
    void setUp() {
        stringHandler = new StringHandler();
    }

    @DisplayName("구분자 ,를 기준으로 문자열을 분리하여 문자열 배열을 반환한다.")
    @Test
    void split() {
        // given
        String input1 = "a,b,c";
        String input2 = ",";
        String input3 = "a, b";
        String input4 = "a ,b";
        String input5 = ", ,";
        String input6 = "";

        // when
        String[] result1 = stringHandler.split(input1);
        String[] result2 = stringHandler.split(input2);
        String[] result3 = stringHandler.split(input3);
        String[] result4 = stringHandler.split(input4);
        String[] result5 = stringHandler.split(input5);
        String[] result6 = stringHandler.split(input6);

        // then
        Assertions.assertThat(result1)
                .hasSize(3)
                .containsExactly("a", "b", "c");
        Assertions.assertThat(result2)
                .hasSize(0);
        Assertions.assertThat(result3)
                .hasSize(2)
                .containsExactly("a", " b");
        Assertions.assertThat(result4)
                .hasSize(2)
                .containsExactly("a ", "b");
        Assertions.assertThat(result5)
                .hasSize(2)
                .containsExactly("", " ");
        Assertions.assertThat(result6)
                .hasSize(1)
                .containsExactly("");
    }

    @DisplayName("문자열을 구분자 , 를 기준으로 결합하여 리턴한다.")
    @Test
    void join() {
        // given
        List<String> input = new ArrayList<>(List.of("a", "b"));

        // when
        String result = stringHandler.join(input);

        // then
        Assertions.assertThat(result).isEqualTo("a, b");
    }

    @DisplayName("문자열을 int로 변환한다.")
    @Test
    void stringToInt() {
        // given
        String input1 = String.valueOf(Integer.MIN_VALUE);
        String input2 = String.valueOf(Integer.MAX_VALUE);

        // when
        int result1 = stringHandler.StringToInt(input1);
        int result2 = stringHandler.StringToInt(input2);

        // then
        Assertions.assertThat(result1).isEqualTo(Integer.MIN_VALUE);
        Assertions.assertThat(result2).isEqualTo(Integer.MAX_VALUE);
    }

    @DisplayName("문자열을 int로 변환할 수 없으면 예외를 반환한다.")
    @Test
    void stringToIntWithNotInteger() {
        // given
        String input1 = String.valueOf(Long.MIN_VALUE);
        String input2 = String.valueOf(Long.MAX_VALUE);
        String input3 = "12;;;";

        // when & then
        Assertions.assertThatThrownBy(() -> stringHandler.StringToInt(input1))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.TRY_COUNT_NOT_NUMBER);
        Assertions.assertThatThrownBy(() -> stringHandler.StringToInt(input2))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.TRY_COUNT_NOT_NUMBER);
        Assertions.assertThatThrownBy(() -> stringHandler.StringToInt(input3))
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.TRY_COUNT_NOT_NUMBER);
    }
}