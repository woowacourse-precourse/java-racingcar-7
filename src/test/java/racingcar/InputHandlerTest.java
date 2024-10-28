package racingcar;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class InputHandlerTest {
    InputHandler inputHandler = new InputHandler();

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 정상 입력")
    void Should_Pass_When_InputIsNormalNames() {
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("pobi", 0);
        expectedResult.put("woni", 0);
        expectedResult.put("jun", 0);
        expectedResult.put("S", 0);
        expectedResult.put("b_man", 0);

        String input = "pobi,woni,jun,S,b_man";
        Map<String, Integer> actualResult = inputHandler.readCarNames(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("경주 이동 횟수 입력 테스트 : 정상 입력")
    void Should_Pass_When_InputIsNormalNum() {
        String input = "19258";
        int actualResult = inputHandler.readIterNum(input);

        assertThat(actualResult).isEqualTo(19258);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 공백 입력 예외 처리")
    void Should_ThrowException_When_InputIsEmpty() {
        assertThatThrownBy(() -> {
            String input = " ";
            inputHandler.readCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 불완전 입력 예외 처리")
    void Should_ThrowException_When_InputIsIncomplete() {
        assertThatThrownBy(() -> {
            String input = ",name,";
            inputHandler.readCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 5글자 초과 이름 예외 처리")
    void Should_ThrowException_When_NameLengthIsOverThanFive() {
        assertThatThrownBy(() -> {
            String input = "short,long_name";
            inputHandler.readCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 중복된 이름 예외 처리")
    void Should_ThrowException_When_NameIsDuplicated() {
        assertThatThrownBy(() -> {
            String input = "name,name";
            inputHandler.readCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트 : 빈 이름 예외 처리")
    void Should_ThrowException_When_NameIsBlank() {
        assertThatThrownBy(() -> {
            String input = "name,,name";
            inputHandler.readCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 이동 횟수 입력 테스트 : 숫자가 아닌 문자 예외 처리")
    void Should_ThrowException_When_NumIsNotNum() {
        assertThatThrownBy(() -> {
            String input = "-10";
            inputHandler.readIterNum(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 이동 횟수 입력 테스트 : 양수가 아닌 숫자 예외 처리")
    void Should_ThrowException_When_NumIsNotPositive() {
        assertThatThrownBy(() -> {
            String input = "0";
            inputHandler.readIterNum(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
