package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    private void command(String... args) {
        String input = String.join(",", args);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close(); // 각 테스트 이후 Scanner 초기화
    }

    @ParameterizedTest
    @CsvSource({
            "'car,hi,asdf,lll'",
            "'abc,a,b,c'",
            "'aaaa,abcd,abcd,kore,asdf'",
            "'abcde,qwert,qewss,poiuy'"
    })
    @DisplayName("유효한 자동차 이름 입력 테스트")
    void testGetCarNames(String input) {
        // Given
        this.command(input);
        String[] expectedCarNames = input.split(",");

        // When
        List<String> carNames = InputView.getCarNames();

        // Then
        assertThat(carNames).containsExactly(expectedCarNames);
        assertThat(carNames).hasSize(expectedCarNames.length);
    }

    @ParameterizedTest
    @CsvSource({
            "'abc,123,kkk'",        // 이름 아닌 숫자 구성 예외 케이스
            "'abcde,qwerty,pokk'",  // 이름 5글자 초과 예외 케이스
            "'a, b, c'",            // 공백 포함 예외 케이스
            "'a , b'"
    })
    @DisplayName("유효하지 않은 자동차 이름 입력 테스트")
    void testGetCarNamesException(String input) {
        // Given
        this.command(input);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                InputView::getCarNames);
        assertThat(exception.getMessage()).isEqualTo("자동차 이름 입력이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "100",
            "425"
    })
    @DisplayName("유효한 이동 횟수 입력 테스트")
    void testGetMoveCount(String moveCount) {
        // Given
        this.command(moveCount);

        // When
        int moveCountResult = InputView.getMoveCount();

        // Then
        assertThat(moveCountResult).isEqualTo(Integer.valueOf(moveCount));
    }


    @ParameterizedTest
    @CsvSource({
            "001",  // 유효하지 않은 숫자 형태 correct: 1
            "-1",   // 음수 입력 예외 케이스
            "'\n'"  // 아무 것도 입력하지 않고 엔터 눌렀을 시
    })
    @DisplayName("유효하지 않은 이동 횟수 입력 테스트")
    void testGetMoveCountException(String moveCount) {
        // Given
        this.command(moveCount);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                InputView::getMoveCount);
        assertThat(exception.getMessage()).isEqualTo("이동 횟수 입력이 올바르지 않습니다.");
    }
}