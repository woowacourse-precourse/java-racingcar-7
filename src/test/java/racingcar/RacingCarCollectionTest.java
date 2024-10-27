package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarCollectionTest {
    RacingCarCollection collection;

    @Test
    void 자동차_중복_테스트() {
        Assertions.assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        collection = new RacingCarCollection("a,a,a", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] : 자동차의 이름이 중복되어서는 안됩니다.")
        );
    }

    @Test
    void 자동차_길이_테스트() {
        Assertions.assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        collection = new RacingCarCollection("aaaaaa,bbbb,cccc", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] : 자동차 이름은 5자 이하이거나 비어서는 안됩니다.")
        );
    }

    @Test
    void 자동차_문자_테스트() {
        Assertions.assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        collection = new RacingCarCollection("a;a,b+b,c c", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] : 허용되지 않은 문자가 포함되어있습니다.")
        );
    }

    @Test
    void 시도횟수_양수_테스트() {
        Assertions.assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        collection = new RacingCarCollection("a,b,c", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] : 시도 횟수는 양수를 입력해주세요.")
        );
    }
}