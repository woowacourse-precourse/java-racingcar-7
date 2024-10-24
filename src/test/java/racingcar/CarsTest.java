package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private ArrayList<String> convertMapToList(Map<String, Integer> map) {
        return new ArrayList<>(map.keySet());
    }

    @Test
    void 자동차이름_쉼표기준으로_나누기() {
        Assertions.assertThat(convertMapToList(Cars.createNameList("abcde,woni,jun")))
                .isEqualTo(List.of("abcde", "woni", "jun"));
        Assertions.assertThat(convertMapToList(Cars.createNameList("가나다라마,woni,jun")))
                .isEqualTo(List.of("가나다라마", "woni", "jun"));
        Assertions.assertThat(convertMapToList(Cars.createNameList("12345,woni,jun")))
                .isEqualTo(List.of("12345", "woni", "jun"));
        Assertions.assertThat(convertMapToList(Cars.createNameList("++==+,woni,jun")))
                .isEqualTo(List.of("++==+", "woni", "jun"));
    }

    @DisplayName(",를 기준으로 구분했을 때 빈문자열이 있으면 오류")
    @Test
    void 자동차이름_잘못된_입력() {
        Assertions.assertThatThrownBy(() -> Cars.createNameList(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList(",pobi,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList("pobi,,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList("pobi,woni,jun,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");
    }

    @Test
    void 자동차이름_5자_제한_확인() {
        Assertions.assertThatThrownBy(() -> Cars.createNameList("abcdef,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList("가나다라마바,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList("123456,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> Cars.createNameList("/*-+=_,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");
    }
}
