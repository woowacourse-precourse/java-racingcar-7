package racingcar.service;

import static racingcar.model.ExceptionMessage.EMPTY_STRING;
import static racingcar.model.ExceptionMessage.INVALID_CHARACTER;
import static racingcar.model.ExceptionMessage.INVALID_VALUE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("빈 문자열이 아니면 정상 통과한다.")
    void validInputEmpty() {
        String input = "pobi,woni";
        boolean result = InputValidator.validInputEmpty(input);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("빈 문자열을 입력하면 IllegalArgumentException을 throw한다.")
    void invalidInputEmpty() {
        String input = "";
        Assertions.assertThatThrownBy(
                        () -> InputValidator.validInputEmpty(input)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_STRING.getMessage());
    }

    @Test
    @DisplayName("영어 대소문자, 공백, 쉼표(,)로만 구성되어있으면 통과한다.")
    void validInputCharacter() {
        String input = "abcde,ABCDE, ";
        boolean result = InputValidator.validInputCharacter(input);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("영어 대소문자, 공백, 쉼표(,) 외의 문자가 포함되어있으면 IllegalArgumentException을 throw한다.")
    void invalidInputCharacter() {
        String input = "???,!!!;abc";
        Assertions.assertThatThrownBy(
                        () -> InputValidator.validInputCharacter(input)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("경기 횟수가 0보다 크면 정상 통과한다.")
    void validInputRaceCount() {
        int raceCount = 10;
        boolean result = InputValidator.validInputRaceCount(raceCount);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("경기 횟수가 0보다 작으면 IllegalArgumentException을 throw한다.")
    void invalidInputRaceCount() {
        int raceCount = -1;
        Assertions.assertThatThrownBy(
                        () -> InputValidator.validInputRaceCount(raceCount)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE.getMessage());
    }
}