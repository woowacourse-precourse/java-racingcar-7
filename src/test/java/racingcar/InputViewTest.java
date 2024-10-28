package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("문자열을 입력받으면 ',' 로 분리하여 리스트로 반환할 수 있다.")
    @Test
    void 문자열을_입력_받으면_분리해서_리스트로_반환한다() {
        // given
        setInput("재석,하하,광수");

        // when
        List<String> strings = InputView.inputCarNames();

        // then
        Assertions.assertThat(strings).isEqualTo(List.of("재석", "하하", "광수"));
    }

    @DisplayName("중복된 값이 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideInvalidCarNames")
    void 잘못된_값이_입력되면_실패(String input) {
        setInput(input);

        Assertions.assertThatThrownBy(InputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자를 입력받으면 검증하여 숫자로 변환할 수 있다.")
    @Test
    void 숫자_입력_받기() {
        // given
        setInput("3");

        // when
        int tryCount = InputView.inputTryCount();

        // then
        Assertions.assertThat(tryCount).isEqualTo(3);
    }

    @DisplayName("숫자가 아닌 값이 입력되면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"일", "다섯", "aa"})
    void 숫자가_아닌값이_입력되면_실패(String input) {
        setInput(input);

        Assertions.assertThatThrownBy(InputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수를 입력해주세요.");
    }

    private static Stream<String> provideInvalidCarNames() {
        return Stream.of(
                "1,1",          // 중복된 이름
                "재석,재석",     // 중복된 이름
                "alex,alex"     // 중복된 이름
        );
    }
}
