package racingcar.model.carname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameSplitTest {
    @Test
    @DisplayName("자동차 이름이 콤마(,)를 기준으로 잘 분할 되는지 확인한다")
    void 자동차_이름_분할_테스트() {
        String[] carNameArray = CarNameSplit.nameSplit("pobi,woni,jun");
        assertThat(carNameArray).containsExactly("pobi", "woni", "jun");
    }
}