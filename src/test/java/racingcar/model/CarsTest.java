package racingcar.model;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @DisplayName("중복되는 이름 입력")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "woni,jun,jun", "me,you,me"})
    void 중복_이름_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Cars(Cars.makeCarList(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름이 존재합니다.");
    }

    @DisplayName("자동차 개수 0개 되도록 입력")
    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",,,", ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,"})
    void 공백_이름_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Cars(Cars.makeCarList(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 없습니다.");
    }

    @DisplayName("자동차 개수 최대 범위 입력")
    @Test
    void 자동차_최대개수_입력() {
        ArrayList<String> names = new ArrayList<>();
        for (char alpha = 'a'; alpha <= 'z'; alpha++) {
            for (int cnt = 0; cnt < 4; cnt++) {
                names.add(String.valueOf(alpha) + cnt);
            }
        }

        String input = String.join(",", names);
        Assertions.assertThatThrownBy(() -> new Cars(Cars.makeCarList(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최대 100개까지 입력 가능합니다.");
    }

}