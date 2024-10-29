package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarNameInputTest {
    @Test
    @DisplayName("정상적인 사용자 입력의 경우 테스트")
    void getRacingCarNameListTest() {
        //given
        String userInput = "car1,car2,car3";
        //when
        RacingCarNameInput racingCarNameInput = new RacingCarNameInput(userInput);
        //then
        List<String> expected = List.of("car1", "car2", "car3");
        assertThat(racingCarNameInput.getRacingCarNameList()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi"})
    @DisplayName("플레이어가 1명 이하일 때의 경우 테스트")
    void validateMinimumPlayerTest(String userInput) {
        assertThatThrownBy(() -> {
            new RacingCarNameInput(userInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 플레이어는 2명입니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 테스트")
    void validateNameRangeTest() {
        //given
        String userInput = "supernovaMK,pobi";
        // when & then
        assertThatThrownBy(() -> {
            new RacingCarNameInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자를 넘길 수 없습니다.");
    }

    @Test
    @DisplayName("중복된 이름이 입력된 경우 테스트")
    void validateSameNameTest() {
        //given
        String userInput = "minki,minki";
        //when & then
        assertThatThrownBy(() -> {
            new RacingCarNameInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다");
    }

    @Test
    @DisplayName("자동차이름이 공백으로만 이루어진 경우")
    void validateNameNothingTest() {
        //given
        String userInput = "    ,minki";
        //when & then
        assertThatThrownBy(() -> {
            new RacingCarNameInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백만 포함된 이름은 설정할 수 없습니다.");
    }
}
