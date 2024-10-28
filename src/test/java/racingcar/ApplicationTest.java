package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import racingcar.Application.Car;

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("Car 객체 생성 테스트")
    void createCar() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름 길이 검증 테스트")
    void validateCarNameLength() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Application.validateCarName("overfive"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하여야 합니다");
        });
    }

    @Test
    @DisplayName("시도 횟수 입력 검증 테스트")
    void validateAttemptCount() {
        assertSimpleTest(() -> {
            String input = "not_a_number\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            assertThatThrownBy(Application::getAttemptCount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMovement() {
        Car car = new Car("pobi");

        // move 메서드를 호출하여 자동차가 움직였는지 확인
        car.move(); // 조건을 만족하는 경우에만 move()가 호출되어 위치가 증가한다고 가정

        // 예상된 위치와 실제 위치를 비교
        assertThat(car.getPosition()).isGreaterThan(0); // 위치가 증가했는지 확인
    }

    @Test
    @DisplayName("라운드별 결과 출력 테스트")
    void roundResultDisplay() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    @DisplayName("우승자 결정 테스트")
    void announceWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // 각 차의 이동 횟수를 설정
        car1.move(); // pobi가 2칸 이동
        car1.move();
        car2.move(); // woni가 1칸 이동

        List<Car> cars = List.of(car1, car2);

        // 콘솔 출력을 검증하는 방법으로 수정
        assertSimpleTest(() -> {
            Application.announceWinners(cars);
            assertThat(output()).contains("최종 우승자 : pobi");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
