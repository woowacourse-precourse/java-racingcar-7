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
        // 자동차 이름이 5자를 초과하는 경우
        assertThatThrownBy(() -> new Car("pobi,jjuchan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print()); // 예외 메시지 확인
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1"); // 사용자 입력값 실행
                    String output = output(); // 출력 결과 가져오기
                    assertThat(output)
                            .contains("pobi : -") // 정확한 출력을 확인
                            .contains("woni : ") // 정확한 출력을 확인
                            .contains("최종 우승자 : pobi"); // 최종 우승자 확인
                },
                MOVING_FORWARD, STOP // 무작위 값 범위 지정
        );
    }

    @Test
    void 예외_테스트() {
        // 자동차 이름이 5자 이상일 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,jjuchann", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print()) // 예외 메시지 확인
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{}); // Application의 main 메서드 실행
    }
}
