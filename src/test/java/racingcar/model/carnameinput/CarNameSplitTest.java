package racingcar.model.carnameinput;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameSplitTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi,   woni   ,jun,   ,   "})
    @DisplayName("자동차 이름이 콤마(,)를 기준으로 잘 분할 되는지 확인한다")
    void 자동차_이름_분할_테스트(String name) {
        String[] carNameArray = CarNameSplit.nameSplit(name);
        assertThat(carNameArray).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ,   ,   ", ",   ,        ,      "})
    @DisplayName("배열의 크기가 0일때 오류 확인한다.")
    void 자동차_이름_분할_실패_테스트(String name) {
        assertThatThrownBy(() -> CarNameSplit.nameSplit(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

}