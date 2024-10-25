package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceServiceTest {

    private static final RaceService raceService = new RaceService();

    @DisplayName("중복되는 이름 입력")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "woni,jun,jun", "me,you,me"})
    void 중복_이름_입력(String input) {
        Assertions.assertThatThrownBy(() -> raceService.carListOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름이 존재합니다.");
    }
}