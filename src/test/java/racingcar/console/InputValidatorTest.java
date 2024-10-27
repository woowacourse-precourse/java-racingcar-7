package racingcar.console;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = InputValidator.init();
    }

    @Test
    void 유효한_참여자_입력은_익셉션이_발생하지_않을_것이다() {
        Assertions.assertThatCode(() -> validator.validLastString("pobi,kong"))
            .doesNotThrowAnyException();
    }

    @Test
    void 마지막에_콤마를_입력하면_익셉션이_발생할_것이다() {
        Assertions.assertThatThrownBy(() -> validator.validLastString("pobi,kong,"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_참여자는_익셉션이_발생하지_않을_것이다() {
        String[] players = {"Alice", "Bob"};

        Assertions.assertThatCode(() -> validator.validPlayerList(players))
            .doesNotThrowAnyException();
    }

    @Test
    void 중복된_참가자는_익셉션이_발생할_것이다() {
        String[] players = {"Alice", "Alice"};

        Assertions.assertThatThrownBy(() -> validator.validPlayerList(players))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자가_한_명이라면_익셉션이_발생할_것이다() {
        String[] players = {"Alice"};

        Assertions.assertThatThrownBy(() -> validator.validPlayerList(players))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_이름이_5글자_이하라면_익셉션이_발생하지_않을_것이다() {
        String[] players = {"Alice", "Bob"};

        Assertions.assertThatCode(() -> validator.validPlayerList(players))
            .doesNotThrowAnyException();
    }

    @Test
    void 참가자_이름이_5글자를_넘어가면_익셉션이_발생할_것이다() {
        String[] players = {"Alice", "Charlie"};

        Assertions.assertThatThrownBy(() -> validator.validPlayerList(players))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최소_바큇수_검증에_성공할_것이다() {
        assertDoesNotThrow(() -> validator.validTotalLapCount(3L));
    }

    @Test
    void 최소_바큇수_미달이면_익셉션이_발생할_것이다() {
        Assertions.assertThatThrownBy(() -> validator.validTotalLapCount(0L))
            .isInstanceOf(IllegalArgumentException.class);
    }
}