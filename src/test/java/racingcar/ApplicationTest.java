package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 입력값이_양의_정수가_아닌_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCount("0");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCount("-1");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCount("abc");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCount(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCount(" ");
        });
    }

    @Test
    void 유효한_양의_정수_입력() {
        Application.validateCount("5");
    }

    @Test
    void 입력값이_null인_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCar(null);
        });
    }

    @Test
    void 입력값이_빈_문자열인_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCar(" ");
        });
    }

    @Test
    void 유효한_입력_테스트() {
        Application.validateCar("validName");
    }

    @Test
    void 우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차입력_테스트() {
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
