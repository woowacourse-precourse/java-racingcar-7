package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg,pobi", "pobi,abcdefg"})
    void 자동차_이름_길이_테스트(String candidate) {
        assertSimpleTest(()->
                assertThatThrownBy(()->run(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,포비", "포비,Pobi", "포pobi,pobi", "pobi포,pobi"})
    void 영어가_아닌_이름_테스트(String candidate){
        assertSimpleTest(()->
                assertThatThrownBy(() -> run(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 알파벳으로만 구성되어야 합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "a,b,c,d,e,f,g,h,i,j,k"})
    void 자동차_대수가_2대_미만_10대_초과_테스트(String candidate){
        assertSimpleTest(()->
                assertThatThrownBy(() -> run(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 대수는 2대 이상 10대 이하여야 합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "pobi,Pobi"})
    void 중복_이름_테스트(String candidate){
        assertSimpleTest(() -> assertThatThrownBy(() -> run(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름은 사용할 수 없습니다.(대문자와 소문자는 동일하게 인식됩니다.)")
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
