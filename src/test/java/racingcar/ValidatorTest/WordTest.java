package racingcar.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class WordTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("잘못된 문자 사용 - 숫자")
    void ValidateNumber() {
        assertThatCode(() -> validator.validateInput("1,2", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.");
    }

    @Test
    @DisplayName("잘못된 문자 사용 - 문자와 숫자 혼합")
    void ValidateWordAndNumber() {
        assertThatCode(() -> validator.validateInput("pobi,pobi77", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.");
    }

    @Test
    @DisplayName("잘못된 문자 사용 - 대문자 알파벳")
    void ValidateCapitals() {
        assertThatCode(() -> validator.validateInput("POBI,woni", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.");
    }

    @Test
    @DisplayName("잘못된 문자 사용 - 한글")
    void ValidateKorean() {
        assertThatCode(() -> validator.validateInput("우테코,woo", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 소문자 알파벳으로만 이루어져야 합니다.");
    }


}
