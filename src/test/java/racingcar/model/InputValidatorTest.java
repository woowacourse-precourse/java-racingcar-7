package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차의 이름은 5자 이하의 한글, 소문자 영어이다.")
    @MethodSource("inputCarNameSuccessList")
    @ParameterizedTest
    void carNameSuccessTest(String input) {
        assertDoesNotThrow(() -> {
            inputValidator.validateCarName(input);
        });
    }

    @DisplayName("자동차의 이름은 5자 이하의 한글, 소문자 영어가 아니면 에러가 발생한다.")
    @MethodSource("inputCarNameFailureList")
    @ParameterizedTest
    void carNameFailureTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateCarName(input);
        });
    }

    private static Stream<Arguments> inputCarNameSuccessList() {
        return Stream.of("a", "ab", "abc", "abcd", "abcde",
                "pobi", "woni", "corpi",
                "일", "이이", "삼삼삼", "사사사사", "오오오오오",
                "갻덄럖뱚휿", "갉랉딽깎쌌"
        ).map(Arguments::of);
    }

    private static Stream<Arguments> inputCarNameFailureList() {
        return Stream.of("", " ",
                "!", "@", "|",
                "ㄱ", "ㅎ", "ㅏ", "ㅣ",
                "ㄱㄴㄷㄹㅁ", "ㅏㅑㅓㅕㅗ",
                "여섯글자문자", "sixsix",
                "★", "😁"
        ).map(Arguments::of);
    }
}