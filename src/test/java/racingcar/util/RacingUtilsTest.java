package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingUtilsTest {

    @Test
    @DisplayName("입력받은 자동차 이름에 중복 값이 있는 경우 예외를 발생시킨다.")
    void duplicateCarNameTest() {
        assertThatThrownBy(() -> RacingUtils.divideComma("123,123,456"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @Test
    @DisplayName("쉼표 옆에 띄어쓰기가 있을 경우 띄어쓰기를 제거하고 분리한다.")
    void commaAroundWhiteSpaceTest() {
        assertThat(RacingUtils.divideComma("123 , 456, 789"))
            .containsExactlyElementsOf(List.of("123", "456", "789"));
    }

    @Test
    @DisplayName("쉼표 옆에 띄어쓰기가 올 경우 예외를 발생시킨다.")
    void commaWithEmptyTest() {
        assertThatThrownBy(() -> RacingUtils.divideComma("123, "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @Test
    @DisplayName("자동차 이름이 하나만 존재하거나 빈 문자열일 경우 예외를 발생시킨다.")
    void singleCarName() {
        assertAll(
            () -> assertThatThrownBy(() -> RacingUtils.divideComma("123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다."),
            () -> assertThatThrownBy(() -> RacingUtils.divideComma("123,,456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘어가는 경우 예외를 발생시킨다.")
    void ExceedCarNameLengthTest() {
        assertAll(
            () -> assertThat(RacingUtils.divideComma("12345, 6789"))
                .containsExactlyElementsOf(List.of("12345", "6789")),
            () -> assertThatThrownBy(() -> RacingUtils.divideComma("123456, 789"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.")
        );
    }

    @Test
    @DisplayName("입력받은 실행 횟수가 정수형이 아니거나 양수가 아닐 경우 예외를 발생시킨다.")
    void executeCountTest() {
        assertAll(
            () -> assertThatThrownBy(() -> RacingUtils.parseInt("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다."),
            () -> assertThatThrownBy(() -> RacingUtils.parseInt("6.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다."),
            () -> assertThatThrownBy(() -> RacingUtils.parseInt("-9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다."),
            () -> assertThat(RacingUtils.parseInt("3"))
                .isEqualTo(3)
        );
    }

}
