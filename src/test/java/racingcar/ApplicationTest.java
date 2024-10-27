package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import view.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름에_대한_예외_테스트() {
        // Car 객체를 생성해 addCar 메서드에 접근
        Car car = new Car();
        assertThatThrownBy(() -> car.addCar("pobi,jjuchan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print()); // 예외 메시지 추가
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1"); // run 메서드 호출
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1")) // 이름이 5자 이상일 경우 예외
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print()) // 예외 메시지 추가
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{}); // Application의 main 실행
    }
}
