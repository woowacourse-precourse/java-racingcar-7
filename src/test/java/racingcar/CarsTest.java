package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 자동차이름_쉼표기준으로_나누기() {
        Assertions.assertThat(new Cars("abcde,woni,jun").getNameList())
                .isEqualTo(List.of("abcde", "woni", "jun"));

        Assertions.assertThat(new Cars("가나다라마,woni,jun").getNameList())
                .isEqualTo(List.of("가나다라마", "woni", "jun"));

        Assertions.assertThat(new Cars("12345,woni,jun").getNameList())
                .isEqualTo(List.of("12345", "woni", "jun"));

        Assertions.assertThat(new Cars("++==+,woni,jun").getNameList())
                .isEqualTo(List.of("++==+", "woni", "jun"));
    }

    @DisplayName("분리됐을 때 빈문자열이 있으면 오류")
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
