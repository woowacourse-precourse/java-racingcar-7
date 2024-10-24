package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private ArrayList<String> convertMapToList(Cars cars) {
        return new ArrayList<>(cars.getCars().keySet());
    }

    @Test
    void 자동차이름_쉼표기준으로_나누기() {
        Assertions.assertThat(convertMapToList(new Cars("abcde,woni,jun")))
                        .isEqualTo(List.of("abcde", "woni", "jun"));
        Assertions.assertThat(convertMapToList(new Cars("가나다라마,woni,jun")))
                .isEqualTo(List.of("가나다라마", "woni", "jun"));
        Assertions.assertThat(convertMapToList(new Cars("12345,woni,jun")))
                .isEqualTo(List.of("12345", "woni", "jun"));
        Assertions.assertThat(convertMapToList(new Cars("++==+,woni,jun")))
                .isEqualTo(List.of("++==+", "woni", "jun"));
    }

    @DisplayName(",를 기준으로 구분했을 때 빈문자열이 있으면 오류")
    @Test
    void 자동차이름_잘못된_입력() {
        Assertions.assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> new Cars(",pobi,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> new Cars("pobi,,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");

        Assertions.assertThatThrownBy(() -> new Cars("pobi,woni,jun,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하셨습니다.");
    }

    @Test
    void 자동차이름_5자_제한_확인() {
        Assertions.assertThatThrownBy(() -> new Cars("abcdef,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> new Cars("가나다라마바,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> new Cars("123456,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");

        Assertions.assertThatThrownBy(() -> new Cars("/*-+=_,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");
    }
}
