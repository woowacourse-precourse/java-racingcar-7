package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView = new InputView();

    @BeforeEach
    void restoreInputStream() {
        System.setIn(System.in);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1,2,3", "abcde", "12345"})
    void 자동차_이름_올바른_입력_테스트(String carNames) {
        // given
        // 입력 흐름을 지정한 버퍼로 변경
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatCode(() -> {
            inputView.enterCarNames();
        }).doesNotThrowAnyException();

        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "a,", ",a", "a,,a"})
    void 자동차_이름_빈_문자열_예외_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    inputView.enterCarNames();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 1글자 이상 5글자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef,a", "123456,1", "abcdef", "123456"})
    void 자동차_이름_6자_이상_예외_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    inputView.enterCarNames();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 1글자 이상 5글자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde,abcde,abc", "123,1,123"})
    void 자동차_이름_중복_예외_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    inputView.enterCarNames();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "999999"})
    void 경기_횟수_올바른_입력_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatCode(() -> {
            inputView.enterRoundCount();
        }).doesNotThrowAnyException();

        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@@", "abc", "십만"})
    void 경기_횟수_정수가_아닌_경우_예외_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    inputView.enterRoundCount();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-100"})
    void 경기_횟수_양수가_아닌_경우_예외_테스트(String carNames) {
        // given
        String[] args = {carNames};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    inputView.enterRoundCount();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 100만 이하의 숫자를 입력해주세요.");
    }
}