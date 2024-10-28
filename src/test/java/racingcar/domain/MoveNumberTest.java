package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "11", "100"})
    void 객체_생성(String testNumber) {
        MoveNumber moveNumber = MoveNumberFactory.createMoveNumber(testNumber);

        assertThat(moveNumber.moveNumber()).isEqualTo(Integer.parseInt(testNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.1", "aa", "1a", " ", "1.0", "12.00"})
    void 정수가_아니면_예외(String testNumber) {
        assertThatThrownBy(() -> MoveNumberFactory.createMoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수로 된 이동 횟수를 입력해주세요.");
    }
}
