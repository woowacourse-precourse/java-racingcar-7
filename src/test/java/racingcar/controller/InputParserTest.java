package racingcar.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void 이름_입력이_주어지면_List로_변환_테스트() {
        String nameInput = "123,456,789";
        List<String> nameList = inputParser.parseNamesToList(nameInput);
        Assertions.assertThat(nameList).isInstanceOf(List.class).hasSize(3).containsExactly("123", "456", "789");
    }

    @Test
    void 횟수_입력이_주어지면_long_으로_변환_테스트() {
        String timeInput = "3";
        long times = inputParser.parseTimesToLong(timeInput);
        Assertions.assertThat(times).isInstanceOf(Long.class).isEqualTo(3L);
    }

    @Test
    void 이름이_주어지면_양옆의_공백을_제거하고_list로_변환_테스트() {
        String nameInput = "123  , 4 56, 789";
        List<String> nameList = inputParser.parseNamesToList(nameInput);
        Assertions.assertThat(nameList).isInstanceOf(List.class).hasSize(3).containsExactly("123", "4 56", "789");
    }

    @Test
    void 횟수_입력이_공백이면_예외_반환_테스트() {
        String timeInput = "";
        Assertions.assertThatThrownBy(() -> {
            inputParser.parseTimesToLong(timeInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력이_long범위를_벗어나면_예외_반환_테스트() {
        String timeInput = "99999999999999999999999999999999999999999999999999";
        Assertions.assertThatThrownBy(() -> {
            inputParser.parseTimesToLong(timeInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력이_공백일때_예외_반환_테스트() {
        String timeInput = " ";
        Assertions.assertThatThrownBy(() -> {
            inputParser.parseTimesToLong(timeInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력이_null_일때_예외_반환_테스트() {
        String nameInput = null;
        Assertions.assertThatThrownBy(() -> {
            inputParser.parseNamesToList(nameInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}