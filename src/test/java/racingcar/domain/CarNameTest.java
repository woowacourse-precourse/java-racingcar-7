package racingcar.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    @DisplayName("정상적인 자동차 이름 리스트일 때 예외가 발생하지 않는다")
    void 이름_입력_성공() {
        List<String> carNames = Arrays.asList("pobi", "woni", "honux");
        assertDoesNotThrow(() -> new CarName(carNames));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외가 발생한다")
    void 이름_글자수_초과_실패() {
        List<String> carNames = Arrays.asList("pobiiii", "woni", "honux");
        assertThatThrownBy(() -> new CarName(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @DisplayName("자동차 이름에 빈 값이 있을 경우 예외가 발생한다")
    void 공백_이름_실페(String carnames) {
        List<String> carNames = Arrays.asList(carnames);
        assertThatThrownBy(() -> new CarName(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외가 발생한다")
    void 이름_중복_실패() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "honux");
        assertThrows(IllegalArgumentException.class, () -> new CarName(carNames), "이름이 중복되었습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCarNames")
    @DisplayName("자동차 개수가 1개이거나 10개 초과일 경우 예외가 발생한다")
    void 자동차_갯수_실패(List<String> carNames) {
        assertThatThrownBy(() -> new CarName(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidCarNames() {
        return Stream.of(
            Arguments.of(Collections.singletonList("pobi")),  // 1개 (실패 케이스)
            Arguments.of(
                Arrays.asList("pobi", "woni", "honux", "june", "kim", "lee", "park", "choi", "yoon",
                    "jang", "lim"))  // 11개 (실패 케이스)
        );
    }

}
