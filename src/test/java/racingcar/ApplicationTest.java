package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차입력_테스트(){
        // given: 쉼표로 구분된 자동차 이름 문자열
        String input = "car1,car2,car3";

        // when: car_input 메서드 실행
        List<RacingCar> carList = Application.car_input(input);

        // then: 결과 리스트가 예상과 일치하는지 검증
        assertEquals(3, carList.size());
        assertEquals("car1", carList.get(0).getName());
        assertEquals("car2", carList.get(1).getName());
        assertEquals("car3", carList.get(2).getName());
    }

    @Test
    public void 횟수입력_테스트() {
        // given: 숫자로 이루어진 문자열
        String input = "5";

        // when: count_input 메서드 실행
        int count = Application.count_input(input);

        // then: 결과 값이 예상과 일치하는지 검증
        assertEquals(5, count);
    }

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
